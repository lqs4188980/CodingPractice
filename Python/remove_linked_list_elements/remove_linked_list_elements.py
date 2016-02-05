class Solution(object):
    def removeElements(self, head, val):
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        while p.next:
            if p.next.val == val:
                p.next = p.next.next
                continue
            p = p.next
        return dummy.next


class ListNode(object):
    def __init__(self, val):
        self.val = val
        self.next = None

def convert(lst):
    if lst == []:
        return None
    dummy = ListNode(0)
    q = dummy
    for e in lst:
        q.next = ListNode(0)
        q.next.val = e
        q = q.next
    return dummy.next

def print_ll(head):
    while head:
        print('{} -> '.format(head.val), end='')
        head = head.next
    print('NULL')
