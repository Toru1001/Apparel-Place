/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apparel.model;

import javax.swing.Icon;


public class selectedItem {

    /**
     * @return the finderLocation
     */
    public String getFinderLocation() {
        return finderLocation;
    }

    /**
     * @param finderLocation the finderLocation to set
     */
    public void setFinderLocation(String finderLocation) {
        this.finderLocation = finderLocation;
    }

    /**
     * @return the img
     */
    public Icon getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Icon img) {
        this.img = img;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName; 
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemBrand
     */
    public String getItemBrand() {
        return itemBrand;
    }

    /**
     * @param itemBrand the itemBrand to set
     */
    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @param itemDescription the itemDescription to set
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * @return the itemPrice
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return the itemSize
     */
    public String getItemSize() {
        return itemSize;
    }

    /**
     * @param itemSize the itemSize to set
     */
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    /**
     * @return the itemQuantity
     */
    public String getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
        private String finderLocation;
        private String itemName;
        private String itemBrand;
        private String itemDescription;
        private int itemPrice;
        private String itemSize;
        private String itemQuantity; 
        private Icon img;
}
