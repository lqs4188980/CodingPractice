class Solution(object):
	def generateAbbreviations(self, word):
		res = [word]
		for i in range(1, len(word)+1):
			res.extend(self.snippet(word, i))
		return res

	def snippet(self, word, n):
		res = []
		for i in range(len(word)-n+1):
			if len(word[i+n:]) > 1:
				posts = []
				for k in range(1, len(word[i+n:])):
					posts.extend(self.snippet(word[i+n+1:], k))
				for post in posts:
					res.append(word[:i]+str(n)+word[i+n]+post)
			res.append(word[:i]+str(n)+word[i+n:])
		return res

