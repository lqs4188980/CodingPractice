# 1st
class Solution(object):
	def shortestDistance(self, words, word1, word2):
		d = {}
		for i, word in enumerate(words):
			if word in d:
				d[word].append(i)
			else:
				d[word] = [i]

		res = abs(d[word1][0]-d[word2][0])
		for i in d[word1]:
			for j in d[word2]:
				res = min(res, abs(i-j))
		return res

# 2ed trivial improvement
class Solution(object):
	def shortestDistance(self, words, word1, word2):
		res = len(words)
		pos_1, pos_2 = -1, -1
		for i, word in enumerate(words):
			if word == word1:
				pos_1 = i
			if word == word2:
				pos_2 = i
			if pos_1 != -1 and pos_2 != -1:
				res = min(res, abs(pos_1 - pos_2))
		return res
