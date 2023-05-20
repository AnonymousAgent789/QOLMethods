package QOLMethods.JFrame;

import java.awt.Component;
import java.awt.Point;

public abstract class JFrameComponentMethods {
		
	public static void centerComp(Component comp) {
		comp.setLocation(JFrameMethods.getCenterX()  - (comp.getWidth() / 2), JFrameMethods.getCenterY() - (comp.getHeight() / 2));
	}
			
	public static void centerCompOnPoint(Component comp, int x, int y) {
		comp.setLocation(x  - (comp.getWidth() / 2), y - (comp.getHeight() / 2));
	}
	
	public static void centerCompOnPoint(Component comp, Point p) {
		comp.setLocation(p.x  - (comp.getWidth() / 2), p.y - (comp.getHeight() / 2));
	}
	
}