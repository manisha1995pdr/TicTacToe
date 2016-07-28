package TicTacToe;


public class Board {

	private char[][] board;
	private char player1Symbol;
	private char player2Symbol;
	
	public static int Player1_Won = 1;
	public static int Player2_Won = 2;
	public static int Draw = 3;
	public static int Not_Finished = 4;

	public Board(char player1Symbol, char player2Symbol ){
		board = new char[3][3];
		this.player1Symbol = player1Symbol;
		this.player2Symbol = player2Symbol;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j] = ' ';
			}
		}
	}
	
	public int gameStatus(){
		for(int i = 0; i<3; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				if(board[i][0] == player1Symbol){
					return Player1_Won;
				}
				else if(board[i][0] == player2Symbol){
					return Player2_Won;
				}
			}
		}

		for(int j = 0; j<3; j++){
			if(board[0][j] == board[1][j] && board[0][j] == board[2][j]){
				if(board[0][j] == player1Symbol){
					return Player1_Won;
				}
				else if(board[0][j] == player2Symbol){
					return Player2_Won;
				}
			}
		}


		if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			if(board[0][0] == player1Symbol){
				return Player1_Won;
			}
			else if(board[0][0] == player2Symbol){
				return Player2_Won;
			}
		}

		if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			if(board[0][2] == player1Symbol){
				return Player1_Won;
			}
			else if(board[0][2] == player2Symbol){
				return Player2_Won;
			}
		}
		
		
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(board[i][j] == ' '){
					return Not_Finished;
				}
			}
		}
		
		return Draw;
	}
	
	public void print(){
		System.out.println("----------");
		for(int i=0; i<3; i++){
			System.out.println('|');
			for(int j=0; j<3; j++){
				System.out.println(board[i][j] + '|');
				
				System.out.println();
				System.out.println("-----------");
			}
		}
	}
	
	public void makeMove(int x, int y, char Symbol) throws InvalidMoveException{
		if (x < 0 || x > 2|| y < 0 || y > 2 || board[x][y] != ' ') {
			InvalidMoveException e = new InvalidMoveException();
			throw e;
		}
		board[x][y] = Symbol;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
