package com.epicness.battlesquicks.game;

import com.epicness.battlesquicks.game.logic.GameLogic;
import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;

public class GameInitializer extends Initializer {

    public GameInitializer() {
        super(new GameAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new GameLogic(sharedResources.getLogic());
        renderer = new GameRenderer();
        stuff = new GameStuff();
        super.initialize(sharedResources);
    }
}