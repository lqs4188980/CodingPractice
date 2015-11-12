import gc
from pdb import set_trace as bp
class Solution(object):
    def __init__(self):
        self.result = []
    def generatePossibleNextMoves(self, s):
        """
        :type s: str
        :rtype List[str]
        """
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
            #slots = self.find_all(idx+2, s_new, replace_str)
            #if slots != []:
            #    self.nextStep(slots, s_new, replace_str)

    def find_all(self, idx, s, sub_s):
        sub_len = len(sub_s)
        result = []
        while idx+sub_len <= len(s):
            if s[idx:idx+sub_len] == sub_s:
                result.append(idx)
            idx += 1 
        return result

s = Solution()
_str = "----++++--------++++-------+++++++-+-+-+-+"
_str = '++++'
print _str
print s.find_all(0, _str, '--')
print s.find_all(0, _str, '++')
result=s.generatePossibleNextMoves(_str)
import pprint
pprint.PrettyPrinter(indent=4).pprint(result)
print len(set(result))
