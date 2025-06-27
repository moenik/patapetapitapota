package org.exiva.patapetapitapota.helpers;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

public class MouseAndDisplay {

	public static Point getMousePosition() {
        return MouseInfo.getPointerInfo().getLocation();
    }
	
	public static Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public static void setMousePosition(Point p) {
		try { new Robot().mouseMove((int)p.getX(), (int)p.getY()); } catch (AWTException e) { }
	}
	
	
}
