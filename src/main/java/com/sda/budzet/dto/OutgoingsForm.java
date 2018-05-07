package com.sda.budzet.dto;


import java.time.LocalDate;

public class OutgoingsForm {

    private int outgoingsID;
    private int userID;
    private int categoryID;
    private String outgoingsName;
    private String addDate;
    private int outgoingsAmount;

    public int getOutgoingsID() {
        return outgoingsID;
    }

    public void setOutgoingsID(int outgoingsID) {
        this.outgoingsID = outgoingsID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

