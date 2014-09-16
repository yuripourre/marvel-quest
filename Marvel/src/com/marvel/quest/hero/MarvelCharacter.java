package com.marvel.quest.hero;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.arcade.player.ArcadePlayer;
import br.com.tide.arcade.player.ArcadePlayerListener;

public abstract class MarvelCharacter extends ArcadePlayer implements Drawable, Comparable<MarvelCharacter>, ArcadePlayerListener {

	protected boolean turnedRight = true;
	
	protected String path;
	
	protected GeometricLayer shadow;
	
	public MarvelCharacter(String path) {
		super();
	
		this.listener = this;
		
		this.turnedRight = true;
		
		this.path = path;
	
		shadow = new GeometricLayer();				
	}

	@Override
	public int compareTo(MarvelCharacter character) {

		return shadow.getY()-character.shadow.getY();
	}	

}
