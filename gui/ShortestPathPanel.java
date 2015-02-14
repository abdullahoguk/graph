package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import processes.ShortestPath;

public class ShortestPathPanel extends JPanel {

	private static final long serialVersionUID = 7799145103207188778L;

	private JLabel lSPath;
	private JTextField tSPath;
	private JButton bSPath;
	private JTextArea tAreaPaths;
	private JScrollPane sPane;
	private Font font;
	
	public ShortestPathPanel() {
		setBackground(Color.BLACK);
		setLayout(null);
		
		font = new Font("Verdana", Font.BOLD, 15);

		lSPath = new JLabel(
				"Select the vertex you want, to find shortest path from :");
		add(lSPath);
		lSPath.setForeground(Color.WHITE);
		lSPath.setBounds(25, 40, 280, 20);

		tSPath = new JTextField();
		add(tSPath);
		tSPath.setBounds(65, 70, 80, 20);

		bSPath = new JButton("Find");
		add(bSPath);
		bSPath.setBounds(185, 70, 80, 20);
		
		tAreaPaths = new JTextArea();
		tAreaPaths.setBounds(25, 100, 400, 250);
		tAreaPaths.setEditable(false);
		tAreaPaths.setFont(font);
		sPane = new JScrollPane(tAreaPaths);
		sPane.setBounds(25, 100, 400, 250);
		add(sPane);
		
		
		bSPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tAreaPaths.setText(null);
				try {
					ShortestPath sPath = new ShortestPath(
							CreateGraphPanel.weightedGraph, strToInt(tSPath
									.getText()));
					
					tAreaPaths.append(
							"Shortest paths from vertex " + tSPath.getText() + " are as follows ;" + "\n\n");
					
					for (int i = 0; i < sPath.getDistance().length; i++) {
					
						if (sPath.getDistance()[i] != Integer.MAX_VALUE) {
							tAreaPaths.append(
									" to " + sPath.getPaths()[i] + " : " + sPath.getDistance()[i] + "\n");
						} else {
							
						}
					
					}
					
					tSPath.setText(null);
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Oops, Something has gone wrong!");
					tAreaPaths.setText(null);
					tSPath.setText(null);
				}
			}
		});

	}

	private int strToInt(String value) {
		int convInt = Integer.parseInt(value);
		return convInt;
	}
}
