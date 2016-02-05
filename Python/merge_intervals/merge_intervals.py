class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        if len(intervals) < 2:
            return intervals
        intervals = sorted(intervals, key=lambda i:i.start)
        idx = 0
        for i in range(1, len(intervals)):
            if intervals[idx].end >= intervals[i].start:
                intervals[idx].end = max(intervals[idx].end, intervals[i].end)
            else:
                idx += 1
                intervals[idx] = intervals[i]
        return intervals[:idx+1]
