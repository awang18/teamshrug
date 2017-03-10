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

##Methodology:
Generate an array of random integers (size is specified with each call), then store current time in a variable. Run sort algorithm, and store new time in another variable. Then we'd calculate difference between start and end times. Multiply by 1000000 to get time in milliseconds. To cap it all off, repeat 50 times and take the average to get runtime. Rinse, repeat for larger data sets. 

##Time Measurements & Analysis:
Three trials on randomly ordered arrays ranging from 10000-100000 items

Trial 1:

Duration for n = 10000: 3.9168995952606203
Duration for n = 20000: 7.608818998336792
Duration for n = 30000: 11.752984237670898
Duration for n = 40000: 15.482988910675049
Duration for n = 50000: 19.196475944519044
Duration for n = 60000: 24.70226390838623
Duration for n = 70000: 31.56132667541504
Duration for n = 80000: 35.526602554321286
Duration for n = 90000: 39.30331428527832
Duration for n = 100000: 42.56484268188476

Trial 2:

Duration for n = 10000: 4.04187038898468
Duration for n = 20000: 7.518881759643555
Duration for n = 30000: 11.579692077636718
Duration for n = 40000: 15.871011409759522
Duration for n = 50000: 21.187372703552246
Duration for n = 60000: 25.362903594970703
Duration for n = 70000: 28.850274925231933
Duration for n = 80000: 33.55966827392578
Duration for n = 90000: 38.09876663208008
Duration for n = 100000: 44.676727828979494

Trial 3:

Duration for n = 10000: 4.067324500083924
Duration for n = 20000: 7.588305444717407
Duration for n = 30000: 11.80792932510376
Duration for n = 40000: 16.297885189056398
Duration for n = 50000: 21.0440092086792
Duration for n = 60000: 24.652874870300295
Duration for n = 70000: 28.995745162963868
Duration for n = 80000: 33.76253364562988
Duration for n = 90000: 37.9842374420166
Duration for n = 100000: 43.84884422302246

The time actually seems to be increasing at a constant rate, gaining around 4 milliseconds every 10000 items added. When graphed out, all three cases show a nearly straight line, further showing that the runtime may actually be O(n).


##Data Arrangement:
It's more dependent on the choice of a pivot rather than data arrangement since partition moves everything around depending on the value at the pivot point, unless our code calls for calling a certain point as our pivot. In that case, if we have a sorted array and the chosen pivot ends up being an element that's close to the median, we'd end up with a faster runtime, and slow if we pick a point with an element with a value near the min/max. If the case is that we have a randomly arranged array, it doesn't matter what our selected pivot point is, since we'd be equally likely to get a pivot point with a good value. 


