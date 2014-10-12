package com.marvel.quest.enemy;

import sound.model.Sound;
import br.com.etyllica.animation.listener.OnAnimationFinishListener;
import br.com.tide.PlayerState;
import br.com.tide.arcade.player.ArcadePlayerListener;

import com.marvel.quest.hero.Hero;
import com.marvel.quest.hero.MarvelCharacter;

public abstract class Enemy extends Hero implements OnAnimationFinishListener {

	private Hero target;

	private long startAttack = 0;

	private Sound punchSound;

	public Enemy(int x, int y, String rightPath, ArcadePlayerListener<MarvelCharacter> listener) {
		super(x, y, rightPath, listener);

		this.layer.setOnAnimationFinishListener(this);

		punchSound = new Sound("punch.wav");

		attackDelay = 2000;
	}

	protected boolean wasWalking = false;

	@Override
	public void update(long now) {
		super.update(now);

		if(target != null) {

			boolean isWalkingVertical = walkVertical();

			boolean isWalkingHorizontal = walkHorizontal();

			if(isWalkingHorizontal||isWalkingVertical) {

				wasWalking = true;

			} else {

				if(wasWalking) {

					startAttack = now;

					stand();

					wasWalking = false;
				}

				/*if(isBeignHit()) {
					if(now >= wasHit+hitDelay) {
						stand();
					}
				}*/

				if(now >= startAttack+attackDelay) {

					if(!isAttacking()) {

						attack();

						startAttack = now;

					}

				}

			}

		}

	}

	@Override
	public void attack() {
		super.attack();

		punchSound.play();
	}

	private boolean walkVertical() {

		boolean walkVertical = false;

		int verticalDistance = 16;

		if(target.getY() < this.getY()-verticalDistance) {

			walkUp();

			walkVertical = true;

		} else if(target.getY() > this.getY()+verticalDistance) {

			walkDown();

			walkVertical = true;

		} else if(hasState(PlayerState.WALK_UP, PlayerState.WALK_DOWN)) {

			states.remove(PlayerState.WALK_UP);

			states.remove(PlayerState.WALK_DOWN);

		}

		return walkVertical;

	}

	private boolean walkHorizontal() {

		boolean walkHorizontal = false;

		int horizontalDistance = 32;

		if(target.getX() < this.getX()-horizontalDistance) {

			walkLeft();

			walkHorizontal = true;

		} else if(target.getX() > this.getX()+horizontalDistance) {

			walkRight();

			walkHorizontal = true;

		} else if(hasState(PlayerState.WALK_LEFT, PlayerState.WALK_RIGHT)) {

			states.remove(PlayerState.WALK_LEFT);

			states.remove(PlayerState.WALK_RIGHT);

		}

		return walkHorizontal;
	}

	public Hero getTarget() {
		return target;
	}

	public void setTarget(Hero target) {
		this.target = target;
	}

	@Override
	public void onAnimationFinish(long now) {

		if(isAttacking()) {

			hitTarget(now);

			stand();		
		}

	}

	private void hitTarget(long now) {

		if(target == null) {
			return;
		}

		target.beignHit(this, now);		
	}

}
