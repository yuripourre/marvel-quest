package com.marvel.quest.hero;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.layer.GeometricLayer;
import br.com.tide.platform.player.Player;

public abstract class MarvelCharacter extends Player implements Drawable, Comparable<MarvelCharacter> {

	protected boolean turnedRight = true;
	
	protected String path;
	
	protected GeometricLayer shadow;
	
	public MarvelCharacter(String path) {
		super();
	
		this.turnedRight = true;
		
		this.path = path;
	
		shadow = new GeometricLayer();
		
	}

	@Override
	public int compareTo(MarvelCharacter character) {

		return shadow.getY()-character.shadow.getY();
	}	

}
