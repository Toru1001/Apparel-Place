
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
import javax.swing.SwingConstants;
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
            addItem(new modelItem(ID++, "Jacket", "Trendy Nike Jacket", 350, "Nike", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/Nike (Jacket).jpg"))));
            addItem(new modelItem(ID++, "Cardigan", "Ralph Lauren Cardigan", 250, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/RL (cardigan).jpg"))));
            addItem(new modelItem(ID++, "Sweater Vest", "<html><body><p align='justify'>Ralph Lauren Knitted Sweater Vest</p></body></html>", 250, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/RL (sweater vest).jpg"))));
            addItem(new modelItem(ID++, "Sweater", "<html><body><p align='justify'>Ralph Lauren Unisex Sweater</p></body></html>", 350, "Ralph Laurel", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/RL (SWEATER).jpg"))));
            addItem(new modelItem(ID++, "Hoodie", "Drawstring Plain Hoodie", 300, "UNIQLO", new ImageIcon(getClass().getResource("/com/apparel/items/shirt/Uniqlo (oversized hoodie).jpg"))));
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
        users_firstname.setText(login.firstname);
        users_firstname.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText.setText("WELCOME, " + login.firstname.toUpperCase() + "!");
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
        pictureBox5 = new com.apparel.model.pictureBox();
        jLabel1 = new javax.swing.JLabel();
        accountButton = new javax.swing.JPanel();
        pictureBox7 = new com.apparel.model.pictureBox();
        users_firstname = new javax.swing.JLabel();
        homeButton = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        pictureBox6 = new com.apparel.model.pictureBox();
        cartButton = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pictureBox9 = new com.apparel.model.pictureBox();
        pictureBox10 = new com.apparel.model.pictureBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        homepage = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pictureBox12 = new com.apparel.model.pictureBox();
        pictureBox13 = new com.apparel.model.pictureBox();
        welcomeText = new javax.swing.JLabel();
        shopButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        products = new javax.swing.JPanel();
        bagsButton = new javax.swing.JPanel();
        pictureBox1 = new com.apparel.model.pictureBox();
        jLabel3 = new javax.swing.JLabel();
        clothesButton = new javax.swing.JPanel();
        pictureBox2 = new com.apparel.model.pictureBox();
        jLabel4 = new javax.swing.JLabel();
        footwearButton = new javax.swing.JPanel();
        pictureBox3 = new com.apparel.model.pictureBox();
        jLabel5 = new javax.swing.JLabel();
        accessoriesButton = new javax.swing.JPanel();
        pictureBox11 = new com.apparel.model.pictureBox();
        jLabel10 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pictureBox4 = new com.apparel.model.pictureBox();
        logOutButton = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        pictureBox8 = new com.apparel.model.pictureBox();
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
        cart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartItems = new com.apparel.model.PanelItem();
        items = new javax.swing.JPanel();
        itemScrollBar = new javax.swing.JScrollPane();
        panelItem1 = new com.apparel.model.PanelItem();

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

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_50px_1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("PRODUCTS");

        javax.swing.GroupLayout productButtonLayout = new javax.swing.GroupLayout(productButton);
        productButton.setLayout(productButtonLayout);
        productButtonLayout.setHorizontalGroup(
            productButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(productButtonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
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

        pictureBox7.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Test_Account_60px_1.png"))); // NOI18N

        users_firstname.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        users_firstname.setForeground(new java.awt.Color(51, 51, 51));
        users_firstname.setText("ACCOUNT");
        users_firstname.setAlignmentX(Component.RIGHT_ALIGNMENT);
        users_firstname.setToolTipText("");

        javax.swing.GroupLayout accountButtonLayout = new javax.swing.GroupLayout(accountButton);
        accountButton.setLayout(accountButtonLayout);
        accountButtonLayout.setHorizontalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountButtonLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(accountButtonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(users_firstname)))
                .addGap(16, 16, 16))
        );
        accountButtonLayout.setVerticalGroup(
            accountButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountButtonLayout.createSequentialGroup()
                .addComponent(pictureBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(users_firstname)
                .addContainerGap())
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

        pictureBox6.setBackground(new java.awt.Color(204, 204, 204));
        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_home_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout homeButtonLayout = new javax.swing.GroupLayout(homeButton);
        homeButton.setLayout(homeButtonLayout);
        homeButtonLayout.setHorizontalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeButtonLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(21, 21, 21))
        );
        homeButtonLayout.setVerticalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel20.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("CART");

        pictureBox9.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Shopping_Cart_60px_1.png"))); // NOI18N

        javax.swing.GroupLayout cartButtonLayout = new javax.swing.GroupLayout(cartButton);
        cartButton.setLayout(cartButtonLayout);
        cartButtonLayout.setHorizontalGroup(
            cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartButtonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartButtonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel20))
                    .addComponent(pictureBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        cartButtonLayout.setVerticalGroup(
            cartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartButtonLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(pictureBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        pictureBox10.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/APPAREL PLACE LOGO(small).png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Inter ExtraBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("APPAREL");

        jLabel17.setFont(new java.awt.Font("Impact", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("-------------------");

        jLabel9.setFont(new java.awt.Font("Inter ExtraBold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("PLACE");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel17)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(239, 239, 239)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pictureBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1280, 90));

        cardPanel.setLayout(new java.awt.CardLayout());

        homepage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Inter ExtraLight", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 255));
        jLabel23.setText("WEAR BETTER, LOOK BETTER.");

        pictureBox12.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/City Streetstyle.jpg"))); // NOI18N

        pictureBox13.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/Ultra Light Down.jpg"))); // NOI18N

        welcomeText.setFont(new java.awt.Font("Inter ExtraBold", 0, 36)); // NOI18N
        welcomeText.setForeground(new java.awt.Color(153, 0, 204));
        welcomeText.setText("WELCOME,");

        shopButton.setBackground(new java.awt.Color(153, 0, 204));
        shopButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shopButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                shopButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                shopButtonMouseExited(evt);
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

        javax.swing.GroupLayout homepageLayout = new javax.swing.GroupLayout(homepage);
        homepage.setLayout(homepageLayout);
        homepageLayout.setHorizontalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageLayout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepageLayout.createSequentialGroup()
                .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepageLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
                .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pictureBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        homepageLayout.setVerticalGroup(
            homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepageLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel23)
                .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(homepageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(homepageLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(shopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
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

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Bag_90px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Inter SemiBold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("BAGS");

        javax.swing.GroupLayout bagsButtonLayout = new javax.swing.GroupLayout(bagsButton);
        bagsButton.setLayout(bagsButtonLayout);
        bagsButtonLayout.setHorizontalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagsButtonLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(bagsButtonLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bagsButtonLayout.setVerticalGroup(
            bagsButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bagsButtonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
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

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Inter SemiBold", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CLOTHES");

        javax.swing.GroupLayout clothesButtonLayout = new javax.swing.GroupLayout(clothesButton);
        clothesButton.setLayout(clothesButtonLayout);
        clothesButtonLayout.setHorizontalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesButtonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        clothesButtonLayout.setVerticalGroup(
            clothesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clothesButtonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(43, Short.MAX_VALUE))
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

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px_1.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Inter SemiBold", 0, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("FOOTWEAR");

        javax.swing.GroupLayout footwearButtonLayout = new javax.swing.GroupLayout(footwearButton);
        footwearButton.setLayout(footwearButtonLayout);
        footwearButtonLayout.setHorizontalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footwearButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        footwearButtonLayout.setVerticalGroup(
            footwearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footwearButtonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(36, Short.MAX_VALUE))
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

        pictureBox11.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px_1.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Inter SemiBold", 0, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ACCESSORIES");

        javax.swing.GroupLayout accessoriesButtonLayout = new javax.swing.GroupLayout(accessoriesButton);
        accessoriesButton.setLayout(accessoriesButtonLayout);
        accessoriesButtonLayout.setHorizontalGroup(
            accessoriesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessoriesButtonLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accessoriesButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        accessoriesButtonLayout.setVerticalGroup(
            accessoriesButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accessoriesButtonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pictureBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addGap(50, 50, 50)
                .addGroup(productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accessoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bagsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(footwearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clothesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(320, Short.MAX_VALUE))
        );

        cardPanel.add(products, "card2");

        profile.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel22.setFont(new java.awt.Font("Inter SemiBold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("PROFILE");

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_account_80px.png"))); // NOI18N

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

        pictureBox8.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Login_50px.png"))); // NOI18N

        javax.swing.GroupLayout logOutButtonLayout = new javax.swing.GroupLayout(logOutButton);
        logOutButton.setLayout(logOutButtonLayout);
        logOutButtonLayout.setHorizontalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        logOutButtonLayout.setVerticalGroup(
            logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, logOutButtonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pictureBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 941, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

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
        saveEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveEdit.setForeground(new java.awt.Color(0, 0, 0));
        saveEdit.setText("Save");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEdit)
                    .addComponent(jButton1))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(profile, "card4");

        cart.setBackground(new java.awt.Color(255, 255, 255));
        cart.setForeground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setViewportView(cartItems);

        javax.swing.GroupLayout cartLayout = new javax.swing.GroupLayout(cart);
        cart.setLayout(cartLayout);
        cartLayout.setHorizontalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
                .addContainerGap())
        );
        cartLayout.setVerticalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        cardPanel.add(cart, "card5");

        itemScrollBar.setViewportView(panelItem1);

        javax.swing.GroupLayout itemsLayout = new javax.swing.GroupLayout(items);
        items.setLayout(itemsLayout);
        itemsLayout.setHorizontalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        itemsLayout.setVerticalGroup(
            itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        cardPanel.add(items, "card6");

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
        clearAllProducts();
    }//GEN-LAST:event_productButtonMouseClicked

    private void accountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountButtonMouseClicked
       changeCard(profile);
        saveEdit.hide();
        uneditted();
    }//GEN-LAST:event_accountButtonMouseClicked

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        changeCard(homepage);
    }//GEN-LAST:event_homeButtonMouseClicked

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

    private void shopButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shopButtonMouseEntered
       shopButton.setBackground(new Color(204,102,255));
    }//GEN-LAST:event_shopButtonMouseEntered

    private void shopButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shopButtonMouseExited
        shopButton.setBackground(new Color(153,0,204));
    }//GEN-LAST:event_shopButtonMouseExited

    private void shopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shopButtonMouseClicked
        changeCard(products);
    }//GEN-LAST:event_shopButtonMouseClicked

    private void accessoriesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseClicked
        // TODO add your handling code here:
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
        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px.png")));
    }//GEN-LAST:event_clothesButtonMouseEntered

    private void clothesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clothesButtonMouseExited
        clothesButton.setBackground(new Color (204,204,204));
        jLabel4.setForeground(new Color(51,51,51));
        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_clothes_90px_1.png")));
    }//GEN-LAST:event_clothesButtonMouseExited

    private void footwearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseEntered
        footwearButton.setBackground(new Color (204,153,255));
        jLabel5.setForeground(new Color(255,255,255));
        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px.png")));
    }//GEN-LAST:event_footwearButtonMouseEntered

    private void footwearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footwearButtonMouseExited
        footwearButton.setBackground(new Color (204,204,204));
        jLabel5.setForeground(new Color(51,51,51));
        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_Trainers_90px_1.png")));
    }//GEN-LAST:event_footwearButtonMouseExited

    private void accessoriesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseEntered
        accessoriesButton.setBackground(new Color (204,153,255));
        jLabel10.setForeground(new Color(255,255,255));
        pictureBox11.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px.png")));
    }//GEN-LAST:event_accessoriesButtonMouseEntered

    private void accessoriesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessoriesButtonMouseExited
        accessoriesButton.setBackground(new Color (204,204,204));
        jLabel10.setForeground(new Color(51,51,51));
        pictureBox11.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/mainUI/utilities/icons8_womens_bow_tie_90px_1.png")));
    }//GEN-LAST:event_accessoriesButtonMouseExited

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        logOutButton.setBackground(new Color(204,153,255));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setBackground(new Color(153,0,153));
    }//GEN-LAST:event_logOutButtonMouseExited

   
    
    public void changeCard(Component Card) {
        cardPanel.removeAll();
        cardPanel.add(Card);
        cardPanel.repaint();
        cardPanel.revalidate();
                if(Card.isValid()){
                homeButton.setBackground(new Color(153,0,153));
                }
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
    private javax.swing.JPanel accessoriesButton;
    private javax.swing.JPanel accountButton;
    private javax.swing.JPanel bagsButton;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel cart;
    private javax.swing.JPanel cartButton;
    private com.apparel.model.PanelItem cartItems;
    private javax.swing.JLabel closeButton;
    private javax.swing.JPanel clothesButton;
    private javax.swing.JTextField email_address;
    private javax.swing.JTextField first_name;
    private javax.swing.JPanel footwearButton;
    private javax.swing.JPanel homeButton;
    private javax.swing.JPanel homepage;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField local_address;
    private javax.swing.JPanel logOutButton;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JTextField mobile_number;
    private com.apparel.model.PanelItem panelItem1;
    private javax.swing.JPasswordField passWord;
    private com.apparel.model.pictureBox pictureBox1;
    private com.apparel.model.pictureBox pictureBox10;
    private com.apparel.model.pictureBox pictureBox11;
    private com.apparel.model.pictureBox pictureBox12;
    private com.apparel.model.pictureBox pictureBox13;
    private com.apparel.model.pictureBox pictureBox2;
    private com.apparel.model.pictureBox pictureBox3;
    private com.apparel.model.pictureBox pictureBox4;
    private com.apparel.model.pictureBox pictureBox5;
    private com.apparel.model.pictureBox pictureBox6;
    private com.apparel.model.pictureBox pictureBox7;
    private com.apparel.model.pictureBox pictureBox8;
    private com.apparel.model.pictureBox pictureBox9;
    private javax.swing.JPanel productButton;
    private javax.swing.JPanel products;
    private javax.swing.JPanel profile;
    private javax.swing.JButton saveEdit;
    private javax.swing.JPanel shopButton;
    private keeptoo.KGradientPanel sidePanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel users_firstname;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
