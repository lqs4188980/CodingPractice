package com.leetcode.mergeIntervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
	
	/*
	public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) {
            return (List)result;
        }
        
        Interval[] itvs = new Interval[intervals.size()];
        
        int index = 0;
        for (Interval it : intervals) {
            itvs[index] = it;
            ++index;
        }
        
        qsort(itvs, 0, itvs.length - 1);
        
        
        Interval temp = itvs[0];
        for (int i = 1; i < itvs.length; ++i) {
            if (itvs[i].start > temp.end) {
                result.add(temp);
                temp = itvs[i];
            } else {
                temp.start = Math.min(temp.start, itvs[i].start);
                temp.end = Math.max(temp.end, itvs[i].end);
            }
        }
        
        result.add(temp);
        
        return (List)result;
    }
    
    private void qsort(Interval[] intervals, int from, int to) {
        if (from >= to) {
            return;
        }
        
        Random ri = new Random();
        int randMid = ri.nextInt(to - from + 1) + from;
        
        Interval temp = intervals[from];
        intervals[from] = intervals[randMid];
        intervals[randMid] = temp;
        
        Interval t = intervals[from];
        
        int l = from, r = to + 1;
        while (l < r) {
            while (++l <= to && intervals[l].start < t.start) {
                ;
            }
            
            while (--r >= from && intervals[r].start > t.start) {
                ;
            }
            
            if (l > r) {
                break;
            }
            
            temp = intervals[l];
            intervals[l] = intervals[r];
            intervals[r] = temp;
        } 
    
        temp = intervals[from];
        intervals[from] = intervals[r];
        intervals[r] = temp;
        
        
        qsort(intervals, from, r - 1);
        qsort(intervals, r + 1, to);
    }
	 */
}
