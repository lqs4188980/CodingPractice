class Solution(object):
    def maxDepth(self, root):
        max_depth = [0]
        self.helper(root, 0, max_depth)
        return max_depth

    def helper(self, root, curr, max_depth):
        if root is None:
            max_depth = max_depth \
                    if max_depth[0] > curr else [curr]
            return
        curr += 1
        self.helper(root.left, curr, max_depth)
        self.helper(root.right, curr, max_depth)
