package com.epicness.battlesquicks.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.battlesquicks.game.GameConstants.ICON_HEIGHT;
import static com.epicness.battlesquicks.game.GameConstants.ICON_WIDTH;

public class Icon {

    private final DualSprited dualSprited;
    private final Text text;

    public Icon(Sprite backgroundSprite, Sprite foregroundSprite, BitmapFont font, int cost) {
        dualSprited = new DualSprited(backgroundSprite, foregroundSprite);
        dualSprited.setSize(ICON_WIDTH, ICON_HEIGHT);
        text = new Text(font);
        text.setText(cost + "");
    }

    public void draw(SpriteBatch spriteBatch) {
        dualSprited.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        dualSprited.setPosition(x, y);
        text.setPosition(x, y + ICON_HEIGHT);
    }

    public void setForegroundColor(Color color) {
        dualSprited.setForegroundColor(color);
    }
}