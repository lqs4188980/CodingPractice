# duplicate, one to one mapping?

class Solution(object):
    def isIsomorphic(self, s, t):
        if len(s) != len(t):
            return False
        table = {}
        for i in range(len(s)):
            if s[i] not in table:
                table[s[i]] = t[i]
            elif table[s[i]] != t[i]:
                return False
        table = {}
        for i in range(len(s)):
            if t[i] not in table:
                table[t[i]] = s[i]
            elif table[t[i]] != s[i]:
                return False

        return True
