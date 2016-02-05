class Solution(object):
    def convertToTitle(self, n):
        res = ""
        while n:
            d = n % 26 - 1
            d = 25 if d < 0 else d
            res = res + chr(d + ord('A'))
            n -= d
            n //= 26
        return res[::-1]
