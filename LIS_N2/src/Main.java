public class Main {
	static int N = 5; 
	static int A[] = {5, 7, 1, 3, 4};
	static int LIS[];
	public static void main (String [] args) throws Exception {
		LIS = new int[N];
		
		// 초기값
		int max = 0;
		LIS[0] = 1;
		
		for (int i = 1; i < N; i++) {			
			LIS[i] = 1;
			// Case 2. LIS(i)가 ai를 포함한 경우
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && 1 + LIS[j] > LIS[i]) {
					LIS[i] = 1 + LIS[j];
				}
			}
			// Case 1. LIS(i)가 ai를 포함하지 않은 경우
			if (max < LIS[i]) max = LIS[i];
		}
		
		System.out.println("Longest Increasing Subsequence: " + LIS[N-1]);
	}
}