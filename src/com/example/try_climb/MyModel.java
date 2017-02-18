package com.example.try_climb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.example.try_gameengine.framework.Data;
import com.example.try_gameengine.framework.GameModel;
import com.example.try_gameengine.framework.Sprite;
import com.example.try_gameengine.remotecontroller.custom.CustomRemoteController;
import com.example.try_gameengine.remotecontroller.custom.CustomTouch;

public class MyModel extends GameModel{
	private MapU map;
	private PlayBoard playBoard;
	private MyPlayer player;
	private Ostcal ostcal;
	private List<Ostcal> ostcals = new ArrayList<Ostcal>();
	private Sprite leftKey, rightKey;
	private final int MAX_LIFT_VALUE = 3;
	private int life = MAX_LIFT_VALUE;
	
	private final int NONE = 0; 
	private final int LEFT = 0; 
	private final int RIGHT = 0; 
	private int dir = NONE;
	
	public MyModel(Context context, Data data) {
		super(context, data);
		// TODO Auto-generated constructor stub
		CustomRemoteController customRemoteController = CustomRemoteController.createRemoteController();
		customRemoteController.setRemoteContollerListener(new CustomRemoteController.RemoteContollerListener() {
			
			@Override
			public void pressDown(List<CustomTouch> commandTouch) {
				// TODO Auto-generated method stub
				CustomTouch customTouch = commandTouch.get(0);
				switch (customTouch.getEvent().getAction()) {
				case MotionEvent.ACTION_DOWN:
					if(customTouch.getTouch() == leftKey){
						dir = LEFT;
					}
					break;

				default:
					break;
				}
			}
		});
	}
	
	private void init(){
		map = new MapU(context);
		player = new MyPlayer(CommonUtil.screenWidth/2f, CommonUtil.screenHeight - 100, false);
		
	}
	
	private void createRandomObstructer(){
		Random random = new Random();
		float randomX = random.nextInt(CommonUtil.screenWidth);
		ostcal = new Ostcal(randomX, 0, false);
		ostcals.add(ostcal);
	}
	
	private void playerMove(){
		if(dir == LEFT){
			player.move(-5, 0);
		}else if(dir == RIGHT){
			player.move(5, 0);
		}
		
		dir = NONE;
	}
	
	private boolean checkCollision(){
		boolean isCollision = false;
		for(Ostcal ostcal : ostcals){
			if(RectF.intersects(player.getFrame(), ostcal.getFrame())){
				isCollision = true;
				break;
			}
		}
		
		return isCollision;
	}
	
	private void obstructerMove() {
		for(Ostcal ostcal : ostcals){
			ostcal.move(0, 1);
		}
	}
	
	private void logical(){
		if(checkCollision()){
			playerBeHited();
			life--;
		}
		checkRemoveObstructer();
		checkLoseOrWin();
	}
	
	private void playerBeHited(){
		player.beHited();
	}
	
	private void checkRemoveObstructer(){
		List<Ostcal> needRemoved = new ArrayList<Ostcal>();
		for(Ostcal ostcal : ostcals){
			if(ostcal.getY() > CommonUtil.screenHeight || ostcal.isHidden()){
				needRemoved.add(ostcal);
			}
		}
		
		ostcals.removeAll(needRemoved);
	}
	
	private void checkLoseOrWin(){
		if(life <= 0){
			lose();
			return;
		}
//		if(win){
//			win();
//		}
	}
	
	private void lose(){
		
	}
	
	private void win(){
		
	}
	
	private void reset(){
		
	}
	
	@Override
	protected void process() {
		// TODO Auto-generated method stub
		super.process();
		
		playerMove();
		obstructerMove();
		checkCollision();
	}

	@Override
	protected void doDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.doDraw(canvas);
		
		player.drawSelf(canvas, null);
		
		for(Ostcal ostcal : ostcals){
			ostcal.drawSelf(canvas, null);
		}
	}
	
	@Override
	public void onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		super.onTouchEvent(event);
	}
}
