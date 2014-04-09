package boardgame.yut.view;

import boardgame.yut.Globals;
import boardgame.yut.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		//Initialize---------------------------------------------------------
		getWindowManager().getDefaultDisplay().getSize(Globals.gScreenSize);
		Globals.gBoardSize = new Rect(Globals.gScreenSize.x/2 - Globals.gScreenSize.y/2, 0, Globals.gScreenSize.x/2 + Globals.gScreenSize.y/2, Globals.gScreenSize.y);
		Globals.gBigFieldSize = Globals.gBoardSize.height() * 55 / 400;
		Globals.gSmallFieldSize = Globals.gBoardSize.height() * 35 / 400;
		Globals.gStraightSpace = (Globals.gBoardSize.height() - Globals.gBigFieldSize*2) / 5;
		Globals.gDigonalSpace = (Globals.gBoardSize.height() - Globals.gBigFieldSize*2) / 6;
		
		Globals.gContext = this;
		//-------------------------------------------------------------------
		
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}
}