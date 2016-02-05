# TLE
class TwoSum(object):
    def __init__(self):
        self.value = 0
        self.d = {}
    def add(self, number):
        self.d[number] = self.value - number
    def find(self, value):
        diff = value - self.value
        self.value = value
        found = False
        for k in self.d:
            self.d[k] = self.d[k] + diff
            if self.d[k] in self.d:
                found = True
        return found

# 644
class TwoSum(object):
    def __init__(self):
        self.holder = {}
    def add(self, number):
        if number not in self.holder:
            self.holder[number] = 1
        else:
            self.holder[number] += 1
    def find(self, value):
        for num in self.holder:
            if value - num in self.holder:
                if value - num == num and self.holder[num] > 1 or \
                        value - num != num and len(self.holder) > 1:
                    return True
        return False

# dict_instance.get(key, default), TLE
# if key in d VS if key in d.keys(); ok, TLE
