package com.epicness.battlesquicks.game.logic;

import com.epicness.battlesquicks.game.GameStuff;

import static com.epicness.battlesquicks.game.GameConstants.BASE_UPGRADE_COST;

public class UpgradeHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private int upgradeCost;

    public void configure() {
        upgradeCost = BASE_UPGRADE_COST;
        stuff.getUpgradeText().setText(upgradeCost + " PARA MEJORAR");
    }

    public void update() {
        if (logic.getMoneyHandler().getMoney() > upgradeCost) {
            stuff.getUpgradeText().setText("PRESIONA ESPACIO PARA MEJORAR");
        }
    }

    public void upgradePressed() {
        if (logic.getMoneyHandler().getMoney() >= upgradeCost) {
            upgrade();
        }
    }

    public void upgrade() {
        stuff.getMoney().setText(logic.getMoneyHandler().getMoney() - upgradeCost + "");
        upgradeCost *= 1.5f;
        stuff.getUpgradeText().setText(upgradeCost + " PARA MEJORAR");
        logic.getMoneyHandler().upgradeInterval();
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}