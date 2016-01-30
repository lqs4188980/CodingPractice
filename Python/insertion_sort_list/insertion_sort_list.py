class Solution(object):
    def insertionSortList(self, head):
        if head is None:
            return head
        dummy = ListNode(0)
        dummy.next, curr = head, head
        while curr.next:
            if curr.next.val < curr.val:
                post = curr.next
                curr.next = post.next
                post.next = None
                phead = dummy
                while phead.next and phead.next.val < post.val:
                    phead = phead.next
                post.next = phead.next
                phead.next = post
                if phead == curr:
                    curr = curr.next
            else:
                curr = curr.next
        return dummy.next

#!! insert node if:
#   curr.next.val < curr.val, 