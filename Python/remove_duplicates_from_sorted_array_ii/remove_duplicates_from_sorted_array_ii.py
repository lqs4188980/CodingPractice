class Solution(object):
	def removeDuplicates(self, nums):
		if len(nums) <= 2:
			return len(nums)

		idx = 1
		for i in range(2, len(nums)):
			if nums[i] == nums[idx]:
				if nums[idx] != nums[idx-1]:
					idx += 1
					nums[idx] = nums[i]
			else:
				idx += 1
				nums[idx] = nums[i]

		return idx + 1


