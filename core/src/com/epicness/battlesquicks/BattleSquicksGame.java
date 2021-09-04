package com.epicness.battlesquicks;

import com.badlogic.gdx.Game;
import com.epicness.battlesquicks.game.GameInitializer;
import com.epicness.fundamentals.SharedResources;

public class BattleSquicksGame extends Game {

    @Override
    public void create() {
        new GameInitializer().initialize(new SharedResources(this));
    }
}