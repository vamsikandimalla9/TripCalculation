package com.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.bean.Driver;
import com.bean.Trip;

public class Application {

	public static void main(String[] args) throws ParseException, IOException {
		Application app = new Application();
		List<String> list = new ArrayList<String>();
		List<Driver> drivers = new ArrayList<Driver>();
		List<Trip> trips = new ArrayList<Trip>();

		File file = new File("~//input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String thisLine = null;
		while ((thisLine = br.readLine()) != null) {
			String[] lines = thisLine.split("\r?\n");

			for (String s : lines) {
				list.add(s);
			}
			
		}

		for (String input : list) {
			String[] i = input.split(" ");
			String pointer = i[0];
			if (pointer.equals("Driver")) {
				Driver d = new Driver();
				d.setName(i[1]);
				drivers.add(d);

			}
			if (pointer.equals("Trip")) {

				Trip trip = new Trip(i[1], i[2], i[3], i[4]);
				trips.add(trip);
				for (Driver dr : drivers) {
					double t1 = 0;
					double m1 = 0;
					for (Trip tp : trips) {

						if (dr.getName().equals(tp.getDriver())) {

							t1 += app.calculateTimeInMilliSeconds(tp.getFrom(), tp.getTo());
							m1 += Double.parseDouble(tp.getMiles());

						}
						double mph = app.calculateMph(t1, m1);
						dr.setMph(mph);
						dr.setMiles(m1);

					}

				}
			}

		}
		Collections.sort(drivers, app.new Sortbymiles());
		;
		for (Driver dr : drivers) {
			app.printOutput(dr);
		}
		br.close();
	}

	public double calculateMph(double totaltime, double totalmiles) throws ParseException {
		double result = (totalmiles * 3600 * 1000) / totaltime;
		return result;
	}

	public double calculateTimeInMilliSeconds(String from, String to) throws ParseException {

		from = from + ":00";
		to = to + ":00";
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(from);
		Date date2 = format.parse(to);
		double diff = date2.getTime() - date1.getTime();
		return diff;
	}

	public void printOutput(Driver dr) {
		if ((dr.getMph() >= 5 && dr.getMph() <= 100)) {

			System.out.println(dr);
		} else if (dr.getMiles() == 0) {

			System.out.println(dr.getName() + ": " + Math.round(dr.getMiles()) + " miles");
		}
	}

	class Sortbymiles implements Comparator<Driver> {

		@Override
		public int compare(Driver d1, Driver d2) {
			return (int) (d2.getMiles() - d1.getMiles());
		}
	}

}
