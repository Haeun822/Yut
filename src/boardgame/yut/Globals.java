package boardgame.yut;

import boardgame.yut.game.*;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;

public class Globals {
	
	public static Point gScreenSize = new Point();
	
	public static Rect gBoardSize;
	public static int gBigFieldSize;
	public static int gSmallFieldSize;
	public static int gStraightSpace;
	public static int gDigonalSpace;
	
	public static Context gContext;
	
	public static GameBoard gGameBoard;
	public static Player[] gPlayers;
	public static int gTurn;

}
