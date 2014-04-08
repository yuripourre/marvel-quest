package com.marvel.quest.enemy;

import com.marvel.quest.hero.Hero;

public class Enemy extends Hero {

	private Hero target;
	
	private long attackDelay = 2000;
	
	private long startAttack = 0;
	
	public Enemy(int x, int y, String rightPath, String leftPath) {
		super(x, y, rightPath, leftPath);
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
				
				if(isWalking()) {
					stopWalk();
					startAttack = now;
					
					stand();					
				}
				
				if(now>=startAttack+attackDelay) {
	
					if(!isAttacking()) {
					
						attack();
					
						startAttack = now;
						
					}
					
					if(layer.getCurrentFrame() >= layer.getFrames()-1) {
						stand();
						stopAttack();
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

}
