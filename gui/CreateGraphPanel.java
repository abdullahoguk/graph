package gui;

import java.awt.Color;
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
import javax.swing.JTextField;

import processes.WeightedGraph;

public class CreateGraphPanel extends JPanel {
	private static final long serialVersionUID = 9104443435433103247L;
	
	private JLabel lVertice1, lVertice2, lWeight;
	private JTextField tVertice1, tVertice2, tWeight;
	private JButton bNewEdge;
	private Image backgr;
	
	public static WeightedGraph weightedGraph = new WeightedGraph();

	public CreateGraphPanel() {
		loadImage();
		setLayout(null);
		
		lVertice1 = new JLabel("First Vertice :");
		add(lVertice1);
		lVertice1.setBounds(100, 50, 80, 20);
		lVertice1.setForeground(Color.WHITE);

		tVertice1 = new JTextField();
		add(tVertice1);
		tVertice1.setBounds(200, 50, 80, 20);

		lVertice2 = new JLabel("Second Vertice");
		add(lVertice2);
		lVertice2.setBounds(100, 80, 80, 20);
		lVertice2.setForeground(Color.WHITE);

		tVertice2 = new JTextField();
		add(tVertice2);
		tVertice2.setBounds(200, 80, 80, 20);
		
		lWeight = new JLabel("Weight");
		add(lWeight);
		lWeight.setBounds(100, 110, 80, 20);
		lWeight.setForeground(Color.WHITE);
		
		tWeight = new JTextField();
		add(tWeight);
		tWeight.setBounds(200, 110, 80, 20);

		bNewEdge = new JButton("Add an edge!");
		add(bNewEdge);
		bNewEdge.setBounds(140, 140, 100, 20);
		
		bNewEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				weightedGraph.addEdge(strToInt(tVertice1.getText()), strToInt(tVertice2.getText()), strToInt(tWeight.getText()));
				
				tVertice1.setText(null);
				tVertice2.setText(null);
				tWeight.setText(null);	
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
		g.drawImage(backgr, x , y - 10, this);
	}

	private void loadImage() {
		String fileName = "images/createGraphBackgr.png";
		try {
			URL url = getClass().getResource(fileName);
			backgr = ImageIO.read(url);
		} catch (MalformedURLException mue) {
			System.out.println("url: " + mue.getMessage());
		} catch (IOException ioe) {
			System.out.println("read: " + ioe.getMessage());
		}
	}
	
	private Integer strToInt(String value){
		int convInt = Integer.parseInt(value);
		return convInt;
	}

}
