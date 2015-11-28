# two stack
class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        # push to stack
        # if smaller than min_stack top, push
        self.stack.append(x)
        if self.min_stack == [] or \
            x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if self.stack != []:
            if self.stack[-1] == self.min_stack[-1]:
                self.min_stack.pop()
            self.stack.pop()


    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]