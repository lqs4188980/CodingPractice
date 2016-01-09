# (A, D)	(C, D)
# (A, B)	(C, B)
# 		(E, H)	(G, H)
# 		(E, F)	(G, F)
# dot, line
# ??? why the result for dotA in rectB is areaB ???
class Solution(object):
	def computeArea(self, A, B, C, D, E, F, G, H):
		# # wrong, if right < left and bottom < top
		# # areaA + areaB - intersection
		# left, right = max(A, E), min(C, G)
		# top, bottom = min(D, H), max(B, F)
		# intersect = (right-left)*(top-bottom)	
		# # wrong, if right < left and bottom < top
		left = max(A, E)
		right = max(min(C, G), left)
		bottom = max(B, F)
		top = max(min(D, H), bottom)
		intersect = (right-left)*(top-bottom)	
		return (C-A)*(D-B) + (G-E)*(H-F) - intersect




