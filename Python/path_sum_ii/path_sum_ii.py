class Solution(object):
    def pathSum(self, root, sum):
        results = []
        self.helper(root, [], results, sum)
        return results

    def helper(self, root, curr, results, s):
        if root is None:
            return
        s -= root.val
        new_curr = curr + [root.val]
        if s == 0 and root.left is None and root.right is None:
            results.append(new_curr)
            return

        self.helper(root.left, new_curr, results, s)
        self.helper(root.right, new_curr, results, s)
