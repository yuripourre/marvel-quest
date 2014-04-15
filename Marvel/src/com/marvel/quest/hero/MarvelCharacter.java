package com.marvel.quest.hero;

import br.com.etyllica.core.Drawable;
import br.com.tide.platform.player.Player;

public abstract class MarvelCharacter extends Player implements Drawable {

	protected boolean turnedRight = true;
	
	protected String path;
	
	public MarvelCharacter(String path) {
		super();
	
		this.turnedRight = true;
		
		this.path = path;
	
	}

}
