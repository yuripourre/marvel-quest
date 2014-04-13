package com.marvel.quest.hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import br.com.etyllica.animation.listener.OnAnimationFinishListener;
import br.com.etyllica.animation.listener.OnFrameChangeListener;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.BufferedLayer;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class Hero extends MarvelCharacter implements OnFrameChangeListener {

	protected AnimatedLayer layer;
	
	protected BufferedLayer buffer;
	
	protected GeometricLayer shadow;

	public Hero(int x, int y, String rightPath, String leftPath) {
		super(rightPath, leftPath);

		walkSpeed = 3;
				
		layer = new AnimatedLayer(x, y, 64, 96, rightPath);
		
		layer.setOnFrameChangeListener(this);
		
		buffer = new BufferedLayer(x, y, 96, 96);//Max Tile Size
		
		shadow = new GeometricLayer();
				
		onStand();
		
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

	}
	
	@Override
	public void onBeignHit(Player attacker) {
	
		layer.setFrames(1);
		layer.setSpeed(100);

		layer.setTileW(96);
		layer.setTileH(96);
		
		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*2);

		layer.setNeedleX(layer.getTileW()*0);
		layer.setNeedleY(layer.getTileH()*2);

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
		//layer.draw(g);
		
		buffer.draw(g);
		
	}
	
	private void drawShadow(Graphic g) {
				
		g.setColor(Color.BLACK);
				
		g.fillOval(shadow);
		
	}
	
	private GeometricLayer updateShadow() {
				
		int shadowSize = 16;
		
		shadow.setBounds(layer.getX(), this.getY(), layer.getTileW(), shadowSize);
		
		return shadow;
		
	}

	public void animate(long now) {
		
		layer.animate(now);
		
	}

	@Override
	public void update(long now) {
		super.update(now);

		updateShadow();
		
		animate(now);

		if(state.contains(PlayerState.WALK_RIGHT)) {
			
			this.layer.setOffsetX(walkSpeed);
			
		} else if(state.contains(PlayerState.WALK_LEFT)) {
			
			this.layer.setOffsetX(-walkSpeed);
			
		}

		if(state.contains(PlayerState.WALK_DOWN)) {
			
			this.layer.setOffsetY(walkSpeed);
			
		} else if(state.contains(PlayerState.WALK_UP)) {
			
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

	@Override
	//And On state change
	public void onFrameChange(long now) {
		
		buffer.clearGraphics();
		
		Graphic g = buffer.getGraphics();
		
		int layerX = layer.getX();
		int layerY = layer.getY();
		
		layer.setX(0);
		layer.setY(0);
		
		layer.draw(g);
		
		buffer.refresh();

		layer.setX(layerX);
		layer.setY(layerY);
		
		//Change on Walk Events
		buffer.setX(layerX);
		buffer.setY(layerY);
						
	}


}
