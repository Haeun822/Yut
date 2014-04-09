package boardgame.yut.game;

import boardgame.yut.Globals;
import android.graphics.Rect;

public class Field {
	
	public static final int START_FIELD = 0;
	public static final int BIG_FIELD = 1;
	public static final int SMALL_FIELD = 2;

	public int number;
	public int type;
	public Rect rect = new Rect();
	
	Piece piece = null;
	
	public Field(int number){
		this.number = number;
		initField();
	}
	
	void initField(){
		if(number < 20){						//외곽 초기화
			type = SMALL_FIELD;
			if(number / 5 == 0){
				rect.right = Globals.gBoardSize.right;
				rect.left = rect.right - Globals.gSmallFieldSize;
				rect.top = Globals.gBoardSize.top + Globals.gBigFieldSize/2 + Globals.gStraightSpace * (5 - number % 5) - Globals.gSmallFieldSize/2;
				rect.bottom = rect.top + Globals.gSmallFieldSize;
			}
			else if(number / 5 == 1){
				rect.top = Globals.gBoardSize.top;
				rect.bottom = rect.top + Globals.gSmallFieldSize;
				rect.right = Globals.gBoardSize.right - Globals.gBigFieldSize/2 - Globals.gStraightSpace * (number % 5) + Globals.gSmallFieldSize/2;
				rect.left = rect.right - Globals.gSmallFieldSize;
			}
			else if(number / 5 == 2){
				rect.left = Globals.gBoardSize.left;
				rect.right = Globals.gBoardSize.left + Globals.gSmallFieldSize;
				rect.top = Globals.gBoardSize.top + Globals.gBigFieldSize/2 + Globals.gStraightSpace * (number % 5) - Globals.gSmallFieldSize/2;
				rect.bottom = rect.top + Globals.gSmallFieldSize;
			}
			else if(number / 5 == 3){
				rect.bottom = Globals.gBoardSize.bottom;
				rect.top = rect.bottom - Globals.gSmallFieldSize;
				rect.left = Globals.gBoardSize.left + Globals.gBigFieldSize/2 + Globals.gStraightSpace * (number % 5) - Globals.gSmallFieldSize/2;
				rect.right = rect.left + Globals.gSmallFieldSize;
			}
			
			//모서리 초기화
			if(number == 0){
				type = BIG_FIELD;
				rect.left = rect.right - Globals.gBigFieldSize;
				rect.bottom = Globals.gBoardSize.bottom;
				rect.top = rect.bottom - Globals.gBigFieldSize;
			}
			if(number == 5){
				type = BIG_FIELD;
				rect.bottom = rect.top + Globals.gBigFieldSize;
				rect.right = Globals.gBoardSize.right;
				rect.left = rect.right - Globals.gBigFieldSize;
			}
			if(number == 10){
				type = BIG_FIELD;
				rect.right = rect.left + Globals.gBigFieldSize;
				rect.top = Globals.gBoardSize.top;
				rect.bottom = rect.top + Globals.gBigFieldSize;
			}
			if(number == 15){
				type = BIG_FIELD;
				rect.top = rect.bottom - Globals.gBigFieldSize;
				rect.left = Globals.gBoardSize.left;
				rect.right = rect.left + Globals.gBigFieldSize;
			}
			
		}
		else{							//대각선 초기화
			type = SMALL_FIELD;
			if(number < 25){
				rect.top = Globals.gBoardSize.top + Globals.gBigFieldSize/2 + Globals.gDigonalSpace*(number % 5 + 1) - Globals.gSmallFieldSize/2;
				rect.bottom = rect.top + Globals.gSmallFieldSize;
				rect.right = Globals.gBoardSize.right - Globals.gBigFieldSize/2 - Globals.gDigonalSpace*(number % 5 + 1) + Globals.gSmallFieldSize/2;
				rect.left = rect.right - Globals.gSmallFieldSize;
			}
			else{
				rect.top = Globals.gBoardSize.top + Globals.gBigFieldSize/2 + Globals.gDigonalSpace*(number % 5 + 1) - Globals.gSmallFieldSize/2;
				rect.bottom = rect.top + Globals.gSmallFieldSize;
				rect.left = Globals.gBoardSize.left + Globals.gBigFieldSize/2 + Globals.gDigonalSpace*(number % 5 + 1) - Globals.gSmallFieldSize/2;
				rect.right = rect.left + Globals.gSmallFieldSize;
			}
			
			if(number == 22){
				type = BIG_FIELD;
				rect.top = Globals.gBoardSize.centerY() - Globals.gBigFieldSize/2;
				rect.bottom = rect.top + Globals.gBigFieldSize;
				rect.left = Globals.gBoardSize.centerX() - Globals.gBigFieldSize/2;
				rect.right = rect.left + Globals.gBigFieldSize;
			}
			
		}
	}
}
