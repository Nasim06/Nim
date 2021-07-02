import java.util.*;

public class Nim{
	
	public static void main(String args[]){
		
		int stack1 = 6;
		int stack2 = 8;
		Scanner sc = new Scanner(System.in);
		int player = 1;
		int round = 1;
		Boolean win = false;
		
		while(win == false) {

			if(round % 2 == 0){
				player = 2;
			}
			else {
				player = 1;
			}
			
			System.out.println("Biscuits Left - Barrel 1: "+ stack1 + " \n Biscuits Left - Barrel 2: " + stack2);	
			int amount = 0;
			boolean valid = false;
			while(valid == false) {
				System.out.print("Biscuits taken by player"+player+":");
				while(! sc.hasNextInt()) {
					System.out.println("Error: input must be an integer");
					sc.next();
					System.out.print("Biscuits taken by player"+player+":");
				}
				amount = sc.nextInt();
				if((amount <= stack1 || amount <= stack2) && amount > 0) {
					valid = true;
				}
				else {
					System.out.println("Error: that is outside the range");
				}
			}
			
			valid = false;
			String type = "yeet";
			while(valid == false) {
				System.out.print("From barrel1 (one), barrel2 (two) or both (both)? ");
				type = sc.next();
				type = type.toLowerCase();
				if(type.equals("one") && amount <= stack1){
					valid = true;
				}
				else if(type.equals("two") && amount <= stack2){
					valid = true;
				}
				else if(type.equals("both") && amount <= stack1 && amount <= stack2) {
					valid = true;
				}
				else if(amount > stack1 || amount > stack2) {
					System.out.println("Error: You are trying to remove more biscuits than exist from one or both of the barrels");
				}
				else {
					System.out.println("Error: input is incorrect");
				}
			}
			
			if(type.equals("one")) {
				stack1 = stack1 - amount;
			}
			else if(type.equals("two")) {
				stack2 = stack2 - amount;
			}
			else {
				stack1 = stack1 - amount;
				stack2 = stack2 - amount;
			}
			
			if(stack1 == 0 && stack2 == 0) {
				win = true;
				System.out.println("Biscuits Left - Barrel 1: 0 \n Biscuits Left - Barrel 2: 0");
				System.out.println("Winner is player "+ player);
			}
			round++;
		}
		sc.close();
	}
	
}