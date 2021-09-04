package com.epicness.battlesquicks.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.battlesquicks.game.GameAssets;
import com.epicness.battlesquicks.game.GameStuff;
import com.epicness.battlesquicks.game.stuff.Cat;

import static com.epicness.battlesquicks.game.GameConstants.BASE_WIDTH;
import static com.epicness.battlesquicks.game.GameConstants.UNIT_COMPARATOR;
import static com.epicness.battlesquicks.game.GameConstants.UNIT_SIZE;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class CatSpawner {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void slot1Pressed() {
        if (logic.getMoneyHandler().getMoney() >= 20) {
            spawnCat(Color.WHITE, 2);
            logic.getMoneyHandler().spendMoney(20);
        }
    }

    public void slot2Pressed() {
        if (logic.getMoneyHandler().getMoney() >= 35) {
            spawnCat(Color.CYAN, 3);
            logic.getMoneyHandler().spendMoney(35);
        }
    }

    public void slot3Pressed() {
        if (logic.getMoneyHandler().getMoney() >= 50) {
            spawnCat(Color.RED, 4);
            logic.getMoneyHandler().spendMoney(50);
        }
    }

    private void spawnCat(Color color, int health) {
        Cat cat = new Cat(assets.getCatWalkFrames(), assets.getCatAttackFrames(), health);
        cat.setColor(color);
        cat.setPosition(CAMERA_WIDTH - BASE_WIDTH / 2f - UNIT_SIZE, MathUtils.random(200f, 250f));
        stuff.getCats().add(cat);
        stuff.getCats().sort(UNIT_COMPARATOR);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}