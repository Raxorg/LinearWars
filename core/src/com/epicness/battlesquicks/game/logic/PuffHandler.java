package com.epicness.battlesquicks.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.battlesquicks.game.GameAssets;
import com.epicness.battlesquicks.game.GameStuff;
import com.epicness.battlesquicks.game.stuff.Puff;

public class PuffHandler {

    private GameAssets assets;
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Puff> puffs = stuff.getPuffs();
        for (int i = 0; i < puffs.size; i++) {
            puffs.get(i).addTime(delta);
            if (puffs.get(i).isAnimationFinished()) {
                puffs.removeValue(puffs.get(i), true);
            }
        }
    }

    public void spawnPuff(float x, float y) {
        Puff puff = new Puff(assets.getPuffFrames());
        puff.setPosition(x, y);
        stuff.getPuffs().add(puff);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}