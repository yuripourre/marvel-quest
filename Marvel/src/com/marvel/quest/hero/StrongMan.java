package com.marvel.quest.hero;


public class StrongMan extends Hero {

	public StrongMan(int x, int y) {
		super(x, y, "sprites/strongman.png", "sprites/strongman_inv.png");
		
		onWalkLeft();
		
		onStand();
	}
	
	@Override
	public void onStand() {

		layer.setFrames(1);
		layer.setSpeed(300);

		layer.setNeedleX(0);
		layer.setNeedleY(0);

		layer.setYImage(0);
		layer.setXImage(0);

		layer.setTileW(64);
		layer.setTileH(96);

	}

}
