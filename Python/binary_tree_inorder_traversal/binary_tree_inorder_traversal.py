class Solution(object):
    def __init__(self):
        self.result = []
    def inorderTraversal(self, root):
        self.helper(root)
        return self.result

    def helper(self, root):
        if root is None:
            return
        self.helper(root.left)
        self.result.append(root.val)
        self.helper(root.right)
