class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if p.val < q.val:
            return self.helper(root, p, q)
        else:
            return self.helper(root, q, p)
    def helper(self, root, p, q):
        if root is p or root is q:
            return root
        if root.val < q.val and root.val < p.val:
            return self.helper(root.right, p, q)
        if root.val > q.val and root.val > p.val:
            return self.helper(root.left, p, q)
        return root
