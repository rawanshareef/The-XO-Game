package xoGAME;
import java.util.Scanner;  // Import the Scanner class
//This project needs her to realize an X-O game that can really be played together.

//The board of the game in dimensions 3 * 3
public class Board {

	static String The_Board[][]= {{"*","*","*"},//We will initialize a board that is a 3 * 3 matrix and fill
			                      {"*","*","*"},
			                      {"*","*","*"}}; 
	                                               //it with "*" because the entire starting board is "*"
	private static Scanner scanner;


	//This function opens the game and declares that player X is the first
	public void The_first_turn(){
		System.out.println("Welcome to X-O GAME ! ");
		print_the_board();
		scanner = new Scanner(System.in);
		System.out.print("Player X You start first, choose where to put X:");
		String X_choice = scanner.nextLine();//Read user input
		Player_X.Coordinate_selection_X(X_choice);
		turns();
	}

	//The function that works in turns
	public static void turns(){
		while(chick()==false) {
			scanner = new Scanner(System.in);
			System.out.print("The turn of O:");
			String O_choice = scanner.nextLine();//Read user input
			Player_O.Coordinate_selection_O(O_choice);
			boolean win_O=TheWinner.Winner_O();
			if(win_O==true) {
				break;
			}
			if(chick()==false) {
				scanner = new Scanner(System.in);
				System.out.print("The turn of X:");
				String X_choice2 = scanner.nextLine();//Read user input
				Player_X.Coordinate_selection_X(X_choice2);
				boolean win=TheWinner.Winner_X();
				if(win==true) {
					break;
				}
			}
		}

	}


	//A function that checks whether the board is full or not Does the full board mean that a draw has been announced
	public static  boolean chick() {
		boolean flage=true;
		for (int i = 0; i < The_Board.length; i++) {
			for (int j = 0; j < The_Board.length; j++) {
				if(The_Board[i][j]=="*") {//If there is a square board that has a "*" in it, it means that the board is still empty
					flage=false;
					return flage;
				}
			}
		}
		System.out.print("The game ended in a draw!!");//Return that the board has been filled when not returning it is empty
		return flage;
	}


	//Inner Classes for Player X 

	public static class Player_X{
		//the turn of X in this function weI pick what player X 
		//chose and then save the first number as 'a' and the second as 'b' and then update the new position on the board in X
		public static void Coordinate_selection_X(String X_choice) {
			int a=X_choice.charAt(0);
			a=a-49;//Subtract 48 because it returns the value of the number to me according to the ASCII-Table and then subtract 1 
			//because the player selects a number that starts from one and the matrix starts from zero
			int b=X_choice.charAt(2);
			b=b-49;//Subtract 48 because it returns the value of the number to me according to the ASCII-Table and then subtract 1 
			//because the player selects a number that starts from one and the matrix starts from zero
			if(The_Board[a][b]!="*") {
				scanner = new Scanner(System.in);
				System.out.print("Player X,select another coordinate because the position is already occupied:");
				String X_choice2 = scanner.nextLine();//Read user input
				Coordinate_selection_X(X_choice2);
			}
			else {
				The_Board[a][b]="X";
				print_the_board();//print the board
			}


		}
	};
	//Inner Classes for Player O 
	public static class Player_O{

		//the turn of O in this function weI pick what player O
		//chose and then save the first number as 'a' and the second as 'b' and then update the new position on the board in O
		public static void Coordinate_selection_O(String O_choice) {
			int a=O_choice.charAt(0);
			a=a-49;//Subtract 48 because it returns the value of the number to me according to the ASCII-Table and then subtract 1 
			//because the player selects a number that starts from one and the matrix starts from zero
			int b=O_choice.charAt(2);
			b=b-49;//Subtract 48 because it returns the value of the number to me according to the ASCII-Table and then subtract 1 
			//because the player selects a number that starts from one and the matrix starts from zero
			if(The_Board[a][b]!="*") {
				scanner = new Scanner(System.in);
				System.out.print("Player O,select another coordinate because the position is already occupied:");
				String O_choice2 = scanner.nextLine();//Read user input
				Coordinate_selection_O(O_choice2);
			}
			else {
				The_Board[a][b]="O";
				print_the_board();//print the board
			}



		}
	};

