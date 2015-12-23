# iteratively
class Solution(object):
	def reverseList(self, head):
		dummy = ListNode(0)
		while head:
			_next = dummy.next
			dummy.next = head
			head = head.next
			dummy.next.next = _next
		return dummy.next

# recursively
class Solution(object):
	def reverseList(self, head):
		dummy = ListNode(0)
		self.helper([dummy], head)
		return dummy.next

	def helper(self, holder, head):
		if head == None:
			return 
		self.helper(holder, head.next)
		head.next = None
		holder[0].next = head
		holder[0] = holder[0].next




