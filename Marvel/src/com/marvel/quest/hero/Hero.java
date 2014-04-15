package com.marvel.quest.hero;

import java.awt.Color;

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

	public Hero(int x, int y, String path) {
		super(path);

		walkSpeed = 3;
				
		layer = new AnimatedLayer(0, 0, 64, 96, path);
		
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
		
		changeState();

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
		
		changeState();

	}
	
	@Override
	public void stand() {
		super.stand();
		
		changeState();
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
		
		changeState();
		
	}

	private void animateWalk() {

		if(!isWalking()) {

			onWalk();
			
		}
			
	}

	@Override
	public void onStopWalkUp() {

		if(!isWalking()) {
			this.stand();			
		}

	}

	@Override
	public void onStopWalkDown() {

		if(!isWalking()) {
			this.stand();
		}

	}

	@Override
	public void onStopWalkRight() {

		if(!isWalking()) {
			this.stand();
		}

	}

	@Override
	public void onStopWalkLeft() {

		if(!isWalking()) {
			this.stand();
		}

	}

	@Override
	public void draw(Graphic g) {
	
		g.setAlpha(70);
		drawShadow(g);
		
		g.setAlpha(100);
		buffer.draw(g);
				
	}
	
	private void drawShadow(Graphic g) {
				
		g.setColor(Color.BLACK);
				
		g.fillOval(shadow);
		
	}
	
	private GeometricLayer updateShadow() {
				
		int shadowSize = 16;
		
		int width = buffer.getModifiedBuffer().getWidth();
		
		int dif = width-layer.getTileW();
		
		shadow.setBounds(buffer.getX()+dif/2, buffer.getY()+layer.getTileH()-shadowSize*2/3, layer.getTileW(), shadowSize);
		
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
			
			this.buffer.setOffsetX(walkSpeed);
			
		} else if(state.contains(PlayerState.WALK_LEFT)) {
			
			this.buffer.setOffsetX(-walkSpeed);
			
		}

		if(state.contains(PlayerState.WALK_DOWN)) {
			
			this.buffer.setOffsetY(walkSpeed);
			
		} else if(state.contains(PlayerState.WALK_UP)) {
			
			this.buffer.setOffsetY(-walkSpeed);
			
		}

	}

	public int getX() {
		
		return buffer.getX()+shadow.getW()/2;
		
	}
	
	public int getY() {
				
		return shadow.getY();
	}
	
	private void changeState() {
				
		onFrameChange(0);
				
	}

	@Override
	//And On state change
	public void onFrameChange(long now) {
				
		buffer.clearGraphics();
		
		Graphic g = buffer.getGraphics();
				
		int width = buffer.getModifiedBuffer().getWidth();
		
		int dif = width-layer.getTileW();
		
		this.layer.setX(dif/2);
		
		layer.draw(g);
		
		this.layer.setX(0);
						
		buffer.refresh();

		if(!turnedRight) {
			buffer.flipHorizontal();
		}

	}


}
