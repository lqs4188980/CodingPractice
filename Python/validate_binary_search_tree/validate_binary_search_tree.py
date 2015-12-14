class Solution(object):
	def __init__(self):
		self.nums = []

	def isValidBST(self, root):
		# in-order, compare
		self.in_order(root)
		sorted_nums = sorted(set(self.nums))
		if len(self.nums) != len(sorted_nums):
			return False
		return cmp(self.nums, sorted_nums) == 0

	def in_order(self, root):
		if root is None:
			return
		self.in_order(root.left)
		if self.nums == []:
			self.nums = [root.val]
		else:
			self.nums.append(root.val)
		self.in_order(root.right)
