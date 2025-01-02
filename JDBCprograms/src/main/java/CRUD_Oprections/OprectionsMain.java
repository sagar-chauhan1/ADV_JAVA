package CRUD_Oprections;

import java.util.Scanner;

public class OprectionsMain {
	
	public static void main(String args[]) {
		
		System.out.println("Enter your coise: \n "+ "1.insert \n "
				+ "2.update \n"
				+ " 3.delet \n"
				+ " 4.show");
		Scanner s1 = new Scanner(System.in);
		int ans = s1.nextInt();
		
		OprectionsDeta op = new OprectionsDeta();
		
		if(ans==1) {
			op.insert();			
		}else if(ans==2) {
			op.update();
		}else if(ans==3) {
			op.delete();
		}else if(ans==4) {
			op.show();
		}else {
			System.out.println("envalid number");
		}
		
		s1.close();
	}

}
