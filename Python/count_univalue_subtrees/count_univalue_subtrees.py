class Solution(object):
    def countUnivalSubtrees(self, root):
        count = [0]
        self.helper(root, count)
        return count[0]

    def helper(self, root, count):
        if root is None:
            return True
        if root.left is None and root.right is None:
            count[0] += 1
            return True
        left_uni = self.helper(root.left, count)
        right_uni = self.helper(root.right, count)
        if root.left and root.val == root.left.val and left_uni and root.right is None:
            count[0] += 1
            return True
        if root.right and root.val == root.right.val and right_uni and root.left is None:
            count[0] += 1
            return True
        if root.left and root.right and root.val == root.right.val and root.val == root.left.val \
                and left_uni and right_uni:
            count[0] += 1
            return True

        return False
