package org.example.orderObject.schema;

public class Items {

    //mandatory
    Integer itemId;
    String itemName;

    public Items(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + itemId +
                ", name='" + itemName + '\'' +
                '}';
    }








}

