
package com.apparel.model;

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.WrappedPlainView;

public class PanelItem extends JPanel {
    
    public PanelItem(){
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT,45,45));
    }
}
