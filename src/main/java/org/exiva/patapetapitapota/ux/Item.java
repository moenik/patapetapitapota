package org.exiva.patapetapitapota.ux;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.exiva.patapetapitapota.Main;

public class Item extends JDialog{

	private static final long serialVersionUID = 1L;

	private static final ImageIcon imgEGG = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/egg.png"));
	private JLabel lblImg;
	public Item(String item, Point location) {		
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setSize(32, 32);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		this.setLayout(new GridLayout(1, 1));
		this.lblImg = new JLabel();
		this.add(lblImg);
		this.setBackground(new Color(0, 0, 0, 0)); 
		this.setLocation(location);
		this.setVisible(true);
		switch (item) {
		case "EGG":
			updateImage(imgEGG);			
			break;
		default:
			this.dispose();
			break;
		}
	}
	
	private void updateImage(ImageIcon img) {
		if(img == null || this.lblImg.getIcon() == img) {
			return;
		}
		this.lblImg.setIcon(img);
		this.setSize(img.getIconWidth(), img.getIconHeight());
		this.repaint();
	}
	
	
	
}
