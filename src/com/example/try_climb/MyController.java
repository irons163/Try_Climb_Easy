package com.example.try_climb;

import android.app.Activity;
import android.view.SurfaceHolder;

import com.example.try_gameengine.framework.GameController;
import com.example.try_gameengine.framework.IGameModel;

public class MyController extends GameController{
	MyGameView gameView;
	
	public MyController(Activity activity, IGameModel gameModel) {
		super(activity, gameModel);
		// TODO Auto-generated constructor stub
		
		initStart();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initGameView(Activity activity, IGameModel gameModel) {
		// TODO Auto-generated method stub
		gameView = new MyGameView(activity, this, gameModel);
	}

	@Override
	protected void arrangeView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setActivityContentView(Activity activity) {
		// TODO Auto-generated method stub
		activity.setContentView(gameView);
	}

	@Override
	protected void beforeGameStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void afterGameStart() {
		// TODO Auto-generated method stub
		
	}

}
