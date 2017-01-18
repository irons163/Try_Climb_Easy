package com.example.try_climb;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class MApCell {
	Bitmap bitmap;
	Rect rect;
	int col ,row;
	int w, h;
	
	public void setBitmal(Bitmap bitmap){
		this.bitmap = bitmap;
		w = bitmap.getWidth();
		h = bitmap.getHeight();
	}
	
	public void setColRow(int col, int row){
		this.col = col;
		this.row = row;
		
		rect = new Rect(col*w , row*h, (col+1)*w, (row+1)*h);
	}
	
	public Bitmap getBitmap(){
		return bitmap;
	}
	
	public Rect getRect(){
		return rect;
	}
}
