class Solution(object):
	def isBalanced(self, root):
		_, is_balanced = self.helper(root)
		return is_balanced

	def helper(self, root):
		if root is None:
			return 0, True
		l, l_b = self.helper(root.left)
		r, r_b = self.helper(root.right)
		if l_b and r_b and abs(l-r) < 2:
			return max(l, r)+1, True
		else:
			return 0, False

