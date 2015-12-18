package jaffa.contacts;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;

public class ContactGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		ContactGui gui = new ContactGui();
		gui.setVisible(true);
	}

	private JList<String> list;
	private ContactThread thread;

	public ContactGui() {
		setTitle("Contact List");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();

		list = new JList<String>();

		list.setLayoutOrientation(JList.VERTICAL);

		container.add(list);

		thread = new ContactThread(list);
		thread.start();
	}

}