class Solution(object):
	def swapPairs(self, head):
		dummy_head = ListNode(0)
		dummy_head.next = head

		curr = dummy_head.next
		prev_node = dummy_head
		while curr and curr.next:
			next_node = curr.next.next
			prev_node.next = curr.next
			prev_node.next.next = curr
			prev_node.next.next.next = next_node

			prev_node = prev_node.next.next
			curr = prev_node.next

		return dummy_head.next
		