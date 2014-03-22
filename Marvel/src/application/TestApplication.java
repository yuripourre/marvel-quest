package application;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.ImageLayer;

public class TestApplication extends Application {

	public TestApplication(int w, int h) {
		super(w, h);
	}

	private ImageLayer wolverine;

	@Override
	public void load() {

		wolverine = new ImageLayer("sprites/wolverine.png");
		
		loading = 100;
	}
	
	@Override
	public void draw(Graphic g) {
		
		wolverine.draw(g);
		
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
