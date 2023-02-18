
package com.apparel.model;

import javax.swing.Icon;


public class modelItem {

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the quality
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuantity(String quality) {
        this.quantity = quality;
    }
   
    
    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
    }
    

    public modelItem(String size, String quantity,int item, String itemName, String description, double price, String brandName, Icon image) {
        this.item = item;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.brandName = brandName;
        this.image = image;
        this.quantity = quantity;
        this.size = size;
    }
    private String size;
    private String quantity;
    private int item;
    private String itemName;
    private String description;
    private double price;
    private String brandName;
    private Icon image;
    
}
