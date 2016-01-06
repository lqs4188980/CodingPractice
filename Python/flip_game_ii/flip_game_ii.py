# slow

class Solution(object):
    def canWin(self, s):
        if '++' not in s:
            return False
        can_win = False
        idx = 0
        while idx < len(s) - 1:
            if s[idx:idx+2] == '++':
                can_win = can_win or \
                not self.canWin(s[:idx] + '--' + s[idx+2:])
            idx += 1
        return can_win
        