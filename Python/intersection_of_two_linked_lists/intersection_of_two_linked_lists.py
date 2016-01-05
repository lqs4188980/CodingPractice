class Solution(object):
	def getIntersectionsNode(self, headA, headB):
		if headA is None and headB is None:
			return None
		pa, pb = headA, headB
		while pa and pb:
			pa = pa.next
			pb = pb.next
		diff = 0
		shorterA = False
		while pa:
			pa = pa.next
			diff += 1
		while pb:
			pb = pb.next
			diff += 1
			shorterA = True
		p, q = (headA, headB) if shorterA else (headB, headA)
		while diff:
			q = q.next
			diff -= 1
		while p != q:
			p = p.next
			q = q.next
		return p



