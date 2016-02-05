# corner cases:
# 0, 1, 8 good for single, central
# 0, 1, 6, 8, 9 for rest

class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        _str = str(num)
        num_candidates = ['0','1','6','8','9']
        i = 0
        j = len(_str) - 1
        while i < j - 1:
            if _str[i] not in num_candidates or \
                _str[j] not in num_candidates or \
                _str[i] != self.get_mirror(_str[j]):
                return False
            i += 1
            j -= 1
        if i == j:
            return _str[i] == '0' or _str[i] == '1' or _str[j] == '8'
        else:
            return _str[i] == self.get_mirror(_str[j])

    def get_mirror(self, num_char):
        if num_char == '0':
            return '0'
        elif num_char == '1':
            return '1'
        elif num_char == '6':
            return '9'
        elif num_char == '8':
            return '8'
        elif num_char == '9':
            return '6'
