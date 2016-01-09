#    2
#     \
#      3
#     /
#    2
#   /
#  1
# O: 2-3
# X: 3-2-1
# HOWTO: from child to parent?

# slow
class Solution(object):
	def longestConsecutive(self, root):
		root_w, root_wo = self.get_consec(root)
		return max(root_w, root_wo)

	def get_consec(self, root):
		'''
		rtype: long_consec_w, long_conse_wo
		'''
		if root is None:
			return 0, 0
		left_w, left_wo = self.get_consec(root.left)
		right_w, right_wo = self.get_consec(root.right)
		if root.left and root.val+1 == root.left.val:
			curr_w_left, curr_wo_left = left_w+1, 0
		else:
			curr_w_left = 1
			curr_wo_left = max(left_w, left_wo)
		if root.right and root.val+1 == root.right.val:
			curr_w_right, curr_wo_right = right_w+1, 0
		else:
			curr_w_right = 1
			curr_wo_right = max(right_w, right_wo)
		curr_w = max(curr_w_left, curr_w_right)
		curr_wo = max(left_wo, right_wo, curr_wo_left, curr_wo_right)
		return curr_w, curr_wo










