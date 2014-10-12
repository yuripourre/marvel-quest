package com.marvel.quest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.etyllica.context.Application;
import br.com.tide.arcade.player.ArcadePlayerListener;

import com.marvel.quest.enemy.Enemy;
import com.marvel.quest.hero.Hero;
import com.marvel.quest.hero.MarvelCharacter;

public abstract class Stage extends Application implements ArcadePlayerListener<MarvelCharacter> {

	protected List<Enemy> enemies = new ArrayList<Enemy>();
	protected List<Hero> heroes = new ArrayList<Hero>();
	
	protected HashMap<Enemy, MarvelCharacter> wasHit = new HashMap<Enemy, MarvelCharacter>();
	
	public Stage(int w, int h) {
		super(w, h);
	}

	@Override
	public void onAttack(MarvelCharacter player) {
		
		if(!heroes.contains(player))
			return;
		
		for(Enemy enemy: enemies) {
			
			if(player.isColliding(enemy)) {
				wasHit.put(enemy, player);
			}
		}	
	}
	
	protected void updateEnemies(long now) {
		
		for(Enemy enemy: wasHit.keySet()) {
			
			MarvelCharacter player = wasHit.get(enemy);
			
			enemy.beignHit(player, now);
		}				
		
		wasHit.clear();
	}
	
	@Override
	public void onWalkLeft(MarvelCharacter player) {
		
	}

	@Override
	public void onWalkRight(MarvelCharacter player) {
		
	}

	@Override
	public void onWalkUp(MarvelCharacter player) {

	}

	@Override
	public void onWalkDown(MarvelCharacter player) {
			
	}

	@Override
	public void onStopWalkLeft(MarvelCharacter player) {
		player.checkWalk();
	}

	@Override
	public void onStopWalkRight(MarvelCharacter player) {
		player.checkWalk();
	}

	@Override
	public void onStopWalkUp(MarvelCharacter player) {
		player.checkWalk();
	}

	@Override
	public void onStopWalkDown(MarvelCharacter player) {
		player.checkWalk();
	}

}
