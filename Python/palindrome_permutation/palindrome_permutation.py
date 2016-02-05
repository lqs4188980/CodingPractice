class Solution(object):
    def canPermutePalindrome(self, s):
        # odd, one odd
        # even, all even
        counts = {}
        for char in s:
            if char not in counts:
                counts[char] = 1
            else:
                counts[char] += 1

        odd_count = reduce(lambda init, v: init + 1 if v % 2 else init, counts.values(), 0)

        if len(s) % 2 == 0:
            return odd_count == 0
        else:
            return odd_count == 1
