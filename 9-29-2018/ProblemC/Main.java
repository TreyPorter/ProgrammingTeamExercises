import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		int chairs = in.nextInt();
		String pattern = in.next();
		for(int i = 0; i < chairs-1; ++i) {
			char curr = pattern.charAt(i);
			if(curr == pattern.charAt(i+1)) {
				//Consecutive 1s case || 00 at end/beginning || 000 case
				if(curr == '1' || (i == 0 || i == chairs-2) || (i < (chairs-2) && pattern.charAt(i+2) == '0')) {
					System.out.println("No");
					return;
				}
			}
		}
		if(chairs == 1 && pattern.charAt(0) == '0') {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
	}
}
