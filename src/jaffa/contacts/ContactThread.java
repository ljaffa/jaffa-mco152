package jaffa.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.google.gson.Gson;

public class ContactThread extends Thread {

	private String urlString;
	private BufferedReader reader;
	private JList<String> list;
	private Contact[] contacts;

	public ContactThread(JList<String> list) {
		this.urlString = "http://jsonplaceholder.typicode.com/users";
		// this.contacts = contacts;
		this.list = list;
	}

	@Override
	public void run() {
		//Contact[] contacts = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			InputStream in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();
			contacts = gson.fromJson(reader, Contact[].class);

			DefaultListModel<String> model = new DefaultListModel<String>();

			for (int i = 0; i < contacts.length; i++) {
				model.addElement(contacts[i].toString());
			}

			list.setModel(model);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DefaultListModel<String> sortModel = (DefaultListModel<String>) list
				.getModel();
		String[] sortArray = new String[sortModel.getSize()];
		for (int i = 0; i < sortArray.length; i++) {
			sortArray[i] = sortModel.elementAt(i).toString();
		}
		Arrays.sort(sortArray);

		list.setListData(sortArray);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList clickedList = (JList) e.getSource();
				if (e.getClickCount() == 2) {
					int i = clickedList.locationToIndex(e.getPoint());
					System.out.println(i);
					ContactInfo info = new ContactInfo(contacts[i].getName(), contacts[i]
							.getEmail(), contacts[i].getAddress(), contacts[i]
									.getPhone());
					info.setVisible(true);
				}
			}
		});
	}

}
