package com.marvel.quest.hero;

import br.com.tide.arcade.player.ArcadePlayerListener;



public class Beast extends Hero {

	public Beast(int x, int y, ArcadePlayerListener<MarvelCharacter> listener) {
		super(x, y, "sprites/beast.png", listener);
	}
	
	@Override
	public void onStand() {

		layer.setFrames(4);
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
		
		layer.setFrames(6);
		layer.setSpeed(150);

		layer.setTileW(64);
		layer.setTileH(96);

		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*0);

		layer.setNeedleX(layer.getTileW()*4);
		layer.setNeedleY(layer.getTileH()*1);
		
		changeState();
		
	}

}
