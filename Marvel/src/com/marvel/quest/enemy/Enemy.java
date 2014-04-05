package com.marvel.quest.enemy;

import br.com.etyllica.animation.AnimationListener;

import com.marvel.quest.hero.Hero;

public class Enemy extends Hero implements AnimationListener {

	private Hero target;
	
	private long attackDelay = 2000;
	
	private long startAttack = 0;

	public Enemy(int x, int y, String rightPath, String leftPath) {
		super(x, y, rightPath, leftPath);
		
		this.layer.setListener(this);
	}

	@Override
	public void update(long now) {
		super.update(now);
		
		if(target != null) {
			
			int distance = 32;

			if(target.getX() < this.getX()-distance) {
				
				walkLeft();
				
			} else if(target.getX() > this.getX()+distance) {
				
				walkRight();
				
			} else {
				
				if(now >= startAttack+attackDelay) {
	
					if(!isAttacking()) {
					
						attack();
					
						startAttack = now;
						
					}					

				}
				
			}

		}
		
	}
	
	public Hero getTarget() {
		return target;
	}

	public void setTarget(Hero target) {
		this.target = target;
	}

	@Override
	public void onEndAnimation() {
		
		if(isAttacking()) {
			stand();
		}
				
	}

}
