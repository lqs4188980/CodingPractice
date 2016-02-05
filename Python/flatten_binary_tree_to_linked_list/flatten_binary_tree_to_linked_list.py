class Solution(object):
    def flatten(self, root):
        if root is None:
            return None
        dummy = TreeNode(0)
        curr = dummy
        stack = [root]
        while stack:
            node = stack.pop()
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            curr.right = node
            curr = curr.right
            curr.left = None
