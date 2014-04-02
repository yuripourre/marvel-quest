package com.marvel.quest.hero;

import br.com.etyllica.core.Drawable;
import br.com.tide.platform.player.Player;

public abstract class MarvelCharacter extends Player implements Drawable {

	protected boolean turnedRight = true;
	
	protected String rightPath;
	
	protected String leftPath;

	public MarvelCharacter(String rightPath, String leftPath) {
		super();
	
		this.turnedRight = true;
		
		this.rightPath = rightPath;
		
		this.leftPath = leftPath;

	}

}
