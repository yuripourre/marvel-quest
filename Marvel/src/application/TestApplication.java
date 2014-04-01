package application;

import application.hero.Beast;
import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.BufferedLayer;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;

public class TestApplication extends Application {

	public TestApplication(int w, int h) {
		super(w, h);
	}

	private BufferedLayer wolverine;
	
	private Beast hank;
	
	private Controller easyController;

	@Override
	public void load() {
		
		wolverine = new BufferedLayer(160,260,"sprites/wolverine.png");
		wolverine.setW(64);
		wolverine.setH(64);
		wolverine.flipHorizontal();
		
		hank = new Beast(40, 40);
		
		easyController = new EasyController(hank);
						
		updateAtFixedRate(30);
		
		loading = 100;
	}
	
	@Override
	public void timeUpdate(long now){
		
		hank.update(now);
		
	}
	
	@Override
	public void draw(Graphic g) {
		
		wolverine.draw(g);
		
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
