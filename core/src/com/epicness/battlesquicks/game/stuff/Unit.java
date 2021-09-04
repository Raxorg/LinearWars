package com.epicness.battlesquicks.game.stuff;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import static com.epicness.battlesquicks.game.GameConstants.UNIT_SIZE;

public abstract class Unit extends Healthed {

    protected final Animation<Sprite> walkAnimation, attackAnimation;
    private float time, cooldown;
    private boolean attacking;
    private Healthed target;

    public Unit(Sprite[] walkSprites, Sprite[] attackSprites, int health) {
        super(health);
        Sprite[] walkFrames = new Sprite[walkSprites.length];
        for (int i = 0; i < walkSprites.length; i++) {
            walkFrames[i] = new Sprite(walkSprites[i]);
            walkFrames[i].setSize(UNIT_SIZE, UNIT_SIZE);
        }
        walkAnimation = new Animation<>(0.175f, walkFrames);
        walkAnimation.setPlayMode(LOOP);

        Sprite[] attackFrames = new Sprite[attackSprites.length];
        for (int i = 0; i < attackSprites.length; i++) {
            attackFrames[i] = new Sprite(attackSprites[i]);
            attackFrames[i].setSize(UNIT_SIZE, UNIT_SIZE);
        }
        attackAnimation = new Animation<>(0.125f, attackFrames);
    }

    public void draw(SpriteBatch spriteBatch) {
        if (attacking) {
            attackAnimation.getKeyFrame(time).draw(spriteBatch);
        } else {
            walkAnimation.getKeyFrame(time).draw(spriteBatch);
        }
    }

    public void addTime(float additionalTime) {
        if (cooldown > 0f) {
            cooldown -= additionalTime;
        } else {
            time += additionalTime;
        }
    }

    public void setTime(float newTime) {
        time = newTime;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public float getX() {
        return walkAnimation.getKeyFrames()[0].getX();
    }

    public void translateX(float amount) {
        for (int i = 0; i < walkAnimation.getKeyFrames().length; i++) {
            walkAnimation.getKeyFrames()[i].translateX(amount);
        }
        for (int i = 0; i < attackAnimation.getKeyFrames().length; i++) {
            attackAnimation.getKeyFrames()[i].translateX(amount);
        }
    }

    public float getY() {
        return walkAnimation.getKeyFrames()[0].getY();
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < walkAnimation.getKeyFrames().length; i++) {
            walkAnimation.getKeyFrames()[i].setPosition(x, y);
        }
        for (int i = 0; i < attackAnimation.getKeyFrames().length; i++) {
            attackAnimation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public int getFrameIndex() {
        return attackAnimation.getKeyFrameIndex(time);
    }

    public void putOnCooldown() {
        cooldown = 2f;
    }

    public boolean isOnCooldown() {
        return cooldown > 0;
    }

    public Healthed getTarget() {
        return target;
    }

    public void setTarget(Healthed target) {
        this.target = target;
    }
}