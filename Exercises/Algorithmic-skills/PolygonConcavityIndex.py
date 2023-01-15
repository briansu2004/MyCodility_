'''
An array A of points in a 2D plane is given. These points represent a polygon: every two consecutive points describe an edge of the polygon, and there is an edge connecting the last point and the first point in the array.

A set of points in a 2D plane, whose boundary is a straight line, is called a semiplane. More precisely, any set of the form {(x, y) : ax + by ≥ c} is a semiplane. The semiplane contains its boundary.

A polygon is convex if and only if, no line segment between two points on the boundary ever goes outside the polygon.

For example, the polygon consisting of vertices whose Cartesian coordinates are consecutively:
  (-1, 3)   (3, 1)   (0, -1)   (-2, 1)
is convex.

The convex hull of a finite set of points in a 2D plane is the smallest convex polygon that contains all points in this set. For example, the convex hull of a set consisting of seven points whose Cartesian coordinates are:
  (-1, 3)   (1, 2)   (3, 1)   (1, 1)   (0, -1)   (-2, 1)  (-1, 2)
is a polygon that has five vertices. When traversed clockwise, its vertices are:
  (-1, 3)   (1, 2)   (3, 1)   (0, -1)   (-2, 1)

If a polygon is concave (that is, it is not convex), it has a vertex which does not lie on its convex hull border. Your assignment is to find such a vertex.

Assume that the following declarations are given:

class Point2D(object):
  x = 0
  y = 0

Write a function:

def solution(A)

that, given a non-empty array A consisting of N elements describing a polygon, returns −1 if the polygon is convex. Otherwise, the function should return the index of any point that doesn't belong to the convex hull border. Note that consecutive edges of the polygon may be collinear (that is, the polygon might have 180−degrees angles).

To access the coordinates of the K-th point (where 0 ≤ K < N), use the following syntax:

A[K].x to access the x-coordinate,
A[K].y to access the y-coordinate.

For example, given array A such that:
  A[0].x = -1  A[0].y =  3
  A[1].x =  1  A[1].y =  2
  A[2].x =  3  A[2].y =  1
  A[3].x =  0  A[3].y = -1
  A[4].x = -2  A[4].y =  1
the function should return −1, as explained in the example above.

However, given array A such that:
  A[0].x = -1  A[0].y =  3
  A[1].x =  1  A[1].y =  2
  A[2].x =  1  A[2].y =  1
  A[3].x =  3  A[3].y =  1
  A[4].x =  0  A[4].y = -1
  A[5].x = -2  A[5].y =  1
  A[6].x = -1  A[6].y =  2
the function should return either 2 or 6. These are the indices of the polygon lying strictly in its convex hull (that is, not on the convex hull border).

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..10,000];
the coordinates of each point in array A are integers within the range [−1,000,000,000..1,000,000,000];
no two edges of the polygon A intersect, other than meeting at their endpoints;
array A does not contain duplicate points.
'''


def solution(A):
    """
    判断A中点组成的多边形是否是凸多边形，是的话返回-1，不是的话返回在凸包内部的任意一点的索引
    利用Graham扫描算法得到凸包
    :param A: 顶点的坐标
    :return: -1或者凸包内部任意点的索引
    """
    if len(A) < 4:
        return -1
    # 所有点的集合
    point_set = []
    for i in range(len(A)):
        point_set.append([i, [A[i].x, A[i].y]])  # 题目中设定的数据结构
        # point_set.append([i, [A[i][0], A[i][1]]])
    # 选出所有点中纵坐标最小的点，纵坐标相同的选择横坐标最小的点
    point_set.sort(key=lambda s: [s[1][1], s[1][0]])
    min_y_point = point_set[0]  # 参考点P0
    # 将上面选择的点，转移到原点，计算其他所有点转移后和原点构成的向量和x轴正向的夹角
    # 按照夹角从小到大排列，相同角度的, 按照y的降序排列
    more_equal_than_zero = []  # 大于等于0的升序排列，相同值的按照y的降序排列
    less_than_zero = []  # 小于0的升序排列，相同值的按照y的降序排列
    positive_infinity = []   # 等于正无穷的按照y值的降序排列
    for p in point_set[1:]:
        point = [p[1][0] - min_y_point[1][0], p[1][1] - min_y_point[1][1]]
        if point[0] != 0:
            tan = point[1] / point[0]
            if tan >= 0:
                more_equal_than_zero.append([p[0], [tan, point[1]], point])
            else:
                less_than_zero.append([p[0], [tan, point[1]], point])
        else:
            positive_infinity.append([p[0], [0, point[1]], point])

    more_equal_than_zero.sort(key=lambda m: [m[1][0], -m[1][1]])
    less_than_zero.sort(key=lambda m: [m[1][0], -m[1][1]])
    positive_infinity.sort(key=lambda m: -m[1][1])

    # 合并后，所有点是按着夹角逆时针排列的
    trans_point_angle = more_equal_than_zero + positive_infinity + less_than_zero

    #  开始位置添加第一个点P0
    trans_point_angle.insert(0, [point_set[0][0], [0, 0], [0, 0]])
    #  结尾位置添加第一个点P0
    trans_point_angle.append(trans_point_angle[0])

    # 把前2个点p0, p1放入栈中，把p1后面的点p2作为评判点，如果向量的叉积V_p0p2*V_p0p1<0,说明p2在p0p1的逆时针方向，是对的，如果为0，
    # 说明三点共线;如果大于0，说明p2在p0p1的顺时针方向，说明P1点是凹进去的
    current = [trans_point_angle[0], trans_point_angle[1]]
    for index in trans_point_angle[2:]:
        p0, p1, p2 = [current[0], current[1], index]
        p0_p = p0[2]
        p1_p = p1[2]
        p2_p = p2[2]
        p0p2 = p2_p[0] - p0_p[0], p2_p[1] - p0_p[1]
        p0p1 = p1_p[0] - p0_p[0], p1_p[1] - p0_p[1]
        product = p0p2[0] * p0p1[1] - p0p2[1] * p0p1[0]

        if product < 0:
            current = [current[1], index]
        elif product == 0:
            current = [current[0], index]
        else:
            return current[1][0]
    return -1


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


if __name__ == '__main__':
    # print(solution(a))

    p1 = Point(-1, 3)
    p2 = Point(1, 2)
    p3 = Point(3, 1)
    p4 = Point(0, -1)
    p5 = Point(-2, 1)
    A = []
    A.append(p1)
    A.append(p2)
    A.append(p3)
    A.append(p4)
    A.append(p5)
    print(solution(A))

    p1 = Point(-1, 3)
    p2 = Point(1, 2)
    p3 = Point(1, 1)
    p4 = Point(3, 1)
    p5 = Point(0, -1)
    p6 = Point(-2, 1)
    p7 = Point(-1, 2)
    B = []
    B.append(p1)
    B.append(p2)
    B.append(p3)
    B.append(p4)
    B.append(p5)
    B.append(p6)
    B.append(p7)
    print(solution(B))
