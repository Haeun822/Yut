package boardgame.yut.game;

import boardgame.yut.Globals;

public class Piece {

	public int playerNumber;
	public int location = -1;
	public int moving = 0;
	public int carry = 1;	//움직일 말의 개수(업은 말의 수만큼 +a)
	public boolean onBoard = false;
	public boolean complete = false; 
	
	public Piece(int number){
		playerNumber = number;
	}
	
	public void back(){
		while(carry < 1){
			Globals.gPlayers[playerNumber].piece.add(new Piece(playerNumber));
			carry--;
		}
		
		location = -1;
		moving = 0;
		carry = 1;
		onBoard = false;
		complete = false;
	}
}
