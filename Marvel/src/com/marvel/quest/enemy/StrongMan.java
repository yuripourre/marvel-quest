package com.marvel.quest.enemy;



public class StrongMan extends Enemy {

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
	
	@Override
	public void onWalk() {
		
		layer.setFrames(4);
		layer.setSpeed(150);

		layer.setTileW(64);
		layer.setTileH(96);

		layer.setXImage(layer.getTileW()*1);
		layer.setYImage(layer.getTileH()*0);

		layer.setNeedleX(layer.getTileW()*1);
		layer.setNeedleY(layer.getTileH()*0);
		
	}

}
