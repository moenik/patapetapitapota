package org.exiva.patapetapitapota.ux;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.exiva.patapetapitapota.Main;
import org.exiva.patapetapitapota.helpers.MouseAndDisplay;

public class Bot extends JDialog implements Runnable{

	private static final long serialVersionUID = 1L;

	private static final ImageIcon imgE1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_E1.png"));
	private static final ImageIcon imgE2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_E2.png"));
	private static final ImageIcon imgE3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_E3.png"));
	
	private static final ImageIcon imgN1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_N1.png"));
	private static final ImageIcon imgN2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_N2.png"));
	private static final ImageIcon imgN3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_N3.png"));
	
	private static final ImageIcon imgS1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_S1.png"));
	private static final ImageIcon imgS2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_S2.png"));
	private static final ImageIcon imgS3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_S3.png"));
	
	private static final ImageIcon imgW1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_W1.png"));
	private static final ImageIcon imgW2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_W2.png"));
	private static final ImageIcon imgW3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_W3.png"));
	
	private static final ImageIcon imgEE1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_E1.png"));
	private static final ImageIcon imgEE2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_E2.png"));
	private static final ImageIcon imgEE3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_E3.png"));
	private static final ImageIcon imgEE4 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_E4.png"));
	
	private static final ImageIcon imgNE1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_N1.png"));
	private static final ImageIcon imgNE2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_N2.png"));
	private static final ImageIcon imgNE3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_N3.png"));
	private static final ImageIcon imgNE4 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_N4.png"));
	
	private static final ImageIcon imgSE1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_S1.png"));
	private static final ImageIcon imgSE2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_S2.png"));
	private static final ImageIcon imgSE3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_S3.png"));
	private static final ImageIcon imgSE4 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_S4.png"));
	
	private static final ImageIcon imgWE1 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_W1.png"));
	private static final ImageIcon imgWE2 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_W2.png"));
	private static final ImageIcon imgWE3 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_W3.png"));
	private static final ImageIcon imgWE4 = new ImageIcon(Main.class.getResource("/org/exiva/patapetapitapota/resources/images/chicken_eat_W4.png"));
	
	
	private boolean alive;
	private JLabel lblImg;
	private int updateFrequency = 100; // milliseconds
	private int velocity = 4; // pixels per update
	
	public Bot() {		
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setSize(32, 32);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		this.setLayout(new GridLayout(1, 1));
		this.lblImg = new JLabel(imgE2);
		this.add(lblImg);
		this.setBackground(new Color(0, 0, 0, 0)); 
		this.setVisible(true);
		this.alive = true;
		new Thread(this).start();
	}
	
	private void updateImage(ImageIcon img) {
		if(img == null || this.lblImg.getIcon() == img) {
			return;
		}
		this.lblImg.setIcon(img);
		this.repaint();
	}
	
	private int step = 0;
	private int eatCounter = 0; // counter for eating animation
	private int eatDirection = 0; // 0 = E, 1 = W, 2 = N, 3 = S
	private int eat() {
		if(this.eatCounter>0) {
			this.eatDirection = step==0?new Random().nextInt(4):this.eatDirection; // random direction on first step
			switch (this.eatDirection) {
			case 0: // E
				switch (step) {
					case 0: this.updateImage(imgEE1); step++; break;
					case 1: this.updateImage(imgEE2); step++; break;
					case 2: this.updateImage(imgEE3); step++; break;
					case 3: this.updateImage(imgEE4); step=0; this.eatCounter--; break;
				}
				break;
			case 1: // W
				switch (step) {
					case 0: this.updateImage(imgWE1); step++; break;
					case 1: this.updateImage(imgWE2); step++; break;
					case 2: this.updateImage(imgWE3); step++; break;
					case 3: this.updateImage(imgWE4); step=0; this.eatCounter--; break;
				}
				break;
			case 2: // N
				switch (step) {
					case 0: this.updateImage(imgNE1); step++; break;
					case 1: this.updateImage(imgNE2); step++; break;
					case 2: this.updateImage(imgNE3); step++; break;
					case 3: this.updateImage(imgNE4); step=0; this.eatCounter--; break;
				}
				break;
			case 3: // S
				switch (step) {
					case 0: this.updateImage(imgSE1); step++; break;
					case 1: this.updateImage(imgSE2); step++; break;
					case 2: this.updateImage(imgSE3); step++; break;
					case 3: this.updateImage(imgSE4); step=0; this.eatCounter--; break;
				}
				break;
			}			
		}		
		return eatCounter;
	}
	
