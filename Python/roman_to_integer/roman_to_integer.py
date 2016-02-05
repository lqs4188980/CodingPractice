class Solution(object):
    def romanToInt(self, s):
        d  = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000,
                        'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}
        num = 0
        idx = 0
        while idx < len(s):
            if idx < len(s) - 1:
                cs = s[idx:idx+2]
                if cs in d:
                    num += d[cs]
                    idx += 2
                    continue
            num += d[s[idx]]
            idx += 1
        return num
