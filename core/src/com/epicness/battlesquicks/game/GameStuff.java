package com.epicness.battlesquicks.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.battlesquicks.game.stuff.Base;
import com.epicness.battlesquicks.game.stuff.Cat;
import com.epicness.battlesquicks.game.stuff.Doge;
import com.epicness.battlesquicks.game.stuff.Icon;
import com.epicness.battlesquicks.game.stuff.Puff;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.battlesquicks.game.GameConstants.BASE_UPGRADE_COST;
import static com.epicness.battlesquicks.game.GameConstants.BASE_WIDTH;
import static com.epicness.battlesquicks.game.GameConstants.ICON_WIDTH;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameStuff extends Stuff {

    private Sprited background;
    private SpritedText money;
    private Base base, enemyBase;
    private DelayedRemovalArray<Cat> cats;
    private DelayedRemovalArray<Doge> doges;
    private Text upgradeText;
    private Icon catFrame1, catFrame2, catFrame3;
    private DelayedRemovalArray<Puff> puffs;
    private SpritedText endText;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        background = new Sprited(assets.getBackground());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        money = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        money.setPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT - 50f);
        money.setText("0");

        base = new Base(assets.getBase(), assets.getSmallPixelFont());
        base.setPosition(CAMERA_WIDTH - BASE_WIDTH, 250f);

        enemyBase = new Base(assets.getBase(), assets.getSmallPixelFont());
        enemyBase.setY(250f);
        enemyBase.flipX();

        cats = new DelayedRemovalArray<>();
        doges = new DelayedRemovalArray<>();

        upgradeText = new Text(assets.getSmallPixelFont());
        upgradeText.setY(900f);
        upgradeText.setTextTargetWidth(CAMERA_WIDTH);
        upgradeText.setHorizontalAlignment(Align.center);
        upgradeText.setCenterVertical(true);
        upgradeText.setText(BASE_UPGRADE_COST + " PARA MEJORAR");

        catFrame1 = new Icon(assets.getCatIconFrame(), assets.getCatIcon(), assets.getSmallPixelFont(), 20);
        catFrame1.setPosition(CAMERA_WIDTH / 2f - ICON_WIDTH * 1.5f - 20f, 15f);
        catFrame2 = new Icon(assets.getCatIconFrame(), assets.getCatIcon(), assets.getSmallPixelFont(), 35);
        catFrame2.setPosition(CAMERA_WIDTH / 2f - ICON_WIDTH * 0.5f, 15f);
        catFrame2.setForegroundColor(Color.CYAN);
        catFrame3 = new Icon(assets.getCatIconFrame(), assets.getCatIcon(), assets.getSmallPixelFont(), 50);
        catFrame3.setPosition(CAMERA_WIDTH / 2f + ICON_WIDTH * 0.5f + 20f, 15f);
        catFrame3.setForegroundColor(Color.RED);

        puffs = new DelayedRemovalArray<>();

        endText = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        endText.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
        endText.setColor(Color.CLEAR);
        endText.setTextColor(Color.CLEAR);
    }

    public Sprited getBackground() {
        return background;
    }

    public SpritedText getMoney() {
        return money;
    }

    public Base getBase() {
        return base;
    }

    public Base getEnemyBase() {
        return enemyBase;
    }

    public DelayedRemovalArray<Cat> getCats() {
        return cats;
    }

    public DelayedRemovalArray<Doge> getDoges() {
        return doges;
    }

    public Text getUpgradeText() {
        return upgradeText;
    }

    public Icon getCatFrame1() {
        return catFrame1;
    }

    public Icon getCatFrame2() {
        return catFrame2;
    }

    public Icon getCatFrame3() {
        return catFrame3;
    }

    public DelayedRemovalArray<Puff> getPuffs() {
        return puffs;
    }

    public SpritedText getEndText() {
        return endText;
    }
}