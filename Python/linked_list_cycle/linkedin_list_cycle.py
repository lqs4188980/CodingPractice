class Solution(object):
    def hasCycle(self, head):
        slow = head
        fast = head
        while slow != None and fast != None:
            slow = slow.next
            fast = fast.next
            if fast is None:
                return False
            fast = fast.next
            if slow == fast:
                return True
        return False
