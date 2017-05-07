import math

class Node(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def dot(self, node):
        return self.x*node.x + self.y*node.y

    def normal(self):
        return Node(-self.y, self.x)

    def normalize(self):
        d = math.sqrt(self.x**2 + self.y**2)
        if d == 0:
            d = 1
        return Node(self.x/d, self.y/d)
