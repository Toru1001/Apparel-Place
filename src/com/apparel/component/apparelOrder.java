
package com.apparel.component;

import com.apparel.model.shipDetails;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class apparelOrder extends javax.swing.JPanel {
    private shipDetails data;
    private boolean selected;
    
    public shipDetails getData() {
        return data;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
   
    public apparelOrder() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public void setData(shipDetails data){
        this.data = data;
        lbPicture.setImage(data.getIcon());
        lbMode.setText("Mode of Payment: " + data.getPaymentMethod());
        lbDetails.setText("<html><body><p align='justify'>"+data.getDescription()+"</p></body></html>");
        lbOrderDate.setText("Date Ordered: " + data.getTimeOrder());
        lbestDateRecieve.setText("Estimated Order Recieved: " + data.getEstRecieveDate());
        lbTotalPayment.setText(data.getTotalPrice());
    }
    
@Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(204,204,204));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(153,0,153));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPicture = new com.apparel.model.pictureBox();
        lbTotalPayment = new javax.swing.JLabel();
        lbOrderDate = new javax.swing.JLabel();
        lbestDateRecieve = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbDetails = new javax.swing.JLabel();
        lbMode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        lbPicture.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/apparel/items/bagProducts/Adidas by Stella McCartney  Gym Sack.png"))); // NOI18N

        lbTotalPayment.setFont(new java.awt.Font("Inter Medium", 0, 18)); // NOI18N
        lbTotalPayment.setForeground(new java.awt.Color(51, 51, 51));
        lbTotalPayment.setText("Total Payment:");

        lbOrderDate.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbOrderDate.setForeground(new java.awt.Color(51, 51, 51));
        lbOrderDate.setText("Date Ordered:");

        lbestDateRecieve.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbestDateRecieve.setForeground(new java.awt.Color(51, 51, 51));
        lbestDateRecieve.setText("Estimated Date Recieve:");

        jLabel3.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Order Details:");

        lbDetails.setBackground(new java.awt.Color(51, 51, 51));
        lbDetails.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        lbDetails.setForeground(new java.awt.Color(51, 51, 51));
        lbDetails.setText("Levi Backpack 2x Size: L ");

        lbMode.setFont(new java.awt.Font("Inter Medium", 0, 14)); // NOI18N
        lbMode.setForeground(new java.awt.Color(51, 51, 51));
        lbMode.setText("Mode of Payment:");

        jLabel1.setFont(new java.awt.Font("Inter Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Ordered Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lbestDateRecieve, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(lbDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMode, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbOrderDate)
                            .addComponent(lbestDateRecieve))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbDetails;
    private javax.swing.JLabel lbMode;
    private javax.swing.JLabel lbOrderDate;
    private com.apparel.model.pictureBox lbPicture;
    private javax.swing.JLabel lbTotalPayment;
    private javax.swing.JLabel lbestDateRecieve;
    // End of variables declaration//GEN-END:variables
}
