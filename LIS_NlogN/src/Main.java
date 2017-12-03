public class Main {
	static int N = 5; 
	static int A[] = {5, 7, 1, 3, 4};
	static int tails[];
	
	static int lowerBound(int left, int right, int key) {
		int med;
		while (left < right) {
			med = (left + right) / 2;
			if (tails[med] >= key) right = med;
			else left = med + 1;
		}
		return right;
	}
	
	public static void main (String [] args) throws Exception {
		tails = new int[N];

		// 초기값
		tails[0] = A[0];
		int length = 1;
		
		for (int i = 1; i < N; i++) {  
			if (A[i] > tails[length-1]) {
				// Case 1. ai가 tails의 마지막 값보다 큰 경우 tails에 ai를 추가한다.
			   	tails[length++] = A[i];
			} else {
				// Case 2. ai가 tails의 마지막 값보다 작은 경우 tails 값들 중 ai의 lowerBound 위치를 찾아 값을 갱신한다.
				tails[lowerBound(0, length-1, A[i])] = A[i];
			}
		}
		
		System.out.println("Longest Increasing Subsequence: " + length);
	}
}