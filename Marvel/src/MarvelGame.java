import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.context.Application;

import com.marvel.quest.FirstStage;


public class MarvelGame extends EtyllicaFrame {

	public MarvelGame() {
		super(800, 600);
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		MarvelGame game = new MarvelGame();
		
		game.init();
	}

	@Override
	public Application startApplication() {
		
		this.setPath(MarvelGame.class.getResource(""));
		
		return new FirstStage(w, h);
	}

}
