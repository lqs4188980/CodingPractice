class Solution(object):
    def upsideDownBinaryTree(self, root):
        # parent -> curr.right
        # parent.right -> curr.left
        # keep parent holder
        if not root or not root.left:
            return root
        ret = root
        while ret.left:
            ret = ret.left
        self.flip(root.left, root)
        return ret

    def flip(self, root, parent):
        if root is None:
            return
        self.flip(root.left, root)
        root.left = parent.right
        root.right = parent
        parent.left = None
        parent.right = None
