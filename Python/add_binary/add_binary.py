# 	  1/1 1/0 0/0
# d     0   1   0
# c     1   0   0
class Solution(object):
	def addBinary(self, a, b):
		l = min(len(a), len(b))
		res = ""
		c = 0
		for i in range(l):
			d = int(a[~i]) + int(b[~i]) + c
			c = 1 if d > 1 else 0 
			d -= 2*c
			res += str(d)
		for i in range(len(res), len(a)):
			d = int(a[~i]) + c
			c = 1 if d > 1 else 0
			d -= 2*c
			res += str(d)
		for i in range(len(res), len(b)):
			d = int(b[~i]) + c
			c = 1 if d > 1 else 0
			d -= 2*c
			res += str(d)
		if c > 0:
			res += str(c)
		return res[::-1]

