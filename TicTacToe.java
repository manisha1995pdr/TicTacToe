package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	public static Player getPlayer(int PlayerNumber){
		System.out.println("Enter Player " + PlayerNumber + " name");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();

		System.out.println("Enter Player " + PlayerNumber + " Symbol");
		char symbol = s.nextLine().charAt(0);
		return new Player(name, symbol);
	}

	public static void start(){
		Player p1 = getPlayer(1);
		Scanner s = new Scanner(System.in);
		boolean done = false;
		Player p2 = null;
		
		while(!done){
			p2 = getPlayer(2);
			if(p1.Symbol != p2.Symbol){
				done = true;
			}
			else{
				System.out.println("Both players cannot have same symbol");
			}
		}
		
		Board b = new Board(p1.Symbol, p2.Symbol);
		boolean Player1Turn = true;
		b.print();
		while(b.gameStatus() == b.Not_Finished){
			Player currentPlayer = null;
			if(Player1Turn == true){
				currentPlayer = p1;
			}
			else{
				currentPlayer = p2;
			}
			System.out.println("Enter the x cordinate");
			int x = s.nextInt();
			System.out.println("Enter the y cordinate");
			int y = s.nextInt();
			try {
				b.makeMove(x,y,currentPlayer.Symbol);
				Player1Turn = !Player1Turn;
			} catch (InvalidMoveException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid move try again!");
			}
			b.print();
		}
		
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

}
