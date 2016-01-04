# one to one mapping
class Solution(object):
	def wordPattern(self, pattern, str):
		segs = str.split()
		if len(pattern) != len(segs):
			return False
		k_v = {}
		v_k = {}
		for i, p in enumerate(pattern):
			if p not in k_v:
				if segs[i] in v_k:
					return False
				k_v[p] = segs[i]
				v_k[segs[i]] = p
			elif k_v[p] != segs[i]:
				return False
		return True
