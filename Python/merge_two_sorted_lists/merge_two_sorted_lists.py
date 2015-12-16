class ListNode(object):
	def __init__(self, val):
		self.val = val
		self.next = None

class Solution(object):
	def mergeTwoLists(self, l1, l2):
		dummy = ListNode(0)
		curr = dummy
		while l1 and l2:
			if l1.val < l2.val:
				curr.next = l1
				l1 = l1.next
			else:
				curr.next = l2
				l2 = l2.next
			curr = curr.next
			curr.next = None

		if l1:
			curr.next = l1
		if l2:
			curr.next = l2

		return dummy.next



