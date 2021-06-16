package gr.uoa.di.pcomp.IncludingRESTAPI.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Runner {


	public static double PI = 3.14159265;
	public static double TWOPI = 2 * PI;
	//ArrayList<String> polygon_lat_long_pairs = new ArrayList<String>();
	public Runner() {
	}
	
/*	public Boolean Check (List<String> polygon, Double latitude, Double longitude) {
		
		ArrayList<Double> lat_array = new ArrayList<Double>();
		ArrayList<Double> long_array = new ArrayList<Double>();
	    Iterator<String> it=polygon.iterator();
	    
	    while (it.hasNext())
	    {
	    	long_array.add(Double.parseDouble(it.next()));
	    	lat_array.add(Double.parseDouble(it.next()));
	    }
	    System.out.println(latitude);

	    System.out.println(longitude);

	    System.out.println(lat_array);
	    System.out.println(long_array);

		for (String s : polygon) {
			lat_array.add(Double.parseDouble(s.split(",")[0]));
			long_array.add(Double.parseDouble(s.split(",")[1]));
		}
		
		return coordinate_is_inside_polygon(latitude, longitude, lat_array, long_array);
	}*/

	//public static boolean coordinate_is_inside_polygon(double latitude, double longitude, ArrayList<Double> lat_array,
	//		ArrayList<Double> long_array) {
	public Boolean coordinate_is_inside_polygon(List<String> polygon, Double latitude, Double longitude) {
		
		ArrayList<Double> lat_array = new ArrayList<Double>();
		ArrayList<Double> long_array = new ArrayList<Double>();
	    Iterator<String> it=polygon.iterator();
	    
	    while (it.hasNext())
	    {
	    	long_array.add(Double.parseDouble(it.next()));
	    	lat_array.add(Double.parseDouble(it.next()));
	    }
		
		int i;
		double angle = 0;
		double point1_lat;
		double point1_long;
		double point2_lat;
		double point2_long;
		int n = lat_array.size();

		for (i = 0; i < n; i++) {
			point1_lat = lat_array.get(i) - latitude;
			point1_long = long_array.get(i) - longitude;
			point2_lat = lat_array.get((i + 1) % n) - latitude;
			// you should have paid more attention in high school geometry.
			point2_long = long_array.get((i + 1) % n) - longitude;
			angle += Angle2D(point1_lat, point1_long, point2_lat, point2_long);
		}

		if (Math.abs(angle) < PI)
			return false;
		else
			return true;
	}

	public static double Angle2D(double y1, double x1, double y2, double x2) {
		double dtheta, theta1, theta2;

		theta1 = Math.atan2(y1, x1);
		theta2 = Math.atan2(y2, x2);
		dtheta = theta2 - theta1;
		while (dtheta > PI)
			dtheta -= TWOPI;
		while (dtheta < -PI)
			dtheta += TWOPI;

		return (dtheta);
	}

	public static boolean is_valid_gps_coordinate(double latitude, double longitude) {
		// This is a bonus function, it's unused, to reject invalid lat/longs.
		if (latitude > -90 && latitude < 90 && longitude > -180 && longitude < 180) {
			return true;
		}
		return false;
	}
}