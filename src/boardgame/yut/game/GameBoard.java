package boardgame.yut.game;

public class GameBoard {

	public Field[] field = new Field[30];
	
	public GameBoard(){
		for(int i=0; i<30; i++){
			if(i == 27)
				field[27] = field[22];
			else field[i] = new Field(i);
		}
	}
	
}
