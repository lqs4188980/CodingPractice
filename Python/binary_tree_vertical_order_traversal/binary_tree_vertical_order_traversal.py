class Solution(object):
	def verticalOrder(self, root):
		if root is None:
			return []
		d = {}
		self.collect_lvl_elems(root, 0, d)
		lst = sorted(d.items())
		return [v for (k, v) in lst]

	def collect_lvl_elems(self, root, vlvl, d):
		q = [(root, vlvl)]
		visited = set()
		while q:
			(rt, vlvl) = q.pop(0)
			visited.add(rt)
			if vlvl in d:
				d[vlvl].append(rt.val)
			else:
				d[vlvl] = [rt.val]
			if rt.left is not None and rt.left not in visited:
				q.append((rt.left, vlvl-1))
			if rt.right is not None and rt.right not in visited:
				q.append((rt.right, vlvl+1))


