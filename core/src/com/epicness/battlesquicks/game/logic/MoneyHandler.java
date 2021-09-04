package com.epicness.battlesquicks.game.logic;

import com.epicness.battlesquicks.game.GameStuff;

public class MoneyHandler {

    private GameStuff stuff;
    // Logic
    private float time, interval = 0.175f;

    public void configure() {
        time = 0f;
        interval = 0.175f;
        stuff.getMoney().setText("0");
    }

    public void update(float delta) {
        time += delta;
        if (time >= interval) {
            time -= interval;
            int money = Integer.parseInt(stuff.getMoney().getText()) + 1;
            stuff.getMoney().setText(money + "");
        }
    }

    public int getMoney() {
        return Integer.parseInt(stuff.getMoney().getText());
    }

    public void spendMoney(int money) {
        int newMoney = Integer.parseInt(stuff.getMoney().getText()) - money;
        stuff.getMoney().setText(newMoney + "");
    }

    public void upgradeInterval() {
        interval /= 1.3f;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}