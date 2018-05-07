package com.sda.budzet.dto;

public class OutgoingsOutput {

    private String categoryName;
    private String outgoingsName;
    private int outgoingsAmount;
    private String addDate;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getOutgoingsName() {
        return outgoingsName;
    }

    public void setOutgoingsName(String outgoingsName) {
        this.outgoingsName = outgoingsName;
    }

    public int getOutgoingsAmount() {
        return outgoingsAmount;
    }

    public void setOutgoingsAmount(int outgoingsAmount) {
        this.outgoingsAmount = outgoingsAmount;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
