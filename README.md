#TeamShrug
Shakil Rafi, Alan Wang, and Angela Kim
Period 4

##Big-Oh Runtime Analysis
###Best case:

###Most likely case:
Most of the time, there will be somewhere beween the optimal number levels of splits and the pessimal number of splits. This number should be close to the average of the optimal and pessimal numbers. The optimal number of levels of splits is some variation of log(n) and the pessimal case leaves close to n levels of splits. Taking the Big-Oh of the average would yield log(n) levels of splits. Each individual split has a linear runtime and multiplying it by the number of splits leaves an overall Big-Oh runtime of nlog(n) or loglinear.

###Worst case:


