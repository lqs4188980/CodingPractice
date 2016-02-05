class Solution(object):
	def preorderTraversal(self, root):
		lst = []
		self.preorder(root, lst)
		return lst
	def preorder(self, root, lst):
		if root is None:
			return
		lst.append(root.val)
		self.preorder(root.left, lst)
		self.preorder(root.right, lst)