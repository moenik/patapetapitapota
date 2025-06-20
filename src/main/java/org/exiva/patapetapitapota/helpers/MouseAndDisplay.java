package org.exiva.patapetapitapota.helpers;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;

public class MouseAndDisplay {

	public static Point getMousePosition() {
        return MouseInfo.getPointerInfo().getLocation();
    }
	
	public static Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	
}
