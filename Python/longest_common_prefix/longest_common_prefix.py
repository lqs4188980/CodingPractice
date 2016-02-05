class Solution(object):
    def longestCommonPrefix(self, strs):
        prefix = ""
        if len(strs) < 1:
            return prefix
        for j in range(len(strs[0])):
            p = strs[0][j]
            for i in range(len(strs)):
                if len(strs[i]) > j and strs[i][j] == p:
                    continue
                else:
                    p = ""
            if p == "":
                break
            prefix += p
        return prefix
