package com.epicness.battlesquicks.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer {

    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(Color.YELLOW);

        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        stuff.getMoney().draw(spriteBatch);
        stuff.getBase().draw(spriteBatch);
        stuff.getEnemyBase().draw(spriteBatch);
        for (int i = 0; i < stuff.getCats().size; i++) {
            stuff.getCats().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getDoges().size; i++) {
            stuff.getDoges().get(i).draw(spriteBatch);
        }
        stuff.getUpgradeText().draw(spriteBatch);
        stuff.getCatFrame1().draw(spriteBatch);
        stuff.getCatFrame2().draw(spriteBatch);
        stuff.getCatFrame3().draw(spriteBatch);
        for (int i = 0; i < stuff.getPuffs().size; i++) {
            stuff.getPuffs().get(i).draw(spriteBatch);
        }
        stuff.getEndText().draw(spriteBatch);
        spriteBatch.end();
    }
}