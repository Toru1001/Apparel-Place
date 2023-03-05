
package com.apparel.model;

import javax.swing.Icon;

public class shipDetails {

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

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
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
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
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the totalPrice
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the timeOrder
     */
    public String getTimeOrder() {
        return timeOrder;
    }

    /**
     * @param timeOrder the timeOrder to set
     */
    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    /**
     * @return the estRecieveDate
     */
    public String getEstRecieveDate() {
        return estRecieveDate;
    }

    /**
     * @param estRecieveDate the estRecieveDate to set
     */
    public void setEstRecieveDate(String estRecieveDate) {
        this.estRecieveDate = estRecieveDate;
    }
    
   public shipDetails(String email,String firstname,String lastname,String address,String mobileNumber,String paymentMethod,String size,String quantity,String product,String description,String price,String totalPrice,String brand,Icon icon,String timeOrder,String estRecieveDate, String status){
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.paymentMethod = paymentMethod;
        this.size = size;
        this.quantity = quantity;
        this.product = product;
        this.description = description;
        this.price = price;
        this.totalPrice = totalPrice;
        this.brand = brand;
        this.icon = icon;
        this.timeOrder = timeOrder;
        this.estRecieveDate = estRecieveDate;
        this.status = status;
    }
   private String status;
   private String email;
   private String firstname;
   private String lastname;
   private String username;
   private String address;
   private String mobileNumber;
   private String paymentMethod;
   private String size;
   private String quantity;
   private String product;
   private String description;
   private String price;
   private String totalPrice;
   private String brand;
   private Icon icon;
   private String timeOrder;
   private String estRecieveDate;
}
