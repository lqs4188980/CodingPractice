class Solution(object):
	def deleteDuplicates(self, head):
		if head is None:
			return head
		# 1 -> 1
		dummy = ListNode(0)
		dummy.next = head
		p = dummy
		d = False
		while p.next and p.next.next:
			if p.next.val == p.next.next.val:
				p.next.next = p.next.next.next
				d = True
				continue
			if d:
				p.next = p.next.next
				d = False
			else:
				p = p.next
		if d:
			p.next = p.next.next
		return dummy.next
