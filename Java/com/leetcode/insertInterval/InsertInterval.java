package com.leetcode.insertInterval;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.dataStructures.Interval;;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,5));
		insert(intervals, new Interval(0, 0));

	}
	
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        
        
        ArrayList<Interval> newIntervals = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            newIntervals.add(newInterval);
            return (List)newIntervals;
        }
        
        boolean isStart = true,
                hasInside = false,
                onTheRight = false;
        int start = 0,
            end = 0,
            prevEnd = 0,
            
            i = 0;
        for (; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            System.out.println("Round " + i);
            if (isStart) {
                if ((i == 0 && interval.start > newInterval.start) || (i != 0 && newInterval.start > prevEnd && newInterval.start < interval.start)) {
                	System.out.println("Start at beginning or outside");
                	start = newInterval.start;
                    isStart = false;
                } else if (newInterval.start >= interval.start && newInterval.start <= interval.end) {
                	System.out.println("Start inside");
                    start = interval.start;
                    hasInside = true;
                    isStart = false;
                } else if (newInterval.start > interval.end && i == intervals.size() - 1) {
                	System.out.println("Start on the right");
                    newIntervals.add(interval);
                    start = newInterval.start;
                    onTheRight = true;
                    isStart = false;
                } else {
                    newIntervals.add(interval);
                    prevEnd = interval.end;
                }
            } 
            System.out.println("Start End");
            System.out.println(isStart);
            if (!isStart) {
            	System.out.println("i = " + i + ", newInterval.end = " + newInterval.end + ", ");
                if ((i == 0 && newInterval.end < interval.start) || (i != 0 && newInterval.end > prevEnd && newInterval.end < interval.start) || (newInterval.end > interval.end && i == intervals.size() - 1)) {
                	System.out.println("End at beginning or outside");
                	end = newInterval.end;
                    break;
                } else if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
                	System.out.println("End inside");
                	end = interval.end;
                    hasInside = true;
                    break;
                } else {
                	System.out.println("Prepare for next round");
                    prevEnd = interval.end;
                }
            }
        }
        
        Interval comb = new Interval(start, end);
        newIntervals.add(comb);
        if (hasInside || onTheRight) {
        	
            i++;
        }
        for (; i < intervals.size(); i++) {
        	
            newIntervals.add(intervals.get(i));
        }
        
        return (List)newIntervals;
    }

}
