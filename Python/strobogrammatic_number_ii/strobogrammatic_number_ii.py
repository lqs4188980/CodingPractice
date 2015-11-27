# corner cases:
# won't start with 0
# 0, 1, 8 good for central
# 0, 1, 6, 8, 9 for rest

class Solution(object):
    def __init__(self):
        self.odd = ['0','1','8']
        self.whole = ['0','1','6','8','9']
        self.non_zero = ['1','6','8','9']
        
    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        nums = []
        if n % 2 == 1:
            for char in self.odd:
                self.get_stro_num(n, char, nums)
        else:
            self.get_stro_num(n, '', nums)
        return nums
    
    def get_stro_num(self, n, curr_num, nums):
        if n == len(curr_num):
            nums.append(curr_num)
            return
        if n == len(curr_num) + 2:
            for char in self.non_zero:
                self.get_stro_num(n, \
                    char + curr_num + self.get_mirror(char), \
                    nums)    
        else:
            for char in self.whole:
                self.get_stro_num(n, \
                    char + curr_num + self.get_mirror(char), \
                    nums) 
        
    def get_mirror(self, char):
        if char == '0' or \
            char == '1' or \
            char == '8':
            return char
        elif char == '6':
            return '9'
        else:
            return '6'
        # else raise exception