import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		//size of our tic tac toe board
		int n = 4;

		//Create a nxn array that represents our tic tac toe board
		char[][] board = new char[n][n];
		
		//Initialize our board empty positions
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = '-';
			}
		}

		//Ask users for their Names
		Scanner.in = new Scanner(System.in);
		System.out.println("Hello there, Welcome to my TicTacToe Game in Java!!");
		System.out.println("First let me get yopur names");
		System.out.print("Player 1, what is your name? ");
		String p1 = in.nextLine();
		System.out.print("Player 2, what is your name? ");
		String p2 = in.nextLine();

		//Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
		boolean player1 = true;

		//Create a gameEnded boolean and use it as the condition in the while loop
		boolean gameEnded = false;
		while(!gameEnded) {

			drawBoard(board);

			//Print whose turn it is
			if(player1) {
				System.out.println(p1 + "'s Turn (x):");
			} else {
				System.out.println(p2 + "'s Turn (o):");
			}

			//Create a char variable that stores either 'x' or 'o' based on what player's turn it is
			char c = '-';
			if(player1) {
				c = 'x';
			} else {
				c = 'o';
			}

			int row = 0;
			int col = 0;

			//Get a valid input
			while(true) {
				
				//Ask the user for what position they want to place their x or o
				System.out.print("Enter a row number: ");
				row = in.nextInt();
				System.out.print("Enter a column number: ");
				col = in.nextInt();

				if(row < 0 || col < 0 || row >= n || col >= n) {
					System.out.println("This position is off the bounds of the board! Try again.");
				
				} else if(board[row][col] != '-') {
					System.out.println("Someone has already made a move at this position! Try again.");
				
				} else {
					break;
				}
			
			}

			board[row][col] = c;

			//Check to see if either player has won
			if(playerHasWon(board) == 'x') {
				System.out.println(p1 + " has won!");
				gameEnded = true;
			} else if(playerHasWon(board) == 'o') {
				System.out.println(p2 + " has won!");
				gameEnded = true;
			} else {
				if(boardIsFull(board)) {
					System.out.println("It's a tie!");
					gameEnded = true;
				} else {
					player1 = !player1;
				}

			}

		}
		drawBoard(board);

  }

	//This function draws the board 
	public static void drawBoard(char[][] board) {
		System.out.println("Board:");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	//This function checks if someone has won or nor
	public static char playerHasWon(char[][] board) {
		
		for(int i = 0; i < board.length; i++) {
			
			boolean inARow = true;
			char value = board[i][0];
			
			if(value == '-') {
				inARow = false;


			} else {
				for(int j = 1; j < board[i].length; j++) {
					if(board[i][j] != value) {
						inARow = false;
						break;
					}
				}
			}
			if(inARow) {
				return value;
			}
		
		}

		for(int j = 0; j < board[0].length; j++) {
			
			boolean inACol = true;
			char value = board[0][j];
			
			if(value == '-') {
				inACol = false;

			} else {
				for(int i = 1; i < board.length; i++) {
					if(board[i][j] != value) {
						inACol = false;
						break;
					}
				}
			}

			if(inACol) {
				return value;
			}
		}
		
		boolean inADiag1 = true;
		char value1 = board[0][0];
		
		if(value1 == '-') {
			inADiag1 = false;

		} else {
			for(int i = 1; i < board.length; i++) {
				if(board[i][i] != value1) {
					inADiag1 = false;
					break;
				}
			}
		}

		if(inADiag1) {
			return value1;
		}
		boolean inADiag2 = true;
		char value2 = board[0][board.length-1];
		
		if(value2 == '-') {
			inADiag2 = false;

		} else {
			for(int i = 1; i < board.length; i++) {
				if(board[i][board.length-1-i] != value2) {
					inADiag2 = false;
					break;
				}
			}
		}

		if(inADiag2) {
			return value2;
		}
		return ' ';

	}

	//Make a function to check if all of the positions on the board have been filled
	public static boolean boardIsFull(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}