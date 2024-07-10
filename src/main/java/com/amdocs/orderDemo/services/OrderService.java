package com.amdocs.orderDemo.services;

import com.amdocs.orderDemo.Entities.Order;
import com.amdocs.orderDemo.OrderDemoApplication;
import com.amdocs.orderDemo.feignClients.CustomerClient;
import com.amdocs.orderDemo.feignClients.PricingClient;
import com.amdocs.orderDemo.feignClients.ProductOrderClient;
import com.amdocs.orderDemo.feignClients.ProductsClient;
import com.amdocs.orderDemo.request.ProductOrderRequest;
import com.amdocs.orderDemo.response.*;
import com.amdocs.orderDemo.repository.OrderRepository;
import com.amdocs.orderDemo.request.OrderRequest;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderDemoApplication.class);


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductsClient productsClient;

    @Autowired
    private ProductOrderClient productOrderClient;


    @Autowired
    private PricingClient pricingClient;
    double totalOrder;


    public OrderResponse createOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setExtraDiscount(orderRequest.getExtraDiscount());
        order.setCustomer(orderRequest.getCustomerID());
        order.setCreationDate(LocalDate.now());
        OrderResponse response = new OrderResponse();
        mapCustomer(response, orderRequest.getCustomerID());
        order = orderRepository.save(order);
        List<ProductsResponse> productsList = new ArrayList<>();

        totalOrder = 0.0;

        for (ProductOrderRequest product: orderRequest.getProducts()) {
            ProductOrderRequest request = mapOrderRequest(order.getOrderId(), product.getProductId(), product.getQuantity());
            productOrderClient.addProductOrder(request);
            Optional<ProductsResponse> optionalProductsResponse = productsClient.getProductById(product.getProductId());
            productsList.add(optionalProductsResponse.get());
            optionalProductsResponse.get().setQuantity(product.getQuantity());
            response.setProducts(productsList);
            response.setTotalPrice(sumTotalPrice(optionalProductsResponse.get(),orderRequest.getExtraDiscount()));
        }
        response.setOrderId(order.getOrderId());
        response.setTotalQuantityProducts(totalQuantityProducts(orderRequest));
        response.setExtraDiscount(order.getExtraDiscount());

        return response;
    }


    private void  mapProducts(OrderResponse response, Integer orderId) {
        List<ProductsResponse> productsList = new ArrayList<>();
        totalOrder = 0.0;

        List<ProductOrderResponse> productOrderResponse = productOrderClient.findByOrderID(orderId);
        for (ProductOrderResponse products : productOrderResponse) {
            System.out.println("pipirupu" + products.getProductId());
            Optional<ProductsResponse> optionalProductsResponse = productsClient.getProductById(products.getProductId());
            productsList.add(optionalProductsResponse.get());
            response.setProducts(productsList);
            optionalProductsResponse.get().setQuantity(products.getQuantity());
            response.setTotalPrice(sumTotalPrice(optionalProductsResponse.get(), response.getExtraDiscount()));
        }
        response.setTotalQuantityProducts(totalQuantityForProducts(response));
    }




    private ProductOrderRequest mapOrderRequest(Integer orderId, Integer productId, Integer quantity) {
        ProductOrderRequest request = new ProductOrderRequest();
        request.setOrderId(orderId);
        request.setProductID(productId);
        request.setQuantity(quantity);
        return request;
    }


    private  Integer totalQuantityProducts (OrderRequest orderRequest){
        Integer totalQuantity = 0;
        for (ProductOrderRequest product : orderRequest.getProducts()){
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;

    }
    private  Integer totalQuantityForProducts (OrderResponse response){
        Integer totalQuantity = 0;
        for (ProductsResponse product : response.getProducts() ){
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;

    }



    private Double sumTotalPrice( ProductsResponse productsResponse,Double extraDiscount){

        double totalPrice;
        double price;
        double priceTax;
        double discount ;
        double tax;
        double totalDiscount;

            price = productsResponse.getPricing().getPrice();
            tax = price*(productsResponse.getPricing().getTax() / 100);
            priceTax = price + tax;
            discount = (priceTax - (productsResponse.getPricing().getDiscount() * priceTax) / 100);
            totalPrice = discount * productsResponse.getQuantity();
            totalOrder += totalPrice;
            totalDiscount =(totalOrder - (extraDiscount * totalOrder) / 100);

        System.out.println("precio normal " + price);
        System.out.println("TAX  :"+tax);
        System.out.println("precio con tax  :" + priceTax);
        System.out.println("desc : " + (productsResponse.getPricing().getDiscount() * priceTax) / 100);
        System.out.println("precio con descuento :" + discount);
        System.out.println("precio final :" + totalPrice);
        System.out.println("descuento final : " +extraDiscount);
        System.out.println("total order : " + totalDiscount);
        System.out.println("----------------------------------------");


          return totalDiscount;
    }






    private void mapOrder(OrderResponse orderResponse, Order order){
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setExtraDiscount(order.getExtraDiscount());
    }


    private  void mapCustomer(OrderResponse orderResponse, Integer customerId){
        Optional<CustomerResponse> optionalCustomerResponse = customerClient.getCustomerById(customerId);
        if (optionalCustomerResponse.isPresent()){
            orderResponse.setCustomer(optionalCustomerResponse.get());

        }
    }



    public OrderResponse getOrderById(Integer orderId) {
        OrderResponse response = new OrderResponse();
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            mapOrder(response, order);
            mapCustomer(response,order.getCustomer());

            mapProducts(response,order.getOrderId());
            System.out.println("hola");


        }



        return response;
    }


    public OrderResponse deleteOrder(Integer orderId) {
    return null;
    }
}