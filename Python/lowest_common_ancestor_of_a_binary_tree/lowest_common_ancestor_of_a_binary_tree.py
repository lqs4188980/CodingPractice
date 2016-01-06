# BFS
class Solution(object):
	def lowestCommonAncestor(self, root, p, q):
		if root is None:
			return None
		qu, pair, parents = [root], [], {root : None}
		while qu:
			curr = qu.pop(0)
			if curr is p or curr is q:
				pair.append(curr)
			if len(pair) == 2:
				break
			if curr.left:
				qu.append(curr.left)
				parents[curr.left] = curr
			if curr.right:
				qu.append(curr.right)
				parents[curr.right] = curr
		if len(pair) != 2:
			return None
		curr, dest = pair[0], pair[1]
		while curr != None:
			if self.reachable(curr, dest):
				return curr
			curr = parents[curr]
		return root

	def reachable(self, root, p):
		if root is None:
			return False
		if root is p:
			return True
		return self.reachable(root.left, p) or \
			self.reachable(root.right, p)

# DFS, TODO