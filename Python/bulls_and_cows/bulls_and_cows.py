class Solution(object):
	def getHint(self, secret, guess):
		bulls = 0
		pos = {}
		for i, c in enumerate(secret):
			if c == guess[i]:
				bulls += 1
			else:
				pos[c] = pos.setdefault(c, 0) + 1
		cows = 0
		for i, c in enumerate(guess):
			if c != secret[i]:
				if c in pos and pos[c] > 0:
					pos[c] -= 1
					cows += 1
		return str(bulls) + "A" + str(cows) + "B"


