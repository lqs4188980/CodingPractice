class Solution(object):
    def detectCycle(self, head):
        p = head
        q = head
        while p is not None and q is not None:
            p = p.next
            q = q.next
            if p is None or q is None:
                return None
            q = q.next
            if q is None:
                return None
            if p == q:
                break

        if p is None or q is None:
            return None

        p = head
        while p != q:
            p = p.next
            q = q.next

        return p
