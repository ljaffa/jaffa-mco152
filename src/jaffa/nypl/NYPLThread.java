package jaffa.nypl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import com.google.gson.Gson;

public class NYPLThread extends Thread {

	private JList<String> list;
	private JLabel numbers;
	private String search;
	private JLabel imageLabel;
	private String urlString;

	private MainApi api;
	private Result[] results;
	private JButton next;
	private JButton previous;

	private ImageIcon image;
	private int index;

	public NYPLThread(JList<String> list, JLabel numbers, String search,
			JLabel imageLabel, JButton next, JButton previous) {
		this.list = list;
		this.numbers = numbers;
		this.search = search;
		this.imageLabel = imageLabel;
		this.next = next;
		this.previous = previous;

		this.urlString = "http://api.repo.nypl.org/api/v1/items/search?q="
				+ search + "&publicDomainOnly=true";
	}

	@Override
	public void run() {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			connection.setRequestProperty("Authorization",
					"Token token=\"78lwc4kj3fyntzj9\"");

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new Gson();
			api = gson.fromJson(reader, MainApi.class);

			DefaultListModel<String> model = new DefaultListModel<String>();

			results = api.getNyplAPI().getResponse().getResults();
			for (int i = 0; i < results.length; i++) {
				if (results[i].getTitle().length() > 30) {
					model.addElement(results[i].getTitle().substring(0, 30));
				} else {
					model.addElement(results[i].getTitle());
				}
			}
			list.setModel(model);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<String> clickedList = (JList<String>) e.getSource();
				int i = clickedList.locationToIndex(e.getPoint());
				if (e.getClickCount() == 1) {
					URL itemUrl;
					try {
						itemUrl = new URL(results[i].getApiItemUrl());
						HttpURLConnection connection = (HttpURLConnection) itemUrl
								.openConnection();

						connection.setRequestProperty("Authorization",
								"Token token=\"78lwc4kj3fyntzj9\"");

						InputStream in = connection.getInputStream();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(in));

						Gson gson = new Gson();
						MainApi item = gson.fromJson(reader, MainApi.class);

						Capture[] capturePictures = item.getNyplAPI()
								.getResponse().getCaptures();
						String[] pictures = new String[capturePictures.length];
						for (int j = 0; j < capturePictures.length; j++) {
							String pictureUrl = capturePictures[j]
									.getImageLinks().getImageLink()[3];
							pictures[j] = pictureUrl;
						}

						image = new ImageIcon(new URL(pictures[0]));
						imageLabel.setIcon(image);
						numbers.setText("1/" + pictures.length);
						index = 0;
						if (index >= pictures.length - 1) {
							next.setEnabled(false);
						} else {
							next.setEnabled(true);
						}
						if (index <= 0) {
							previous.setEnabled(false);
						} else {
							previous.setEnabled(true);
						}

						next.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								index++;
								if (index >= pictures.length - 1) {
									next.setEnabled(false);
								}
								previous.setEnabled(true);
								try {
									image = new ImageIcon(new URL(
											pictures[index]));
									imageLabel.setIcon(image);
									numbers.setText(index + 1 + "/"
											+ pictures.length);
								} catch (MalformedURLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						});

						previous.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								index--;
								if (index <= 0) {
									previous.setEnabled(false);
								}
								try {
									image = new ImageIcon(new URL(
											pictures[index]));
									imageLabel.setIcon(image);
									numbers.setText(index + 1 + "/"
											+ pictures.length);
								} catch (MalformedURLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						});

					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
