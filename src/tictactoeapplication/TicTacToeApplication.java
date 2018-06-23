package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Allows for continuous. games
		boolean doYouWantToPlay = true;
			//setting up our token and AI
		while(doYouWantToPlay) {
			System.out.println("Welcome to Tic Tac Toe? You are about to go against"
					+ " the master of TicTacToe. Are you ready? I hope so! \n But first , you "
					+ "must pick what character you want to be and which character I will be.");
			System.out.println();
			System.out.println("Enter a single character that will represent you on the board!");
			char playerToken = sc.next().charAt(0);
			System.out.println("Enter a single character that will represent your oppoenent on the board!");
			char opponentToken = sc.next().charAt(0);
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			AI ai = new AI();
			
			//set up game
			System.out.println();
			System.out.println("Now we can start the game. To play, enter a number and your token shall be put "
					+ " in its place.\n The numbers go from 1-9. We shall see who will win this round.");
			TicTacToe.printIndexBoard();
			System.out.println();
			
			//Lets Play
			while(game.gameOver().equals("notOver")) {
				if(game.currentMarker == game.userMarker) {
					//user turn
					System.out.println("It's your turn! Enter a spot for your token");
					int spot= sc.nextInt();
					while(!game.playTurn(spot)) {
						System.out.println("Try again. " +spot+ " is invalid. This spot "
								+ "is already taken.");
						spot = sc.nextInt();
					}
					System.out.println("You picked " + spot + "!");
				} else {
					//AI turn
					System.out.println("It is my turn!");
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked "+aiSpot+"!");
				}
				 System.out.println();
				 game.printBoard();
			}
			System.out.println();
			System.out.println(game.gameOver());
			System.out.println();
			
			//set up a new game...
			
			System.out.println("Do you want to play again? Enter Y if you do. "
					+ "Enter anything else if you are tired of me.");
			char response = sc.next().charAt(0);
			
			doYouWantToPlay = (response == 'Y');
			System.out.println();
			System.out.println();
			
		}

	}

}
