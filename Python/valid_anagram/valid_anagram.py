# good for unicode

class Solution(object):
    def isAnagram(sefl, s, t):
        lst_s = sorted([c for c in s])
        lst_t = sorted([c for c in t])
        if len(lst_s) != len(lst_t):
            return False
        for i in range(len(lst_s):
            if lst_s[i] != lst_t[i]:
                return False

        return True
