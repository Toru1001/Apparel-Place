
package com.apparel.userLogin;


import com.apparel.component.apparelItem;
import com.apparel.component.apparelOrder;
import com.apparel.model.ScrollBar;
import com.apparel.model.modelItem;
import com.apparel.model.selectedItem;
import com.apparel.model.shipDetails;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.StringUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.IconUIResource;
import javax.swing.table.DefaultTableModel;

public class mainInterface extends javax.swing.JFrame {
    userLogIn login = new userLogIn();  
    selectedItem select = new selectedItem();
    int xMouse, yMouse;
    String next;
    
        public void changeCard(Component Card) {    // Changes to selected panel
        cardPanel.removeAll();
        cardPanel.add(Card);
        cardPanel.repaint();
        cardPanel.revalidate();
    }
        
        public void changeOrderCard(Component Card) {       // Changes to selected card panel in orders
        myOrdersCard.removeAll();
        myOrdersCard.add(Card);
        myOrdersCard.repaint();
        myOrdersCard.revalidate();
                
    }
    
        void showUser(){    //shows user info to profile and with other components
        login.info(next);
        userid.setText("User Id: " + login.userId);
        first_name.setText(login.firstname);
        last_name.setText(login.lastname);
        userName.setText(login.username);
        email_address.setText(login.email);
        local_address.setText(login.localaddress);
        mobile_number.setText(login.mobilenumber);
        passWord.setText(login.password);
        users_firstname.setText(login.firstname);
        users_firstname.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText.setText("WELCOME, " + login.firstname.toUpperCase() + "!");
        itemScrollBar.setVerticalScrollBar(new ScrollBar());
        cartScrollBar.setVerticalScrollBar(new ScrollBar());
    }
    
