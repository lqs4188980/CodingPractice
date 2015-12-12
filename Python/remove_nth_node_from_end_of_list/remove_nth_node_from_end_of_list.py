# Recursion

class Solution(object):
	def removeNthFromEnd(self, head, n):
		if head is None:
			return head
		return self.helper(head, [n])


	def helper(self, curr, holder):
		if curr is None:
			return None
		curr.next = self.helper(curr.next, holder)
		holder[0] -= 1
		if holder[0] == 0:
			curr = curr.next
		return curr

	def print_l(self, head):
		while head:
			print(str(head.val)+' -> ', end='')
			head = head.next
		print('None')