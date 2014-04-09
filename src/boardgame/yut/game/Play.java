package boardgame.yut.game;

import java.util.ArrayList;
import java.util.Random;

import boardgame.yut.Globals;
import android.content.Context;
import android.util.Log;

public class Play implements Runnable{

	Context mContext;
	GameBoard mGameBoard;
	
	Player[] players = new Player[4];
	int turn = 0;
	
	public Play(Context context){
		mContext = context;
		mGameBoard = Globals.gGameBoard;
		Globals.gPlayers = players;
		Globals.gTurn = turn;
		
		//플레이어초기화
		for(int i=0; i<2; i++){
			players[i] = new Player(i);
		}
	}
	
	@Override
	public void run() {	
		while(true){
			playerPlay(players[turn]);
			if(players[turn].isWin() == false){
				turn++;
				if(turn >= players.length) turn = 0;
			}
			else break;
			
			Globals.gTurn = turn;
		}
		
		Log.i("HE_Play", "Game End");
	}

	void playerPlay(Player player){
		ArrayList<Integer> yutValues = new ArrayList<Integer>();
		int yut;
		
		//윷을 던지고 윷이나 모가 나오면 반복해서 던짐
		yut = throwYut(player);
		yutValues.add(yut);
		while(yut == 5 || yut == 4){
			yut = throwYut(player);
			yutValues.add(yut);
		}
	}
	
	int throwYut(Player player){
		//윷값 랜덤생성 - 추후 수정
		int number = 0;
		
		Random rand = new Random();
		
		for(int i=0; i<4; i++)
			number += rand.nextInt(2);
		
		if(number == 0) number = 5;
		if(number == 1 && rand.nextInt(4) == 0) number = -1;
		
		Log.i("HE_Play", "Yut : " + number);
		return number;
	}
}
