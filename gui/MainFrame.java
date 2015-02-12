package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2292455670620751734L;
	private JPanel contentPane, toolBar, cardPanel;
	private CardLayout cardHolder;
	private HomePanel homePanel;
	private CreateGraphPanel createGraphPanel;
	private PrintGraphPanel printGraphPanel;
	private ShortestPathPanel shortestPathPanel;
	private MinSpanTreePanel minSpanTreePanel;
	private SearchElementPanel searchElementPanel;

	private JMenuBar menuBar;
	private JMenu file, edit, help;
	private JMenuItem home, exit, createGraph, printGraph, shortestPath, minSpanTree,
			searchElement, howto, credits;

	public MainFrame() {
		setTitle("Simple Graph App");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 450);
		setResizable(false);
		setLocation(250, 100);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// INITIALIZATION OF TOOLBAR PANEL

		toolBar = new JPanel();
		contentPane.add(toolBar);
		toolBar.setBounds(0, 0, 800, 30);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.setBackground(new Color(255, 102, 0));

		menuBar = new JMenuBar();
		toolBar.add(menuBar);

		file = new JMenu("File");
		menuBar.add(file);
		
		home = new JMenuItem("Return to Home");
		file.add(home);
		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "homePanel");
			}
		});

		exit = new JMenuItem("Exit");
		file.add(exit);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog( new JFrame(), "Are you sure ?", "Exit", JOptionPane.YES_NO_OPTION);
				if(n == 0){
					System.exit(0);
				} else{
					
				}
			}
		});

		edit = new JMenu("Edit");
		menuBar.add(edit);

		createGraph = new JMenuItem("Create Graph");
		edit.add(createGraph);

		createGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "createGraphPanel");
			}
		});

		printGraph = new JMenuItem("Print Graph");
		edit.add(printGraph);

		printGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "printGraphPanel");
			}
		});

		shortestPath = new JMenuItem("Shortest Path");
		edit.add(shortestPath);

		shortestPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "shortestPathPanel");
			}
		});

		minSpanTree = new JMenuItem("Minimum Spanning Tree");
		edit.add(minSpanTree);

		minSpanTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "minSpanTreePanel");
			}
		});

		searchElement = new JMenuItem("Search For An Element");
		edit.add(searchElement);

		searchElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardHolder = (CardLayout) (cardPanel.getLayout());
				cardHolder.show(cardPanel, (String) "searchElementPanel");
			}
		});

		help = new JMenu("Help");
		menuBar.add(help);

		howto = new JMenuItem("How To Use");
		help.add(howto);

		howto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You can create a Graph Structure on edit->Create Graph.In order to do that :");
			}
		});

		credits = new JMenuItem("Credits");
		help.add(credits);

		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Ahmet Kaþif, Abdullah Öðük, Mustafa Özdemir\n                       December 2014");
			}
		});

		// INITIALIZATION OF CARD PANEL

		cardPanel = new JPanel();
		contentPane.add(cardPanel);
		cardPanel.setBounds(0, 30, 800, 420);
		cardPanel.setBackground(Color.BLUE);

		cardHolder = new CardLayout();
		cardHolder.setHgap(0);
		cardHolder.setVgap(0);
		cardPanel.setLayout(cardHolder);

		homePanel = new HomePanel();
		cardPanel.add("homePanel", homePanel);

		createGraphPanel = new CreateGraphPanel();
		cardPanel.add("createGraphPanel", createGraphPanel);

		printGraphPanel = new PrintGraphPanel();
		cardPanel.add("printGraphPanel", printGraphPanel);

		shortestPathPanel = new ShortestPathPanel();
		cardPanel.add("shortestPathPanel", shortestPathPanel);

		minSpanTreePanel = new MinSpanTreePanel();
		cardPanel.add("minSpanTreePanel", minSpanTreePanel);

		searchElementPanel = new SearchElementPanel();
		cardPanel.add("searchElementPanel", searchElementPanel);
	}

}
