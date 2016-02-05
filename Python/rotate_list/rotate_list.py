class Solution(object):
    def rotateRight(self, head, k):
        if head is None:
            return head
        l = 0
        p = head
        while p:
            l += 1
            p = p.next
        k %= l
        if k == 0:
            return head
        i, p = l-k, head
        while i:
            i -= 1
            p = p.next
        q = p
        while q.next:
            q = q.next
        q.next = head
        i = l-k-1
        while i > 0:
            i -= 1
            head = head.next
        head.next = None
        return p
