package boardgame.yut.view;

import boardgame.yut.Globals;
import boardgame.yut.R;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	Context mContext;
	SurfaceHolder mHolder;
	GameThread mThread;
	
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mHolder = getHolder();
		mHolder.addCallback(this);
		mThread = new GameThread();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if(mThread.getState() == Thread.State.NEW)
			mThread.start();
		else onResume();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		mThread.isRun = false;
	}
	
	public void onPause(){
		mThread.isWait = true;
	}
	
	public void onResume(){
		if(mThread.getState() == Thread.State.NEW)
			mThread.start();
		else{
			mThread.isWait = false;
			mThread.isRun = true;
			synchronized(mThread){
				mThread.notify();
			}
		}
	}
	
	
	//--------------------------------------------------------------------------------
	//--------------------------Thread------------------------------------------------
	//--------------------------------------------------------------------------------

	class GameThread extends Thread{
		
		boolean isRun = true;
		boolean isWait = false;
		
		Typeface namsan = Typeface.createFromAsset(mContext.getAssets(), "namsan.otf");
		
		Bitmap board = BitmapFactory.decodeResource(Globals.gContext.getResources(), R.drawable.board);
		
		public GameThread(){}
		
		public void run(){
			Canvas canvas;
			while(isRun){
				//Draw----------------------------------------------------------------
				canvas = mHolder.lockCanvas();
				try{
					synchronized(mHolder){
						//Draw Background---------------------------------------------
						canvas.drawColor(Color.BLACK);
						canvas.drawBitmap(board, null, Globals.gBoardSize, null);
						//------------------------------------------------------------
					}
				}finally{
					mHolder.unlockCanvasAndPost(canvas);
				}
				//-------------------------------------------------------------------
				
				
				
				
				//Thread Sleep-------------------------------------------------------
				try{
					sleep(200);
				}catch (InterruptedException e){ }
				//-------------------------------------------------------------------
				
				
				
				
				//Thread Pause-------------------------------------------------------
				if(isWait)
					try{
						synchronized(this){
							wait();
						}
					}catch (InterruptedException e){ }
				//-------------------------------------------------------------------
			}
		}
		
	}
	//Thread end---------------------------------------------------------------------
	
}
