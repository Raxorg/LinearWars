package com.epicness.battlesquicks.game.logic;

import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.NUM_1;
import static com.badlogic.gdx.Input.Keys.NUM_2;
import static com.badlogic.gdx.Input.Keys.NUM_3;
import static com.badlogic.gdx.Input.Keys.SPACE;

public class GameInputHandler extends InputHandler {

    private GameLogic logic;

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case NUM_1:
                logic.getCatSpawner().slot1Pressed();
                break;
            case NUM_2:
                logic.getCatSpawner().slot2Pressed();
                break;
            case NUM_3:
                logic.getCatSpawner().slot3Pressed();
                break;
            case SPACE:
                logic.getUpgradeHandler().upgradePressed();
                break;
        }
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }
}