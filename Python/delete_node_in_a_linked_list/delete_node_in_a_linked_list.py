# 1st
class Solution(object):
    def deleteNode(self, node):
        curr = node
        while curr.next:
            curr.val = curr.next.val
            if not curr.next.next:
                curr.next = None
            else:
                curr = curr.next

# 2ed
class Solution(object):
    def deleteNode(self, node):
        node.val = node.next.val
        node.next = node.next.next
