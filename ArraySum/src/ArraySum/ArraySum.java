/**
 * 
 */
package ArraySum;

import java.util.*;

/**
 * @author Teresa Scudder 3/26/2020
 */
public class ArraySum extends Thread implements Runnable{
	
	private int Sums;
	private int firstSum;
	private int secondSum;
	private static final Random RAND = new Random(42); // random number generator
	
	public ArraySum(int Sums, int firstSum, int secondSum) {
		this.setSums(Sums);
		this.setFirstSum(firstSum);
		this.setSecondSum(secondSum);			
	}

	public static void main(String[] args) throws Throwable {
		int LENGTH = 200000000; // Length of array
		int RUNS = 2;  		

		for (int i = 1; i <= RUNS; i++) {
			int[] a = createRandomArray(LENGTH);

			// length of time it takes
			long startTime1 = System.currentTimeMillis();
			int total = 0;

			for (int j = 1; j <= 100; j++) {
				total = sum2(a);
			}

			long endTime1 = System.currentTimeMillis();

			System.out.printf("%10d elements  =>  %6d ms \n", LENGTH, endTime1 - startTime1);
			
		}
	}

	// Total sum of all elements of the given array.
	public static int sum(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}

	// Computes the total array sums in a parallel thread
	public static int sum2(int[] a) {
		
		// create threads
		Sums firstSum = new Sums();
		Sums secondSum = new Sums();
		Thread firstThread = new Thread();
		Thread secondThread = new Thread();

		// run threads
		firstThread.start();
		secondThread.start();

		// threads finish
		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException ie){}

		// combine the results of the two threads
		int first = firstSum.getSum(); 
		int	second = secondSum.getSum();
		return first + second;
	}

	
	// Create array and fill it with random numbers
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = RAND.nextInt(50);
		}
		return a;
	}

	//getters and setters
	public int getSums() {
		return Sums;
	}

	public void setSums(int sums) {
		Sums = sums;
	}

	public int getFirstSum() {
		return firstSum;
	}

	public void setFirstSum(int firstSum) {
		this.firstSum = firstSum;
	}

	public int getSecondSum() {
		return secondSum;
	}

	public void setSecondSum(int secondSum) {
		this.secondSum = secondSum;
	}
}