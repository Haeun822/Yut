package boardgame.yut.view;

import boardgame.yut.Globals;
import boardgame.yut.game.GameBoard;
import boardgame.yut.R;
import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//INIT
		Globals.gGameBoard = new GameBoard();
		
		setContentView(R.layout.activity_game);
	}

}
