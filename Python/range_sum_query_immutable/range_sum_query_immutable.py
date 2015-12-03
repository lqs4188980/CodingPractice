class NumArray(object):
	def __init__(self, nums):
		if len(nums) < 2:
			self.nums = nums
			return
		for i in range(1,len(nums)):
			nums[i] = nums[i-1] + nums[i]
		self.nums = nums

	def sumRange(self, i, j):
		if i == 0:
			return self.nums[j]
		else:
			return self.nums[j] - self.nums[i-1]
        
