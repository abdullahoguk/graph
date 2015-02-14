package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import processes.Edge;

public class SearchElementPanel extends JPanel {
	private static final long serialVersionUID = -229973149836070331L;

	private JLabel lSPath;
	private JTextField tSPath;
	private JButton bSPath;
	private JTextArea tAreaPaths;
	private JScrollPane sPane;
	private Font font;

	public SearchElementPanel() {
		setBackground(Color.BLACK);
		setLayout(null);

		font = new Font("Verdana", Font.BOLD, 15);

		lSPath = new JLabel(
				"Select the vertex you want, to find information about ;");
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
				try {
					int xde = Integer.parseInt(tSPath.getText());
					Iterator<Edge> itxDe = CreateGraphPanel.weightedGraph
							.getIncidentEdges(xde);
					while (itxDe.hasNext()) {
						Edge temp=itxDe.next();
						String curr ="to "+temp.getVertex2()+" with weigth " +temp.getWeight()+" \n";
						tAreaPaths.append(curr);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Oops, something has gone wrong!");
				}
			}
		});

	}

}
