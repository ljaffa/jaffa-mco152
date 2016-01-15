package jaffa.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NYPLGui extends JFrame {

	private JTextField searchBox;
	private JButton searchButton;
	private final JButton previous;
	private final JButton next;
	private JLabel numbers;
	private JList<String> list;
	private JPanel imagePanel;
	private JPanel searchPanel;
	private JPanel buttonPanel;
	private JPanel listPanel;
	private JLabel imageLabel;
	private JPanel imageButtonPanel;

	public NYPLGui() {
		setTitle("NYPL Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		imageButtonPanel = new JPanel();
		imageButtonPanel.setLayout(new BorderLayout());
		searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout());
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());

		imagePanel = new JPanel();
		imageLabel = new JLabel();
		imagePanel.add(imageLabel);

		/*JScrollPane scroll = new JScrollPane(imagePanel);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(50,30,300,50);
		add(scroll, BorderLayout.AFTER_LAST_LINE);*/

		searchBox = new JTextField();
		searchBox.setPreferredSize(new Dimension(getWidth() - 150, 20));
		searchPanel.add(searchBox);
		searchButton = new JButton("Search");
		searchPanel.add(searchButton);
		add(searchPanel, BorderLayout.PAGE_START);

		previous = new JButton("Previous");
		buttonPanel.add(previous);
		previous.setEnabled(false);
		numbers = new JLabel();
		buttonPanel.add(numbers);
		next = new JButton("Next");
		buttonPanel.add(next);
		next.setEnabled(false);


		imageButtonPanel.add(buttonPanel, BorderLayout.PAGE_START);
		imageButtonPanel.add(imageLabel, BorderLayout.CENTER);
		add(imageButtonPanel, BorderLayout.CENTER);


		list = new JList<String>();
		listPanel.add(list);
		add(listPanel, BorderLayout.LINE_START);

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NYPLThread thread = new NYPLThread(list, numbers, searchBox
						.getText(), imageLabel, next, previous);
				thread.start();
			}

		});



	}

	public JButton getSearch(){
		return searchButton;
	}

}
