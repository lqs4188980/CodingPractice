class TrieNode(object):
	def __init__(self, c=None):
		self.c = c
		self.nil = False
		self.children = {}

class Trie(object):

	def __init__(self):
		self.root = TrieNode()

	def insert(self, word):
		root = self.root
		for c in word:
			if c not in root.children:
				root.children[c] = TrieNode(c)
			root = root.children[c]
		root.nil = True

	def search(self, word):
		root = self.root
		for c in word:
			if c not in root.children:
				return False
			root = root.children[c]
		return root.nil

	def startsWith(self, prefix):
		root = self.root
		for c in prefix:
			if c not in root.children:
				return False
			root = root.children[c]
		return True
		