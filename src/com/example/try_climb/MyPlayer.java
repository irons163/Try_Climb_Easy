package com.example.try_climb;

import android.graphics.Bitmap;
import android.view.MotionEvent;

import com.example.try_gameengine.action.MovementAction;
import com.example.try_gameengine.action.MovementActionInfo;
import com.example.try_gameengine.action.MovementActionItemBaseReugularFPS;
import com.example.try_gameengine.framework.Sprite;

public class MyPlayer extends Sprite{
	enum PlayerAnimaton {
		Move(
		"PLAYER_MOVE",
		new Bitmap[] {
				
		},
		new int[] {
				10,
				10,
				10
		})
		;

		String name;
		Bitmap[] bitmaps;
		int[] framesTime;

		private PlayerAnimaton(String name, Bitmap[] bitmaps, int[] framesTime) {
			this.name = name;
			this.bitmaps = bitmaps;
			this.framesTime = framesTime;
		}

		public String getName() {
			return name;
		}

		public int[] getFramesTime() {
			return framesTime;
		}
		
		public Bitmap[] getBitmaps() {
			return bitmaps;
		}
		
//		public void setBitmaps(Bitmap[] bitmaps){
//			this.bitmaps = bitmaps;
//		}
	}

	private Bitmap bitmap;
	
	public MyPlayer(float x, float y, boolean autoAdd) {
		super(x, y, autoAdd);
		// TODO Auto-generated constructor stub
//		bitmap = BitmapUtil.getBitmapFromRes(R.drawable.hited);
	}

	public void onTouch(MotionEvent event){
		if(event.getAction() == event.ACTION_DOWN){
			MovementActionInfo info = new MovementActionInfo(1000, 100, 50, 0, "", null, false, MyPlayer.this, "");
			MovementAction action = new MovementActionItemBaseReugularFPS(info);
		}
	}
	
	public void beHited(){
		setBitmap(bitmap);
	}
	
	@Override
	public void move(float dx, float dy) {
		// TODO Auto-generated method stub
		super.move(dx, dy);
		
		if(dx < 0){
			moveLeftAnimate();
		}else if(dx > 0){
			moveRightAnimate();
		}
	}
	
	private void moveLeftAnimate(){
		addActionFPS(PlayerAnimaton.Move.getName(), PlayerAnimaton.Move.getBitmaps(), PlayerAnimaton.Move.getFramesTime());
	}
	
	private void moveRightAnimate(){
		addActionFPS(PlayerAnimaton.Move.getName(), PlayerAnimaton.Move.getBitmaps(), PlayerAnimaton.Move.getFramesTime());
	}
}
