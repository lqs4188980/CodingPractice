# - sys.maxsize, sys.maxint \or
# - def find_min(self, root):
# - def find_max(self, root):

class Solution(object):
    def closestValue(self, root, target):
        MAX = 2**63 - 1
        MIN = - MAX - 1
        return self.search_with_range(root, MIN, MAX, target)

    def search_with_range(self, root, left, right, target):
        if root is None:
            return left if abs(left - target) < abs(right - target) else right
        if root.val == target:
            return root.val
        elif root.val < target:
            return self.search_with_range(root.right, root.val, right, target)
        else:
            return self.search_with_range(root.left, left, root.val, target)
