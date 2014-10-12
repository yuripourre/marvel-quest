package com.marvel.quest.hero;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.arcade.player.ArcadePlayer;
import br.com.tide.arcade.player.ArcadePlayerListener;

public abstract class MarvelCharacter extends ArcadePlayer implements Drawable, Comparable<MarvelCharacter> {

	protected boolean turnedRight = true;
	
	protected String path;
	
	protected GeometricLayer shadow;
	
	public MarvelCharacter(String path, ArcadePlayerListener listener) {
		super();
			
		this.turnedRight = true;
		
		this.path = path;
	
		shadow = new GeometricLayer();
		
		this.listener = listener;
	}

	@Override
	public int compareTo(MarvelCharacter character) {

		return shadow.getY()-character.shadow.getY();
	}

	public boolean isColliding(MarvelCharacter character) {
		return shadow.colideRect(character.shadow);
	}
	
	public void turnLeft() {
		turnedRight = false;
	}
	
	public void turnRight() {
		turnedRight = true;
	}
	
	public void animateWalk() {

		if(!isWalking()) {

			onWalk();			
		}			
	}
	
	public abstract void onWalk();
	
	public void checkWalk() {
		
		if(!isWalking()) {
			this.stand();		
		}
	}

}
