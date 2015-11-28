# slow

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        # a timestamp queue
        self.cache = {}
        self.timestamp = []
        self.capacity = capacity
        self.cache_size = 0

    def get(self, key):
        """
        :rtype: int
        """
        if key in self.cache:
            self.timestamp_update(key)
            return self.cache[key]
        else:
            return -1

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.cache:
            self.timestamp_update(key)
        else:
            if self.cache_size == self.capacity:
                self.timestamp_kick()
                self.timestamp.append(key)
            else:
                self.timestamp.append(key)
                self.cache_size += 1
        self.cache[key] = value

    def timestamp_kick(self):
        to_kickout = self.timestamp[0]
        self.timestamp = self.timestamp[1:]
        del self.cache[to_kickout]

    def timestamp_update(self, key):
        # assuming key is in deque
        idx = self.timestamp.index(key)
        del self.timestamp[idx]
        self.timestamp.append(key)
        