package com.ncr.hackspre.model;

import com.google.gson.annotations.*;

public class OrderDetails {

    @SerializedName("ExtenalItedId")
    private int externItemId;

    @SerializedName("ItemName")
    private String itemName;

    @SerializedName("Quantity")
    private float quantity;

    @SerializedName("UnitPrice")
    private float unitPrice;

    @SerializedName("UnitSellPrice")
    private float unitSellPrice;

    @SerializedName("LineItemNotes")
    private String lineItemNotes;

    @SerializedName("SourceApplicationName")
    private String sourceApplicationName;


}
