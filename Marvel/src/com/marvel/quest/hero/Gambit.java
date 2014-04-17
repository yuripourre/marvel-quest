package com.marvel.quest.hero;


public class Gambit extends Hero {

	public Gambit(int x, int y) {
		super(x, y, "sprites/gambit.png");
	}
	
	@Override
	public void onStand() {

		layer.setFrames(3);
		layer.setSpeed(300);		

		layer.setTileW(64);
		layer.setTileH(96);
		
		layer.setNeedleX(0);
		layer.setNeedleY(0);

		layer.setYImage(0);
		layer.setXImage(0);
		
		changeState();

	}
	
	@Override
	public void onWalk() {
		
		layer.setFrames(5);
		layer.setSpeed(150);

		layer.setTileW(64);
		layer.setTileH(96);

		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*0);

		layer.setNeedleX(layer.getTileW()*3);
		layer.setNeedleY(layer.getTileH()*1);
		
		changeState();
		
	}

}
