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

public class PrintGraphPanel extends JPanel {
	private static final long serialVersionUID = 5670661511300069926L;

	private JLabel bfsPrinter, dfsPrinter;
	private Font font;
	private Image backgr;

	public PrintGraphPanel() {
		loadImage();
		setLayout(null);

		font = new Font("Verdana", Font.BOLD, 42);

		bfsPrinter = new JLabel();
		add(bfsPrinter);
		bfsPrinter.setBounds(50, 100, 500, 100);
		bfsPrinter.setForeground(Color.PINK);
		bfsPrinter.setFont(font);

		dfsPrinter = new JLabel();
		add(dfsPrinter);
		dfsPrinter.setBounds(50, 250, 500, 100);
		dfsPrinter.setForeground(Color.MAGENTA);
		dfsPrinter.setFont(font);

		bfsPrinter.setText("BFS : ");

		dfsPrinter.setText("DFS : ");
		
		JButton buton = new JButton("Print Graph using BFS and DFS");
		add(buton);
		buton.setBounds(300, 50, 200, 20);
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBfsText();
			}
		});

	}

	private void setBfsText(){
		bfsPrinter.setText("BFS : " + CreateGraphPanel.weightedGraph.bfs(0));		
		dfsPrinter.setText("DFS : " + CreateGraphPanel.weightedGraph.dfs(0));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int imageWidth = backgr.getWidth(this);
		int imageHeight = backgr.getHeight(this);
		int x = (w - imageWidth) / 2;
		int y = (h - imageHeight) / 2;
		g.drawImage(backgr, x , y - 10, this);
	}

	private void loadImage() {
		String fileName = "images/printGraphBackgr.png";
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
