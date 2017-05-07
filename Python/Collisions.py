from Shapes import *
from Node import *

class Projection(object):
    def  __init__(self, mini, maxi):
        """ Create the projection with it's two values: min, max"""
        self.min = mini;
        self.max = maxi;

    def overlap(self, p2):
        """ Check if this projection overlaps with the passed one"""
        return (not(p2.max < self.min or self.max < p2.min))



def main():
    """Test a collision detection between a Triangle and a Circle"""
    print(test_collision(Polygon([1,3,1], [1,2,3]),Circle(Node(-2,-2),3)))

def test_collision(A, B):
    """Test collisions between two Shapes: they can be any type of Shape (Circle or Polygon)"""
    axes = A.get_axes() + B.get_axes() # Get the list of all the axes to project the shapes along

    for axis in axes:
        # project both Shapes onto the axis
        pA = project(A, axis)
        pB = project(B, axis)
        # do the projections overlap?
        if not(pA.overlap(pB)):
            #If they don't, the shapes don't either so return false
            return False

    # All the projections overlap: the shapes collide -> return True
    return True

def project(a, axis):
    """ Project the shapes along the axis"""
    mini = axis.dot(a.get_node(0, axis)) # Get the first min
    maxi = mini
    for i in range(1,a.num_of_nodes()):
        p = axis.dot(a.get_node(i, axis)) # Get the dot product between the axis and the node
        if p < mini: 
            mini = p
        elif p > maxi:
            maxi = p

    return Projection(mini, maxi)

main()
