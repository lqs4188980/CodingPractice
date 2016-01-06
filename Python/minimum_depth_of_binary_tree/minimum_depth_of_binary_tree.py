class Solution(object):
	def minDepth(self, root):
		if root is None:
			return 0
		q = [(root, 1)]
		while q:
			(v, depth) = q.pop(0)
			if v.left is None and v.right is None:
				return depth
			if v.left:
				if v.left.left is None and \
					v.left.right is None:
					return depth+1
				q.append((v.left, depth+1))
			if v.right:
				if v.right.left is None and \
					v.right.right is None:
					return depth+1
				q.append((v.right, depth+1))
		return depth
