package org.example.orderObject;

import org.example.orderObject.schema.Items;
import org.example.orderObject.schema.Order;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");

        Order order = new Order.Builder(1, 11, 111, Arrays.asList(new Items(1,"chocolate"))).withCouponCode("123").withDeliveryInstructions("call me when you are near").withGiftWrap(true).withScheduledDeliveryTime(LocalDateTime.now().plusHours(1)).withSpecialNote("this is a special note").build();

        System.out.println(order.getOrderId()+" "+order.getCustomerId()+" "+order.getRestaurantId()+" "+order.getItems()+" "+order.getCouponCode()+" "+order.isGiftWrap()+" "+order.getDeliveryInstructions()+" "+order.getScheduledDeliveryTime()+" "+order.getSpecialNote());

    }
}