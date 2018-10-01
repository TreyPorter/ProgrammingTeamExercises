import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		int arr_len = in.nextInt();
		int[] arr = new int[arr_len];
		for(int i = 0; i < arr_len; ++i) {
			arr[i] = in.nextInt();
		}
		int a = 0;
		int b = arr_len-1;
		long aSum = arr[0];
		long bSum = arr[b];
		long maxSum = 0;
		while(a < b) {
			if(aSum == bSum) {
				if(aSum > maxSum) {
					maxSum = aSum;
				}
				if (arr[a+1] < arr[b-1]) {
					++a;
					aSum += arr[a];
				}
				else if(arr[a+1] > arr[b-1]){
					--b;
					bSum += arr[b];
				}
				else {
					/*++a;
					aSum += arr[a];*/
					--b;
					bSum += arr[b];
				}
			}
			else if(aSum > bSum) {
				--b;
				bSum += arr[b];
			}
			else if(aSum < bSum) {
				++a;
				aSum += arr[a];
			}
		}
		System.out.println(maxSum);
	}
}
