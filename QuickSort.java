//Allan Wang
//APCS2-p4
//HW15 - So So Quick
//2017-03-09
/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * Divide an array into two parts, being the lower elements depending
 * on a certain pivot value and the higher elements. Recursively solve
 * for each of these sub-arrays.
 * 2a. Worst pivot choice / array state and associated runtime:
 * By picking pivots on the ends of the array, one sub-array is only
 * going to have one element, and the other n-1. With N operations
 * per level, the worst-case runtime for QuickSort is O(N^2).
 * 2b. Best pivot choice / array state and associated runtime:
 * The best case pivot choice is the middle of the array. If we
 * assume that the algorithm always picks the middle element,
 * the array will be sorted into two equal halves each time, so
 * it'll take log(N) splits until we get single elements into
 * sub-arrays. Since there are log(N) levels to QuickSort and each
 * involves N operations, the best-case runtime for QuickSort should be
 * Nlog(n)
 * 3. Approach to handling duplicate values in array:
 * To avoid O(n^2) runtime, would it be possible to just not deal with
 * all duplicates and keep them in a sub-array while regularly sorting/Partitioning
 * the rest of the array?
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    //return randomPivot index
    public static int randomPivot(int left, int right){
      return left + (int)Math.random() * (right - left);
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    {
      qsortH(d, 0, d.length-1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.

    public static int partition( int arr[], int left, int right, int pivotIndex)
    {
	int pivotValue = arr[pivotIndex];

	swap( pivotIndex, right, arr); //move pivotValue to right(which can be the end)
	int s = left;

	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= pivotValue) {
		swap( i, s, arr );
		s++;
    //i should > s
    }
	}
	swap(s,right,arr);
  //move pivotValue to it's final index at the partition index

	return s; //index of partition/pivot
    }

    public static void qsortH(int[] arr, int left, int right)
    {
      if (left < right){
        int pivotIndex = randomPivot(left, right);
        pivotIndex = partition(arr, left, right, pivotIndex);
        qsortH(arr, left, right-1);
        //call on left partitioned part
        qsortH(arr, left+1, right);
        //call on right partitioned part
      }
    }


    //main method for testing
    public static void main( String[] args )
    {


	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;

	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);

  int [] arr3 = {7,8,7,14,8,7,7,7,8,8,9,7,7,8,8};
	System.out.println("\narr3 init'd to: " );
	printArr(arr3);

	qsort( arr3 );
       	System.out.println("arr3 after qsort: " );
	printArr(arr3);

  int [] arr4 = {5,5,3,7,8,7,14,8,7,7,7,8,8,9,7,7,8,8,5,5,4};
	System.out.println("\narr4 init'd to: " );
	printArr(arr4);

	qsort( arr4 );
       	System.out.println("arr3 after qsort: " );
	printArr(arr4);

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );

	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
