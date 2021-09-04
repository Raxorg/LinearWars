package com.epicness.battlesquicks.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.battlesquicks.game.GameAssets;
import com.epicness.battlesquicks.game.GameStuff;
import com.epicness.battlesquicks.game.stuff.Cat;
import com.epicness.battlesquicks.game.stuff.Doge;

import static com.epicness.battlesquicks.game.GameConstants.BASE_WIDTH;
import static com.epicness.battlesquicks.game.GameConstants.CAT_SPEED;
import static com.epicness.battlesquicks.game.GameConstants.DOGE_SPEED;
import static com.epicness.battlesquicks.game.GameConstants.UNIT_SIZE;

public class UnitHandler {

    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void setup() {
        stuff.getCats().clear();
        stuff.getDoges().clear();
    }

    public void update(float delta) {
        updateAnimations(delta);
        checkProximity();
        moveUnits(delta);
        checkAttackFrame();
        checkHealth();
    }

    private void updateAnimations(float delta) {
        DelayedRemovalArray<Cat> cats = stuff.getCats();
        for (int i = 0; i < cats.size; i++) {
            cats.get(i).addTime(delta);
        }
        DelayedRemovalArray<Doge> doges = stuff.getDoges();
        for (int i = 0; i < doges.size; i++) {
            doges.get(i).addTime(delta);
        }
    }

    private void moveUnits(float delta) {
        DelayedRemovalArray<Cat> cats = stuff.getCats();
        for (int i = 0; i < cats.size; i++) {
            if (cats.get(i).isAttacking() || cats.get(i).isOnCooldown()) {
                continue;
            }
            cats.get(i).translateX(-delta * CAT_SPEED);
        }
        DelayedRemovalArray<Doge> doges = stuff.getDoges();
        for (int i = 0; i < doges.size; i++) {
            if (doges.get(i).isAttacking() || doges.get(i).isOnCooldown()) {
                continue;
            }
            doges.get(i).translateX(delta * DOGE_SPEED);
        }
    }

    private void checkProximity() {
        DelayedRemovalArray<Cat> cats = stuff.getCats();
        DelayedRemovalArray<Doge> doges = stuff.getDoges();
        for (int i = 0; i < cats.size; i++) {
            Cat cat = cats.get(i);
            for (int j = 0; j < doges.size; j++) {
                Doge doge = doges.get(j);
                if (cat.getX() <= doge.getX() + UNIT_SIZE) {
                    if (!cat.isOnCooldown()) {
                        if (!cat.isAttacking()) {
                            cat.setTime(0f);
                        }
                        cat.setAttacking(true);
                        cat.setTarget(doge);
                    }
                    if (!doge.isOnCooldown()) {
                        if (!doge.isAttacking()) {
                            doge.setTime(0f);
                        }
                        doge.setAttacking(true);
                        doge.setTarget(cat);
                    }
                }
            }
            if (cat.isOnCooldown()) {
                continue;
            }
            if (cat.getX() <= stuff.getEnemyBase().getX() + BASE_WIDTH) {
                if (!cat.isAttacking()) {
                    cat.setTime(0f);
                }
                cat.setAttacking(true);
                cat.setTarget(stuff.getEnemyBase());
            }
        }
        for (int i = 0; i < doges.size; i++) {
            Doge doge = doges.get(i);
            if (doge.isOnCooldown()) {
                continue;
            }
            if (doge.getX() + UNIT_SIZE * 0.7f >= stuff.getBase().getX()) {
                if (!doge.isAttacking()) {
                    doge.setTime(0f);
                }
                doge.setAttacking(true);
                doge.setTarget(stuff.getBase());
            }
        }
    }

    private void checkAttackFrame() {
        DelayedRemovalArray<Cat> cats = stuff.getCats();
        for (int i = 0; i < cats.size; i++) {
            Cat cat = cats.get(i);
            if (cats.get(i).isAttacking()) {
                if (cat.getFrameIndex() == 3) {
                    cat.putOnCooldown();
                    cat.setAttacking(false);
                    cat.getTarget().reduceHealth();
                    assets.getAttack().play(0.5f);
                    logic.getPuffHandler().spawnPuff(cat.getX() - UNIT_SIZE, cat.getY());
                }
            }
        }
        DelayedRemovalArray<Doge> doges = stuff.getDoges();
        for (int i = 0; i < doges.size; i++) {
            Doge doge = doges.get(i);
            if (doges.get(i).isAttacking()) {
                if (doge.getFrameIndex() == 3) {
                    doge.putOnCooldown();
                    doge.setAttacking(false);
                    doge.getTarget().reduceHealth();
                    assets.getAttack().play(0.5f);
                    logic.getPuffHandler().spawnPuff(doge.getX() + UNIT_SIZE, doge.getY());
                }
            }
        }
    }

    private void checkHealth() {
        DelayedRemovalArray<Cat> cats = stuff.getCats();
        for (int i = 0; i < cats.size; i++) {
            Cat cat = cats.get(i);
            if (cat.getHealth() <= 0) {
                cats.removeValue(cat, true);
            }
        }
        DelayedRemovalArray<Doge> doges = stuff.getDoges();
        for (int i = 0; i < doges.size; i++) {
            Doge doge = doges.get(i);
            if (doge.getHealth() <= 0) {
                doges.removeValue(doge, true);
            }
        }
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