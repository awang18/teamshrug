#TeamShrug
Shakil Rafi, Allan Wang, and Angela Kim
Period 4

##Big-Oh Runtime Analysis
###Best case:
In the best case scenario, the pivot choice is always the median value of the elements. Assuming that fact, the array will be sorted into two equal halves each time, leading to an N/2 amount of swaps during each partition. For each level it'd go from N/2, then N/4, N/8, etc. leading us to log(N) swaps per level. And since each individual partition has O(N) runtime, multiplying it by the number of swaps leaves a Big-O runtime of O(nlogn).


###Most likely case:
Most of the time, there will be somewhere beween the optimal number levels of splits and the pessimal number of splits. This number should be close to the average of the optimal and pessimal numbers. The optimal number of levels of splits is some variation of log(n) and the pessimal case leaves close to n levels of splits. Taking the Big-Oh of the average would yield log(n) levels of splits. Each individual split has a linear runtime and multiplying it by the number of splits leaves an overall Big-Oh runtime of nlog(n) or loglinear.

###Worst case:
By picking pivots at the ends of the arrays, one sub-array is only going to have one element, and the other N-1. In this case, during a partition we'd have to swap every single element in the sub-array, leading to close to an N number of swaps. Since each partition has O(N) runtime, multiplying it by the number of swaps leaves a Big-O runtime of O(n^2).


