package com.epicness.battlesquicks.game;

import com.epicness.battlesquicks.game.stuff.Unit;

import java.util.Comparator;

public class GameConstants {

    // Other
    public static final Comparator<Unit> UNIT_COMPARATOR = new UnitComparator();
    // Units
    public static final float DOGE_SPAWN_BASE_INTERVAL = 1.25f;
    public static final float DOGE_SPAWN_INTERVAL_VARIATION = 5f;
    public static final float UNIT_SIZE = 100f;
    public static final float DOGE_SPEED = 50f * 5;
    public static final float CAT_SPEED = 60f * 5;
    // Base
    public static final int STARTING_BASE_HEALTH = 25;
    public static final float BASE_WIDTH = 225f;
    public static final float BASE_HEIGHT = BASE_WIDTH * 1.5f;
    // Upgrade
    public static final int BASE_UPGRADE_COST = 50;
    // Icons
    public static final float ICON_WIDTH = 80f * 2f;
    public static final float ICON_HEIGHT = 60f * 2f;
}