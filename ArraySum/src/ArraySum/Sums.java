package ArraySum;

import java.util.*;

public class Sums {
	// helper method to compute sum of array
		public static int sumRange(int[] a, int min, int max) {
			int result = 0;
			for (int i = min; i < max; i++) {
				result += a[i];
			}
			return result;
		}

		public int getSum() {
			// TODO Auto-generated method stub
			return 0;
		}
	
}
