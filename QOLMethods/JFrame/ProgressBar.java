package QOLMethods.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProgressBar extends JPanel {
	
	public static final int PERCENTAGE_BAR = 0; //Shows text as percentage
	public static final int FRACTION_BAR = 1; //Shows text as fraction
	public static final int NO_TEXT = 2; //Hides text
	public static final int BORDER_BAR = 0; //Refers to this object
	public static final int BACKGROUND_BAR = 1; //Refers to backBar
	public static final int FRONT_BAR = 2; //Refers to frontBar
	final JPanel frontBar = new JPanel();
	final JPanel backBar = new JPanel();
	final JLabel text = new JLabel();
	int border;
	double value = 0;
	int maxValue = 100;
	double width;
	int textType;
	Point location;
	Dimension dimension;
	
	
	/**
     * Creates a <code>ProgressBar</code> instance with the specified properties.
     * The progress bar has a default value of 0 and a default maximum value of 100
     *
     * @param size The size of the progress bar
     * @param bord The width of the border
     * @param location The location of the top-left corner of the progress bar
     * @param textNum The type of text of text to be shown (<code>PERCENTAGE_BAR, FRACTION_BAR, NO_BAR</code>)
     */
	public ProgressBar(Dimension size, int bord, Point location, int textNum) {
		border = bord;
		dimension = size;
		this.location = location;
		textType = textNum;
		setBorder(bord);
		this.setLayout(null);
		
		setBarColor(Color.gray, Color.gray.darker(), Color.green);
		
		this.add(text);
		this.add(frontBar);
		this.add(backBar);
		showValue();
	}
	
	public void setBarLocation(Point p) {
		this.setLocation(p);
		frontBar.setLocation(border, border);
		backBar.setLocation(border, border);
		JFrameComponentMethods.centerCompOnPoint(text, dimension.width - text.getFont().getSize(), (dimension.height / 2) - (dimension.height / 15));
	}
	
	public void setValue(double value) {
		if (value > maxValue) {
			this.value = maxValue;
		} else {
			this.value = value < 0 ? 0 : value;
		}
		
		showValue();
	}
	
	public void changeValue(double value) {
		setValue(getValue() + value);
	}
	
	public double getValue() {
		return value;
	}
	
	public double getValueAsPercentage() {
		double val = value * 100;
		val = val / maxValue;
		val = Math.round(val * 10);
		return val / 10;
	}
	
	private void showValue() {
		width = (((double) (dimension.width - (border * 2)) / maxValue) * value);
		width = Math.round(width);
		frontBar.setSize((int) width, dimension.height - (border * 2));
		if (textType == 0) {
			text.setVisible(true);
			text.setText(getValueAsPercentage() + "%");
		} else if (textType == 1) {
			text.setVisible(true);
			text.setText((Math.round(value)) + "/" + maxValue);
		} else {
			text.setVisible(false);
		}
	}
	
	public void setMaxValue(int val) {
		maxValue = val;
		if (maxValue < value) {
			value = maxValue;
		}
		showValue();
	}
	
	public int getMaxValue() {
		return maxValue;
	}
	
	public void setTextType(int type) {
		textType = type;
	}
	
	public int getTextType() {
		return textType;
	}
	
	public void setBarSize(int x, int y) {
		dimension.width = x;
		dimension.height = y;
		this.setSize(x, y);
		backBar.setSize(x - (border * 2), y - (border * 2));
		text.setSize(x - (border * 2), y - (border * 2));
		text.setFont(new Font("sans-serif", Font.BOLD, Math.min(x / 2, y) / 3));
		JFrameComponentMethods.centerCompOnPoint(text, dimension.width - text.getFont().getSize() * 2, (dimension.height / 2) - (dimension.height / 15));
		showValue();
	}
	
	public void setBarColor(int barType, Color color) {
		if (barType == 0) {
			this.setBackground(color);
		}
		if (barType == 1) {
			backBar.setBackground(color);
		}
		if (barType == 2) {
			frontBar.setBackground(color);
		}
	}
	
	public void setBarColor(Color backColor, Color emptyColor, Color filledColor) {
		this.setBackground(backColor);
		backBar.setBackground(emptyColor);
		frontBar.setBackground(filledColor);
	}
	
	public void setBorder(int size) {
		border = size;
		setBarSize(dimension.width, dimension.height);
		setBarLocation(location);
	}
	
	public int getBorderWidth() {
		return border;
	}
	
	public Color getColor() {
		return frontBar.getBackground();
	}
	
	public Dimension getSize() {
		return dimension;
		
	}
	
	public Point getLocation() {
		return location;
	}
	
}