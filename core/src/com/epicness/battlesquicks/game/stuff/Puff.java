package com.epicness.battlesquicks.game.stuff;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.epicness.battlesquicks.game.GameConstants.UNIT_SIZE;

public class Puff {

    private final Animation<Sprite> animation;
    private float time;

    public Puff(Sprite[] sprites) {
        Sprite[] puffFrames = new Sprite[sprites.length];
        for (int i = 0; i < sprites.length; i++) {
            puffFrames[i] = new Sprite(sprites[i]);
            puffFrames[i].setSize(UNIT_SIZE, UNIT_SIZE);
        }
        animation = new Animation<>(0.1f, puffFrames);
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.getKeyFrame(time).draw(spriteBatch);
    }

    public void addTime(float additionalTime) {
        time += additionalTime;
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public boolean isAnimationFinished() {
        return animation.isAnimationFinished(time);
    }
}