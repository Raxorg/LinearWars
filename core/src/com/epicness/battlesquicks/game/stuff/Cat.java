package com.epicness.battlesquicks.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cat extends Unit {

    public Cat(Sprite[] walkFrames, Sprite[] attackFrames, int health) {
        super(walkFrames, attackFrames, health);
    }

    public void setColor(Color color) {
        for (int i = 0; i < walkAnimation.getKeyFrames().length; i++) {
            walkAnimation.getKeyFrames()[i].setColor(color);
        }
        for (int i = 0; i < attackAnimation.getKeyFrames().length; i++) {
            attackAnimation.getKeyFrames()[i].setColor(color);
        }
    }
}