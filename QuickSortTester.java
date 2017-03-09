//Team Shrug

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
	for (int i = 0; i < 10; i++)
	    sum += testSort_size(n);
	return sum/10;
    }

    public static void main(String[] args) {
	for (int i = 10; i < 100; i += 10)
	    System.out.println("Duration for n = " + i + ": " + testSort_avg(i));
    }
}