	//Inner Classes for The Winner
	public static class TheWinner{
		//chick if X is win
		public static boolean Winner_X() {
			boolean If_succeeded=false;
			//0   1   2
			/*  |---|---|---|
	      0 | X | * | * |
	        |-----------|
	       1|  *| * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][0]=="X") {//Start checking the first place it is in the place (0,0) and check its neighbors
				if(The_Board[0][1]=="X"&&The_Board[0][2]=="X") {//Check if the organs to our right are also X if so then X is the winner
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][1]=="X"&&The_Board[2][2]=="X") {//Check the members of the main diagonal if they are also X then X is the winner
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][0]=="X"&&The_Board[2][0]=="X") {//Check if the organs below it are also X if so then X is the winner
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}


			}


			//0   1   2
			/*  |---|---|---|
	      0 | * | X | * |
	        |-----------|
	       1|  *| * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][1]=="X") {// checking the first place it is in the place (0,1) and check its neighbors
				//In this place there is only one option for victory which is if the organs below it are also X if so then X is the winner
				if(The_Board[1][1]=="X"&&The_Board[2][1]=="X") {
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}


			}

			//0   1   2
			/*  |---|---|---|
	      0 | * | * | X |
	        |-----------|
	       1| * | * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][2]=="X") {// checking the first place it is in the place (0,2) and check its neighbors
				if(The_Board[1][1]=="X"&&The_Board[2][0]=="X") {// Check the members diagonally if they are also X then X is the winner
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][2]=="X"&&The_Board[2][2]=="X") {//Check if the organs below it are also X if so then X is the winner
					System.out.print("X is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}

			}

			return If_succeeded;

		}
		//chick if O is win
		public static boolean Winner_O() {
			boolean If_succeeded=false;
			//0   1   2
			/*  |---|---|---|
	      0 | O | * | * |
	        |-----------|
	       1|  *| * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][0]=="O") {////Start checking the first place it is in the place (0,0) and check its neighbors
				if(The_Board[0][1]=="O"&&The_Board[0][2]=="O") {//Check if the organs to our right are also O if so then O is the winner
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][1]=="O"&&The_Board[2][2]=="O") {//Check the members of the main diagonal if they are also O then O is the winner
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][0]=="O"&&The_Board[2][0]=="O") {//Check if the organs below it are also O if so then O is the winner
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}


			}
			//0   1   2
			/*  |---|---|---|
	      0 | * | X | * |
	        |-----------|
	       1|  *| * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][1]=="O") {// checking the first place it is in the place (0,1) and check its neighbors
				//In this place there is only one option for victory which is if the organs below it are also O if so then O is the winner
				if(The_Board[1][1]=="O"&&The_Board[2][1]=="O") {
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}


			}


			//0   1   2
			/*  |---|---|---|
	      0 | * | * | O |
	        |-----------|
	       1| * | * | * |
	        |-----------|
	       2| * | * | * |
	        |---|---|---|*/
			if(The_Board[0][2]=="O") {// checking the first place it is in the place (0,2) and check its neighbors
				if(The_Board[1][1]=="O"&&The_Board[2][0]=="O") {// Check the members diagonally if they are also O then O is the winner
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}
				if(The_Board[1][2]=="O"&&The_Board[2][2]=="O") {//Check if the organs below it are also O if so then O is the winner
					System.out.print("O is the winner!!");
					If_succeeded=true;
					return If_succeeded;
				}

			}

			return If_succeeded;

		}
	};
	//The function goes over the board and prints it
	public static void print_the_board() {
		//Go through the whole board which is basically a matrix and print the matrix in all the places(With design)
		/*|--|---|---|
		  | *|  *|  *|
	      |----------|
		  | *|  *|  *|
		  |----------|
		  | *|  *|  *|
		  |----------|*/
		System.out.println("|--|---|---|");
		for (int i = 0; i < The_Board.length; i++) {
			for (int j = 0; j < The_Board.length; j++) {
				if(i==0&j==0) {
					System.out.print("| "+The_Board[i][j]+ "|");

				}
				else if(i==1&j==0) {
					System.out.print("| "+The_Board[i][j] + "|");

				}
				else if(i==2&j==0) {
					System.out.print("| "+The_Board[i][j] + "|");

				}
				else {
					System.out.print("  "+The_Board[i][j] + "|");

				}

			}

			System.out.println();
			System.out.println("|----------|");


		}
	}

	
}
