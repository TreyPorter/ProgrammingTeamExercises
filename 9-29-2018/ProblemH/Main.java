import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args)	{
		Scanner in = new Scanner(System.in);
		StringBuffer rows = new StringBuffer();
		int rowNum = in.nextInt();
		if(rowNum > 1000 || rowNum < 1) {
			return;
		}
		boolean possible = false;
		for(int i=0; i<rowNum;) {
			String row = in.next();
			if(!possible) {
				if(row.charAt(0) == 'O' && row.charAt(1) == 'O') {
					row = "++" + row.substring(2);
					possible = true;
				}
				else if(row.charAt(3) == 'O' && row.charAt(4) == 'O') {
					row = row.substring(0,3)+ "++";
					possible = true;
				}
			}
			rows.append(row);
			if(++i != rowNum) {
				rows.append("\n");
			}
		}
		if(possible) {
			System.out.println("YES");
			System.out.println(rows);
		}
		else {
			System.out.println("NO");
		}
	}
}
