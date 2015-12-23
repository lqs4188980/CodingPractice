# Python 2: from Queue import Queue
# Python 3: from queue import Queue
from queue import Queue
class Stack(object):
	def __init__(self):
		self.q1 = Queue()
		self.q2 = Queue()
	def push(self, x):
		self.top = x
		self.q1.put(x)
	def pop(self):
		while self.q1.qsize() > 1:
			self.top = self.q1.get()
			self.q2.put(self.top)
		item = self.q1.get()
		self.q1 = self.q2
		self.q2 = Queue()
	# 'int' object is not callable????
	def empty(self):
		return self.q1.empty()
	def top(self):
		return self.top
	def print_q(self):
		for elem in list(self.q1.queue):
			print('{}, '.format(elem),end='')
		print('NIL')
		print(self.top)

# 'int' object is not callable?
 # 17         168 LOAD_NAME               10 (print)
 #            171 LOAD_NAME                6 (stack)
 #            174 LOAD_ATTR               12 (top)
 #    -->     177 CALL_FUNCTION            0 (0 positional, 0 keyword pair)
 #            180 CALL_FUNCTION            1 (1 positional, 0 keyword pair)
 #            183 POP_TOP
 #            184 POP_BLOCK
 #            185 JUMP_FORWARD            66 (to 254)
            