package com.epicness.battlesquicks.game;

import com.epicness.battlesquicks.game.stuff.Unit;

import java.util.Comparator;

public class UnitComparator implements Comparator<Unit> {

    @Override
    public int compare(Unit unit1, Unit unit2) {
        if (unit1.getY() == unit2.getY()) {
            return 0;
        }
        boolean lower = unit1.getY() < unit2.getY();
        return lower ? 1 : -1;
    }
}