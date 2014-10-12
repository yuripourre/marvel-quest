package com.marvel.quest.hero;

import br.com.tide.arcade.player.ArcadePlayerListener;


public class Gambit extends Hero {

	public Gambit(int x, int y, ArcadePlayerListener<MarvelCharacter> listener) {
		super(x, y, "sprites/gambit.png", listener);
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
	
	@Override
	public void onAttack() {
		
		layer.setFrames(3);
		layer.setSpeed(180);
		
		layer.setTileW(96);
		layer.setTileH(96);
		
		layer.setXImage(layer.getTileW()*1);
		layer.setYImage(layer.getTileH()*1);
		
		layer.setNeedleX(layer.getTileW()*1);
		layer.setNeedleY(layer.getTileH()*1);
		
		layer.restartAnimation();
		
		changeState();
	}

}
