package jaffa.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(
				"ufo_awesome.json"));

		Gson gson = new Gson();

		UFOSighting[] list = gson.fromJson(in, UFOSighting[].class);

		in.close();

		HashMap<String, Integer> locations = new HashMap<String, Integer>();

		for (int i = 0; i < list.length; i++) {
			Integer value = locations.get(list[i].getLocation());
			if (value == null) {
				locations.put(list[i].getLocation(), 1);
			} else {
				locations.put(list[i].getLocation(), value + 1);
			}
		}

		int top = 0;
		String topLocation = null;
		ArrayList<String> max = new ArrayList<String>();
		ArrayList<Integer> maxCount = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			for (Map.Entry<String, Integer> location : locations.entrySet()) {
				if (!max.contains(location.getKey())
						&& !maxCount.contains(location.getValue())
						&& location.getValue() > top) {

					top = location.getValue();
					topLocation = location.getKey();
				}

			}

			max.add(topLocation);
			maxCount.add(top);

			top = 0;
			topLocation = null;

		}

		for (int j = 0; j < max.size(); j++) {
			System.out.println(j + 1 + ": " + max.get(j) + " - "
					+ maxCount.get(j) + " sightings");
		}

	}
}
