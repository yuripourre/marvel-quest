package com.marvel.quest.hero;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.platform.player.PlayerState;

public class Hero extends MarvelCharacter {

	protected AnimatedLayer layer;

	public Hero(int x, int y, String rightPath, String leftPath) {
		super(rightPath, leftPath);

		walkSpeed = 3;
				
		layer = new AnimatedLayer(x, y, 64, 96, rightPath);
		
		onStand();
		
	}

	@Override
	public void onStand() {

		layer.setFrames(4);
		layer.setSpeed(300);

		layer.setNeedleX(0);
		layer.setNeedleY(0);

		layer.setYImage(0);
		layer.setXImage(0);

		layer.setTileW(64);
		layer.setTileH(96);

	}

	@Override
	public void onAttack() {

		layer.setFrames(3);
		layer.setSpeed(180);

		layer.setXImage(layer.getTileW()*1);
		layer.setYImage(layer.getTileH()*1);

		layer.setNeedleX(layer.getTileW()*1);
		layer.setNeedleY(layer.getTileH()*1);

		layer.setTileW(96);
		layer.setTileH(96);

	}

	@Override
	public void onWalkLeft() {

		turnedRight = false;

		animateWalk();

	}

	@Override
	public void onWalkRight() {

		turnedRight = true;

		animateWalk();

	}

	@Override
	public void onWalkDown() {
		animateWalk();
	}

	@Override
	public void onWalkUp() {
		animateWalk();
	}
	
	public void onWalk() {
		
		layer.setFrames(6);
		layer.setSpeed(150);

		layer.setTileW(64);
		layer.setTileH(96);

		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*0);

		layer.setNeedleX(layer.getTileW()*4);
		layer.setNeedleY(layer.getTileH()*1);
		
	}

	private void animateWalk() {

		if(!isWalking()) {

			onWalk();
			
		}
		
		if(turnedRight) {

			layer.setPath(rightPath);

		} else {
		
			layer.setPath(leftPath);
			
		}
		
	}

	@Override
	public void onStopWalkUp() {

		if(!isWalking()) {
			super.stand();
		}

	}

	@Override
	public void onStopWalkDown() {

		if(!isWalking()) {
			super.stand();
		}

	}

	@Override
	public void onStopWalkRight() {

		if(!isWalking()) {
			super.stand();
		}

	}

	@Override
	public void onStopWalkLeft() {

		if(!isWalking()) {
			super.stand();
		}

	}

	@Override
	public void draw(Graphic g) {
	
		g.setAlpha(70);
		drawShadow(g);
		
		g.setAlpha(100);		
		layer.draw(g);
	}
	
	private void drawShadow(Graphic g) {
				
		g.setColor(Color.BLACK);
		
		GeometricLayer shadow = getShadow();
		
		g.fillOval(shadow);
		
	}
	
	private GeometricLayer getShadow() {
				
		int shadowSize = 16;
		
		GeometricLayer shadow = new GeometricLayer(layer.getX(), this.getY(), layer.getTileW(), shadowSize);
		
		return shadow;
		
	}

	public void animate(long now) {
		layer.animate(now);
	}

	@Override
	public void update(long now) {
		super.update(now);

		animate(now);

		if(state.contains(PlayerState.WALK_RIGHT)) {
			this.layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)) {
			this.layer.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)) {
			this.layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)) {
			this.layer.setOffsetY(-walkSpeed);
		}

	}

	public int getX() {
		return layer.getX()+layer.getTileW()/2;
	}
	
	public int getY() {
		
		int shadowSize = 16;
		
		int offset = shadowSize-shadowSize/4;
		
		return layer.getY()+layer.getTileH()-offset;
	}


}
