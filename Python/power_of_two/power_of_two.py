class Solution(object):
    def isPowerOfTwo(self, n):
        is_power = False
        if n <= 0:
            return is_power
        while n > 0:
            if n & 1:
                if is_power:
                    return False
                else:
                    is_power = not is_power
            n = n >> 1
        return True
        