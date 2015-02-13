package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinSpanTreePanel extends JPanel {
	private static final long serialVersionUID = -8607843374750339613L;

	private Image backgr;
	private JButton bMSpan;
	private JLabel lFinal;
	private Font font;

	public MinSpanTreePanel() {
		setBackground(Color.BLACK);
		loadImage();
		setLayout(null);
		
		font = new Font("Verdana", Font.BOLD, 24);

		bMSpan = new JButton("Minimum Spanning Tree");
		bMSpan.setBounds(250, 20, 200, 20);
		add(bMSpan);
		
		lFinal = new JLabel("Minimum Spanning Tree : ");
		lFinal.setBounds(40, 100, 600, 60);
		lFinal.setFont(font);
		lFinal.setForeground(Color.WHITE);
		add(lFinal);
		
		bMSpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lFinal.setText("Minimum Spanning Tree : " + CreateGraphPanel.weightedGraph.bfs(0));			
				}
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int imageWidth = backgr.getWidth(this);
		int imageHeight = backgr.getHeight(this);
		int x = (w - imageWidth) / 2;
		int y = (h - imageHeight) / 2;
		g.drawImage(backgr, x, y - 10, this);
	}

	private void loadImage() {
		String fileName = "images/minSpanTreeBackgr.jpg";
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
