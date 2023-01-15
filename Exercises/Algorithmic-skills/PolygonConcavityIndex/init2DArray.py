
if __name__ == '__main__':
    rows = 6
    columns = 2
    a = [[0 for x in range(columns)] for y in range(rows)]
    print(a)


    N = M = 5
    Matrix = {(x,y):0 for x in range(N) for y in range(M)}
    point1 = (1, 2)
    Matrix[point1] = 2
    print( Matrix[(1, 2)] )


