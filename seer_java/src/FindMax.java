import java.util.Arrays;

/**
 * Given a list of first monotonically increasing then monotonically decreasing
 * integers. Find the max.
 */
public class FindMax {

	static int findMax_naive(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length - 1];
	}

	/**
	 * My version 1.
	 */
	static int findMax_v1(int[] arr) {
		return findMax_v1(arr, 0, arr.length - 1);
	}

	private static int findMax_v1(int[] arr, int start, int end) {
		int mid = start + ((end - start) >> 1);
		if (mid == start) {
			return arr[start] >= arr[end] ? arr[start] : arr[end];
		}

		if (arr[mid - 1] > arr[mid]) {
			return findMax_v1(arr, start, mid - 1);
		} else if (arr[mid] < arr[mid + 1]) {
			return findMax_v1(arr, mid + 1, end);
		} else {
			return arr[mid];
		}
	}

	/**
	 * Candidate's version.
	 */
	static int findMax_v2(int[] arr) {
		return findMax_v2(arr, 0, arr.length - 1);
	}

	private static int findMax_v2(int[] arr, int start, int end) {
		int mid = start + ((end - start) >> 1);
		if (mid == start) {
			return arr[start] >= arr[end] ? arr[start] : arr[end];
		}
		
		if (arr[mid - 1] < arr[mid]) {
			return findMax_v2(arr, mid, end);
		} else {
			return findMax_v2(arr, start, mid-1);
		}
	}

	public static void main(String[] args) {
		int[][] testCases = {
				{ 1 },
				{ 1, 2 },
				{ 1, 2, 3 },
				{ 1, 2, 3, 4 },
				{ 1, 2, 3, 4, 5 },
				{ 5, 4 },
				{ 5, 4, 3 },
				{ 5, 4, 3, 2 },
				{ 5, 4, 3, 2, 1 },
				{ 1, 3, 2 }, { 1, 5, 4, 3, 2 },
				{ 1, 2, 3, 5, 7, 9, 10, 11, 8, 4, 1 }
		};

		for (int[] test : testCases) {
			int answer = findMax_naive(test);
			int result = findMax_v2(test);
			if (answer == result) {
				System.out.println("[pass] " + Arrays.toString(test));
			} else {
				System.out.printf("[fail %d %d], %s", result, answer, Arrays.toString(test));
			}
		}
	}

}
