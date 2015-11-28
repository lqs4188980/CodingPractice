class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for char in s:
            if char == '(' or char == '[' or char == '{':
                stack.append(char)
            elif len(stack) == 0:
                return False
            elif char != self.get_mirror(stack[-1]):
                return False
            else:
                stack.pop()
        return True
    
    def get_mirror(self, char):
        if char == ')':
            return '('
        elif char == ']':
            return '['
        elif char == '}':
            return '{'