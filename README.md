#TeamShrug
Shakil Rafi, Allan Wang, and Angela Kim
Period 4

##Big-Oh Runtime Analysis
###Best case:
In the best case scenario, the pivot choice is always the median value of the elements. Assuming that fact, the array will be sorted into two equal halves each partition, producing two regions with # elements N/2. Since each region will continue to be partitioned into two equal regions(n/2, n/4, n/8, etc elements per region at each level), the array will be partitioned log(n) times. This means we'd have log(n) levels, and since each individual partition has O(n) runtime, multiplying it by the number of levels leaves a bigO runtime of O(nlogn).


###Most likely case:
Most of the time, there will be somewhere beween the optimal number levels of swaps and the pessimal number of partitions. This number should be close to the average of the optimal and pessimal numbers. The optimal number of partitions is some variation of log(n) and the pessimal case leaves close to n levels of swaps. Taking the Big-Oh of the average would yield log(n) levels of partition. Each individual partition has a linear runtime and multiplying it by the number of levels leaves an overall Big-Oh runtime of nlog(n) or loglinear.

###Worst case:
By picking pivots at the ends of the arrays, one sub-array is only going to have one element, and the other N-1. In this case, partition would have to be run N times since each we'd have to run partition for each element in the array, which would also lead to N levels. Each individual partition has a linear runtime and multiplying it by the number of levels leaves a Big O runtime of O(n^2).


