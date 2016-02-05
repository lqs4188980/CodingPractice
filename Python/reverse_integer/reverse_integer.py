class Solution(object):
    def reverse(self, x):
        MAX = 2**31 - 1
        MIN = - MAX - 1
        pos = False if x < 0 else True
        x = abs(x)
        res = 0
        while x:
            res *= 10
            d = x % 10
            res += d
            x //= 10
        # HOWTO: in C/C++?
        if pos:
            res = res if res <= MAX else 0
        else:
            res = -res if -res >= MIN else 0
        return res
