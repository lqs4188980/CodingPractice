class Solution(object):
    def reverseWords(self, s):
        i = 0
        j = len(s)-1
        while i < j:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
        i = 0
        j = i
        while i < len(s):
            j = i
            while j < len(s) and s[j] != ' ':
                j += 1
            start = j
            j -= 1
            while i < j:
                s[i], s[j] = s[j], s[i]
                i += 1
                j -= 1
            i = start + 1
