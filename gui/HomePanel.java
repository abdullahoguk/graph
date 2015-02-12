package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = -59115957354504598L;
	private Image backgr;
	JLabel info, info2;
	
	public HomePanel() {
		setBackground(Color.BLACK);
		loadImage();
		setLayout(null);
		
		info = new JLabel("*) Welcome; if you have any questions, please use help.");
		add(info);
		info.setBounds(10, 30, 500, 25);
		info.setForeground(Color.WHITE);
		
		info2 = new JLabel("*) The images you will see through program are just visual backgrounds.");
		add(info2);
		info2.setBounds(10, 65, 500, 25);
		info2.setForeground(Color.WHITE);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int imageWidth = backgr.getWidth(this);
		int imageHeight = backgr.getHeight(this);
		int x = (w - imageWidth) / 2;
		int y = (h - imageHeight) / 2;
		g.drawImage(backgr, x + 120 , y - 10, this);
	}

	private void loadImage() {
		String fileName = "images/homeBackgr.jpg";
		try {
			URL url = getClass().getResource(fileName);
			backgr = ImageIO.read(url);
		} catch (MalformedURLException mue) {
			System.out.println("url: " + mue.getMessage());
		} catch (IOException ioe) {
			System.out.println("read: " + ioe.getMessage());
		}
	}

}
