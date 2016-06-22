package com.intercorm.utils;

public class GreatCircleUtil {
	
	private GreatCircleUtil(){};

	public static double calculate(double srcLatitude, double srcLongitude,
			double destLatitude, double destLongitude) {
		double x1 = Math.toRadians(srcLatitude);
		double y1 = Math.toRadians(srcLongitude);
		double x2 = Math.toRadians(destLatitude);
		double y2 = Math.toRadians(destLongitude);
		double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1)
				* Math.cos(x2) * Math.cos(y1 - y2));
		angle1 = Math.toDegrees(angle1);
		double distance1 = 60 * angle1;
		return distance1;
	}
}
