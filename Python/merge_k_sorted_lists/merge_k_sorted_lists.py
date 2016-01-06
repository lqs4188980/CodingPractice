import heapq

# first elem in tuple is treated as key
class MyHeap(object):
	def __init__(self, init=None, key=lambda node:node.val):
		self.key = key
		if init:
			self._data = [(key(item), item) for item in init]
			heapq.heapify(self._data)
		else:
			self._data = []
	def push(self, item):
		heapq.heappush(self._data, (self.key(item), item))

	def pop(self):
		return heapq.heappop(self._data)[1]

class Solution(object):
	def mergeKLists(self, lists):
		if len(lists) < 1:
			return None
		h = MyHeap()
		lists = list(filter(lambda l: l is not None, lists))
		while True:
			count = 0
			for i in range(len(lists)):
				if lists[i] == None:
					count += 1
					continue
				h.push(lists[i])
				lists[i] = lists[i].next

			if count == len(lists):
				break

		dummy = ListNode(0)
		curr = dummy
		while h._data:
			curr.next = h.pop()
			curr = curr.next
			curr.next = None
		return dummy.next

