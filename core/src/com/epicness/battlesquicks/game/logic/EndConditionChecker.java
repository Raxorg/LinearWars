package com.epicness.battlesquicks.game.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.epicness.battlesquicks.game.GameStuff;

import static com.badlogic.gdx.Input.Keys.R;
import static com.epicness.battlesquicks.game.GameConstants.STARTING_BASE_HEALTH;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;

public class EndConditionChecker {

    private GameLogic logic;
    private GameStuff stuff;

    public void update() {
        if (stuff.getBase().getHealth() <= 0) {
            stuff.getEndText().setColor(TRANSPARENT);
            stuff.getEndText().setTextColor(Color.WHITE);
            stuff.getEndText().setText("DERROTA                                                   R PARA REINICIAR");
        }
        if (stuff.getEnemyBase().getHealth() <= 0) {
            stuff.getEndText().setColor(TRANSPARENT);
            stuff.getEndText().setTextColor(Color.WHITE);
            stuff.getEndText().setText("VICTORIA                                                  R PARA REINICIAR");
        }
        if (Gdx.input.isKeyJustPressed(R)) {
            stuff.getBase().setHealth(STARTING_BASE_HEALTH);
            stuff.getEnemyBase().setHealth(STARTING_BASE_HEALTH);
            stuff.getEndText().setColor(Color.CLEAR);
            stuff.getEndText().setTextColor(Color.CLEAR);
            logic.initialLogic();
        }
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}