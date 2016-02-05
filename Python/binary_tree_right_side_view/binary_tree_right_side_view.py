class Solution(object):
    def rightSideView(self, root):
        view = []
        self.helper(root, 1, view)
        return view

    def helper(self, root, lvl, view):
        if root is None:
            return
        if lvl > len(view):
            view.append(root.val)
        self.helper(root.right, lvl+1, view)
        self.helper(root.left, lvl+1, view)
