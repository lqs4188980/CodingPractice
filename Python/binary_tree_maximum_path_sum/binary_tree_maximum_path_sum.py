class Solution(object):
    def maxPathSum(self, root):
        if root is None:
            return 0
        self.MIN = -2**31
        max_val, _ = self.get_max(root)
        return max_val

    def get_max(self, root):
        if root.left is None and root.right is None:
            return root.val, root.val
        left_max, left_path_max = self.get_max(root.left) if root.left else (self.MIN, self.MIN)
        right_max, right_path_max = self.get_max(root.right) if root.right else (self.MIN, self.MIN)
        curr_path_max = max(root.val,
                                                left_path_max + root.val,
                                                right_path_max + root.val)
        curr_max = max(left_max,
                                        right_max,
                                        curr_path_max,
                                        left_path_max + right_path_max + root.val)
        return curr_max, curr_path_max
