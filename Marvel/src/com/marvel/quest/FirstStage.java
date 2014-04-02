package com.marvel.quest;

import com.marvel.quest.hero.Beast;
import com.marvel.quest.hero.MarvelCharacter;
import com.marvel.quest.hero.StrongMan;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.BufferedLayer;
import br.com.etyllica.layer.ImageLayer;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;

public class FirstStage extends Application {

	public FirstStage(int w, int h) {
		super(w, h);
	}

	private ImageLayer background;
	
	private BufferedLayer wolverine;
	
	private Beast hank;
	
	private Controller easyController;
	
	private MarvelCharacter strongMan;

	@Override
	public void load() {
		
		background = new ImageLayer("background/sor3.png");
		
		wolverine = new BufferedLayer(160,180,"sprites/wolverine.png");
		wolverine.setW(64);
		wolverine.setH(64);
		wolverine.flipHorizontal();
		
		hank = new Beast(40, 100);
		
		easyController = new EasyController(hank);
		
		strongMan = new StrongMan(300, 100);
		
		updateAtFixedRate(30);
		
		loading = 100;
	}
	
	@Override
	public void timeUpdate(long now){
		
		hank.update(now);
		
		strongMan.update(now);
		
	}
	
	@Override
	public void draw(Graphic g) {
		
		background.draw(g);
		
		strongMan.draw(g);
		
		hank.draw(g);	
		
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		easyController.handleEvent(event);
		
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
