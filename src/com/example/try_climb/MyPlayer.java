package com.example.try_climb;

import android.view.MotionEvent;

import com.example.try_gameengine.action.MovementAction;
import com.example.try_gameengine.action.MovementActionInfo;
import com.example.try_gameengine.action.MovementActionItemBaseReugularFPS;
import com.example.try_gameengine.framework.Sprite;

public class MyPlayer extends Sprite{

	public MyPlayer(float x, float y, boolean autoAdd) {
		super(x, y, autoAdd);
		// TODO Auto-generated constructor stub
	}

	public void onTouch(MotionEvent event){
		if(event.getAction() == event.ACTION_DOWN){
			MovementActionInfo info = new MovementActionInfo(1000, 100, 50, 0, "", null, false, MyPlayer.this, "");
			MovementAction action = new MovementActionItemBaseReugularFPS(info);
		}
	}
}
