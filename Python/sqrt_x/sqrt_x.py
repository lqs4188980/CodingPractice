class Solution(object):
    def mySqrt(self, x):
        val = self.helper(0, x, x)
        if x < 2:
            return val
        else:
            return val-1

    def helper(self, start, end, x):
        if start == end:
            return start
        if end - start == 1:
            if x - start*start < x - end*end:
                return start
            else:
                return end
        median = (start + end) / 2
        if median * median > x:
            return self.helper(start, median, x)
        else:
            return self.helper(median, end, x)
