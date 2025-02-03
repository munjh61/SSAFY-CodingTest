import java.util.Arrays;
import java.util.Scanner;

public class Boj_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("길이 입력");
		String a = sc.nextLine();
		String[] result = a.split(" ");
		int N = Integer.parseInt(result[0]);
		int K = Integer.parseInt(result[1]);

		int[] arr = new int[N];
		int[] nullarr = new int[N];
		int nullcnt = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}

		int k = K;
		for(int i=0;i<N;i++) {
			int count = 0;
			if(nullcnt == 0) {
				K--;
			}else {
				K = k;
			}
			while(count < K) {	
				
				int temp = arr[0];
				for(int j=0;j<arr.length;j++) {
					if(j == arr.length-1) {
						break;
					}
					arr[j] = arr[j+1];
				}
				arr[N-1] = temp;
				if(arr[0] == 0) {
					continue;
				}
				arr[N-1] = temp;
				count++;
			}
			nullarr[nullcnt] = arr[0];
			nullcnt++;
			arr[0] = 0;

		}	

		System.out.print("<");
		for(int i=0;i<nullarr.length;i++) {
			System.out.print(nullarr[i]);
			if(i != nullarr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}	