        void updateUser(){  // Method for updating the users info to database
        
        String userId = userid.getText();
        String upFirstName = first_name.getText();
        String upLastName = last_name.getText();
        String upUsername = userName.getText();
        String upEmail = email_address.getText();
        String upLocal = local_address.getText();
        String upMobile = mobile_number.getText();
        String upPass = new String (passWord.getText());
        try {
            login.prep = login.connect.prepareStatement("UPDATE user_logins SET `first_name` = '"+upFirstName+"', `last_name` = '"+upLastName+"', `username` = '"+upUsername+"', `email` = '"+upEmail+"', `mobile_number` = '"+upMobile+"', `password` = '"+upPass+"', `local_address` = '"+upLocal+"' WHERE `user_logins`.`username` = '" +login.username+"'");
                login.prep.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your account has been updated!");
                uneditted();
        } catch (SQLException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        void onClickPendingOrderTable() throws IOException, SQLException{                       // show selected table row data to Order Details
            DefaultTableModel tableModel = (DefaultTableModel) pendingOrderTable.getModel();
            int selectedIndex = pendingOrderTable.getSelectedRow();
            tableFullName.setText(tableModel.getValueAt(selectedIndex, 0).toString());
            tableAddress.setText(tableModel.getValueAt(selectedIndex, 1).toString());
            tableEmail.setText(tableModel.getValueAt(selectedIndex, 2).toString());
            tableMobileNumber.setText(tableModel.getValueAt(selectedIndex, 3).toString());
            tableOrderDate.setText(tableModel.getValueAt(selectedIndex, 9).toString());
            tableERD.setText(tableModel.getValueAt(selectedIndex, 10).toString());
            tableProduct.setText("<html><body><p align='justify'>"+tableModel.getValueAt(selectedIndex, 4).toString()+"</p></body></html>");
            tableSize.setText(tableModel.getValueAt(selectedIndex, 5).toString());
            tableQuantity.setText(tableModel.getValueAt(selectedIndex, 6).toString());
            tablePrice.setText(tableModel.getValueAt(selectedIndex, 7).toString());
            tableStatus.setText(tableModel.getValueAt(selectedIndex, 8).toString());
        }
        
        void onClickMessageTable() throws IOException, SQLException{
            DefaultTableModel tableModel = (DefaultTableModel) messageTable.getModel();
            int selectedIndex = messageTable.getSelectedRow();
            messName.setText(tableModel.getValueAt(selectedIndex, 0).toString());
            messEmail.setText(tableModel.getValueAt(selectedIndex, 1).toString());
            messNumber.setText(tableModel.getValueAt(selectedIndex, 2).toString());
            messStatus.setText(tableModel.getValueAt(selectedIndex, 5).toString());
            messSubject.setText("<html><body><p align='justify'>"+tableModel.getValueAt(selectedIndex, 3).toString()+"</p></body></html>");
            messText.setText("<html><body><p align='justify'>"+tableModel.getValueAt(selectedIndex, 4).toString()+"</p></body></html>");
            messDate.setText(tableModel.getValueAt(selectedIndex, 6).toString());
        }
    
        public void showBagItems(){     // displays bag items from database
        
        int ID = 1;
        for(int i = 0; i<=15; i++){
            try {
                
                login.prep = login.connect.prepareStatement("SELECT * FROM bagproducts where Id = '"+i+"'");
                login.rst = login.prep.executeQuery();
                
                while (login.rst.next()){
                   String id = login.rst.getString("Id");
                   String product = login.rst.getString("product");
                   String description = login.rst.getString("description");
                   int price = Integer.parseInt(login.rst.getString("price"));
                   String brand = login.rst.getString("brand");
                   String img = login.rst.getString("icon");
                   addItem(new modelItem(" ","--",ID++, product, description, price, brand, new ImageIcon(getClass().getResource(img))));
                    
                }   } catch (SQLException ex) {
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }}
    
        public void showClothesItems(){     //  shows clothes item from database
        
        int ID = 1;
        for(int i = 0; i<=15; i++){
            try {
                login.prep = login.connect.prepareStatement("SELECT * FROM clothesproduct where Id = '"+ID+"'");
                login.rst = login.prep.executeQuery();
                
                while (login.rst.next()){
                    String id = login.rst.getString("Id");
                    String product = login.rst.getString("product");
                    String description = login.rst.getString("description");
                    int price = Integer.parseInt(login.rst.getString("price"));
                    String brand = login.rst.getString("brand");
                    String img = login.rst.getString("icon");
                    addItem(new modelItem("--","--",ID++, product, description, price, brand, new ImageIcon(getClass().getResource(img))));
                    
                }   } catch (SQLException ex) { 
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        public void showFootwearItems (){    // shows footwear items from database
         int ID = 1;
          for(int i = 0; i<=15; i++){
              
            try {
                login.prep = login.connect.prepareStatement("SELECT * FROM footwearproducts where Id = '"+ID+"'");
                login.rst = login.prep.executeQuery();
                
                while (login.rst.next()){
                    String id = login.rst.getString("Id");
                    String product = login.rst.getString("product");
                    String description = login.rst.getString("description");
                    DecimalFormat df = new DecimalFormat("PHP #,##0.00");
                    int price = Integer.parseInt(login.rst.getString("price"));
                    String brand = login.rst.getString("brand");
                    String img = login.rst.getString("icon");
                    addItem(new modelItem("--","--",ID++, product, description, price, brand, new ImageIcon(getClass().getResource(img))));
                }   } catch (SQLException ex) {   
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
          }  
}
        
        public void showAccessoryItems(){       //  shows accessory item from database
        
        int ID = 1;
        for(int i = 0; i<=15; i++){
            try {
                login.prep = login.connect.prepareStatement("SELECT * FROM accessoriesproducts where Id = '"+ID+"'");
                login.rst = login.prep.executeQuery();
                
                while (login.rst.next()){
                    String id = login.rst.getString("Id");
                    String product = login.rst.getString("product");
                    String description = login.rst.getString("description");
                    DecimalFormat df = new DecimalFormat("PHP #,##0.00");
                    int price = Integer.parseInt(login.rst.getString("price"));
                    String brand = login.rst.getString("brand");
                    String img = login.rst.getString("icon");
                    addItem(new modelItem(" ","--",ID++, product, description, price, brand, new ImageIcon(getClass().getResource(img))));
                    
                }   } catch (SQLException ex) {   
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        public void showCart(){     //  displays cart items from database cartitems
            
            int ID = 1;
            try {
                login.prep = login.connect.prepareStatement("SELECT * FROM cartitems where userEmail = '"+login.email+"'");
                login.rst = login.prep.executeQuery();
                
                while (login.rst.next()){
                    String size = login.rst.getString("size");
                    String quantity = login.rst.getString("quantity");
                    String product = login.rst.getString("product");
                    String description = login.rst.getString("description");
                    int price = Integer.parseInt(login.rst.getString("price"));
                    String brand = login.rst.getString("brand");
                    String img = login.rst.getString("icon");
                    addtocartItem(new modelItem(size,quantity,ID++, product, description, price, brand, new ImageIcon(getClass().getResource(img))));
                }   
            } catch (SQLException ex) {   
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public void showToShip(){              // Displays products to "to Ship" panel from database
        try {
            login.prep = login.connect.prepareStatement("SELECT * FROM toshipitems where email = '"+login.email+"' AND status = 'To Ship'");
            login.rst = login.prep.executeQuery();
            while(login.rst.next()){
            String email = login.rst.getString("email");
            String firstname = login.rst.getString("firstname");
            String lastname = login.rst.getString("lastname");
            String address = login.rst.getString("address");
            String mobileNumber = login.rst.getString("mobileNumber");
            String paymentMethod = login.rst.getString("paymentMethod");
            String size = login.rst.getString("size");
            String quantity = login.rst.getString("quantity");
            String product = login.rst.getString("product");
            String description = login.rst.getString("description");
            String price = login.rst.getString("price");
            String totalPrice = login.rst.getString("totalPrice");
            String brand = login.rst.getString("brand");
            String icon = login.rst.getString("icon");
            String timeOrder = login.rst.getString("timeOrder");
            String estRecieveDate = login.rst.getString("estRecieveDate");
            String status = login.rst.getString("status");
            select.setFinderLocation(timeOrder);
            userorderUpdate.setVisible(false);
            addItemtoShip(new shipDetails(email, firstname, lastname,address, mobileNumber, paymentMethod, size, quantity, product,description, price, totalPrice, brand, new ImageIcon(getClass().getResource(icon)),timeOrder, estRecieveDate, status));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void showToRecieve(){        // Displays products to "to Recieve" panel from database
        try {
            login.prep = login.connect.prepareStatement("SELECT * FROM toshipitems where email = '"+login.email+"' AND status = 'To Recieve' OR status = 'Waiting Seller Confirmation'");
            login.rst = login.prep.executeQuery();
            while(login.rst.next()){
            String email = login.rst.getString("email");
            String firstname = login.rst.getString("firstname");
            String lastname = login.rst.getString("lastname");
            String address = login.rst.getString("address");
            String mobileNumber = login.rst.getString("mobileNumber");
            String paymentMethod = login.rst.getString("paymentMethod");
            String size = login.rst.getString("size");
            String quantity = login.rst.getString("quantity");
            String product = login.rst.getString("product");
            String description = login.rst.getString("description");
            String price = login.rst.getString("price");
            String totalPrice = login.rst.getString("totalPrice");
            String brand = login.rst.getString("brand");
            String icon = login.rst.getString("icon");
            String timeOrder = login.rst.getString("timeOrder");
            String estRecieveDate = login.rst.getString("estRecieveDate");
            String status = login.rst.getString("status");
            userorderUpdate.setVisible(false);
            addItemtoRecieve(new shipDetails(email, firstname, lastname,address, mobileNumber, paymentMethod, size, quantity, product,description, price, totalPrice, brand, new ImageIcon(getClass().getResource(icon)),timeOrder, estRecieveDate, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void showRecieved(){         // Displays products to "Recieved" panel from database
        try {
            login.prep = login.connect.prepareStatement("SELECT * FROM toshipitems where email = '"+login.email+"' AND status = 'Recieved'");
            login.rst = login.prep.executeQuery();
            while(login.rst.next()){
            String email = login.rst.getString("email");
            String firstname = login.rst.getString("firstname");
            String lastname = login.rst.getString("lastname");
            String address = login.rst.getString("address");
            String mobileNumber = login.rst.getString("mobileNumber");
            String paymentMethod = login.rst.getString("paymentMethod");
            String size = login.rst.getString("size");
            String quantity = login.rst.getString("quantity");
            String product = login.rst.getString("product");
            String description = login.rst.getString("description");
            String price = login.rst.getString("price");
            String totalPrice = login.rst.getString("totalPrice");
            String brand = login.rst.getString("brand");
            String icon = login.rst.getString("icon");
            String timeOrder = login.rst.getString("timeOrder");
            String estRecieveDate = login.rst.getString("estRecieveDate");
            String status = login.rst.getString("status");
            userorderUpdate.setVisible(false);
            addItemRecieved(new shipDetails(email, firstname, lastname,address, mobileNumber, paymentMethod, size, quantity, product,description, price, totalPrice, brand, new ImageIcon(getClass().getResource(icon)),timeOrder, estRecieveDate, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
        public void uneditted(){        //  sets JtextField to unedditable from profile
            first_name.setEditable(false);
            last_name.setEditable(false);
            userName.setEditable(false);
            email_address.setEditable(false);
            local_address.setEditable(false);
            mobile_number.setEditable(false);
            passWord.setEditable(false);
        }
        
        public void edittable(){            // sets JtextField to edittable from profile
            first_name.setEditable(true);
            last_name.setEditable(true);
            userName.setEditable(true);
            email_address.setEditable(true);
            local_address.setEditable(true);
            mobile_number.setEditable(true);
            passWord.setEditable(true);
        }
        
        public void clearAllProducts(){     //  clears the products that is previously added to the itemPanel
        panelItem1.removeAll();
        panelItem1.repaint();
        panelItem1.revalidate();
        panelItem2.removeAll();
        panelItem2.repaint();
        panelItem2.revalidate();
        panelItem3.removeAll();
        panelItem3.repaint();
        panelItem3.revalidate();
        panelItem4.removeAll();
        panelItem4.repaint();
        panelItem4.revalidate();
        panelItem5.removeAll();
        panelItem5.repaint();
        panelItem5.revalidate();
    }
    
        public void addItem(modelItem data){        //  method for gaining data that was encapsulated and is used for adding the products to itemPanel
        apparelItem item = new apparelItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                   select.setItemName(data.getItemName());
                   select.setItemBrand(data.getBrandName());
                   select.setImg(data.getImage());
                   select.setItemPrice((int) data.getPrice());
                   select.setItemDescription(data.getDescription());
                   select.setItemSize(data.getSize());
                   select.setItemQuantity(data.getQuantity());
                   selectedItems();
                }
            }
        });
        panelItem1.add(item);
        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
        public void addtocartItem(modelItem data){      //  method for gaining data that was encapsulated and also setting new data that is
        apparelItem item = new apparelItem();           //  selected and is used for adding the products to add to cart itemPanel
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                   select.setItemName(data.getItemName());
                   select.setItemBrand(data.getBrandName());
                   select.setImg(data.getImage());
                   select.setItemPrice((int) data.getPrice());
                   select.setItemDescription(data.getDescription());
                   selectedItems();
                }
            }
        });
        panelItem2.add(item);
        panelItem2.repaint();
        panelItem2.revalidate();
    }
        
         public void addItemtoShip(shipDetails data){            //  auto generate to ship products to the item panel 
        apparelOrder item = new apparelOrder();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                  productDetails.setText("<html><body><p align='justify'>"+data.getDescription()+"</p></body></html>");
                  productTotalPrice.setText(data.getTotalPrice());
                  fullName.setText(data.getFirstname() + " " + data.getLastname());
                  localAddress.setText(data.getAddress());
                  orderDate.setText("Contact Number: " + data.getMobileNumber());
                  paymentMethod.setText(data.getPaymentMethod());
                  orderDate.setText(data.getTimeOrder());
                  estimateDate.setText("Estimated Date of Arrival: " + data.getEstRecieveDate());
                  mobileNumber.setText("Mobile Number: " + data.getMobileNumber());
                  status.setText("Status: " + data.getStatus());
                  if(data.getStatus().equals("To Ship")){
                  userorderUpdate.setVisible(false);
                  }
                }
            }
        });
        panelItem3.add(item);
        panelItem3.repaint();
        panelItem3.revalidate();
    }
         
        public void addItemtoRecieve(shipDetails data){             //  auto generate to recieve products to the item panel
        apparelOrder item = new apparelOrder();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                  productDetails.setText("<html><body><p align='justify'>"+data.getDescription()+"</p></body></html>");
                  productTotalPrice.setText(data.getTotalPrice());
                  fullName.setText(data.getFirstname() + " " + data.getLastname());
                  localAddress.setText(data.getAddress());
                  orderDate.setText("Contact Number: " + data.getMobileNumber());
                  paymentMethod.setText(data.getPaymentMethod());
                  orderDate.setText(data.getTimeOrder());
                  estimateDate.setText("Estimated Date of Arrival: " + data.getEstRecieveDate());
                  mobileNumber.setText("Mobile Number: " + data.getMobileNumber());
                  status.setText("Status: " + data.getStatus());
                  if(data.getStatus().equals("To Recieve")){
                  userorderUpdate.setVisible(true);
                  }
                }
            }
        });
        panelItem4.add(item);
        panelItem4.repaint();
        panelItem4.revalidate();
    }
        
        public void addItemRecieved(shipDetails data){          //  auto generate to Recieved products to the item panel
        apparelOrder item = new apparelOrder();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                    productDetails.setText("<html><body><p align='justify'>"+data.getDescription()+"</p></body></html>");
                  productTotalPrice.setText(data.getTotalPrice());
                  fullName.setText(data.getFirstname() + " " + data.getLastname());
                  localAddress.setText(data.getAddress());
                  orderDate.setText("Contact Number: " + data.getMobileNumber());
                  paymentMethod.setText(data.getPaymentMethod());
                  orderDate.setText(data.getTimeOrder());
                  estimateDate.setText("Estimated Date of Arrival: " + data.getEstRecieveDate());
                  mobileNumber.setText("Mobile Number: " + data.getMobileNumber());
                  status.setText("Status: " + data.getStatus());
                  if(data.getStatus().equals("Recieved")){
                  userorderUpdate.setVisible(false);
                  }
                }
            }
        });
        panelItem5.add(item);
        panelItem5.repaint();
        panelItem5.revalidate();
    }
     
        public void selectedItems(){            // sets the selected data to the side panel of items
        pic.setImage(select.getImg());
        lbItemName.setText(select.getItemName());
        lbBrand.setText(select.getItemBrand());
        lbDescription.setText(select.getItemDescription());
        lbPrice.setText("PHP "+ Integer.toString(select.getItemPrice())+".00");
        items.repaint();
        items.revalidate();
    }
        
        public void toShip(){           //  Insert/ Update from "cartitems" products to "toshipitems"  
        try {
            
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime newDateTime = localDateTime.plusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter estformatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            String dateTime = localDateTime.format(estformatter);
            String estDateTime = newDateTime.format(formatter);
            login.prep = login.connect.prepareStatement("SELECT * FROM cartitems WHERE userEmail = '"+login.email+"'");
            login.rst = login.prep.executeQuery();
            ArrayList<String> str = new ArrayList<>();
            ArrayList<String> size = new ArrayList<>();
            ArrayList<String> quantity = new ArrayList<>();
            while(login.rst.next()){
                select.setItemSize(login.rst.getString("size"));
                select.setItemQuantity(login.rst.getString("quantity"));
                select.setItemName(login.rst.getString("product"));
                select.setItemDescription(login.rst.getString("description"));
                select.setItemPrice(Integer.parseInt(login.rst.getString("price")));
                select.setItemBrand(login.rst.getString("brand"));
                select.setFinderLocation(login.rst.getString("icon"));
                str.add(select.getItemBrand()+ " " + select.getItemName() + " " + select.getItemQuantity()+ "x Size: " + select.getItemSize());
                size.add(select.getItemSize());
                quantity.add(select.getItemQuantity());
            }   
                login.prep = login.connect.prepareStatement("INSERT INTO toshipitems(email,firstname, lastname, username, address, mobileNumber, size, quantity, product, description, price, totalPrice, brand, icon, timeOrder, estRecieveDate, paymentMethod,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                login.prep.setString(1, login.email);
                login.prep.setString(2, login.firstname);
                login.prep.setString(3, login.lastname);
                login.prep.setString(4, login.username);
                login.prep.setString(5, login.localaddress);
                login.prep.setString(6, login.mobilenumber);
                login.prep.setString(7, ""+String.join(", ", size)+"");
                login.prep.setString(8, ""+String.join(", ", quantity)+"");
                login.prep.setString(9, select.getItemName());
                login.prep.setString(10, ""+String.join(", ", str)+"");
                login.prep.setString(11, Integer.toString(select.getItemPrice()));
                login.prep.setString(12, totalAmount.getText());
                login.prep.setString(13, select.getItemBrand());
                login.prep.setString(14, select.getFinderLocation());
                login.prep.setString(15, dateTime);
                login.prep.setString(16, estDateTime);
                login.prep.setString(17, "Cash On Delivery");
                login.prep.setString(18, "To Ship");
                login.prep.executeUpdate();
                str.clear();
                size.clear();
                quantity.clear();
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
        public void findImageLoc(){         //  finds the icon location from the database all_items
        try {
            
            String finderDescription = select.getItemDescription();
            
            login.prep = login.connect.prepareStatement("SELECT * FROM all_items WHERE description = '"+ finderDescription +"';");
            login.rst = login.prep.executeQuery();
            
            while (login.rst.next()){
                String imageLoc = login.rst.getString("icon");
                select.setFinderLocation(imageLoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
        
        public void totalCartPrice(){                           //  gets the total price of products inside the cart
        ArrayList<Integer> prices = new ArrayList();
        DecimalFormat df = new DecimalFormat("#, ###");
        totalPrice.setText("0.00");
        totalAmount.setText("PHP 0.00");
        try {
        login.prep = login.connect.prepareStatement("SELECT * FROM cartitems where userEmail = '"+ login.email +"'");
         login.rst = login.prep.executeQuery();
           while(login.rst.next()){
               int price;
               int quantity;
                price = Integer.parseInt(login.rst.getString("price"));
                quantity = Integer.parseInt(login.rst.getString("quantity"));
                price = price * quantity;
                
                if(price >100){
                prices.add(price);
                int prevValue;
                prevValue= prices.get(0);
            if(prices.size() < 1){
               totalPrice.setText("0.00");
               totalAmount.setText("PHP 0.00");
            } else if(prices.size() == 1){
               totalPrice.setText(df.format(prevValue) + ".00");
               totalAmount.setText("PHP " + df.format(prevValue + 100) + ".00");

            } else if (prices.size() > 1){
                
                for(int i = 1; i<prices.size();i++){
               int price1 = prevValue + prices.get(i);
               prevValue = price1;
               totalPrice.setText(df.format(price1) + ".00");
               totalAmount.setText("PHP " + df.format(price1 + 100) + ".00");
           } }}}
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void setRemoveData(){       // sets previously selected data to default
            select.setItemBrand(null);
            select.setImg(null);
            select.setItemDescription(null);
            select.setItemName(null);
            select.setItemPrice(0);
            lbQuantity.setText("1");
            select.setItemSize(null);
        }
        
        public void updateTable(JTable pendingOrderTable) throws SQLException{          //  updates/shows the admin table from the toshipitems data inside the database
            
        try {
            login.prep = login.connect.prepareStatement("SELECT * FROM toshipitems");
            login.rst = login.prep.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) pendingOrderTable.getModel();
                tableModel.setRowCount(0);
            while(login.rst.next()){
                Vector<String> row = new Vector<String>();
                
                String firstname = login.rst.getString("firstname");
                String lastname = login.rst.getString("lastname");
                row.add(firstname + " " + lastname);
                row.add(login.rst.getString("address"));
                row.add(login.rst.getString("email"));
                row.add(login.rst.getString("mobileNumber"));
                row.add(login.rst.getString("description"));
                row.add(login.rst.getString("size"));
                row.add(login.rst.getString("quantity"));
                row.add(login.rst.getString("totalPrice"));
                row.add(login.rst.getString("status"));
                row.add(login.rst.getString("timeOrder"));
                row.add(login.rst.getString("estRecieveDate"));
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
        public void updateMessageTable(JTable messageTable) throws SQLException{
            login.prep = login.connect.prepareStatement("SELECT * FROM usermessage");
            login.rst = login.prep.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) messageTable.getModel();
                tableModel.setRowCount(0);
            while(login.rst.next()){
                Vector<String> row = new Vector<String>();
                row.add(login.rst.getString("fullName"));
                row.add(login.rst.getString("email"));
                row.add(login.rst.getString("mobileNumber"));
                row.add(login.rst.getString("subject"));
                row.add(login.rst.getString("message"));
                row.add(login.rst.getString("status"));
                row.add(login.rst.getString("messageDate"));
                tableModel.addRow(row);
                acknowledgedButton.setVisible(false);
            }
        }
        
     public mainInterface() {
        initComponents();
        showUser(); // With other components
        pendingOrdersButtton.setVisible(false);
        if(login.username.equals("admin")){
            cartButton.setVisible(false);
            myOrdersButton.setVisible(false);
            pendingOrdersButtton.setVisible(true);
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        sidePanel = new keeptoo.KGradientPanel();
        myOrdersButton = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        pictureBox10 = new com.apparel.model.pictureBox();
        productButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pictureBox5 = new com.apparel.model.pictureBox();
        accountButton = new javax.swing.JPanel();
        users_firstname = new javax.swing.JLabel();
        pictureBox7 = new com.apparel.model.pictureBox();
        homeButton = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        pictureBox6 = new com.apparel.model.pictureBox();
        cartButton = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pictureBox9 = new com.apparel.model.pictureBox();
        pictureBox20 = new com.apparel.model.pictureBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        logo = new com.apparel.model.pictureBox();
        pendingOrdersButtton = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        pictureBox21 = new com.apparel.model.pictureBox();
        messageButton = new javax.swing.JPanel();
        pictureBox23 = new com.apparel.model.pictureBox();
        cardPanel = new javax.swing.JPanel();
        homepage = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        welcomeText = new javax.swing.JLabel();
        shopButton = new RoundedPanel(50, new Color(153,0,204));
        jLabel2 = new javax.swing.JLabel();
        pictureBox14 = new com.apparel.model.pictureBox();
        pictureBox15 = new com.apparel.model.pictureBox();
        jLabel15 = new javax.swing.JLabel();
        pictureBox8 = new com.apparel.model.pictureBox();
        pictureBox13 = new com.apparel.model.pictureBox();
        products = new javax.swing.JPanel();
        bagsButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pictureBox1 = new com.apparel.model.pictureBox();
        clothesButton = new javax.swing.JPanel();
        pictureBox12 = new com.apparel.model.pictureBox();
        jLabel4 = new javax.swing.JLabel();
        footwearButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pictureBox2 = new com.apparel.model.pictureBox();
        accessoriesButton = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pictureBox3 = new com.apparel.model.pictureBox();
        profile = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        pictureBox4 = new com.apparel.model.pictureBox();
        pictureBox11 = new com.apparel.model.pictureBox();
        jPanel2 = new RoundedPanel(50,new Color(204,153,255));
        jLabel7 = new javax.swing.JLabel();
        first_name = new javax.swing.JTextField();
        jlabel = new javax.swing.JLabel();
        last_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        local_address = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        email_address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        mobile_number = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        passWord = new javax.swing.JPasswordField();
        userid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        saveEdit = new javax.swing.JButton();
        cart = new javax.swing.JPanel();
        cartScrollBar = new javax.swing.JScrollPane();
        panelItem2 = new com.apparel.model.PanelItem();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        note1 = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pictureBox17 = new com.apparel.model.pictureBox();
        note2 = new javax.swing.JLabel();
        shipoutButton = new javax.swing.JPanel();
        pictureBox18 = new com.apparel.model.pictureBox();
        note3 = new javax.swing.JLabel();
        removeItem = new javax.swing.JPanel();
        pictureBox19 = new com.apparel.model.pictureBox();
        note4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        totalAmount1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        items = new javax.swing.JPanel();
        itemScrollBar = new javax.swing.JScrollPane();
        panelItem1 = new com.apparel.model.PanelItem();
        lbItemName = new javax.swing.JLabel();
        pic = new com.apparel.model.pictureBox();
        jLabel16 = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        size1 = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JTextField();
        addtoCart = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pictureBox16 = new com.apparel.model.pictureBox();
        clothesSize = new javax.swing.JComboBox<>();
        shoesSize = new javax.swing.JComboBox<>();
        myOrders = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        toRecieveButton = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        shipOutButton = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        recievedButton = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        myOrdersCard = new javax.swing.JPanel();
        toShipPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelItem3 = new com.apparel.model.PanelItem();
        toRecievePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelItem4 = new com.apparel.model.PanelItem();
        recieved = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelItem5 = new com.apparel.model.PanelItem();
        jLabel32 = new javax.swing.JLabel();
        productDetails = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        note5 = new javax.swing.JLabel();
        productTotalPrice = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        fullName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        localAddress = new javax.swing.JLabel();
        mobileNumber = new javax.swing.JLabel();
        paymentMethod = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        estimateDate = new javax.swing.JLabel();
        orderDate1 = new javax.swing.JLabel();
        orderDate = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        userorderUpdate = new javax.swing.JButton();
        pendingOrders = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendingOrderTable = new javax.swing.JTable();
        jPanel4 = new RoundedPanel(50,new Color(204,204,204));
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        tableFullName = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tableAddress = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        tableEmail = new javax.swing.JLabel();
        tableMobileNumber = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        tableOrderDate = new javax.swing.JLabel();
        tableERD = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tableProduct = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tableSize = new javax.swing.JLabel();
        tableQuantity = new javax.swing.JLabel();
        tablePrice = new javax.swing.JLabel();
        tableStatus = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        updateStatus = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        updateStatusRecieve = new javax.swing.JButton();
        userMessage = new javax.swing.JPanel();
        jPanel5 = new RoundedPanel(50,new Color(204,204,204));
        jLabel48 = new javax.swing.JLabel();
        messageFullName = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        messageEmail = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        messageMobileNumber = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        messageSubject = new javax.swing.JTextArea();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        adminMessages = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();
        jPanel7 = new RoundedPanel(50,new Color(204,204,204));
        jLabel49 = new javax.swing.JLabel();
        messDate = new javax.swing.JLabel();
        messStatus = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        messText = new javax.swing.JLabel();
        messEmail = new javax.swing.JLabel();
        messNumber = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        messName = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        messSubject = new javax.swing.JLabel();
        acknowledgedButton = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1275, 730));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlePanel.setBackground(new java.awt.Color(204, 153, 255));
        titlePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlePanelMouseDragged(evt);
            }
        });
        titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlePanelMousePressed(evt);
            }
        });
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px_1.png"))); // NOI18N
        closeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeButtonMouseReleased(evt);
            }
        });
        titlePanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1233, 6, -1, -1));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px_1.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseReleased(evt);
            }
        });
        titlePanel.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1195, 6, 32, -1));

