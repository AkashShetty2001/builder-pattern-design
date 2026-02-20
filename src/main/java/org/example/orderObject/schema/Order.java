package org.example.orderObject.schema;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    /*
    Imutable and mandatory properties:
     */

    private final Integer orderId;
    private final Integer customerId;
    private final Integer restaurantId;
    private final List<Items> items;

    /*
    non mandatory properties:
     */

    private final String couponCode;
    private final boolean giftWrap;
    private final String deliveryInstructions;
    private final LocalDateTime scheduledDeliveryTime;
    private final String specialNote;

    /*
    private constructor to enforce the use of builder
     */
    private Order(Builder builder) {
        this.orderId=builder.orderId;
        this.customerId=builder.customerId;
        this.restaurantId=builder.restaurantId;
        this.items=builder.items;
        this.couponCode=builder.couponCode;
        this.giftWrap=builder.giftWrap;
        this.deliveryInstructions=builder.deliveryInstructions;
        this.scheduledDeliveryTime=builder.scheduledDeliveryTime;
        this.specialNote=builder.specialNote;

    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public List<Items> getItems() {
        return items;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public LocalDateTime getScheduledDeliveryTime() {
        return scheduledDeliveryTime;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", restaurantId=" + restaurantId +
                ", items=" + items +
                ", couponCode='" + couponCode + '\'' +
                ", giftWrap=" + giftWrap +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                ", scheduledDeliveryTime=" + scheduledDeliveryTime +
                ", specialNote='" + specialNote + '\'' +
                '}';
    }

    public static class Builder {
        /*
        Imutable and mandatory properties:
         */
        private final Integer orderId;
        private final Integer customerId;
        private final Integer restaurantId;
        private final List<Items> items;

        /*
        non mandatory properties:
         */
        private String couponCode;
        private boolean giftWrap;
        private String deliveryInstructions;
        private LocalDateTime scheduledDeliveryTime;
        private String specialNote;

        public Builder(Integer orderId, Integer customerId, Integer restaurantId, List<Items> items) {
            if (orderId == null) {
                throw new IllegalArgumentException("orderId is mandatory");
            }

            if (customerId == null) {
                throw new IllegalArgumentException("customerId is mandatory");
            }

            if (restaurantId == null) {
                throw new IllegalArgumentException("restaurantId is mandatory");
            }

            if (items == null || items.isEmpty()) {
                throw new IllegalArgumentException("items is mandatory and cannot be empty");
            }

            this.orderId = orderId;
            this.customerId = customerId;
            this.restaurantId = restaurantId;
            this.items = items;
        }

        public Builder withCouponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Builder withGiftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public Builder withDeliveryInstructions(String deliveryInstructions) {
            this.deliveryInstructions = deliveryInstructions;
            return this;
        }

        public Builder withScheduledDeliveryTime(LocalDateTime scheduledDeliveryTime) {
            LocalDateTime now = LocalDateTime.now();
            if (scheduledDeliveryTime.isBefore(now)) {
                throw new IllegalArgumentException("scheduledDeliveryTime cannot be in the past");
            }
            this.scheduledDeliveryTime = scheduledDeliveryTime;
            return this;
        }

        public Builder withSpecialNote(String specialNote) {
            int length = specialNote.length();
            if (length > 200) {
                throw new IllegalArgumentException("specialNote cannot exceed 200 characters");
            }
            this.specialNote = specialNote;
            return this;
        }

            //final build method to create Order instance
            public Order build () {
                return new Order(this);
            }
    }
}
