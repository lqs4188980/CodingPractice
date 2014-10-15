package com.leetcode.maxPoints;

import java.util.HashMap;
import java.util.Set;

public class MaxPoints {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, 1);
		maxPoints(points);
	}
	
    public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        if(points.length == 1)
            return 1;
        int max = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> slopes = new HashMap<Double, Integer>();
            System.out.println("********************************************************************");
            System.out.println("Point: " + points[i].x + ", " + points[i].y);
            for(int j = 0; j < points.length; j++){
            	if(i == j){
            		continue;
            	}
                System.out.println("	Point: " + points[j].x + ", " + points[j].y);
                if((points[i].x == points[j].x) && (points[i].y == points[j].y)){
                    if(slopes.size() != 0){
                        Set<Double> keySet = slopes.keySet();
                        for(Double slope : keySet){
                            slopes.put(slope, slopes.get(slope) + 1);
                            int value = slopes.get(slope);
                            if(value > max)
                                max = value;
                        }
                        
                        
                        continue;
                    }
                    else{
                        slopes.put(Double.MAX_VALUE, 2);
                        int value = slopes.get(Double.MAX_VALUE);
                        if(value > max)
                            max = value;
                        continue;
                    }
                }
                double slope = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
                if(slopes.containsKey(slope)){
                    slopes.put(slope, slopes.get(slope) + 1);
                    int value = slopes.get(slope);
                    if(value > max)
                        max = value;
                    continue;
                }
                slopes.put(slope, 2);
                int value = slopes.get(slope);
                if(value > max)
                    max = value;
            }
            
            System.out.println(max);
            Set<Double> keySet = slopes.keySet();
            for(Double slope : keySet){
            	System.out.println(slope + ", " + slopes.get(slope));
            }
            System.out.println("********************************************************************");
        }
        return max;
    }

}
