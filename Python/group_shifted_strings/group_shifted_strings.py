class Solution(object):
	def groupStrings(self, strings):
		table = {}
		for s in strings:
			from pdb import set_trace as bp
			bp()
			diff = sorted([(ord(c) - ord(s[0])) % 26 for c in s])
			t = tuple(diff)
			if t in table:
				table[t].append(s)
			else:
				table[t] = [s]
		for k in table:
			table[k] = sorted(table[k])
		return list(table.values())

