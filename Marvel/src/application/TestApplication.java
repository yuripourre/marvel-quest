package application;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.BufferedLayer;

public class TestApplication extends Application {

	public TestApplication(int w, int h) {
		super(w, h);
	}

	private BufferedLayer wolverine;
	
	private AnimatedLayer hank;

	@Override
	public void load() {

		wolverine = new BufferedLayer(160,260,"sprites/wolverine.png");
		wolverine.setW(64);
		wolverine.setH(64);
		wolverine.flipHorizontal();
		
		hank = new AnimatedLayer(40, 40, 64, 96, "sprites/beast.png");
		hank.setFrames(4);
		hank.setSpeed(300);
				
		updateAtFixedRate(30);
		
		loading = 100;
	}
	
	@Override
	public void timeUpdate(long now){
		
		hank.animate(now);
		
	}
	
	@Override
	public void draw(Graphic g) {
		
		wolverine.draw(g);
		
		hank.draw(g);
		
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		if(event.isKeyDown(KeyEvent.TSK_RIGHT_ARROW)) {
			hank.setOffsetX(20);
		} else if(event.isKeyDown(KeyEvent.TSK_LEFT_ARROW)) {
			hank.setOffsetX(-20);
		}
		
		if(event.isKeyDown(KeyEvent.TSK_DOWN_ARROW)) {
			hank.setOffsetY(20);
		} else if(event.isKeyDown(KeyEvent.TSK_UP_ARROW)) {
			hank.setOffsetY(-20);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