        getContentPane().add(titlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setkEndColor(new java.awt.Color(204, 204, 204));
        sidePanel.setkStartColor(new java.awt.Color(204, 204, 204));

        myOrdersButton.setBackground(new java.awt.Color(204, 204, 204));
        myOrdersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myOrdersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myOrdersButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myOrdersButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myOrdersButtonMouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("My Orders");

        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png"))); // NOI18N

        javax.swing.GroupLayout myOrdersButtonLayout = new javax.swing.GroupLayout(myOrdersButton);
        myOrdersButton.setLayout(myOrdersButtonLayout);
        myOrdersButtonLayout.setHorizontalGroup(
            myOrdersButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myOrdersButtonLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(myOrdersButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myOrdersButtonLayout.createSequentialGroup()
                        .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myOrdersButtonLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addContainerGap())))
        );
        myOrdersButtonLayout.setVerticalGroup(
            myOrdersButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myOrdersButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29))
        );

        productButton.setBackground(new java.awt.Color(204, 204, 204));
        productButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productButton.setPreferredSize(new java.awt.Dimension(175, 117));
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("PRODUCTS");

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px_1.png"))); // NOI18N

        javax.swing.GroupLayout productButtonLayout = new javax.swing.GroupLayout(productButton);
        productButton.setLayout(productButtonLayout);
        productButtonLayout.setHorizontalGroup(
            productButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productButtonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        productButtonLayout.setVerticalGroup(
            productButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        accountButton.setBackground(new java.awt.Color(204, 204, 204));
        accountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountButton.setPreferredSize(new java.awt.Dimension(175, 118));
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonMouseExited(evt);
            }
        });

        users_firstname.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        users_firstname.setForeground(new java.awt.Color(51, 51, 51));
        users_firstname.setText("ACCOUNT");
        users_firstname.setAlignmentX(Component.RIGHT_ALIGNMENT);
        users_firstname.setToolTipText("");

        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Test_Account_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout accountButtonLayout = new javax.swing.GroupLayout(accountButton);
        accountButton.setLayout(accountButtonLayout);
        accountButtonLayout.setHorizontalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(users_firstname, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );
        accountButtonLayout.setVerticalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountButtonLayout.createSequentialGroup()
                .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users_firstname)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setPreferredSize(new java.awt.Dimension(175, 117));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("HOMEPAGE");

        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_home_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout homeButtonLayout = new javax.swing.GroupLayout(homeButton);
        homeButton.setLayout(homeButtonLayout);
        homeButtonLayout.setHorizontalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeButtonLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeButtonLayout.createSequentialGroup()
                        .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        homeButtonLayout.setVerticalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        cartButton.setBackground(new java.awt.Color(204, 204, 204));
        cartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartButton.setPreferredSize(new java.awt.Dimension(175, 117));
        cartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartButtonMouseReleased(evt);
            }
        });
        cartButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("CART");
        cartButton.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 67, -1, -1));

        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px_1.png"))); // NOI18N

        pictureBox20.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png"))); // NOI18N
        pictureBox9.add(pictureBox20);
        pictureBox20.setBounds(0, 0, 0, 0);

        cartButton.add(pictureBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 8, 58, 53));

        jLabel6.setFont(new java.awt.Font("Inter ExtraBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("APPAREL");

        jLabel17.setFont(new java.awt.Font("Impact", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("-------------------");

        jLabel9.setFont(new java.awt.Font("Inter ExtraBold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("PLACE");

        logo.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/APPAREL PLACE LOGO(small).png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        pendingOrdersButtton.setBackground(new java.awt.Color(204, 204, 204));
        pendingOrdersButtton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pendingOrdersButtton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingOrdersButttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pendingOrdersButttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pendingOrdersButttonMouseExited(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Pending Orders");

        pictureBox21.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png"))); // NOI18N

        javax.swing.GroupLayout pendingOrdersButttonLayout = new javax.swing.GroupLayout(pendingOrdersButtton);
        pendingOrdersButtton.setLayout(pendingOrdersButttonLayout);
        pendingOrdersButttonLayout.setHorizontalGroup(
            pendingOrdersButttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersButttonLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pictureBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendingOrdersButttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pendingOrdersButttonLayout.setVerticalGroup(
            pendingOrdersButttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersButttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox21, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(12, 12, 12))
        );

        messageButton.setBackground(new java.awt.Color(204, 204, 204));
        messageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                messageButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                messageButtonMouseExited(evt);
            }
        });

        pictureBox23.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_forward_message_30px.png"))); // NOI18N

        javax.swing.GroupLayout messageButtonLayout = new javax.swing.GroupLayout(messageButton);
        messageButton.setLayout(messageButtonLayout);
        messageButtonLayout.setHorizontalGroup(
            messageButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        messageButtonLayout.setVerticalGroup(
            messageButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel17)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(150, 150, 150)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingOrdersButtton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(messageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pendingOrdersButtton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(myOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(messageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1280, 90));

        cardPanel.setLayout(new java.awt.CardLayout());

        homepage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Inter ExtraLight", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 255));
        jLabel23.setText("WEAR BETTER, LOOK BETTER.");

        welcomeText.setFont(new java.awt.Font("Inter ExtraBold", 0, 36)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(153, 0, 204));
        welcomeText.setText("WELCOME,");

        shopButton.setBackground(new java.awt.Color(255, 255, 255));
        shopButton.setForeground(new java.awt.Color(204, 102, 255));
        shopButton.setToolTipText("");
        shopButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shopButtonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Inter Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("SHOP NOW");

        javax.swing.GroupLayout shopButtonLayout = new javax.swing.GroupLayout(shopButton);
        shopButton.setLayout(shopButtonLayout);
        shopButtonLayout.setHorizontalGroup(
            shopButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopButtonLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        shopButtonLayout.setVerticalGroup(
            shopButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopButtonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pictureBox14.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/Ultra Light Down.jpg"))); // NOI18N

        pictureBox15.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/City Streetstyle.jpg"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Inter Light", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 204));
        jLabel15.setText("BE YOUR OWN LABEL.");

        pictureBox8.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/download.jpg"))); // NOI18N

        pictureBox13.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/mens clothes.jpg"))); // NOI18N

        javax.swing.GroupLayout homepageLayout = new javax.swing.GroupLayout(homepage);
        homepage.setLayout(homepageLayout);
        homepageLayout.setHorizontalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageLayout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(homepageLayout.createSequentialGroup()
                .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homepageLayout.createSequentialGroup()
                                .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(homepageLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(pictureBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homepageLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(homepageLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pictureBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pictureBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
        );
        homepageLayout.setVerticalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel23)
                .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pictureBox8, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(pictureBox13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
        );

        cardPanel.add(homepage, "card3");

        products.setBackground(new java.awt.Color(255, 255, 255));

        bagsButton.setBackground(new java.awt.Color(204, 204, 204));
        bagsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bagsButton.setForeground(new java.awt.Color(204, 102, 255));
        bagsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bagsButton.setPreferredSize(new java.awt.Dimension(200, 300));
        bagsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bagsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bagsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bagsButtonMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("BAGS");

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Bag_90px.png"))); // NOI18N

        javax.swing.GroupLayout bagsButtonLayout = new javax.swing.GroupLayout(bagsButton);
        bagsButton.setLayout(bagsButtonLayout);
        bagsButtonLayout.setHorizontalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagsButtonLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagsButtonLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)))
                .addGap(24, 24, 24))
        );
        bagsButtonLayout.setVerticalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bagsButtonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        clothesButton.setBackground(new java.awt.Color(204, 204, 204));
        clothesButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        clothesButton.setForeground(new java.awt.Color(102, 102, 102));
        clothesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clothesButton.setPreferredSize(new java.awt.Dimension(200, 300));
        clothesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clothesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clothesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clothesButtonMouseExited(evt);
            }
        });

        pictureBox12.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CLOTHES");

        javax.swing.GroupLayout clothesButtonLayout = new javax.swing.GroupLayout(clothesButton);
        clothesButton.setLayout(clothesButtonLayout);
        clothesButtonLayout.setHorizontalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesButtonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clothesButtonLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        clothesButtonLayout.setVerticalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesButtonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        footwearButton.setBackground(new java.awt.Color(204, 204, 204));
        footwearButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        footwearButton.setForeground(new java.awt.Color(102, 102, 102));
        footwearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footwearButton.setPreferredSize(new java.awt.Dimension(200, 300));
        footwearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footwearButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                footwearButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                footwearButtonMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("FOOTWEAR");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px_1.png"))); // NOI18N

        javax.swing.GroupLayout footwearButtonLayout = new javax.swing.GroupLayout(footwearButton);
        footwearButton.setLayout(footwearButtonLayout);
        footwearButtonLayout.setHorizontalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGroup(footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(footwearButtonLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(footwearButtonLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        footwearButtonLayout.setVerticalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        accessoriesButton.setBackground(new java.awt.Color(204, 204, 204));
        accessoriesButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        accessoriesButton.setForeground(new java.awt.Color(102, 102, 102));
        accessoriesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accessoriesButton.setPreferredSize(new java.awt.Dimension(200, 300));
        accessoriesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accessoriesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accessoriesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accessoriesButtonMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ACCESSORIES");

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px_1.png"))); // NOI18N

        javax.swing.GroupLayout accessoriesButtonLayout = new javax.swing.GroupLayout(accessoriesButton);
        accessoriesButton.setLayout(accessoriesButtonLayout);
        accessoriesButtonLayout.setHorizontalGroup(
            accessoriesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessoriesButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessoriesButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        accessoriesButtonLayout.setVerticalGroup(
            accessoriesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessoriesButtonLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout productsLayout = new javax.swing.GroupLayout(products);
        products.setLayout(productsLayout);
        productsLayout.setHorizontalGroup(
            productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(bagsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(clothesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(footwearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(accessoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        productsLayout.setVerticalGroup(
            productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accessoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bagsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(footwearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clothesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        cardPanel.add(products, "card2");

        profile.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel22.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("PROFILE");

        logOutButton.setBackground(new java.awt.Color(153, 0, 153));
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logOutButtonMouseReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("LOG - OUT");

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Login_70px.png"))); // NOI18N

        javax.swing.GroupLayout logOutButtonLayout = new javax.swing.GroupLayout(logOutButton);
        logOutButton.setLayout(logOutButtonLayout);
        logOutButtonLayout.setHorizontalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        logOutButtonLayout.setVerticalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logOutButtonLayout.createSequentialGroup()
                        .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pictureBox11.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_account_80px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 941, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("First Name");

        first_name.setBackground(new java.awt.Color(204, 204, 204));
        first_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        first_name.setForeground(new java.awt.Color(51, 51, 51));
        first_name.setText("Marcus");

        jlabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jlabel.setForeground(new java.awt.Color(51, 51, 51));
        jlabel.setText("Last Name");

        last_name.setBackground(new java.awt.Color(204, 204, 204));
        last_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        last_name.setForeground(new java.awt.Color(51, 51, 51));
        last_name.setText("Garcia");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Username");

        userName.setBackground(new java.awt.Color(204, 204, 204));
        userName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        userName.setForeground(new java.awt.Color(51, 51, 51));
        userName.setText("johan13");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Email");

        local_address.setBackground(new java.awt.Color(204, 204, 204));
        local_address.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        local_address.setForeground(new java.awt.Color(51, 51, 51));
        local_address.setText("29 San Pablo Street, Matina Aplaya, Davao City");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Local Address");

        email_address.setBackground(new java.awt.Color(204, 204, 204));
        email_address.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        email_address.setForeground(new java.awt.Color(51, 51, 51));
        email_address.setText("garciamarcusjohan@gmail.com");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Mobile Number");

        mobile_number.setBackground(new java.awt.Color(204, 204, 204));
        mobile_number.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        mobile_number.setForeground(new java.awt.Color(51, 51, 51));
        mobile_number.setText("09103627797");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Password");

        passWord.setBackground(new java.awt.Color(204, 204, 204));
        passWord.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        passWord.setForeground(new java.awt.Color(51, 51, 51));
        passWord.setText("test123");

        userid.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        userid.setForeground(new java.awt.Color(51, 51, 51));
        userid.setText("User Id:");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        saveEdit.setBackground(new java.awt.Color(204, 204, 204));
        saveEdit.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        saveEdit.setForeground(new java.awt.Color(0, 0, 153));
        saveEdit.setText("•");
        saveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(passWord, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(local_address, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(email_address, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jlabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(userid))))
                                .addComponent(mobile_number, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jlabel)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userid)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(local_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mobile_number, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveEdit)
                    .addComponent(jButton1))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(profile, "card4");

        cart.setBackground(new java.awt.Color(255, 255, 255));
        cart.setForeground(new java.awt.Color(51, 51, 51));

        cartScrollBar.setViewportView(panelItem2);

        jLabel21.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Total products price:");

        jLabel24.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Method of payment:");

        note1.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        note1.setForeground(new java.awt.Color(51, 51, 51));
        note1.setText("Our Online Apparel only accepts Cash on Delivery payment method.");

        totalPrice.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        totalPrice.setForeground(new java.awt.Color(51, 51, 51));
        totalPrice.setText("0.00");

        jLabel28.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Cash on Delivery");

        pictureBox17.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/APPAREL PLACE LOGO(small).png"))); // NOI18N

        note2.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        note2.setForeground(new java.awt.Color(51, 51, 51));
        note2.setText("Our Online Apparel only accepts Cash on Delivery payment method.");

        shipoutButton.setBackground(new java.awt.Color(153, 0, 153));
        shipoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shipoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shipoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                shipoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                shipoutButtonMouseExited(evt);
            }
        });

        pictureBox18.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px.png"))); // NOI18N

        note3.setBackground(new java.awt.Color(51, 51, 51));
        note3.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        note3.setForeground(new java.awt.Color(255, 255, 255));
        note3.setText("SHIP OUT");
        note3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout shipoutButtonLayout = new javax.swing.GroupLayout(shipoutButton);
        shipoutButton.setLayout(shipoutButtonLayout);
        shipoutButtonLayout.setHorizontalGroup(
            shipoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipoutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(note3)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        shipoutButtonLayout.setVerticalGroup(
            shipoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shipoutButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(note3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        removeItem.setBackground(new java.awt.Color(153, 0, 153));
        removeItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeItemMouseExited(evt);
            }
        });

        pictureBox19.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_delete_50px.png"))); // NOI18N

        note4.setFont(new java.awt.Font("Inter SemiBold", 0, 16)); // NOI18N
        note4.setForeground(new java.awt.Color(255, 255, 255));
        note4.setText("REMOVE ITEM");

        javax.swing.GroupLayout removeItemLayout = new javax.swing.GroupLayout(removeItem);
        removeItem.setLayout(removeItemLayout);
        removeItemLayout.setHorizontalGroup(
            removeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(note4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        removeItemLayout.setVerticalGroup(
            removeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(removeItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(note4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(pictureBox19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Shipping fee:");

        totalAmount1.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        totalAmount1.setForeground(new java.awt.Color(51, 51, 51));
        totalAmount1.setText("+ 100.00");

        jLabel27.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Total payment of:");

        totalAmount.setFont(new java.awt.Font("Inter Medium", 0, 20)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(51, 51, 51));
        totalAmount.setText("PHP 0.00");

        javax.swing.GroupLayout cartLayout = new javax.swing.GroupLayout(cart);
        cart.setLayout(cartLayout);
        cartLayout.setHorizontalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartLayout.createSequentialGroup()
                .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartLayout.createSequentialGroup()
                        .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cartLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(shipoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(cartLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(note2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(note1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayout.createSequentialGroup()
                                        .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel27))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalAmount1)))
                                    .addGroup(cartLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(12, 12, 12))
                    .addGroup(cartLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(pictureBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(cartScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cartLayout.setVerticalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cartScrollBar)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pictureBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPrice)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(totalAmount1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(note1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(shipoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(note2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        cardPanel.add(cart, "card5");

        items.setBackground(new java.awt.Color(255, 255, 255));

        itemScrollBar.setViewportView(panelItem1);

        lbItemName.setFont(new java.awt.Font("Inter ExtraBold", 0, 24)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(51, 51, 51));
        lbItemName.setText("ITEM NAME");

        pic.setForeground(new java.awt.Color(51, 51, 51));

        jLabel16.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("BRAND:");

        lbBrand.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(51, 51, 51));
        lbBrand.setText("BRAND");

        lbPrice.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(51, 51, 51));
        lbPrice.setText("PHP 0.00");

        lbDescription.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(51, 51, 51));
        lbDescription.setText("<html><body><p align='justify'>  Description </p></body></html>");

        size.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        size.setForeground(new java.awt.Color(51, 51, 51));
        size.setText("Select Size:");

        size1.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        size1.setForeground(new java.awt.Color(51, 51, 51));
        size1.setText("Input Quantity:");

        lbQuantity.setBackground(new java.awt.Color(204, 204, 204));
        lbQuantity.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        lbQuantity.setForeground(new java.awt.Color(51, 51, 51));
        lbQuantity.setText("1");

        addtoCart.setBackground(new java.awt.Color(255, 255, 255));
        addtoCart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addtoCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addtoCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addtoCartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addtoCartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addtoCartMouseExited(evt);
            }
        });
        addtoCart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Add to Cart");
        addtoCart.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        pictureBox16.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px_1.png"))); // NOI18N
        addtoCart.add(pictureBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        clothesSize.setBackground(new java.awt.Color(255, 255, 255));
        clothesSize.setForeground(new java.awt.Color(51, 51, 51));
        clothesSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "XS", "S", "M", "L", "XL" }));
        clothesSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clothesSizeActionPerformed(evt);
            }
        });

        shoesSize.setBackground(new java.awt.Color(255, 255, 255));
        shoesSize.setForeground(new java.awt.Color(51, 51, 51));
        shoesSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "36", "37", "38", "39", "40", "41", "42", "43" }));
        shoesSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoesSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemsLayout.createSequentialGroup()
                        .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemsLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 124, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbItemName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                                            .addComponent(lbBrand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clothesSize, 0, 165, Short.MAX_VALUE)
                            .addComponent(shoesSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(172, 172, 172))
                    .addGroup(itemsLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(itemsLayout.createSequentialGroup()
                                .addComponent(size1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addtoCart, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(itemScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemScrollBar)
            .addGroup(itemsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(size)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clothesSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoesSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(size1)
                    .addComponent(lbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addtoCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        cardPanel.add(items, "card6");

        myOrders.setBackground(new java.awt.Color(204, 204, 204));
        myOrders.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        toRecieveButton.setBackground(new java.awt.Color(102, 102, 102));
        toRecieveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toRecieveButton.setPreferredSize(new java.awt.Dimension(252, 0));
        toRecieveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toRecieveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toRecieveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toRecieveButtonMouseExited(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("TO RECIEVE");

        javax.swing.GroupLayout toRecieveButtonLayout = new javax.swing.GroupLayout(toRecieveButton);
        toRecieveButton.setLayout(toRecieveButtonLayout);
        toRecieveButtonLayout.setHorizontalGroup(
            toRecieveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toRecieveButtonLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel31)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        toRecieveButtonLayout.setVerticalGroup(
            toRecieveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toRecieveButtonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel31)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        shipOutButton.setBackground(new java.awt.Color(102, 102, 102));
        shipOutButton.setForeground(new java.awt.Color(51, 51, 51));
        shipOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shipOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shipOutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                shipOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                shipOutButtonMouseExited(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("TO SHIP-OUT");

        javax.swing.GroupLayout shipOutButtonLayout = new javax.swing.GroupLayout(shipOutButton);
        shipOutButton.setLayout(shipOutButtonLayout);
        shipOutButtonLayout.setHorizontalGroup(
            shipOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipOutButtonLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel30)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        shipOutButtonLayout.setVerticalGroup(
            shipOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipOutButtonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recievedButton.setBackground(new java.awt.Color(102, 102, 102));
        recievedButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recievedButton.setPreferredSize(new java.awt.Dimension(252, 0));
        recievedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recievedButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recievedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recievedButtonMouseExited(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("RECIEVED");

        javax.swing.GroupLayout recievedButtonLayout = new javax.swing.GroupLayout(recievedButton);
        recievedButton.setLayout(recievedButtonLayout);
        recievedButtonLayout.setHorizontalGroup(
            recievedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recievedButtonLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel44)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        recievedButtonLayout.setVerticalGroup(
            recievedButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recievedButtonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(shipOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toRecieveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(recievedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toRecieveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(shipOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recievedButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        myOrders.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));

        myOrdersCard.setLayout(new java.awt.CardLayout());

        toShipPanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(panelItem3);

        javax.swing.GroupLayout toShipPanelLayout = new javax.swing.GroupLayout(toShipPanel);
        toShipPanel.setLayout(toShipPanelLayout);
        toShipPanelLayout.setHorizontalGroup(
            toShipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        toShipPanelLayout.setVerticalGroup(
            toShipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        myOrdersCard.add(toShipPanel, "card2");

        toRecievePanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setViewportView(panelItem4);

        javax.swing.GroupLayout toRecievePanelLayout = new javax.swing.GroupLayout(toRecievePanel);
        toRecievePanel.setLayout(toRecievePanelLayout);
        toRecievePanelLayout.setHorizontalGroup(
            toRecievePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        toRecievePanelLayout.setVerticalGroup(
            toRecievePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        myOrdersCard.add(toRecievePanel, "card3");

        jScrollPane4.setViewportView(panelItem5);

        javax.swing.GroupLayout recievedLayout = new javax.swing.GroupLayout(recieved);
        recieved.setLayout(recievedLayout);
        recievedLayout.setHorizontalGroup(
            recievedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        recievedLayout.setVerticalGroup(
            recievedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        myOrdersCard.add(recieved, "card4");

        myOrders.add(myOrdersCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 920, 560));

        jLabel32.setFont(new java.awt.Font("Inter Black", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("ORDER DETAILS");
        myOrders.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        productDetails.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        productDetails.setForeground(new java.awt.Color(51, 51, 51));
        productDetails.setText("Details");
        myOrders.add(productDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 340, 100));

        jLabel34.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Product Details:");
        myOrders.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 60));

        note5.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
        note5.setForeground(new java.awt.Color(51, 51, 51));
        note5.setText("Total price together with other items and shipping fee.");
        myOrders.add(note5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, 30));

        productTotalPrice.setFont(new java.awt.Font("Inter Black", 0, 24)); // NOI18N
        productTotalPrice.setForeground(new java.awt.Color(51, 51, 51));
        productTotalPrice.setText("PHP 0.00");
        myOrders.add(productTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 310, 40));

        jLabel36.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Total Price:");
        myOrders.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 310, 70));

        jLabel35.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Reciever Full Name:");
        myOrders.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        fullName.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        fullName.setForeground(new java.awt.Color(51, 51, 51));
        fullName.setText("Name");
        myOrders.add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 290, -1));

        jLabel38.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("Delivery Address:");
        myOrders.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 290, -1));

        localAddress.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        localAddress.setForeground(new java.awt.Color(51, 51, 51));
        localAddress.setText("Address");
        myOrders.add(localAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 290, -1));

        mobileNumber.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        mobileNumber.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumber.setText("Contact Number:");
        myOrders.add(mobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 290, -1));

        paymentMethod.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        paymentMethod.setForeground(new java.awt.Color(51, 51, 51));
        paymentMethod.setText("Method");
        myOrders.add(paymentMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 290, -1));

        text1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        text1.setForeground(new java.awt.Color(51, 51, 51));
        text1.setText("Payment Method:");
        myOrders.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 290, -1));

        estimateDate.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        estimateDate.setForeground(new java.awt.Color(51, 51, 51));
        estimateDate.setText("Estimated Date of Arrival:");
        myOrders.add(estimateDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 310, -1));

        orderDate1.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        orderDate1.setForeground(new java.awt.Color(51, 51, 51));
        orderDate1.setText("Order Date:");
        myOrders.add(orderDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 70, -1));

        orderDate.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        orderDate.setForeground(new java.awt.Color(51, 51, 51));
        orderDate.setText("Order Date");
        myOrders.add(orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 210, -1));

        status.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(204, 51, 255));
        status.setText("Status:");
        myOrders.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        userorderUpdate.setBackground(new java.awt.Color(204, 51, 255));
        userorderUpdate.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        userorderUpdate.setForeground(new java.awt.Color(255, 255, 255));
        userorderUpdate.setText("ORDER RECIEVED");
        userorderUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userorderUpdateMouseClicked(evt);
            }
        });
        userorderUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userorderUpdateActionPerformed(evt);
            }
        });
        myOrders.add(userorderUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 555, 180, 30));

        cardPanel.add(myOrders, "card7");

        pendingOrders.setBackground(new java.awt.Color(255, 255, 255));

        pendingOrderTable.setBackground(new java.awt.Color(204, 204, 204));
        pendingOrderTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        pendingOrderTable.setForeground(new java.awt.Color(0, 0, 0));
        pendingOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Address", "Email", "Mobile Number", "Product", "Size", "Quantity", "Order Price", "Status", "Date of Order", "Est. Recieve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingOrderTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pendingOrderTable);
        if (pendingOrderTable.getColumnModel().getColumnCount() > 0) {
            pendingOrderTable.getColumnModel().getColumn(0).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(1).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(2).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(3).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(4).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            pendingOrderTable.getColumnModel().getColumn(5).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(5).setPreferredWidth(20);
            pendingOrderTable.getColumnModel().getColumn(6).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(6).setPreferredWidth(20);
            pendingOrderTable.getColumnModel().getColumn(7).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(7).setPreferredWidth(50);
            pendingOrderTable.getColumnModel().getColumn(8).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(8).setPreferredWidth(50);
            pendingOrderTable.getColumnModel().getColumn(9).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(9).setPreferredWidth(50);
            pendingOrderTable.getColumnModel().getColumn(10).setResizable(false);
            pendingOrderTable.getColumnModel().getColumn(10).setPreferredWidth(70);
        }

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("ORDER DETAILS:");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel39.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Full Name:");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        tableFullName.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableFullName.setForeground(new java.awt.Color(51, 51, 51));
        tableFullName.setText("Full Name");
        jPanel4.add(tableFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, -1));

        jLabel40.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("Reciever Address:");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 124, -1));

        jLabel41.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("Reciever Email:");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 96, -1));

        tableAddress.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableAddress.setForeground(new java.awt.Color(51, 51, 51));
        tableAddress.setText("Address");
        jPanel4.add(tableAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 370, -1));

        jLabel43.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Mobile Number:");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 124, -1));

        tableEmail.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableEmail.setForeground(new java.awt.Color(51, 51, 51));
        tableEmail.setText("Email");
        jPanel4.add(tableEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, -1));

        tableMobileNumber.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableMobileNumber.setForeground(new java.awt.Color(51, 51, 51));
        tableMobileNumber.setText("Mobile Number");
        jPanel4.add(tableMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 180, -1));

        jLabel46.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Order Date:");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 124, -1));

        jLabel47.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Estimate Recieve Date:");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        tableOrderDate.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableOrderDate.setForeground(new java.awt.Color(51, 51, 51));
        tableOrderDate.setText("Order Date");
        jPanel4.add(tableOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 180, -1));

        tableERD.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableERD.setForeground(new java.awt.Color(51, 51, 51));
        tableERD.setText("Estimated Date");
        jPanel4.add(tableERD, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 180, -1));

        jLabel42.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Product:");
        jPanel4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 65, 50));

        tableProduct.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableProduct.setForeground(new java.awt.Color(51, 51, 51));
        tableProduct.setText("Product Name");
        jPanel4.add(tableProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 278, 50));

        jLabel45.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setText("Sizes:");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 65, -1));

        tableSize.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableSize.setForeground(new java.awt.Color(51, 51, 51));
        tableSize.setText("Size");
        jPanel4.add(tableSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 278, -1));

        tableQuantity.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableQuantity.setForeground(new java.awt.Color(51, 51, 51));
        tableQuantity.setText("Quantity");
        jPanel4.add(tableQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 278, -1));

        tablePrice.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tablePrice.setForeground(new java.awt.Color(51, 51, 51));
        tablePrice.setText("Total Price");
        jPanel4.add(tablePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 278, -1));

        tableStatus.setBackground(new java.awt.Color(102, 0, 0));
        tableStatus.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        tableStatus.setForeground(new java.awt.Color(51, 51, 51));
        tableStatus.setText("Status");
        jPanel4.add(tableStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 278, -1));

        jLabel52.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setText("Quantity:");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 65, -1));

        jLabel53.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Order Price:");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabel54.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("Status:");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 65, -1));

        updateStatus.setBackground(new java.awt.Color(204, 51, 255));
        updateStatus.setFont(new java.awt.Font("Inter ExtraBold", 0, 14)); // NOI18N
        updateStatus.setForeground(new java.awt.Color(255, 255, 255));
        updateStatus.setText("Order Shipped");
        updateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusActionPerformed(evt);
            }
        });
        jPanel4.add(updateStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 82, 160, 30));

        jLabel55.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setText("Set Status:");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 61, 100, -1));

        updateStatusRecieve.setBackground(new java.awt.Color(204, 51, 255));
        updateStatusRecieve.setFont(new java.awt.Font("Inter ExtraBold", 0, 14)); // NOI18N
        updateStatusRecieve.setForeground(new java.awt.Color(255, 255, 255));
        updateStatusRecieve.setText("Order Delivered");
        updateStatusRecieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusRecieveActionPerformed(evt);
            }
        });
        jPanel4.add(updateStatusRecieve, new org.netbeans.lib.awtextra.AbsoluteConstraints(924, 80, 160, 30));

        javax.swing.GroupLayout pendingOrdersLayout = new javax.swing.GroupLayout(pendingOrders);
        pendingOrders.setLayout(pendingOrdersLayout);
        pendingOrdersLayout.setHorizontalGroup(
            pendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(pendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        pendingOrdersLayout.setVerticalGroup(
            pendingOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendingOrdersLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardPanel.add(pendingOrders, "card8");

        userMessage.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel48.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Full Name:");

        messageFullName.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        messageFullName.setForeground(new java.awt.Color(51, 51, 51));
        messageFullName.setText("Full Name");

        jLabel50.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("User Email:");

        messageEmail.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        messageEmail.setForeground(new java.awt.Color(51, 51, 51));
        messageEmail.setText("Email");

        jLabel56.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setText("Mobile Number:");

        messageMobileNumber.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        messageMobileNumber.setForeground(new java.awt.Color(51, 51, 51));
        messageMobileNumber.setText("Mobile Number");

        jLabel58.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Subject:");

        messageSubject.setBackground(new java.awt.Color(204, 204, 204));
        messageSubject.setColumns(20);
        messageSubject.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messageSubject.setForeground(new java.awt.Color(51, 51, 51));
        messageSubject.setRows(5);
        jScrollPane5.setViewportView(messageSubject);

        jLabel59.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Message:");

        messageText.setBackground(new java.awt.Color(204, 204, 204));
        messageText.setColumns(20);
        messageText.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messageText.setForeground(new java.awt.Color(51, 51, 51));
        messageText.setRows(5);
        jScrollPane6.setViewportView(messageText);

        jLabel60.setFont(new java.awt.Font("Inter ExtraBold", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("NEW MESSAGE");

        jButton2.setBackground(new java.awt.Color(204, 51, 255));
        jButton2.setFont(new java.awt.Font("Inter ExtraBold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SEND MESSAGE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel50)
                            .addComponent(jLabel56))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(messageFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(messageEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(messageFullName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(messageEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(messageMobileNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout userMessageLayout = new javax.swing.GroupLayout(userMessage);
        userMessage.setLayout(userMessageLayout);
        userMessageLayout.setHorizontalGroup(
            userMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userMessageLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        userMessageLayout.setVerticalGroup(
            userMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userMessageLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        cardPanel.add(userMessage, "card9");

        adminMessages.setBackground(new java.awt.Color(255, 255, 255));

        messageTable.setBackground(new java.awt.Color(204, 204, 204));
        messageTable.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        messageTable.setForeground(new java.awt.Color(0, 0, 0));
        messageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Email", "Mobile Number", "Subject", "Message", "Status", "Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        messageTable.setMinimumSize(new java.awt.Dimension(165, 120));
        messageTable.setPreferredSize(new java.awt.Dimension(710, 120));
        messageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(messageTable);
        if (messageTable.getColumnModel().getColumnCount() > 0) {
            messageTable.getColumnModel().getColumn(0).setResizable(false);
            messageTable.getColumnModel().getColumn(1).setResizable(false);
            messageTable.getColumnModel().getColumn(2).setResizable(false);
            messageTable.getColumnModel().getColumn(3).setResizable(false);
            messageTable.getColumnModel().getColumn(4).setResizable(false);
            messageTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            messageTable.getColumnModel().getColumn(5).setResizable(false);
            messageTable.getColumnModel().getColumn(5).setPreferredWidth(30);
            messageTable.getColumnModel().getColumn(6).setResizable(false);
            messageTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Inter Black", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("MESSAGE DETAILS:");
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 14, -1, -1));

        messDate.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messDate.setForeground(new java.awt.Color(51, 51, 51));
        messDate.setText("Date");
        jPanel7.add(messDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 230, -1));

        messStatus.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messStatus.setForeground(new java.awt.Color(51, 51, 51));
        messStatus.setText("Status");
        jPanel7.add(messStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, -1));

        jLabel61.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("User Email:");
        jPanel7.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel62.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("User Mobile Number:");
        jPanel7.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel63.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Message:");
        jPanel7.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        messText.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messText.setForeground(new java.awt.Color(51, 51, 51));
        messText.setText("User Message");
        jPanel7.add(messText, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 310, 90));

        messEmail.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messEmail.setForeground(new java.awt.Color(51, 51, 51));
        messEmail.setText("Email");
        jPanel7.add(messEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 210, -1));

        messNumber.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messNumber.setForeground(new java.awt.Color(51, 51, 51));
        messNumber.setText("Number");
        jPanel7.add(messNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 210, -1));

        jLabel67.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 51));
        jLabel67.setText("From User:");
        jPanel7.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        messName.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messName.setForeground(new java.awt.Color(51, 51, 51));
        messName.setText("Name");
        jPanel7.add(messName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 210, -1));

        jLabel69.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 51, 51));
        jLabel69.setText("Subject:");
        jPanel7.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        messSubject.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        messSubject.setForeground(new java.awt.Color(51, 51, 51));
        messSubject.setText("Subject");
        jPanel7.add(messSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 300, 60));

        acknowledgedButton.setBackground(new java.awt.Color(204, 51, 255));
        acknowledgedButton.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        acknowledgedButton.setForeground(new java.awt.Color(255, 255, 255));
        acknowledgedButton.setText("Acknowledged");
        acknowledgedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acknowledgedButtonActionPerformed(evt);
            }
        });
        jPanel7.add(acknowledgedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 140, 30));

        jLabel57.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setText("Message Status:");
        jPanel7.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel64.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setText("Date & Time:");
        jPanel7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        javax.swing.GroupLayout adminMessagesLayout = new javax.swing.GroupLayout(adminMessages);
        adminMessages.setLayout(adminMessagesLayout);
        adminMessagesLayout.setHorizontalGroup(
            adminMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMessagesLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminMessagesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminMessagesLayout.setVerticalGroup(
            adminMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardPanel.add(adminMessages, "card10");

        getContentPane().add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1280, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px.png")));
    }//GEN-LAST:event_closeButtonMousePressed

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px_1.png")));
    }//GEN-LAST:event_closeButtonMouseReleased

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMousePressed
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px.png")));
    }//GEN-LAST:event_minimizeButtonMousePressed

    private void minimizeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseReleased
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px_1.png")));
    }//GEN-LAST:event_minimizeButtonMouseReleased

    private void titlePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlePanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_titlePanelMousePressed

    private void titlePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlePanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_titlePanelMouseDragged

    private void productButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseClicked
        changeCard(products);
        setRemoveData();
        clearAllProducts();
    }//GEN-LAST:event_productButtonMouseClicked

    private void accountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseClicked
        changeCard(profile);
        setRemoveData();
        saveEdit.hide();
        uneditted();
    }//GEN-LAST:event_accountButtonMouseClicked

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        changeCard(homepage);
        setRemoveData();
    }//GEN-LAST:event_homeButtonMouseClicked

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        int input = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOG-OUT?", "Apparel Place" ,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        
        if(input == 0){
        this.dispose();
        new userLogIn().setVisible(true);
        }
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void logOutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMousePressed
        logOutButton.setBackground(new java.awt.Color(204,153,255));
    }//GEN-LAST:event_logOutButtonMousePressed

    private void logOutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseReleased
        logOutButton.setBackground(new java.awt.Color(153,0,153));
    }//GEN-LAST:event_logOutButtonMouseReleased

    private void bagsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagsButtonMouseClicked
        changeCard(items);
        showBagItems();
        size.setVisible(false);
        shoesSize.setVisible(false);
        clothesSize.setVisible(false);
       
    }//GEN-LAST:event_bagsButtonMouseClicked

    private void clothesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseClicked
        changeCard(items);
        showClothesItems();
        size.setVisible(true);
        clothesSize.setSelectedIndex(0);
        shoesSize.setVisible(false);
        clothesSize.setVisible(true);
    }//GEN-LAST:event_clothesButtonMouseClicked

    private void footwearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseClicked
        changeCard(items);
        showFootwearItems();
        size.setVisible(true);
        shoesSize.setSelectedIndex(0);
        shoesSize.setVisible(true);
        clothesSize.setVisible(false);
       
    }//GEN-LAST:event_footwearButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        edittable();
        saveEdit.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditActionPerformed
        updateUser();
        uneditted();
        saveEdit.setVisible(false);
    }//GEN-LAST:event_saveEditActionPerformed

    private void productButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseEntered
        productButton.setBackground(new Color(204,153,255));
        jLabel1.setForeground(new Color(204,204,204));
        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_50px.png")));
        
    }//GEN-LAST:event_productButtonMouseEntered

    private void productButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseExited
        productButton.setBackground(new Color(204,204,204)); 
        jLabel1.setForeground(new Color(51,51,51));
        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_50px_1.png")));
        
    }//GEN-LAST:event_productButtonMouseExited

    private void cartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseClicked
        clearAllProducts();
        setRemoveData();
        note1.setText("<html><body><p align='justify'>Note: Our Online Apparel only accepts Cash on Delivery payment method.</p></body></html>");
        note2.setText("<html><body><p align='justify'>Note: Make sure your Contact Details on your Profile is correct and is up to date before shipping out.</p></body></html>");
        totalCartPrice();
        showCart();
        changeCard(cart);
    }//GEN-LAST:event_cartButtonMouseClicked

    private void cartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartButtonMousePressed

    private void cartButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartButtonMouseReleased

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        homeButton.setBackground(new Color(204,153,255));
        jLabel19.setForeground(new Color(204,204,204));
        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_home_60px.png")));
        
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        homeButton.setBackground(new Color(204,204,204));
        jLabel19.setForeground(new Color(51,51,51));
        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_home_60px_1.png")));
    }//GEN-LAST:event_homeButtonMouseExited
        int out = 0;
    private void cartButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseEntered
        cartButton.setBackground(new Color(204,153,255));
        jLabel20.setForeground(new Color(204,204,204));
        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px.png")));
    }//GEN-LAST:event_cartButtonMouseEntered

    private void cartButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseExited
        cartButton.setBackground(new Color(204,204,204));
        jLabel20.setForeground(new Color(51,51,51));
        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px_1.png")));
    }//GEN-LAST:event_cartButtonMouseExited

    private void accountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseEntered
        accountButton.setBackground(new Color(204,153,255));
        users_firstname.setForeground(new Color(204,204,204));
        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Test_Account_60px.png")));
    }//GEN-LAST:event_accountButtonMouseEntered

    private void accountButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseExited
        accountButton.setBackground(new Color(204,204,204));
        users_firstname.setForeground(new Color(51,51,51));
        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Test_Account_60px_1.png")));
    }//GEN-LAST:event_accountButtonMouseExited

    private void shopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shopButtonMouseClicked
        changeCard(products);
    }//GEN-LAST:event_shopButtonMouseClicked

    private void accessoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseClicked
        changeCard(items);
        showAccessoryItems();
        size.setVisible(false);
        shoesSize.setVisible(false);
        clothesSize.setVisible(false);
    }//GEN-LAST:event_accessoriesButtonMouseClicked

    private void bagsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagsButtonMouseEntered
        bagsButton.setBackground(new Color (204,153,255));
        jLabel3.setForeground(new Color(255,255,255));
        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Bag_90px_1.png")));
    }//GEN-LAST:event_bagsButtonMouseEntered

    private void bagsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagsButtonMouseExited
        bagsButton.setBackground(new Color (204,204,204));
        jLabel3.setForeground(new Color(51,51,51));
        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Bag_90px.png")));
    }//GEN-LAST:event_bagsButtonMouseExited

    private void clothesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseEntered
        clothesButton.setBackground(new Color (204,153,255));
        jLabel4.setForeground(new Color(255,255,255));
        pictureBox12.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px.png")));
    }//GEN-LAST:event_clothesButtonMouseEntered

    private void clothesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseExited
        clothesButton.setBackground(new Color (204,204,204));
        jLabel4.setForeground(new Color(51,51,51));
        pictureBox12.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px_1.png")));
    }//GEN-LAST:event_clothesButtonMouseExited

    private void footwearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseEntered
        footwearButton.setBackground(new Color (204,153,255));
        jLabel5.setForeground(new Color(255,255,255));
        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px.png")));
    }//GEN-LAST:event_footwearButtonMouseEntered

    private void footwearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseExited
        footwearButton.setBackground(new Color (204,204,204));
        jLabel5.setForeground(new Color(51,51,51));
        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px_1.png")));
    }//GEN-LAST:event_footwearButtonMouseExited

    private void accessoriesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseEntered
        accessoriesButton.setBackground(new Color (204,153,255));
        jLabel10.setForeground(new Color(255,255,255));
        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px.png")));
    }//GEN-LAST:event_accessoriesButtonMouseEntered

    private void accessoriesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseExited
        accessoriesButton.setBackground(new Color (204,204,204));
        jLabel10.setForeground(new Color(51,51,51));
        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px_1.png")));
    }//GEN-LAST:event_accessoriesButtonMouseExited

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        logOutButton.setBackground(new Color(204,153,255));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setBackground(new Color(153,0,153));
    }//GEN-LAST:event_logOutButtonMouseExited

    private void addtoCartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtoCartMouseEntered
        addtoCart.setBackground(new Color(204,153,255));
        jLabel18.setForeground(new Color(255,255,255));
        pictureBox16.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px.png")));
    }//GEN-LAST:event_addtoCartMouseEntered

    private void addtoCartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtoCartMouseExited
        addtoCart.setBackground(new Color(204,204,255));
        jLabel18.setForeground(new Color(51,51,51));
        pictureBox16.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px_1.png")));
    }//GEN-LAST:event_addtoCartMouseExited

    private void addtoCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addtoCartMouseClicked
        select.setItemQuantity(lbQuantity.getText());
       
        findImageLoc();
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this item to cart?", "Apparel Place" ,JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        
        try {
            
            login.prep = login.connect.prepareStatement("INSERT INTO cartitems(size,quantity,product,description,price,brand,icon,userEmail) VALUES(?,?,?,?,?,?,?,?)");
            login.prep.setString(1, select.getItemSize());
            login.prep.setString(2, select.getItemQuantity());
            login.prep.setString(3, select.getItemName());
            login.prep.setString(4, select.getItemDescription());
            login.prep.setString(5, Integer.toString(select.getItemPrice()));
            login.prep.setString(6, select.getItemBrand());
            login.prep.setString(7, select.getFinderLocation());
            login.prep.setString(8, login.email);
            if(input == 0 && select.getItemSize().equals("--")){
            JOptionPane.showMessageDialog(null, "Select Item Size.");
            }
            else if (input == 0){
               login.prep.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Select Item, Item Size and Item Quantity.");
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addtoCartMouseClicked

    private void removeItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemMouseClicked
       
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this item? " + select.getItemName(), "Apparel Place" ,JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        
        try {
            login.prep = login.connect.prepareStatement("DELETE FROM cartitems WHERE description = '"+ select.getItemDescription() +"' AND userEmail = '"+ login.email +"';");
            if(input == 0){
                login.prep.executeUpdate();
                totalCartPrice();
                clearAllProducts();
                showCart();
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_removeItemMouseClicked

    private void shipoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipoutButtonMouseClicked
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to ship-out items? ", "Apparel Place" ,JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (input == 0){
        toShip();
        try {
            login.prep = login.connect.prepareStatement("DELETE FROM cartitems WHERE userEmail = '"+ login.email +"';");
                login.prep.executeUpdate();
                totalCartPrice();
                clearAllProducts();
                showCart();
                JOptionPane.showMessageDialog(null, "Your items are now waiting to ship out by the seller.");
            
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_shipoutButtonMouseClicked

    private void shipoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipoutButtonMouseEntered
        shipoutButton.setBackground(new Color(204,153,255));
        note3.setForeground(new Color (51,51,51));
        pictureBox18.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png")));
    }//GEN-LAST:event_shipoutButtonMouseEntered

    private void shipoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipoutButtonMouseExited
        shipoutButton.setBackground(new Color(153,0,153));
        note3.setForeground(new Color (255,255,255));
        pictureBox18.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px.png")));
    }//GEN-LAST:event_shipoutButtonMouseExited

    private void removeItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemMouseEntered
        removeItem.setBackground(new Color(204,153,255));
        note4.setForeground(new Color (51,51,51));
        pictureBox19.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_delete_50px_1.png")));
    }//GEN-LAST:event_removeItemMouseEntered

    private void removeItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeItemMouseExited
        removeItem.setBackground(new Color(153,0,153));
        note4.setForeground(new Color (255,255,255));
        pictureBox19.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_delete_50px.png")));
    }//GEN-LAST:event_removeItemMouseExited

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        changeCard(homepage);
    }//GEN-LAST:event_logoMouseClicked

    private void clothesSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clothesSizeActionPerformed
        String selectedValue = clothesSize.getSelectedItem().toString();
        select.setItemSize(selectedValue);
        size.setText("Select Size: " + select.getItemSize());
    }//GEN-LAST:event_clothesSizeActionPerformed

    private void shoesSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoesSizeActionPerformed
        String selectedValue = shoesSize.getSelectedItem().toString();
        select.setItemSize(selectedValue);
        size.setText("Select Size: " + select.getItemSize());
    }//GEN-LAST:event_shoesSizeActionPerformed

    private void myOrdersButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myOrdersButtonMouseEntered
        myOrdersButton.setBackground(new Color(204,153,255));
        jLabel29.setForeground(new Color(204,204,204));
        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px.png")));
    }//GEN-LAST:event_myOrdersButtonMouseEntered

    private void myOrdersButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myOrdersButtonMouseExited
        myOrdersButton.setBackground(new Color(204,204,204)); 
        jLabel29.setForeground(new Color(51,51,51));
        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png")));
    }//GEN-LAST:event_myOrdersButtonMouseExited

    private void shipOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipOutButtonMouseEntered
        shipOutButton.setBackground(new Color(204,204,204));
        jLabel30.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_shipOutButtonMouseEntered

    private void shipOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipOutButtonMouseExited
        shipOutButton.setBackground(new Color(102,102,102));
        jLabel30.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_shipOutButtonMouseExited

    private void toRecieveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toRecieveButtonMouseEntered
        toRecieveButton.setBackground(new Color(204,204,204));
        jLabel31.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_toRecieveButtonMouseEntered

    private void toRecieveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toRecieveButtonMouseExited
        toRecieveButton.setBackground(new Color(102,102,102));
        jLabel31.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_toRecieveButtonMouseExited

    private void myOrdersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myOrdersButtonMouseClicked
        changeCard(myOrders);
        userorderUpdate.setVisible(false);
        changeOrderCard(toShipPanel);
        clearAllProducts();
        showToShip();
    }//GEN-LAST:event_myOrdersButtonMouseClicked

    private void shipOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipOutButtonMouseClicked
        changeOrderCard(toShipPanel);
        clearAllProducts();
        showToShip();
    }//GEN-LAST:event_shipOutButtonMouseClicked

    private void toRecieveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toRecieveButtonMouseClicked
        changeOrderCard(toRecievePanel);
        clearAllProducts();
        showToRecieve();
    }//GEN-LAST:event_toRecieveButtonMouseClicked

    private void pendingOrdersButttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingOrdersButttonMouseClicked
        try {
            changeCard(pendingOrders);
            updateTable(pendingOrderTable);
            updateStatus.setVisible(false);
            updateStatusRecieve.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pendingOrdersButttonMouseClicked

    private void pendingOrdersButttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingOrdersButttonMouseEntered
        pendingOrdersButtton.setBackground(new Color(204,153,255));
        jLabel37.setForeground(new Color(204,204,204));
        pictureBox21.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px.png")));
    }//GEN-LAST:event_pendingOrdersButttonMouseEntered

    private void pendingOrdersButttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingOrdersButttonMouseExited
        pendingOrdersButtton.setBackground(new Color(204,204,204)); 
        jLabel37.setForeground(new Color(51,51,51));
        pictureBox21.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_cardboard_box_50px_1.png")));
    }//GEN-LAST:event_pendingOrdersButttonMouseExited

    private void updateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusActionPerformed
        try {
            login.prep = login.connect.prepareStatement("UPDATE toshipitems SET status = 'To Recieve' WHERE totalPrice = '" +tablePrice.getText()+ "' AND email = '"+tableEmail.getText()+"' AND timeOrder = '"+ tableOrderDate.getText() +"';");
            login.prep.executeUpdate();
            updateTable(pendingOrderTable);
          
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateStatusActionPerformed

    private void updateStatusRecieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusRecieveActionPerformed
        try {
            login.prep = login.connect.prepareStatement("UPDATE toshipitems SET status = 'Recieved' WHERE totalPrice = '" +tablePrice.getText()+ "' AND email = '"+tableEmail.getText()+"' AND timeOrder = '"+ tableOrderDate.getText() +"';");
            login.prep.executeUpdate();
            updateTable(pendingOrderTable);
            updateStatusRecieve.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateStatusRecieveActionPerformed

    private void pendingOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingOrderTableMouseClicked
        try {
            onClickPendingOrderTable();
            if(tableStatus.getText().equals("To Ship")){
                updateStatus.setVisible(true);
                updateStatusRecieve.setVisible(false);
                tableStatus.setForeground(new Color(102,0,0));
            } else if(tableStatus.getText().equals("Waiting Seller Confirmation")){
                updateStatus.setVisible(false);
                updateStatusRecieve.setVisible(true);
                tableStatus.setForeground(new Color(255,102,51));
            } else if(tableStatus.getText().equals("Recieved")){
                updateStatus.setVisible(false);
                updateStatusRecieve.setVisible(false);
                tableStatus.setForeground(new Color(204,51,255));
            }
        } catch (IOException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pendingOrderTableMouseClicked

    private void recievedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recievedButtonMouseClicked
        changeOrderCard(recieved);
        clearAllProducts();
        showRecieved();
    }//GEN-LAST:event_recievedButtonMouseClicked

    private void recievedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recievedButtonMouseEntered
        recievedButton.setBackground(new Color(204,204,204));
        jLabel44.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_recievedButtonMouseEntered

    private void recievedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recievedButtonMouseExited
        recievedButton.setBackground(new Color(102,102,102));
        jLabel44.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_recievedButtonMouseExited

    private void messageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageButtonMouseClicked
        if(login.username.equals("admin")){
            try {
                changeCard(adminMessages);
                updateMessageTable(messageTable);
                
            } catch (SQLException ex) {
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        messageFullName.setText(login.firstname + " " + login.lastname);
        messageEmail.setText(login.email);
        messageMobileNumber.setText(login.mobilenumber);
        changeCard(userMessage);
        }
    }//GEN-LAST:event_messageButtonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to send the message? ", "Apparel Place" ,JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if(input == 0){
            try {
                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
                String dateTime = localDateTime.format(formatter);
                login.prep = login.connect.prepareStatement("INSERT INTO usermessage(fullName,email,mobileNumber,subject,message,status,messageDate) VALUES (?,?,?,?,?,?,?)");
                login.prep.setString(1, messageFullName.getText());
                login.prep.setString(2, messageEmail.getText());
                login.prep.setString(3, messageMobileNumber.getText());
                login.prep.setString(4, messageSubject.getText());
                login.prep.setString(5, messageText.getText());
                login.prep.setString(6, "New Message");
                login.prep.setString(7, dateTime);
                login.prep.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thank you for messaging us! We'll contact you through your email.");
                messageSubject.setText("");
                messageText.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void acknowledgedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acknowledgedButtonActionPerformed
        try {
            login.prep = login.connect.prepareStatement("UPDATE usermessage SET status = 'Acknowledged' WHERE messageDate = '"+ messDate.getText() +"' AND email = '"+ messEmail.getText() +"';");
            login.prep.executeUpdate();
            updateMessageTable(messageTable);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_acknowledgedButtonActionPerformed

    private void messageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseClicked
        try {
            onClickMessageTable();
            if(messStatus.getText().equals("New Message")){
                acknowledgedButton.setVisible(true);
            } else if(messStatus.getText().equals("Acknowledged")){
                acknowledgedButton.setVisible(false);
        }
        } catch (IOException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_messageTableMouseClicked

    private void messageButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageButtonMouseEntered
        messageButton.setBackground(new Color(204,153,255));
        pictureBox23.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_forward_message_30px_1.png")));
    }//GEN-LAST:event_messageButtonMouseEntered

    private void messageButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageButtonMouseExited
        messageButton.setBackground(new Color(204,204,204));
        pictureBox23.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_forward_message_30px.png")));
    }//GEN-LAST:event_messageButtonMouseExited

    private void userorderUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userorderUpdateMouseClicked
        try {
            login.prep = login.connect.prepareStatement("UPDATE toshipitems SET status = 'Waiting Seller Confirmation' WHERE timeOrder = '" + orderDate.getText() + "' AND email = '"+login.email+"';");
            login.prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userorderUpdateMouseClicked

    private void userorderUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userorderUpdateActionPerformed
        try {
            login.prep = login.connect.prepareStatement("UPDATE toshipitems SET status = 'Waiting Seller Confirmation' WHERE timeOrder = '" + orderDate.getText() + "' AND email = '"+login.email+"';");
            login.prep.executeUpdate();
            myOrders.repaint();
            myOrders.revalidate();
            changeOrderCard(toRecievePanel);
            clearAllProducts();
            showToRecieve();
            userorderUpdate.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userorderUpdateActionPerformed

   
    
    
    public static void main(String args[]) {
        
       try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accessoriesButton;
    private javax.swing.JPanel accountButton;
    private javax.swing.JButton acknowledgedButton;
    private javax.swing.JPanel addtoCart;
    private javax.swing.JPanel adminMessages;
    private javax.swing.JPanel bagsButton;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cart;
    private javax.swing.JPanel cartButton;
    private javax.swing.JScrollPane cartScrollBar;
    private javax.swing.JLabel closeButton;
    private javax.swing.JPanel clothesButton;
    private javax.swing.JComboBox<String> clothesSize;
    private javax.swing.JTextField email_address;
    private javax.swing.JLabel estimateDate;
    private javax.swing.JTextField first_name;
    private javax.swing.JPanel footwearButton;
    private javax.swing.JLabel fullName;
    private javax.swing.JPanel homeButton;
    private javax.swing.JPanel homepage;
    private javax.swing.JScrollPane itemScrollBar;
    private javax.swing.JPanel items;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField last_name;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JTextField lbQuantity;
    private javax.swing.JLabel localAddress;
    private javax.swing.JTextField local_address;
    private javax.swing.JPanel logOutButton;
    private com.apparel.model.pictureBox logo;
    private javax.swing.JLabel messDate;
    private javax.swing.JLabel messEmail;
    private javax.swing.JLabel messName;
    private javax.swing.JLabel messNumber;
    private javax.swing.JLabel messStatus;
    private javax.swing.JLabel messSubject;
    private javax.swing.JLabel messText;
    private javax.swing.JPanel messageButton;
    private javax.swing.JLabel messageEmail;
    private javax.swing.JLabel messageFullName;
    private javax.swing.JLabel messageMobileNumber;
    private javax.swing.JTextArea messageSubject;
    private javax.swing.JTable messageTable;
    private javax.swing.JTextArea messageText;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel mobileNumber;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JPanel myOrders;
    private javax.swing.JPanel myOrdersButton;
    private javax.swing.JPanel myOrdersCard;
    private javax.swing.JLabel note1;
    private javax.swing.JLabel note2;
    private javax.swing.JLabel note3;
    private javax.swing.JLabel note4;
    private javax.swing.JLabel note5;
    private javax.swing.JLabel orderDate;
    private javax.swing.JLabel orderDate1;
    private com.apparel.model.PanelItem panelItem1;
    private com.apparel.model.PanelItem panelItem2;
    private com.apparel.model.PanelItem panelItem3;
    private com.apparel.model.PanelItem panelItem4;
    private com.apparel.model.PanelItem panelItem5;
    private javax.swing.JPasswordField passWord;
    private javax.swing.JLabel paymentMethod;
    private javax.swing.JTable pendingOrderTable;
    private javax.swing.JPanel pendingOrders;
    private javax.swing.JPanel pendingOrdersButtton;
    private com.apparel.model.pictureBox pic;
    private com.apparel.model.pictureBox pictureBox1;
    private com.apparel.model.pictureBox pictureBox10;
    private com.apparel.model.pictureBox pictureBox11;
    private com.apparel.model.pictureBox pictureBox12;
    private com.apparel.model.pictureBox pictureBox13;
    private com.apparel.model.pictureBox pictureBox14;
    private com.apparel.model.pictureBox pictureBox15;
    private com.apparel.model.pictureBox pictureBox16;
    private com.apparel.model.pictureBox pictureBox17;
    private com.apparel.model.pictureBox pictureBox18;
    private com.apparel.model.pictureBox pictureBox19;
    private com.apparel.model.pictureBox pictureBox2;
    private com.apparel.model.pictureBox pictureBox20;
    private com.apparel.model.pictureBox pictureBox21;
    private com.apparel.model.pictureBox pictureBox23;
    private com.apparel.model.pictureBox pictureBox3;
    private com.apparel.model.pictureBox pictureBox4;
    private com.apparel.model.pictureBox pictureBox5;
    private com.apparel.model.pictureBox pictureBox6;
    private com.apparel.model.pictureBox pictureBox7;
    private com.apparel.model.pictureBox pictureBox8;
    private com.apparel.model.pictureBox pictureBox9;
    private javax.swing.JPanel productButton;
    private javax.swing.JLabel productDetails;
    private javax.swing.JLabel productTotalPrice;
    private javax.swing.JPanel products;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel recieved;
    private javax.swing.JPanel recievedButton;
    private javax.swing.JPanel removeItem;
    private javax.swing.JButton saveEdit;
    private javax.swing.JPanel shipOutButton;
    private javax.swing.JPanel shipoutButton;
    private javax.swing.JComboBox<String> shoesSize;
    private javax.swing.JPanel shopButton;
    private keeptoo.KGradientPanel sidePanel;
    private javax.swing.JLabel size;
    private javax.swing.JLabel size1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tableAddress;
    private javax.swing.JLabel tableERD;
    private javax.swing.JLabel tableEmail;
    private javax.swing.JLabel tableFullName;
    private javax.swing.JLabel tableMobileNumber;
    private javax.swing.JLabel tableOrderDate;
    private javax.swing.JLabel tablePrice;
    private javax.swing.JLabel tableProduct;
    private javax.swing.JLabel tableQuantity;
    private javax.swing.JLabel tableSize;
    private javax.swing.JLabel tableStatus;
    private javax.swing.JLabel text1;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel toRecieveButton;
    private javax.swing.JPanel toRecievePanel;
    private javax.swing.JPanel toShipPanel;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JLabel totalAmount1;
    private javax.swing.JLabel totalPrice;
    private javax.swing.JButton updateStatus;
    private javax.swing.JButton updateStatusRecieve;
    private javax.swing.JPanel userMessage;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userid;
    private javax.swing.JButton userorderUpdate;
    private javax.swing.JLabel users_firstname;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
class RoundedPanel extends JPanel {

        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;

        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }
