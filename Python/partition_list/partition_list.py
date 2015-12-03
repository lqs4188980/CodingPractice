class ListNode(object):
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution(object):
	def partition(self, head, x):
		head_s = ListNode(0)
		head_l = ListNode(0)
		s = head_s
		l = head_l
		while head:
			if head.val < x:
				s.next = head 
				s = s.next 
			else:
				l.next = head
				l = l.next
			head = head.next
		#!!
		l.next = None
		s.next = head_l.next
		return head_s.next
