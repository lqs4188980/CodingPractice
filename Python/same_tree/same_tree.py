class Solution(object):
	def isSameTree(self, p, q):
		if q is None or p is None:
			if q is None and p is None:
				return True
			else:
				return False
		if q.val != p. val:
			return False
		return self.isSameTree(q.left, p.left) and \
			self.isSameTree(q.right, p.right)
			