	private Point to;	
	private void move() {
		if(this.to == null) return;
		if(to.getX() != this.getLocation().getX()) {
			if(to.getX() < this.getLocation().getX()) {
				this.setLocation((int)this.getLocation().getX()-this.velocity, (int)this.getLocation().getY());
				switch(step) {
				case 0: this.updateImage(imgW1); step++; break;
				case 1: this.updateImage(imgW2); step++; break;
				case 2: this.updateImage(imgW3); step=0;break;
				}
			} else if(to.getX() > this.getLocation().getX()){
				this.setLocation((int)this.getLocation().getX()+this.velocity, (int)this.getLocation().getY());
				switch(step) {
				case 0: this.updateImage(imgE1); step++; break;
				case 1: this.updateImage(imgE2); step++; break;
				case 2: this.updateImage(imgE3); step=0;break;
				}
			}
			if(Math.abs(to.getX() - this.getLocation().getX()) < this.velocity) {
				this.setLocation((int)to.getX(), (int)this.getLocation().getY());
			}
		}else if(to.getY() != this.getLocation().getY()) {
			if(to.getY() < this.getLocation().getY()) {
				this.setLocation((int)this.getLocation().getX(), (int)this.getLocation().getY()-this.velocity);
				switch(step) {
				case 0: this.updateImage(imgN1); step++; break;
				case 1: this.updateImage(imgN2); step++; break;
				case 2: this.updateImage(imgN3); step=0;break;
				}
			} else if(to.getY() > this.getLocation().getY()){
				this.setLocation((int)this.getLocation().getX(), (int)this.getLocation().getY()+this.velocity);
				switch(step) {
				case 0: this.updateImage(imgS1); step++; break;
				case 1: this.updateImage(imgS2); step++; break;
				case 2: this.updateImage(imgS3); step=0;break;
				}
			}
			if(Math.abs(to.getY() > this.getLocation().getY()?to.getY()-this.getLocation().getY():this.getLocation().getY()-to.getY()) < this.velocity) {
				this.setLocation((int)this.getLocation().getX(), (int)to.getY());
			}
		} else {
			this.updateImage(imgS2);
			this.to = null; // reached destination
		}
	}
	
	private void walkTo(Point location) {
		this.to = location;			
		this.step = 0;
	}	
	
	private String action = "IDLE"; 
	@Override
	public void run() {
		
		int cyclesFor1s = (int) 1000 / this.updateFrequency; // how many cycles for 1 second
		int idleCycles  = 0;
		Random random = new Random();
		while(this.alive) {
			//System.out.println(action);
			switch (action) {
			case "WALKING":
				move();
				if(this.to == null)  this.action = "IDLE"; 
				break;
			case "EATING":
				if(eat()==0) this.action = "IDLE"; 
				break;
			case "DECIDE":
				//do a random thing
				switch (random.nextInt(2)) {
				case 0: // walk to a random position
					Dimension dimension = MouseAndDisplay.getScreenSize();
			        int x = random.nextInt(dimension.width-32); // Random x within width
			        int y = random.nextInt(dimension.height-32); // Random y within height
			  		this.action = "WALKING";
					this.walkTo(new Point(x, y));
					break;
				case 1: // eat
					this.eatCounter = random.nextInt(4) + 1; // random between 1 and 4 eating cycles
					this.action = "EATING";
					this.step = 0; // reset step for eating animation
					break;
				default:
					break;
				}
				break;
			case "IDLE":
				this.updateImage(imgS2);
				if(idleCycles<=0) {
					idleCycles = cyclesFor1s * (random.nextInt(5) + 5); // random between 5 and 10 seconds
					this.action = "DECIDE"; // switch to decide action
				}else{ // just count down for n time
					idleCycles--;
				}				
				break;
			default:
				this.action = "IDLE";
				break;
			}
			
			try {
				Thread.sleep(this.updateFrequency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.dispose();
	}

	

	public void kill() {
		this.alive = false;			
	}
	
}
