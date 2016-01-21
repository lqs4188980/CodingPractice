class Solution(object):
    def wordBreak(self, s, wordDict):
        self.solved = {}
        return self.word_break(s, wordDict)

    def word_break(self, s, wordDict):
        if s == '':
            return []
        if s in self.solved:
            return self.solved[s]
        res = []
        for i in range(len(s)):
            if s[:i] in wordDict:
                for p in self.word_break(s[i:], wordDict):
                    res.append(s[:i] + " " + p)
        self.solved[s] = res
        if s in wordDict:
            res.append(s)
        return res

# memorized dfs, prune unnecessary branches, 
# what is the search space?

