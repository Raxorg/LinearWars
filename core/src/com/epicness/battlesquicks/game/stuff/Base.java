package com.epicness.battlesquicks.game.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.battlesquicks.game.GameConstants.BASE_HEIGHT;
import static com.epicness.battlesquicks.game.GameConstants.BASE_WIDTH;
import static com.epicness.battlesquicks.game.GameConstants.STARTING_BASE_HEALTH;

public class Base extends Healthed {

    private final Sprited base;
    private final Text text;

    public Base(Sprite baseSprite, BitmapFont font) {
        super(STARTING_BASE_HEALTH);
        base = new Sprited(baseSprite);
        base.setSize(BASE_WIDTH, BASE_HEIGHT);
        text = new Text(font);
        text.setX(BASE_WIDTH / 2f);
        text.setCenterVertical(true);
        text.setHorizontalAlignment(Align.center);
        text.setText(health + "");
    }

    public void draw(SpriteBatch spriteBatch) {
        base.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    public float getX() {
        return base.getX();
    }

    public void setY(float y) {
        base.setY(y);
        text.setY(y + BASE_HEIGHT * 1.15f);
    }

    public void setPosition(float x, float y) {
        base.setPosition(x, y);
        text.setPosition(x + BASE_WIDTH / 2f, y + BASE_HEIGHT * 1.15f);
    }

    public void flipX() {
        base.flipX();
    }

    @Override
    public void reduceHealth() {
        super.reduceHealth();
        text.setText(health + "");
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
        text.setText(health + "");
    }
}