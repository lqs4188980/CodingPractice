class Solution(object):
	def insert(self, intervals, newInterval):
		if len(intervals) < 1:
			return [newInterval]
		idx = self.get_idx(0, len(intervals), intervals, newInterval)
		if idx == len(intervals) - 1 and newInterval.start > intervals[-1].start:
			intervals = intervals + [newInterval]
		else:
			intervals = intervals[:idx] + [newInterval] + intervals[idx:]
		return self.merge(intervals)

	def merge(self, intervals):
		idx = 0
		for i in range(1, len(intervals)):
			if intervals[idx].end >= intervals[i].start:
				intervals[idx].end = max(intervals[idx].end, intervals[i].end)
			else:
				idx += 1
				intervals[idx] = intervals[i]
		return intervals[:idx+1]

	def get_idx(self, start, end, intervals, newInterval):
		if start == end:
			return start
		median = (start + end) // 2
		if intervals[median].start == newInterval.start:
			return median
		if intervals[median].start > newInterval.start:
			return self.get_idx(start, median, intervals, newInterval)
		else:
			return self.get_idx(median+1, end, intervals, newInterval)

# wow
# slicing: left = [i for i in intervals if i.end < s]
# tilde: ~x == (-x) - 1, s[len(s) - 1]
