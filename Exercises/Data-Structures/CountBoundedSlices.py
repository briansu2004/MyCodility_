def boundedSlicesGolden(K, A):
    maxInt = 1000000000

    N = len(A)

    maxQ = [0] * (N + 1)
    posmaxQ = [0] * (N + 1)
    minQ = [0] * (N + 1)
    posminQ = [0] * (N + 1)

    firstMax, lastMax = 0, -1
    firstMin, lastMin = 0, -1
    j, result = 0, 0

    for i in range(N):
        while (j < N):
            # added new maximum element
            while (lastMax >= firstMax and maxQ[lastMax] <= A[j]):
                lastMax -= 1
            lastMax += 1
            maxQ[lastMax] = A[j]
            posmaxQ[lastMax] = j

            # added new minimum element
            while (lastMin >= firstMin and minQ[lastMin] >= A[j]):
                lastMin -= 1
            lastMin += 1
            minQ[lastMin] = A[j]
            posminQ[lastMin] = j

            if (maxQ[firstMax] - minQ[firstMin] <= K):
                j += 1
            else:
                break
        result += (j - i)
        if result >= maxInt:
            return maxInt
        if posminQ[firstMin] == i:
            firstMin += 1
        if posmaxQ[firstMax] == i:
            firstMax += 1
    return result


if __name__ == '__main__':
    K = 2
    A = [3, 5, 7, 6, 3]
    print(boundedSlicesGolden(K, A))
