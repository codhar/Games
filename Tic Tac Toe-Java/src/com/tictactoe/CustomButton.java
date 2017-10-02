package com.tictactoe;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CustomButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean drawO;
	private boolean drawX;

	public CustomButton() {
		// TODO Auto-generated constructor stub
	}

	public CustomButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public CustomButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public CustomButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public CustomButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isDrawO() {
		return drawO;
	}

	public void setDrawO(boolean drawO) {
		this.drawO = drawO;
	}
	

	public boolean isDrawX() {
		return drawX;
	}

	public void setDrawX(boolean drawX) {
		this.drawX = drawX;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if(drawO){
			g2d.setStroke(new BasicStroke(10));
			g2d.drawOval(15, 15, getWidth()-30, getHeight()-30);
		}
		if(drawX){
			g2d.setStroke(new BasicStroke(10));
			g2d.drawLine(0, 0, getWidth(), getHeight());
			g2d.drawLine(0, getHeight(), getWidth(), 0);
		}
//			g.fillOval(0,0, getWidth(), getHeight());
			
//		g.fillOval((int)getLocationOnScreen().getX(),(int) getLocationOnScreen().getY(), getWidth(), getHeight());
	}

}
