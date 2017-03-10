//Team Shrug
//Shakil Rafi, Alan Wang, Angela Kim

/*
  TIMING MECHANISM:
  Generate an array of random integers (size is specified with each call)
  Store current time in a variable
  Run sort algorithm
  Store new time in a variable
  Calculate difference between start and end times
  Multiply by 1000000 to get time in milliseconds
  Repeat 50 times and take the average to get runtime
 */

public class QuickSortTester  {

    public static int[] populateArrN(int[] arr, int length) {
	for (int i = 0; i < length; i++) {
	    int rnd = (int)(Math.random() * (length - 1)) + 1;
	    arr[i] = rnd;
	}
	return arr;
    }

    public static double testSort_size(int n) {
	int[] arr = new int[n];
	populateArrN(arr, n);
	long startTime = System.nanoTime();
	QuickSort.sort(arr);
	long endTime = System.nanoTime();
	long duration = endTime - startTime;
	return duration/1000000f;
    }

    public static double testSort_avg(int n) {
	double sum = 0;
	for (int i = 0; i < 50; i++)
	    sum += testSort_size(n);
	return sum/50;
    }

    public static void main(String[] args) {
	for (int i = 1000; i < 10000; i += 1000)
	    System.out.println("Duration for n = " + i + ": " + testSort_avg(i));
    }
}
