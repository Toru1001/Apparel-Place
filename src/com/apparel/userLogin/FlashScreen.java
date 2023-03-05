
package com.apparel.userLogin;

import com.apparel.model.modelItem;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class FlashScreen extends javax.swing.JFrame {

    
    
    public FlashScreen() {
        initComponents();
        
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        flashLogo = new javax.swing.JLabel();
        loadingText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apparel Place");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 290, 20));

        jLabel2.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("____________________");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 240, 50));

        jLabel4.setFont(new java.awt.Font("Inter ExtraBold", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("PLACE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inter ExtraBold", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("APPAREL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        flashLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/APPAREL PLACE LOGO(small).png"))); // NOI18N
        getContentPane().add(flashLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 200, 180));

        loadingText.setFont(new java.awt.Font("Inter Medium", 0, 12)); // NOI18N
        loadingText.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(loadingText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 240, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/utilities/Asset 2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    static void progressBarAction() {
        FlashScreen FS = new FlashScreen();
        FS.setVisible(true);
       /* ImageIcon img = new ImageIcon("");
        FS.setIconImage(img.getImage()); */
        UIManager.put("ProgressBar.selectionBackground", Color.black);
        UIManager.put("ProgressBar.selectionForeground", Color.white);
        UIManager.put("ProgressBar.foreground", new Color(49, 65, 95));
        for (float i = 0.00f; i < 1.00f; i += 0.01f) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            FS.setOpacity(i);
        }

        for (int i = 0; i <= 100; i++) {
            try {
                Random random = new Random();
                int number = random.nextInt(30) + 1;
                Thread.sleep(number);
                FS.progressBar.setValue(i);
                if(i <=100){
                    loadingText.setText("Loading in progress... " + i + "%");
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        new userLogIn().setVisible(true);
        FS.dispose();
    }
   
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       progressBarAction();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel flashLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel loadingText;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
