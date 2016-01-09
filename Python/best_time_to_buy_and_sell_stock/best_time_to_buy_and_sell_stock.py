class Solution(object):
	def maxProfit(self, prices):
		if len(prices) < 1:
			return 0
		pmin = prices[0]
		max_profit = 0
		for i in range(0, len(prices)):
			pmin = min(pmin, prices[i])
			max_profit = max(max_profit, prices[i] - pmin)	
		return max_profit
