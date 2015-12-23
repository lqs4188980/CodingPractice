class Solution(object):
	def levelOrderBottom(self, root):
		if root is None:
			return []
		res = []
		lvl = 0
		curr_l = lvl
		q = [(root, lvl)]
		while q:
			(rt, l) = q.pop(0)
			if curr_l == l and res != []:
				res[-1].append(rt.val)
			else:
				res.append([rt.val])
				curr_l = l
			if rt.left:
				q.append((rt.left, l+1))
			if rt.right:
				q.append((rt.right, l+1))
		return list(reversed(res))
# TODO: Queue.Queue
