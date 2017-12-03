import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int A[] = new int[1000];
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
		System.setIn(new FileInputStream("C:\\Users\\YOUNGJOO KIM\\sample_input.txt"));
		MyScanner sc = new MyScanner(System.in, System.out);
		
		N = sc.nextInt();
		tails = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

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
		
		System.out.println(length);
		
		sc.close();
	}
	
	static class MyScanner {
		BufferedReader reader;
		BufferedWriter writer;
		StringTokenizer tokenizer;
		
		MyScanner(InputStream in, OutputStream out) throws IOException {
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new BufferedWriter(new OutputStreamWriter(out));
			tokenizer = new StringTokenizer(reader.readLine());
		}
		
		public String nextString() throws IOException {
			if (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(nextString());
		}
		
		public void close() throws IOException {
			writer.flush();
			writer.close();
			reader.close();
		}
	}
}