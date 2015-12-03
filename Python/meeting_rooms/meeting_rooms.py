# navie merge sort

class Solution(object):
	def canAttendMeetings(self, intervals):
		if intervals == []:
			return True
		# merge sort by first index
		intervals = self.merge_sort(0, len(intervals) - 1, intervals)
		for i in range(len(intervals) - 1):
			if intervals[i].end > intervals[i+1].start:
				return False
		return True

	def merge_sort(self, start, end, intervals):
		if start >= end:
			return [intervals[start]]
		median = (start + end) / 2
		lst1 = self.merge_sort(start, median, intervals)
		lst2 = self.merge_sort(median+1, end, intervals)
		return self.merge(lst1, lst2)

	def merge(self, lst1, lst2):
		lst = []
		i = 0
		j = 0
		while i < len(lst1) and j < len(lst2):
			if lst1[i].start < lst2[j].start:
				lst.append(lst1[i])
				i += 1
			else:
				lst.append(lst2[j])
				j += 1

		while i < len(lst1):
			lst.append(lst1[i])
			i += 1

		while j < len(lst2):
			lst.append(lst2[j])
			j += 1

		return lst

class Solution(object):
	def canAttendMeetings(self, intervals):
		intervals = sorted(intervals, key=lambda i: i[0])
		for i in range(len(intervals) - 1):
			if intervals[i].end > intervals[i+1].start:
				return False
		return True
		