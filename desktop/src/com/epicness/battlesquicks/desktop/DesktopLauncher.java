package com.epicness.battlesquicks.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.epicness.battlesquicks.BattleSquicksGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1800;
        config.height = 900;
        config.forceExit = false;
        new LwjglApplication(new BattleSquicksGame(), config);
    }
}
