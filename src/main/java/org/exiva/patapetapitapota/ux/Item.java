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
	private static final ImageIcon imgPOOP = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/poop_2.png"));
	private JLabel lblImg;
	public Item(String item, Point location, int ttl) {		
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
		this.setModal(false);
		this.setFocusableWindowState(false);
		this.setVisible(true);
		switch (item) {
		case "EGG":
			updateImage(imgEGG);			
			break;
		case "POOP":
			updateImage(imgPOOP);			
			break;
		default:
			this.dispose();
			break;
		}
		if(ttl > 0) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(ttl);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Item.this.dispose();
					//new Bot().setLocation((int)location.getX()-11, (int)location.getY()-20);
				}
			}).start();
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
