package boardgame.yut.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {

	public int number;
	ArrayList<Piece> piece = new ArrayList<Piece>();
	
	public Player(int number){
		this.number = number;
		for(int i=0; i<4; i++)
			piece.add(new Piece(number));
	}
	
	public boolean isWin(){
		for(int i=piece.size()-1; i>=0; i--)
			if(piece.get(i).complete == false) return false;
		
		return true;
	}
	
	public void carryPiece(Piece a, Piece b){
		a.carry++;
		piece.remove(b);
	}
	
	public void pieceSort(){
		Collections.sort(piece, new Comparator<Piece>(){
			@Override
			public int compare(Piece lhs, Piece rhs) {
				return (lhs.location < rhs.location) ? 1 : -1;
			}
		});
	}
}
