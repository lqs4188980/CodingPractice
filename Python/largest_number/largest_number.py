# import functools
# functools.cmp_to_key() not working
# how to in python3?

class Solution(object):
    def largestNumber(self, nums):
        nums_str = map(str, nums)
        def cmp_lt(str1, str2):
            if int(str1+str2) < int(str2+str1):
                return 1
            else:
                return -1

        return str(int(''.join(sorted(nums_str, cmp=cmp_lt))))
