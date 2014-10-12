package com.marvel.quest.enemy;

import com.marvel.quest.hero.MarvelCharacter;

import br.com.tide.ActivePlayer;
import br.com.tide.arcade.player.ArcadePlayerListener;



public class StrongMan extends Enemy {

	public StrongMan(int x, int y, ArcadePlayerListener<MarvelCharacter> listener) {
		super(x, y, "sprites/strongman.png", listener);
				
		onStand();
	}
	
	@Override
	public void onStand() {

		layer.setFrames(1);
		layer.setSpeed(300);

		layer.setTileW(64);
		layer.setTileH(96);
		
		layer.setNeedleX(0);
		layer.setNeedleY(0);

		layer.setYImage(0);
		layer.setXImage(0);

	}
	
	@Override
	public void onAttack() {

		layer.setFrames(3);
		layer.setSpeed(180);

		layer.setTileW(64);
		layer.setTileH(96);
		
		layer.setNeedleX(layer.getTileW()*5);
		layer.setNeedleY(layer.getTileH()*0);

		layer.setXImage(layer.getTileW()*5);
		layer.setYImage(layer.getTileH()*0);

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
	
	@Override
	public void onBeignHit(ActivePlayer attacker) {
	
		layer.setFrames(1);
		layer.setSpeed(100);

		layer.setTileW(64);
		layer.setTileH(96);
		
		layer.setXImage(layer.getTileW()*9);
		layer.setYImage(layer.getTileH()*0);

		layer.setNeedleX(layer.getTileW()*9);
		layer.setNeedleY(layer.getTileH()*0);
		
		changeState();
	}

}
