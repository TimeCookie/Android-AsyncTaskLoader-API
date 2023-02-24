package com.example.lifecost;

public class Data {
    String itemName;
    String categoryName;
    String currency;
    String averagePrice;

    public Data(String itemName, String categoryName, String currency, String averagePrice) {
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.currency = currency;
        this.averagePrice = averagePrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }
}
