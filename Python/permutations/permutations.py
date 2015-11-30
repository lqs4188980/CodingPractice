class Solution(object):
	def __init__(self):
		self.results = []
		self.size = 0
	def permute(self, nums):
		self.size = len(nums)
		self.find_p(nums, [])
		return self.results

	def find_p(self, nums, curr):
		if len(curr) == self.size:
			if self.results == []:
				self.results += [curr]
			else:
				self.results.append(curr)
			return
		for i in range(len(nums)):
			next_elem = curr[:]
			next_elem.append(nums[i])
			self.find_p(nums[:i]+nums[i+1:], next_elem)

