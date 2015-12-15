class Solution(object):
	def postorderTraversal(self, root):
		if root is None:
			return []
		stack = []
		stack.append(root)
		res = []
		curr = None
		while stack:
			if stack[-1].left is None and stack[-1].right is None:
				curr = stack.pop()
				res.append(curr.val)
			elif (curr is stack[-1].left or curr is stack[-1].right) and curr is not None:
				curr = stack.pop()
				res.append(curr.val)
			else:
				top = stack[-1]
				# order of adding right/left matters
				# albeit it makes no sense to restrict order
				# IMO
				if top.right:
					stack.append(top.right)
				if top.left:
					stack.append(top.left)
		return res
