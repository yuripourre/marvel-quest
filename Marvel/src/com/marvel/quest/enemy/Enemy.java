package com.marvel.quest.enemy;

import com.marvel.quest.hero.Hero;

public class Enemy extends Hero {

	private Hero target;

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
			}else if(target.getX() > this.getX()+distance) {
				walkRight();
			}else {
				stand();
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
