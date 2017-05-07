from Node import *

class Polygon(object):
    def __init__(self, x, y):
        """Create a list of nodes with every point"""
        self.nodes = []
        for i in range(len(x)):
            self.nodes.append(Node(x[i], y[i]))

    def get_axes(self):
        """Get the axes to project along"""
        axes = []
        for i in range(len(self.nodes)):
            # Create the vector which joins the current node to the next one
            node = Node(self.nodes[i].x - self.nodes[0 if i+1==len(self.nodes) else i+1].x,
                             self.nodes[i].y - self.nodes[0 if i+1==len(self.nodes) else i+1].y)
            # Get the unit vector of the perpendicular vector to the original one
            axes.append(node.normal().normalize())
        return axes

    def get_node(self, i, axis):
        """ Get the node at position i"""
        return self.nodes[i]

    def num_of_nodes(self):
        """ Get the number of nodes of the shape"""
        return len(self.nodes)


class Circle(object):
    def __init__(self, center, radius):
        self.center = center
        self.radius = radius

    def get_node(self, i, axis):
        """ Get the node at position i"""
        if i:
            # Return the point in one direction
            return Node(self.center.x + (-axis.normal().y * self.radius),
                        self.center.y + (axis.normal().x * self.radius))
        else:
            # Return the point in the other direction
            return Node(self.center.x + (axis.normal().y * self.radius),
                        self.center.y + (-axis.normal().x * self.radius))

    def get_axes(self):
        """ Get the axes to project along"""
        # A circle has no axes to be projected along
        return []

    def num_of_nodes(self):
        """ Get the number of nodes of the shape"""
        # A circle only has 2 for SAT
        return 2
