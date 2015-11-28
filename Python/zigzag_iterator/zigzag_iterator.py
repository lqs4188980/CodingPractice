# cyclic

class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        # better use *args
        # self.args[0] = args[0] etc.
        self.vectors = [v1, v2]
        self.len_col = len(self.vectors)
        self.max_row = reduce(lambda init, v: \
            init if init > len(v) else len(v), self.vectors, 0)
        self.pos = -1

    def next(self):
        """
        :rtype: int
        """
        x = self.pos / self.len_col
        y = self.pos % self.len_col
        return self.vectors[y][x]
                                

    def hasNext(self):
        """
        :rtype: bool
        """
        self.pos += 1
        x = self.pos / self.len_col
        if x >= self.max_row:
            return False
        y = self.pos % self.len_col            
        if len(self.vectors[y]) <= x:
            return self.hasNext()
        else:
            return True