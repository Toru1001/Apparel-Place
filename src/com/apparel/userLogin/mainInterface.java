
package com.apparel.userLogin;


import com.apparel.component.apparelItem;
import com.apparel.model.ScrollBar;
import com.apparel.model.modelItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class mainInterface extends javax.swing.JFrame {
    userLogIn login = new userLogIn();
    String next;
    
    void showUser(){
        login.info(next);
        userid.setText("User Id: " + login.userId);
        first_name.setText(login.firstname);
        last_name.setText(login.lastname);
        userName.setText(login.username);
        email_address.setText(login.email);
        local_address.setText(login.localaddress);
        mobile_number.setText(login.mobilenumber);
        passWord.setText(login.password);
    }
    
    void updateUser(){
        
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
    
    public void showBagItems(){
        
        int ID = 1;
        for(int i = 0; i<=0; i++){
            addItem(new modelItem(ID++, "Daily Bag", "Blueberry Canvas Tote Bag", 600, "BlueBerry", new ImageIcon(getClass().getResource("/com/apparel/items/burberry (tote bag).jpg"))));
            addItem(new modelItem(ID++, "Daily Bag", "Elegant Celine Handbag", 900, "Celine", new ImageIcon(getClass().getResource("/com/apparel/items/celine (handbag).jpg"))));
            addItem(new modelItem(ID++, "Daily Bag", "Everyday used Nike backpack", 600, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/Nike (backpack.jpg"))));
            addItem(new modelItem(ID++, "Daily Bag", "Unisex Crossbody Bag", 150, "North Face", new ImageIcon(getClass().getResource("/com/apparel/items/north face (crossbody bag).jpg"))));
            addItem(new modelItem(ID++, "Daily Bag", "UNISEX Neutral Color YSL satchel", 900, "Saint Laurent", new ImageIcon(getClass().getResource("/com/apparel/items/Saint Laurent (satchel).jpg"))));
            addItem(new modelItem(ID++, "Sports Bag", "Nike Sports Bag BLACK", 550, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/nike (duffel bag_1).jpg"))));
            addItem(new modelItem(ID++, "Sports Bag", "Nike Sports Bag GREEN", 550, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/nike (duffel bag0.jpg"))));
            addItem(new modelItem(ID++, "Sports Bag", "Good quality Sports Bag", 800, "North Face", new ImageIcon(getClass().getResource("/com/apparel/items/north face (sports).jpg"))));
            addItem(new modelItem(ID++, "Travel Bag", "High Quality Backpack", 1100, "North Face", new ImageIcon(getClass().getResource("/com/apparel/items/north face.jpg"))));
            addItem(new modelItem(ID++, "Travel Bag", "Waterproof Nike Travel Bag", 800, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/nike (travel).jpg"))));
            addItem(new modelItem(ID++, "Travel Bag", "Luggage Travel Bag from Muji", 1825, "Muji", new ImageIcon(getClass().getResource("/com/apparel/items/muji.png"))));

        }
        
    }
    
    public void showClothesItems(){
        
        int ID = 1;
        for(int i = 0; i<=0; i++){
            addItem(new modelItem(ID++, "Jacket", "Trendy Nike Jacket", 350, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/Nike (Jacket).jpg"))));
            addItem(new modelItem(ID++, "Cardigan", "Ralph Lauren Cardigan", 250, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/RL (cardigan).jpg"))));
            addItem(new modelItem(ID++, "Sweater Vest", "<html><body><p align='justify'>Ralph Lauren Knitted Sweater Vest</p></body></html>", 250, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/RL (sweater vest).jpg"))));
            addItem(new modelItem(ID++, "Sweater", "<html><body><p align='justify'>Ralph Lauren Unisex Sweater</p></body></html>", 350, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/RL (SWEATER).jpg"))));
            addItem(new modelItem(ID++, "Hoodie", "Drawstring Plain Hoodie", 300, "UNIQLO", new ImageIcon(getClass().getResource("/com/apparel/items/Uniqlo (oversized hoodie).jpg"))));
            addItem(new modelItem(ID++, "Longsleeve", "Printed Love Sleeve Shirt", 400, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/nike (long sleeve).jpg"))));
            addItem(new modelItem(ID++, "Shirts", "Fitted Shirts for Women", 200, "UNIQLO", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/Uniqlo (fit shirt).jpg"))));
            addItem(new modelItem(ID++, "Plaid Shirt", "Long Sleeve Plaid Shirt", 300, "UNIQLO", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/uniqlo (flannel.jpg"))));
            addItem(new modelItem(ID++, "Collared Shirt", "<html><body><p align='justify'>Zara Oversized Long Sleeve Collared Shirt</p></body></html>", 300, "ZARA", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/zara (oversizzed).jpg"))));
            addItem(new modelItem(ID++, "Polo Shirt", "<html><body><p align='justify'>Green/White Simple Collared Polo Shirt </p></body></html>", 250, "ZARA", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/zara (polo shirts).jpg"))));
            addItem(new modelItem(ID++, "Sweatpants", "Comfortable Sweatpants from Adidas", 200, "Adidas", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/adiddas (sweatpants).jpg"))));
            addItem(new modelItem(ID++, "Shorts", "Nike Sports Shorts", 150, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/nike (short).jpg"))));
            addItem(new modelItem(ID++, "Sweatpants", "Plain Grey Nike Sweatpants", 250, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/nike (sweatpants).jpg"))));
            addItem(new modelItem(ID++, "Trouser", "High Quality Uniqlo Trouser", 300, "UNIQLO", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/Uniqlo (trouser).jpg"))));
            addItem(new modelItem(ID++, "Cargo Pants", "Tendy Cargo Pants", 350, "Zara", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/zara (cargo pants).jpg"))));

        }   
    }
    
    public void showFootwearItems (){
         int ID = 1;
          for(int i = 0; i<=0; i++){
            addItem(new modelItem(ID++, "Boots", "Men Casual/Formal Shoes from Dr. Martens (Chealsea Boots)", 2500, "Dr. Martens", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/dr. martens (chealsea boots).jpg"))));
            addItem(new modelItem(ID++, "Formal Shoes", "Men Casual/Formal Shoes from Dr. Martens", 2250, "Dr. Martens", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/dr. martens (formal).jpg"))));
            addItem(new modelItem(ID++, "Green Leather Shoes", "Men Casual/Formal Shoes from Dr. Martens", 2200, "Dr. Martens", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/dr. martens (formal1).jpg"))));
            addItem(new modelItem(ID++, "Loafers", "Men Casual/Formal Shoes from Dr. Martens", 2150, "Dr. Martens", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/dr. martens (loafers).jpg"))));
            addItem(new modelItem(ID++, "Black Formal Shoes", "Men Casual/Formal Shoes from Dr. Martens", 2200, "Dr. Martens", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/dr. martens 1.jpg"))));
            addItem(new modelItem(ID++, "Adidas Sneakers", "Adidas White Sneakers for Men", 1000, "Adidas", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/adidass (sneakers).jpg"))));
            addItem(new modelItem(ID++, "Casual Sneakers", "Casual White Sneakers from Celine", 950, "Celine", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/celine (sneakers).jpg"))));
            addItem(new modelItem(ID++, "High Top", "Converse HIgh Top Canvas Shoes", 1750, "Converse", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/Converse (high top sneakers).jpg"))));
            addItem(new modelItem(ID++, "Nike Sneakers", "High Quality Nike Sneakers", 1500, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/nike (sneakers).jpg"))));
            addItem(new modelItem(ID++, "White Sneakers", "<html><body><p align='justify'>New Arrival Reebok White Sneekers</p></body></html>", 1000, "Reebok", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/reebok (sneakers).jpg"))));
            addItem(new modelItem(ID++, "Black Training Shoes", "Adidas Unisex Running Shoes", 1200, "Adidas", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/adidas (running).jpg"))));
            addItem(new modelItem(ID++, "White Training Shoes", "Breathable White Training Shoes", 1550, "Adidas", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/adiddas (running).jpg"))));
            addItem(new modelItem(ID++, "Running Shoes", "New Balance Sports Shoes for Women", 1500, "New Balance", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/new balance (running).jpg"))));
            addItem(new modelItem(ID++, "Nike Training Shoes", "Nike Training Shoes for Men", 1250, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/nike (running).jpg"))));
            addItem(new modelItem(ID++, "Nike Shoes", "Black Nike Sports Shoes", 1990, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/footwear/nike (running1).jpg"))));
          }  
}
    
        public void uneditted(){
            first_name.setEditable(false);
            last_name.setEditable(false);
            userName.setEditable(false);
            email_address.setEditable(false);
            local_address.setEditable(false);
            mobile_number.setEditable(false);
            passWord.setEditable(false);
        }
        
        public void edittable(){
            first_name.setEditable(true);
            last_name.setEditable(true);
            userName.setEditable(true);
            email_address.setEditable(true);
            local_address.setEditable(true);
            mobile_number.setEditable(true);
            passWord.setEditable(true);
        }
    
    public mainInterface() {
        initComponents();
        showUser();
        itemScrollBar.setVerticalScrollBar(new ScrollBar());
    }

    int xMouse, yMouse;
    
    public void clearAllProducts(){
        panelItem1.removeAll();
        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
    public void addItem(modelItem data){
        apparelItem item = new apparelItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)){
                    System.out.println(data.getDescription());
                }
            }
        });
        
        panelItem1.add(item);
        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        sidePanel = new keeptoo.KGradientPanel();
        productButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cartButton = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        accountButton = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        settingButton = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        productsfirst = new javax.swing.JPanel();
        bagsButton = new javax.swing.JPanel();
        pictureBox1 = new com.apparel.model.pictureBox();
        jLabel3 = new javax.swing.JLabel();
        clothesButton = new javax.swing.JPanel();
        pictureBox2 = new com.apparel.model.pictureBox();
        jLabel4 = new javax.swing.JLabel();
        footwearButton = new javax.swing.JPanel();
        pictureBox3 = new com.apparel.model.pictureBox();
        jLabel5 = new javax.swing.JLabel();
        items = new javax.swing.JPanel();
        itemScrollBar = new javax.swing.JScrollPane();
        panelItem1 = new com.apparel.model.PanelItem();
        profile = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pictureBox4 = new com.apparel.model.pictureBox();
        jPanel2 = new javax.swing.JPanel();
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
        setting = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cart = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px.png"))); // NOI18N
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

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px.png"))); // NOI18N
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

        sidePanel.setkEndColor(new java.awt.Color(204, 0, 204));
        sidePanel.setkStartColor(new java.awt.Color(204, 204, 204));

        productButton.setBackground(new java.awt.Color(153, 0, 153));
        productButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productButtonMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("PRODUCTS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_open_box_80px.png"))); // NOI18N

        javax.swing.GroupLayout productButtonLayout = new javax.swing.GroupLayout(productButton);
        productButton.setLayout(productButtonLayout);
        productButtonLayout.setHorizontalGroup(
            productButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        productButtonLayout.setVerticalGroup(
            productButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productButtonLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(productButtonLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cartButton.setBackground(new java.awt.Color(153, 0, 153));
        cartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartButtonMouseReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Inter SemiBold", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("CART");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_shopping_cart_80px.png"))); // NOI18N

        javax.swing.GroupLayout cartButtonLayout = new javax.swing.GroupLayout(cartButton);
        cartButton.setLayout(cartButtonLayout);
        cartButtonLayout.setHorizontalGroup(
            cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        cartButtonLayout.setVerticalGroup(
            cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartButtonLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        accountButton.setBackground(new java.awt.Color(153, 0, 153));
        accountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accountButtonMouseReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("ACCOUNT");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_account_80px.png"))); // NOI18N

        javax.swing.GroupLayout accountButtonLayout = new javax.swing.GroupLayout(accountButton);
        accountButton.setLayout(accountButtonLayout);
        accountButtonLayout.setHorizontalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountButtonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        accountButtonLayout.setVerticalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountButtonLayout.createSequentialGroup()
                .addGroup(accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accountButtonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accountButtonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        settingButton.setBackground(new java.awt.Color(153, 0, 153));
        settingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                settingButtonMouseReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("SETTINGS");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_settings_80px.png"))); // NOI18N

        javax.swing.GroupLayout settingButtonLayout = new javax.swing.GroupLayout(settingButton);
        settingButton.setLayout(settingButtonLayout);
        settingButtonLayout.setHorizontalGroup(
            settingButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingButtonLayout.setVerticalGroup(
            settingButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingButtonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(settingButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingButtonLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logOutButton.setBackground(new java.awt.Color(153, 0, 153));
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logOutButtonMouseReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Inter SemiBold", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("LOG - OUT");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Login_50px.png"))); // NOI18N

        javax.swing.GroupLayout logOutButtonLayout = new javax.swing.GroupLayout(logOutButton);
        logOutButton.setLayout(logOutButtonLayout);
        logOutButtonLayout.setHorizontalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logOutButtonLayout.setVerticalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logOutButtonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(logOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 230, 690));

        cardPanel.setLayout(new java.awt.CardLayout());

        productsfirst.setBackground(new java.awt.Color(204, 204, 204));

        bagsButton.setBackground(new java.awt.Color(204, 51, 255));
        bagsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bagsButton.setForeground(new java.awt.Color(204, 102, 255));
        bagsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bagsButton.setPreferredSize(new java.awt.Dimension(200, 300));
        bagsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bagsButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bagsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bagsButtonMouseReleased(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Bag_120px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("BAGS");

        javax.swing.GroupLayout bagsButtonLayout = new javax.swing.GroupLayout(bagsButton);
        bagsButton.setLayout(bagsButtonLayout);
        bagsButtonLayout.setHorizontalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagsButtonLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(bagsButtonLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bagsButtonLayout.setVerticalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bagsButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        clothesButton.setBackground(new java.awt.Color(204, 51, 255));
        clothesButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        clothesButton.setForeground(new java.awt.Color(102, 102, 102));
        clothesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clothesButton.setPreferredSize(new java.awt.Dimension(200, 300));
        clothesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clothesButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clothesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clothesButtonMouseReleased(evt);
            }
        });

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Clothes_120px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("CLOTHES");

        javax.swing.GroupLayout clothesButtonLayout = new javax.swing.GroupLayout(clothesButton);
        clothesButton.setLayout(clothesButtonLayout);
        clothesButtonLayout.setHorizontalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clothesButtonLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        clothesButtonLayout.setVerticalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        footwearButton.setBackground(new java.awt.Color(204, 51, 255));
        footwearButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        footwearButton.setForeground(new java.awt.Color(102, 102, 102));
        footwearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footwearButton.setPreferredSize(new java.awt.Dimension(200, 300));
        footwearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footwearButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                footwearButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                footwearButtonMouseReleased(evt);
            }
        });

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Footwear_120px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("FOOTWEAR");

        javax.swing.GroupLayout footwearButtonLayout = new javax.swing.GroupLayout(footwearButton);
        footwearButton.setLayout(footwearButtonLayout);
        footwearButtonLayout.setHorizontalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footwearButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        footwearButtonLayout.setVerticalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout productsfirstLayout = new javax.swing.GroupLayout(productsfirst);
        productsfirst.setLayout(productsfirstLayout);
        productsfirstLayout.setHorizontalGroup(
            productsfirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsfirstLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bagsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(clothesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(footwearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        productsfirstLayout.setVerticalGroup(
            productsfirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsfirstLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(productsfirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(footwearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clothesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bagsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
        );

        cardPanel.add(productsfirst, "card2");

        itemScrollBar.setViewportView(panelItem1);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        cardPanel.add(items, "card6");

        profile.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel22.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("PROFILE");

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_account_80px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
            .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("First Name");

        first_name.setBackground(new java.awt.Color(204, 204, 204));
        first_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        first_name.setForeground(new java.awt.Color(0, 0, 0));
        first_name.setText("Marcus");

        jlabel.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jlabel.setForeground(new java.awt.Color(204, 204, 204));
        jlabel.setText("Last Name");

        last_name.setBackground(new java.awt.Color(204, 204, 204));
        last_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        last_name.setForeground(new java.awt.Color(0, 0, 0));
        last_name.setText("Garcia");

        jLabel8.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Username");

        userName.setBackground(new java.awt.Color(204, 204, 204));
        userName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        userName.setForeground(new java.awt.Color(0, 0, 0));
        userName.setText("johan13");

        jLabel11.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Email");

        local_address.setBackground(new java.awt.Color(204, 204, 204));
        local_address.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        local_address.setForeground(new java.awt.Color(0, 0, 0));
        local_address.setText("29 San Pablo Street, Matina Aplaya, Davao City");

        jLabel12.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Local Address");

        email_address.setBackground(new java.awt.Color(204, 204, 204));
        email_address.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        email_address.setForeground(new java.awt.Color(0, 0, 0));
        email_address.setText("garciamarcusjohan@gmail.com");

        jLabel13.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Mobile Number");

        mobile_number.setBackground(new java.awt.Color(204, 204, 204));
        mobile_number.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        mobile_number.setForeground(new java.awt.Color(0, 0, 0));
        mobile_number.setText("09103627797");

        jLabel14.setFont(new java.awt.Font("Inter SemiBold", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Password");

        passWord.setBackground(new java.awt.Color(204, 204, 204));
        passWord.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        passWord.setForeground(new java.awt.Color(0, 0, 0));
        passWord.setText("test123");

        userid.setFont(new java.awt.Font("Inter SemiBold", 0, 12)); // NOI18N
        userid.setForeground(new java.awt.Color(51, 51, 51));
        userid.setText("User Id:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mobile_number, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(local_address, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabel)))
                            .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_address, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(userid)
                                .addGap(16, 16, 16))))
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(passWord))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(userid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(local_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(mobile_number, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

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
        saveEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveEdit.setForeground(new java.awt.Color(0, 0, 0));
        saveEdit.setText("Save");
        saveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profileLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveEdit)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(profileLayout.createSequentialGroup()
                        .addContainerGap(129, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(saveEdit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(profile, "card4");

        setting.setBackground(new java.awt.Color(204, 204, 204));

        jLabel23.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("SETTINGS");

        javax.swing.GroupLayout settingLayout = new javax.swing.GroupLayout(setting);
        setting.setLayout(settingLayout);
        settingLayout.setHorizontalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel23)
                .addContainerGap(900, Short.MAX_VALUE))
        );
        settingLayout.setVerticalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel23)
                .addContainerGap(629, Short.MAX_VALUE))
        );

        cardPanel.add(setting, "card3");

        cart.setBackground(new java.awt.Color(204, 204, 204));
        cart.setForeground(new java.awt.Color(51, 51, 51));

        jLabel24.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("CART");

        javax.swing.GroupLayout cartLayout = new javax.swing.GroupLayout(cart);
        cart.setLayout(cartLayout);
        cartLayout.setHorizontalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel24)
                .addContainerGap(955, Short.MAX_VALUE))
        );
        cartLayout.setVerticalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel24)
                .addContainerGap(629, Short.MAX_VALUE))
        );

        cardPanel.add(cart, "card5");

        getContentPane().add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 1050, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px_1.png")));
    }//GEN-LAST:event_closeButtonMousePressed

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px.png")));
    }//GEN-LAST:event_closeButtonMouseReleased

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMousePressed
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px_1.png")));
    }//GEN-LAST:event_minimizeButtonMousePressed

    private void minimizeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseReleased
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px.png")));
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
        changeCard(productsfirst);
        clearAllProducts();
    }//GEN-LAST:event_productButtonMouseClicked

    private void cartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseClicked
        changeCard(cart);
    }//GEN-LAST:event_cartButtonMouseClicked

    private void accountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseClicked
       changeCard(profile);
        saveEdit.hide();
        uneditted();
    }//GEN-LAST:event_accountButtonMouseClicked

    private void settingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButtonMouseClicked
        changeCard(setting);
    }//GEN-LAST:event_settingButtonMouseClicked

    private void productButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMousePressed
        productButton.setBackground(new java.awt.Color(204,153,255));
    }//GEN-LAST:event_productButtonMousePressed

    private void productButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseReleased
        productButton.setBackground(new java.awt.Color(153,0,153));
    }//GEN-LAST:event_productButtonMouseReleased

    private void cartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMousePressed
        cartButton.setBackground(new java.awt.Color(204,153,255));
    }//GEN-LAST:event_cartButtonMousePressed

    private void cartButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseReleased
        cartButton.setBackground(new java.awt.Color(153,0,153));
    }//GEN-LAST:event_cartButtonMouseReleased

    private void accountButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMousePressed
        accountButton.setBackground(new java.awt.Color(204,153,255));
    }//GEN-LAST:event_accountButtonMousePressed

    private void accountButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseReleased
        accountButton.setBackground(new java.awt.Color(153,0,153));
    }//GEN-LAST:event_accountButtonMouseReleased

    private void settingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButtonMousePressed
        settingButton.setBackground(new java.awt.Color(204,153,255));
    }//GEN-LAST:event_settingButtonMousePressed

    private void settingButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingButtonMouseReleased
        settingButton.setBackground(new java.awt.Color(153,0,153));
    }//GEN-LAST:event_settingButtonMouseReleased

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        int input = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO LOG-OUT?", "Apparel Place" ,JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
        
        if(input == 0){
        this.setVisible(false);
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
    }//GEN-LAST:event_bagsButtonMouseClicked

    private void clothesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseClicked
        changeCard(items);
        showClothesItems();
    }//GEN-LAST:event_clothesButtonMouseClicked

    private void bagsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagsButtonMousePressed
        bagsButton.setBackground(new Color(204,153,255));
    }//GEN-LAST:event_bagsButtonMousePressed

    private void bagsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bagsButtonMouseReleased
        bagsButton.setBackground(new Color(204,51,255));
    }//GEN-LAST:event_bagsButtonMouseReleased

    private void clothesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMousePressed
        clothesButton.setBackground(new Color(204,153,255));
    }//GEN-LAST:event_clothesButtonMousePressed

    private void clothesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseReleased
        clothesButton.setBackground(new Color(204,51,255));
    }//GEN-LAST:event_clothesButtonMouseReleased

    private void footwearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMousePressed
        footwearButton.setBackground(new Color(204,153,255));
    }//GEN-LAST:event_footwearButtonMousePressed

    private void footwearButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseReleased
        footwearButton.setBackground(new Color(204,51,255));
    }//GEN-LAST:event_footwearButtonMouseReleased

    private void footwearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseClicked
        changeCard(items);
        showFootwearItems();
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

   
    
    public void changeCard(Component Card) {
        cardPanel.removeAll();
        cardPanel.add(Card);
        cardPanel.repaint();
        cardPanel.revalidate();
    }
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountButton;
    private javax.swing.JPanel bagsButton;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cart;
    private javax.swing.JPanel cartButton;
    private javax.swing.JLabel closeButton;
    private javax.swing.JPanel clothesButton;
    private javax.swing.JTextField email_address;
    private javax.swing.JTextField first_name;
    private javax.swing.JPanel footwearButton;
    private javax.swing.JScrollPane itemScrollBar;
    private javax.swing.JPanel items;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField local_address;
    private javax.swing.JPanel logOutButton;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField mobile_number;
    private com.apparel.model.PanelItem panelItem1;
    private javax.swing.JPasswordField passWord;
    private com.apparel.model.pictureBox pictureBox1;
    private com.apparel.model.pictureBox pictureBox2;
    private com.apparel.model.pictureBox pictureBox3;
    private com.apparel.model.pictureBox pictureBox4;
    private javax.swing.JPanel productButton;
    private javax.swing.JPanel productsfirst;
    private javax.swing.JPanel profile;
    private javax.swing.JButton saveEdit;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel settingButton;
    private keeptoo.KGradientPanel sidePanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userid;
    // End of variables declaration//GEN-END:variables
}
