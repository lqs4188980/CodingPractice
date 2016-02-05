class Solution(object):
    def isSymmetric(self, root):
        if root is None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left is None or right is None:
            return left is None and right is None
        if left.val == right.val and \
                self.helper(left.left, right.right) and \
                self.helper(left.right, right.left):
            return True
        return False
