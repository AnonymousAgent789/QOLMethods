package QOLMethods.JFrame;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public abstract class JFrameMethods extends JFrame {
	
	public static void initialiseBlankJFrame(JFrame frame, String title, ImageIcon image) {
		frame.setVisible(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		frame.setTitle(title);
		frame.setIconImage(image.getImage());
	}
	
	public static void initialiseBlankJFrame(JFrame frame, String title) {
		frame.setVisible(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		frame.setTitle(title);
	}
	
	public static void initialiseBlankJFrame(JFrame frame) {
		frame.setVisible(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
	}
	
	public static int getScreenWidth() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x * 2;
	}
	
	public static int getScreenHeight() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y * 2;
	}
	
	public static Point getCenterPoint() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	}
	
	public static int getCenterX() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x;
	}
	
	public static int getCenterY() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y;
	}
	
	public static int getMouseX() {
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	
	public static int getMouseY() {
		return MouseInfo.getPointerInfo().getLocation().y;
	}
	
	public static Point getMouseLocation() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	
}