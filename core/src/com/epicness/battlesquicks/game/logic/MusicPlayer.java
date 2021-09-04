package com.epicness.battlesquicks.game.logic;

import com.epicness.battlesquicks.game.GameAssets;

public class MusicPlayer {

    private GameAssets assets;

    public void playMusic() {
        assets.getBattleTheme().setLooping(true);
        assets.getBattleTheme().play();
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}