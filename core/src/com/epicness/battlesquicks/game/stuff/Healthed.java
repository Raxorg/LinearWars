package com.epicness.battlesquicks.game.stuff;

public abstract class Healthed {

    protected int health;

    public Healthed(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth() {
        health = Math.max(0, health - 1);
    }

    public void setHealth(int health) {
        this.health = health;
    }
}