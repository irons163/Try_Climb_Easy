package com.example.try_climb;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MapU {
	Context context;
	MApCell[][] cells = new MApCell[8][8]; 
	int offX, offY;
	public MapU(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	public void setSize(int col, int row){
		MApCell mApCell = new MApCell();
		mApCell.setBitmal(BitmapUtil.createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.green_point), 50, 50));
		mApCell.setColRow(0, 0);
		cells[0][0] = mApCell;
	}
	
	public void draw(Canvas canvas, Paint paint){
		for(MApCell[] cellsInRow : cells){
			for(MApCell cell : cellsInRow){
				canvas.drawRect(cell.getRect(), paint);
			}
		}
//		canvas.drawRect(cells[0][0].getRect(), paint);
	}
	
	public void process(){
		
	}
	
	public int getOffX(){
		return offX;
	}
	
	public int getOFFY(){
		return offY;
	}

}
