# slow

class Vector2D(object):

    def __init__(self, vec2d):
        self.vec2d = vec2d
        self.x = 0
        self.y = 0
        while self.x < len(self.vec2d) and \
            len(self.vec2d[self.x]) == 0:
            self.x += 1
        

    def next(self):
        cache = self.vec2d[self.x][self.y]
        
        if self.y < len(self.vec2d[self.x]) - 1:
            self.y += 1
        else:
            self.x += 1
            while self.x < len(self.vec2d) and \
                len(self.vec2d[self.x]) == 0:
                self.x += 1
            self.y = 0
            
        return cache
        

    def hasNext(self):
        if self.x <= len(self.vec2d) - 1 and \
            self.y <= len(self.vec2d[self.x]) - 1:
            return True
        else:
            return False