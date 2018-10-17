import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		boolean[] popped = new boolean[n];
		int darts = 0;
		if(n <= 0) {
			System.out.println("0");
			return;
		}
		for(int i = 0; i < n; ++i) {
			arr[i] = in.nextInt();
			popped[i] = false;
		}
		for(int i = 0; i < n; ++i) {
			if(!popped[i]) {
				int height = arr[i]-1;
				popped[i] = true;
				++darts;
				for(int j = i+1; j < n; ++j) {
					if(!popped[j] && arr[j] == height) {
						height = arr[j]-1;
						popped[j] = true;
					}
				}
			}
		}
		System.out.println(darts);
	}
}
