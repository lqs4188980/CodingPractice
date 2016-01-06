# 1104

class Solution(object):
    def __init__(self):
        self.result = []
    def generatePossibleNextMoves(self, s):
        if s == "":
            return self.result
        target = '++'
        idxes = self.find_all(0, s, target)
        if idxes != []:
            self.nextStep(idxes, s, target)
        return self.result

    def nextStep(self, idxes, s, sub_s):
        for idx in idxes:
            s_new = s[:idx] + replace_str + s[idx+len(sub_s):]
            self.result.append(s_new)

    def find_all(self, idx, s, sub_s):
        sub_len = len(sub_s)
        result = []
        while idx+sub_len <= len(s):
            if s[idx:idx+sub_len] == sub_s:
                result.append(idx)
            idx += 1 
        return result

# 1126

class Solution(object):
    def generatePossibleNextMoves(self, s):
        results = []
        if s == '':
            return results
        self.find_next(s, results)
        return results
            
    def find_next(self, curr, results):
        idx = 0
        while idx < len(curr) - 1:
            if curr[idx:idx+2] == '++':
                _next = curr[:idx] + '--' + curr[idx+2:]
                results.append(_next)
            idx += 1
