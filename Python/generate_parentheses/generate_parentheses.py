class Solution(object):
    def generateParenthesis(self, n):
        left = n
        right = n
        result = []
        curr = ''
        self.generate(curr, left, right, result)
        return result

    def generate(self, curr, left, right, result):
        if left > right:
            return
        if left == 0 and right == 0:
            result.append(curr)
        if left:
            self.generate(curr + '(', left - 1, right, result)
        self.generate(curr + ')', left, right - 1, result)
