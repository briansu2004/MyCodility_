# Codility_ Exercises

## Algorithmic skills

### FirstUnique

![1673703234048](image/Exercises/1673703234048.png)

<!--
O(N**2)

54%

```java
import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());

        List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());

        // aList.stream().filter(x -> x > 0);
        for (int i = 0; i < a.length; i++) {
            if (Collections.frequency(aList, a[i]) == 1) {
                return a[i];
            }
        }

        return -1;
    }
}
```

-->

O(N * log(N))

100%

![1673704220801](image/Exercises/1673704220801.png)

![1673704273730](image/Exercises/1673704273730.png)

![1673704303061](image/Exercises/1673704303061.png)

## StrSymmetryPoint

O(length(S))

100%

![1673706130815](image/Exercises/1673706130815.png)

![1673706154340](image/Exercises/1673706154340.png)

![1673706169324](image/Exercises/1673706169324.png)
