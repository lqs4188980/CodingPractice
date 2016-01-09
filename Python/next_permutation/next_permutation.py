class Solution(object):
	def nextPermutation(self, nums):
		i = len(nums) - 1
		while i > 0:
			if nums[i] > nums[i-1]:
				i -= 1
				j = len(nums) - 1
				while nums[j] <= nums[i]:
					j -= 1
				nums[i], nums[j] = nums[j], nums[i]
				i += 1
				break
			i -= 1
		j = len(nums) - 1
		while i < j:
			nums[i], nums[j] = nums[j], nums[i]
			i += 1
			j -= 1




