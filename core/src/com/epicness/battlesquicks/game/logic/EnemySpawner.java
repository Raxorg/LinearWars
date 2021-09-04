package com.epicness.battlesquicks.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.battlesquicks.game.GameAssets;
import com.epicness.battlesquicks.game.GameStuff;
import com.epicness.battlesquicks.game.stuff.Doge;

import static com.epicness.battlesquicks.game.GameConstants.DOGE_SPAWN_BASE_INTERVAL;
import static com.epicness.battlesquicks.game.GameConstants.DOGE_SPAWN_INTERVAL_VARIATION;
import static com.epicness.battlesquicks.game.GameConstants.UNIT_COMPARATOR;

public class EnemySpawner {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private float time, interval;

    public void update(float delta) {
        time += delta;
        if (time >= interval) {
            time -= interval;
            spawnDoge();
        }
    }

    private void spawnDoge() {
        interval = DOGE_SPAWN_BASE_INTERVAL + MathUtils.random(DOGE_SPAWN_INTERVAL_VARIATION);
        Doge doge = new Doge(assets.getDogeWalkFrames(), assets.getDogeAttackFrames());
        doge.setPosition(55f, MathUtils.random(200f, 250f));
        stuff.getDoges().add(doge);
        stuff.getDoges().sort(UNIT_COMPARATOR);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}