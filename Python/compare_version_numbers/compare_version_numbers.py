# 1st !@$#@^$&*&
class Solution(object):
	def compareVersion(self, version1, version2):
		# nums1 = [int(c) for c in version1.split('.')]
		# nums2 = [int(c) for c in version2.split('.')]
		nums1 = map(int, version1.split('.'))
		nums2 = map(int, version2.split('.'))
		nums1 += [0] * (len(nums2) - len(nums1))
		nums2 += [0] * (len(nums1) - len(nums2))
		if nums1 > nums2:
			return 1
		if nums1 < nums2:
			return -1
		return 0
