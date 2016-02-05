class Solution(object):
    def isUgly(self, num):
        if num < 1:
            return False
        for fact in [2, 3, 5]:
            while num % fact == 0:
                num //= fact
        # ???????????????
        # return num == 1
        if num == 1:
            return True
        return False
