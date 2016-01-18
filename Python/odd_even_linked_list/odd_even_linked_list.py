# p_odd.next = curr
# p_odd = p_odd.next
# p_odd.next = None    --> change curr.next to None implicitly 

class Solution(object):
    def oddEvenList(self, head):
        dummy_odd, dummy_even = ListNode(0), ListNode(0)
        p_odd, p_even = dummy_odd, dummy_even
        curr, is_odd = head, True
        while curr:
            tmp = curr.next
            if is_odd:
                p_odd.next = curr
                p_odd = p_odd.next
                p_odd.next = None
            else:
                p_even.next = curr
                p_even = p_even.next
                p_even.next = None
            curr = tmp
            is_odd = not is_odd
        p_odd.next = dummy_even.next
        return dummy_odd.next