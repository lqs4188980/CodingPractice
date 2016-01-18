# stack
class BSTIterator(object):
    def __init__(self, root):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def hasNext(self):
        return self.stack != []

    def next(self):
        self.curr = self.stack[-1]
        if not self.stack[-1].right:
            while self.stack and self.stack[-1].val <= self.curr.val:
                self.stack.pop()
        else:
            curr = self.stack[-1].right
            while curr:
                self.stack.append(curr)
                curr = curr.left

        return self.curr.val

# deconstruct steps
# setNext when necessary
class BSTIterator(object):
    def __init__(self, root):
        self.stack = []
        self.setNext(root)

    def hasNext(self):
        return self.stack != []

    def next(self):
        self.curr = self.stack.pop()
        self.setNext(self.curr.right)
        return self.curr.val

    def setNext(self, root):
        while root:
            self.stack.append(root)
            root = root.left
            