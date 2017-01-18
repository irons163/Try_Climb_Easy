package com.example.try_climb;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.Data;
import com.example.try_gameengine.framework.GameModel;

public class MyModel extends GameModel{
	private MapU map;
	private PlayBoard playBoard;
	private MyPlayer player;
	private Ostcal ostcal;
	
	public MyModel(Context context, Data data) {
		super(context, data);
		// TODO Auto-generated constructor stub
		
	}
	
	private void init(){
		map = new MapU(context);
		player = new MyPlayer(x, y, autoAdd);
		ostcal = new Ostcal(x, y, autoAdd);
	}
	
	@Override
	protected void process() {
		// TODO Auto-generated method stub
		super.process();
	}

	@Override
	protected void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.doDraw(canvas);
	}
	
	@Override
	public void onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		super.onTouchEvent(event);
	}
}
