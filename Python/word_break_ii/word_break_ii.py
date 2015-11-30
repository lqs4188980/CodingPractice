# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         """
#         :type s: str
#         :type wordDict: Set[str]
#         :rtype: List[str]
#         """
#         solved = []
#         self.next_word(s, '', wordDict, solved)
#         return results
        
#     def next_word(self, s, curr, wordDict, solved):
#     	if s == '':
#     		return solved[curr] 
#     	if s in solved:
#     		return solved[s]
