package com.leetcode.mergeIntervals;

import java.util.LinkedList;
import java.util.List;

import com.leetcode.dataStructures.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0 || intervals.size() == 1) {
            return intervals;
        }
        

        LinkedList<Interval> newIntervals = new LinkedList<Interval>();
        newIntervals.add(intervals.get(0));
        // Need fucking sorting
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            for (int j = 0; j < newIntervals.size(); j++) {
                Interval itvl = newIntervals.get(j);
                if ((itvl.end < curr.start) || (curr.end < itvl.start)) {
                    continue;    
                } else {
                    curr.start = (itvl.start < curr.start ? itvl.start : curr.start);
                    curr.end = (itvl.end > curr.end ? itvl.end : curr.end);
                    newIntervals.remove(itvl);
                    j--;
                    continue;
                }
            }
            newIntervals.add(curr);
            
        }
        return (List)newIntervals;
    }
}
