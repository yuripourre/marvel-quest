package application.hero;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class Hero extends Player implements Drawable {

	protected AnimatedLayer layer;
	
	public Hero(int x, int y, String path) {
		super();
		
		layer = new AnimatedLayer(x, y, 64, 96, path);
		layer.setFrames(4);
		layer.setSpeed(300);
		
	}
	
	@Override
	public void onStand() {

		layer.setFrames(4);
		layer.setSpeed(300);
		
		layer.setNeedleX(0);
		layer.setNeedleY(0);
		
		layer.setYImage(0);
		layer.setXImage(0);
		
		layer.setTileW(64);
		layer.setTileH(96);
		
	}
	
	@Override
	public void onAttack() {

		layer.setFrames(3);
		layer.setSpeed(200);

		layer.setXImage(layer.getTileW()*1);
		layer.setYImage(layer.getTileH()*1);
		
		layer.setNeedleX(layer.getTileW()*1);
		layer.setNeedleY(layer.getTileH()*1);
		
		layer.setTileW(96);
		layer.setTileH(96);
		
	}
	
	@Override
	public void draw(Graphic g) {
		layer.draw(g);
	}
	
	public void animate(long now) {
		layer.animate(now);
	}
	
	@Override
	public void update(long now) {
		super.update(now);
		
		animate(now);

		if(state.contains(PlayerState.WALK_RIGHT)) {
			this.layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)) {
			this.layer.setOffsetX(-walkSpeed);
		}

		if(state.contains(PlayerState.WALK_DOWN)) {
			this.layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)) {
			this.layer.setOffsetY(-walkSpeed);
		}

	}
	
}
