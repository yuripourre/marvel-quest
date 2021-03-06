package com.marvel.quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etyllica.context.UpdateIntervalListener;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.layer.BufferedLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;

import com.marvel.quest.enemy.Enemy;
import com.marvel.quest.enemy.StrongMan;
import com.marvel.quest.hero.Beast;
import com.marvel.quest.hero.Gambit;
import com.marvel.quest.hero.MarvelCharacter;

public class FirstStage extends Stage implements UpdateIntervalListener {

	public FirstStage(int w, int h) {
		super(w, h);
	}

	private List<MarvelCharacter> characters = new ArrayList<MarvelCharacter>();
		
	private ImageLayer background;
	
	private BufferedLayer wolverine;
	
	private Beast hank;
	
	private Gambit gambit;
	
	private Controller easyController;
	
	private Controller firstPlayerController;
	
	private Enemy strongMan;

	@Override
	public void load() {
		
		background = new ImageLayer("background/sor3.png");
		
		wolverine = new BufferedLayer(160,180,"sprites/wolverine.png");
		wolverine.setW(64);
		wolverine.setH(64);
		wolverine.flipHorizontal();
		
		hank = new Beast(40, 100, this);
		heroes.add(hank);
		
		gambit = new Gambit(500, 100, this);
		heroes.add(gambit);
		
		easyController = new EasyController(hank);
		
		firstPlayerController = new FirstPlayerController(gambit);
		
		strongMan = new StrongMan(300, 100, this);
		enemies.add(strongMan);
		
		strongMan.setTarget(hank);
		
		characters.add(strongMan);
		characters.add(hank);
		characters.add(gambit);
		
		updateAtFixedRate(30, this);
		
		loading = 100;
	}
	
	@Override
	public void timeUpdate(long now) {
		
		updateEnemies(now);
		
		for(MarvelCharacter character: characters) {
			character.update(now);
		}
		
		Collections.sort(characters);		
	}
	
	@Override
	public void draw(Graphic g) {
		
		background.draw(g);
		
		for(MarvelCharacter character: characters) {
			character.draw(g);
		}
				
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		easyController.handleEvent(event);
		
		firstPlayerController.handleEvent(event);
		
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
