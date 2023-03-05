package com.apparel.userLogin;


import com.apparel.model.userInfo;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class userLogIn extends javax.swing.JFrame {

    int yMouse; int xMouse;
    
    Connection connect;
    PreparedStatement prep;
    ResultSet rst;
    
    static userInfo info = new userInfo();
    static String email, username, firstname,lastname,mobilenumber,localaddress,userId,password;
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/apparel_accounts", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
               
}
    
    public userLogIn() {
        initComponents();
        Connect();
    }

    
    
    public static String info(String a){
        String next= "";
        email = info.getEmail();
        username = info.getUsername();
        firstname = info.getFirstname();
        lastname = info.getLastname();
        mobilenumber = info.getMobilenumber();
        localaddress = info.getLocaladdress();
        userId = info.getUserId();
        password = info.getPassword();
        return next;
    }
    
    
    
    void getuserInfo(){
        String user = usernameField.getText();
        String pass = new String (userPassField.getText());
        try {
            prep = connect.prepareStatement("SELECT * FROM user_logins where username = '"+user+"' and password = '"+pass+"'");
            rst = prep.executeQuery();
            
            while (rst.next()){
            String username = rst.getString("username");
            String email = rst.getString("email");
            String password = rst.getString("password");
            String firstname = rst.getString("first_name");
            String lastname = rst.getString("last_name");
            String userId = rst.getString("user_id");
            String localaddress = rst.getString("local_address");
            String mobilenumber = rst.getString("mobile_number");
            
            info.setEmail(email);
            info.setFirstname(firstname);
            info.setPassword(password);
            info.setLastname(lastname);
            info.setLocaladdress(localaddress);
            info.setMobilenumber(mobilenumber);
            info.setUserId(userId);
            info.setUsername(username);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();
        logIn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userPassField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        registerButton = new javax.swing.JLabel();
        showPassword = new javax.swing.JCheckBox();
        invalidinput = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        newUserField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        localAddressField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        mobileNumberField = new javax.swing.JLabel();
        localAddressField1 = new javax.swing.JTextField();
        mobileNumberField1 = new javax.swing.JLabel();
        mobileNumberField2 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        newPassField = new javax.swing.JPasswordField();
        newRePassField = new javax.swing.JPasswordField();
        panel1 = new keeptoo.KGradientPanel();
        closeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apparel Place");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frame"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardPanel.setLayout(new java.awt.CardLayout());

        logIn.setBackground(new java.awt.Color(204, 204, 204));
        logIn.setPreferredSize(new java.awt.Dimension(350, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username:");

        usernameField.setBackground(new java.awt.Color(204, 204, 204));
        usernameField.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        usernameField.setForeground(new java.awt.Color(51, 51, 51));
        usernameField.setText("Input Username/Email");
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });
        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameFieldKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Password:");

        userPassField.setBackground(new java.awt.Color(204, 204, 204));
        userPassField.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        userPassField.setForeground(new java.awt.Color(51, 51, 51));
        userPassField.setText("password");
        userPassField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userPassFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userPassFieldFocusLost(evt);
            }
        });
        userPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userPassFieldKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 255));
        jButton1.setFont(new java.awt.Font("Inter SemiBold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log - in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_user_80px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("WELCOME!");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Don't have an account?");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        registerButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(204, 0, 204));
        registerButton.setText("Register");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });

        showPassword.setBackground(new java.awt.Color(204, 204, 204));
        showPassword.setFont(new java.awt.Font("Inter Light", 0, 11)); // NOI18N
        showPassword.setForeground(new java.awt.Color(51, 51, 51));
        showPassword.setText("Show Password");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        invalidinput.setBackground(new java.awt.Color(255, 255, 255));
        invalidinput.setForeground(new java.awt.Color(255, 255, 255));
        invalidinput.setText(".");

        javax.swing.GroupLayout logInLayout = new javax.swing.GroupLayout(logIn);
        logIn.setLayout(logInLayout);
        logInLayout.setHorizontalGroup(
            logInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(logInLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(logInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invalidinput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(logInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(userPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(showPassword)
                        .addGroup(logInLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(registerButton))
                        .addGroup(logInLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(jLabel3))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(logInLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logInLayout.setVerticalGroup(
            logInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidinput)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(showPassword)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addGroup(logInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(registerButton))
                .addGap(24, 24, 24))
        );

        cardPanel.add(logIn, "card4");

        registerPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_Add_Male_User_Group_80px.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("USER | SIGN - UP");

        jLabel7.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("First Name:");

        firstNameField.setBackground(new java.awt.Color(204, 204, 204));
        firstNameField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Username:");

        newUserField.setBackground(new java.awt.Color(204, 204, 204));
        newUserField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        newUserField.setForeground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email Address:");

        localAddressField.setBackground(new java.awt.Color(204, 204, 204));
        localAddressField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        localAddressField.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Local Address:");

        emailField.setBackground(new java.awt.Color(204, 204, 204));
        emailField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));

        mobileNumberField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        mobileNumberField.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumberField.setText("Mobile Number:");

        localAddressField1.setBackground(new java.awt.Color(204, 204, 204));
        localAddressField1.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        localAddressField1.setForeground(new java.awt.Color(51, 51, 51));

        mobileNumberField1.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        mobileNumberField1.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumberField1.setText("Type Password:");

        mobileNumberField2.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        mobileNumberField2.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumberField2.setText("Re-type Password:");

        signUpButton.setBackground(new java.awt.Color(204, 204, 204));
        signUpButton.setFont(new java.awt.Font("Inter Black", 0, 12)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(51, 51, 51));
        signUpButton.setText("SIGN - UP");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Last Name:");

        lastNameField.setBackground(new java.awt.Color(204, 204, 204));
        lastNameField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Inter Light", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 153));
        jLabel13.setText("Cancel");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        newPassField.setBackground(new java.awt.Color(204, 204, 204));
        newPassField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        newPassField.setForeground(new java.awt.Color(51, 51, 51));

        newRePassField.setBackground(new java.awt.Color(204, 204, 204));
        newRePassField.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        newRePassField.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(signUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mobileNumberField)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(newUserField)
                            .addComponent(emailField)
                            .addComponent(localAddressField)
                            .addComponent(localAddressField1)
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobileNumberField2)
                                    .addComponent(mobileNumberField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newRePassField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(registerPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(lastNameField))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobileNumberField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localAddressField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileNumberField1)
                    .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileNumberField2)
                    .addComponent(newRePassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpButton)
                    .addComponent(jLabel13))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        cardPanel.add(registerPanel, "card3");

        getContentPane().add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 480));

        panel1.setkEndColor(new java.awt.Color(204, 0, 204));
        panel1.setkGradientFocus(250);
        panel1.setkStartColor(new java.awt.Color(207, 159, 255));

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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/APPAREL PLACE LOGO.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("---------------------------------------");

        jLabel14.setFont(new java.awt.Font("Inter ExtraBold", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("PLACE");

        jLabel16.setFont(new java.awt.Font("Inter ExtraBold", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("APPAREL");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(98, 98, 98))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizeButton)
                    .addComponent(closeButton))
                .addGap(57, 57, 57)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 360, 480));

        jPanel1.setPreferredSize(new java.awt.Dimension(719, 40));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void loginAction(){
        String user = usernameField.getText();
        String pass = new String (userPassField.getText());
        try {
            prep = connect.prepareStatement("SELECT * FROM user_logins");
            rst = prep.executeQuery();
            
            while (rst.next()){
            String username = rst.getString("username");
            String email = rst.getString("email");
            String password = rst.getString("password");
            
            if ((user.equals(username) || user.equals(email)) && (pass.equals(password))){
                invalidinput.setIcon(null);
                getuserInfo();
                JOptionPane.showMessageDialog(null, "You are now Logged-In!");
                new mainInterface().setVisible(true);
                this.setVisible(false);
            } else {
                invalidinput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/invalid.png")));
            }
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginAction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void userPassFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPassFieldFocusLost
        if (userPassField.getText().equals("password") || userPassField.getText().equals("")) {
            userPassField.setForeground(new Color(102, 102, 102));
            userPassField.setText("password");

        }
    }//GEN-LAST:event_userPassFieldFocusLost

    private void userPassFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userPassFieldFocusGained
        if (userPassField.getText().equals("password")) {
            userPassField.setText("");
            userPassField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_userPassFieldFocusGained

    private void usernameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusLost
        if (usernameField.getText().equals("Input Username/Email") || usernameField.getText().equals("")) {
            usernameField.setForeground(new Color(102, 102, 102));
            usernameField.setText("Input Username/Email");
        }
    }//GEN-LAST:event_usernameFieldFocusLost

    private void usernameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFieldFocusGained
        if (usernameField.getText().equals("Input Username/Email")) {
            usernameField.setText("");
            usernameField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_usernameFieldFocusGained

    private void minimizeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseReleased
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px.png")));
    }//GEN-LAST:event_minimizeButtonMouseReleased

    private void minimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMousePressed
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_collapse_30px_1.png")));
    }//GEN-LAST:event_minimizeButtonMousePressed

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void closeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseReleased
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px.png")));
    }//GEN-LAST:event_closeButtonMouseReleased

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/icons8_close_30px_1.png")));
    }//GEN-LAST:event_closeButtonMousePressed

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        JOptionPane.showMessageDialog(null, "Sign up!");
        changeCard(registerPanel);
    }//GEN-LAST:event_registerButtonMouseClicked

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        
        String regFirstName = firstNameField.getText();
        String regLastName = lastNameField.getText();
        String regUsername = newUserField.getText();
        String regEmail = emailField.getText();
        String regLocal = localAddressField.getText();
        String regMobile = localAddressField1.getText();
        String regPass = new String (newPassField.getText());
        String regRePass = new String (newRePassField.getText());
        
        try {
            prep = connect.prepareStatement("INSERT INTO user_logins(first_name,last_name,username,email,mobile_number,password,local_address) VALUES(?,?,?,?,?,?,?)");
            prep.setString(1, regFirstName);
            prep.setString(2, regLastName);
            prep.setString(3, regUsername);
            prep.setString(4, regEmail);
            prep.setString(5, regMobile);
            prep.setString(6, regRePass);
            prep.setString(7, regLocal);    
            
            if(regPass.equals(regRePass)){
                prep.executeUpdate();
                JOptionPane.showMessageDialog(null, "You are now Signed-Up!");
                changeCard(logIn);
            } else {
                JOptionPane.showMessageDialog(null, "Password mismatch!");
            }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(userLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        if (showPassword.isSelected()) {
            userPassField.setEchoChar((char) 0);
        } else {
            userPassField.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        changeCard(logIn);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void userPassFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userPassFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginAction();
        }
    }//GEN-LAST:event_userPassFieldKeyPressed

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginAction();
        }
    }//GEN-LAST:event_usernameFieldKeyPressed

    public void changeCard(Component Card) {
        cardPanel.removeAll();
        cardPanel.add(Card);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    public static void main(String args[]) {
       try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel closeButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel invalidinput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField localAddressField;
    private javax.swing.JTextField localAddressField1;
    private javax.swing.JPanel logIn;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel mobileNumberField;
    private javax.swing.JLabel mobileNumberField1;
    private javax.swing.JLabel mobileNumberField2;
    private javax.swing.JPasswordField newPassField;
    private javax.swing.JPasswordField newRePassField;
    private javax.swing.JTextField newUserField;
    private keeptoo.KGradientPanel panel1;
    private javax.swing.JLabel registerButton;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JButton signUpButton;
    private static javax.swing.JPasswordField userPassField;
    private static javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
