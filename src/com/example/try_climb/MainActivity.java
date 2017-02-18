package com.example.try_climb;

import com.example.try_gameengine.framework.Config;
import com.example.try_gameengine.stage.BaseStage;

import android.graphics.Color;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends BaseStage {
	MyModel model;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void initGame() {
		// TODO Auto-generated method stub
		if(CommonUtil.screenHeight<=0){
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			
			CommonUtil.screenHeight = dm.heightPixels;
			CommonUtil.screenWidth = dm.widthPixels;
			CommonUtil.statusBarHeight = CommonUtil.getStatusBarHeight(this);
			CommonUtil.screenHeight -= CommonUtil.statusBarHeight;
		}
		
		Config.enableFPSInterval = true;
		Config.showMovementActionThreadNumber = true;
		Config.showAllThreadNumber = true;
		Config.debugMessageColor = Color.WHITE;
		Config.fps = 40;
		Config.showFPS = true;
//		Config.destanceType = DestanceType.ScreenPersent;
		Config.currentScreenWidth = CommonUtil.screenWidth;
		Config.currentScreenHeight = CommonUtil.screenHeight;
	}

	@Override
	protected void initGameModel() {
		// TODO Auto-generated method stub
		model = new MyModel(this, null);
	}

	@Override
	protected void initGameController() {
		// TODO Auto-generated method stub
		new MyController(this, model);
	}
}
