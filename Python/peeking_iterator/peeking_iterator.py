# ? one variable not sufficient?

class PeekingIterator(object):
    def __init__(self, iterator):
        self.iterator = iterator
        self.has_next = self.iterator.hasNext()
        if self.has_next:
            self.next_elem = self.iterator.next()
        else:
            self.next_elem = None

    def peek(self):
        return self.next_elem

    def next(self):
        curr = self.next_elem
        self.has_next = self.iterator.hasNext()
        if self.has_next:
            self.next_elem = self.iterator.next()
        return curr

    def hasNext(self):
        return self.has_next
