# F(0) = 1
# F(1) = 1
# F(2) = F(0) * F(1) + F(1) * F(0) = 2
# F(3) = F(0) * F(2) + F(1) * F(1) + F(2) * F(0) = 5
# F(4) = F(0) * F(3) + F(1) * F(2) * F(2) * F(1) + F(3) * F(0) = 14

class Solution(object):
	def numTrees(self, n):
		res = [1] * (n + 1)
		for i in range(2, n + 1):
			num = 0
			for j in range(0, i//2):
				num += res[j] * res[i-j-1]
				if j*2+1 == i:
					tmp = res[j]
			num *= 2
			if i % 2 == 1:
				num += res[i//2] ** 2
			res[i] = num
		return res[n]
