package com.epicness.battlesquicks.game.logic;

import com.epicness.battlesquicks.game.GameAssets;
import com.epicness.battlesquicks.game.GameStuff;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class GameLogic extends Logic {

    private final CatSpawner catSpawner;
    private final EndConditionChecker endConditionChecker;
    private final EnemySpawner enemySpawner;
    private final GameInputHandler gameInputHandler;
    private final MoneyHandler moneyHandler;
    private final MusicPlayer musicPlayer;
    private final PuffHandler puffHandler;
    private final UnitHandler unitHandler;
    private final UpgradeHandler upgradeHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        catSpawner = new CatSpawner();
        endConditionChecker = new EndConditionChecker();
        enemySpawner = new EnemySpawner();
        gameInputHandler = new GameInputHandler();
        moneyHandler = new MoneyHandler();
        musicPlayer = new MusicPlayer();
        puffHandler = new PuffHandler();
        unitHandler = new UnitHandler();
        upgradeHandler = new UpgradeHandler();

        catSpawner.setLogic(this);
        endConditionChecker.setLogic(this);
        gameInputHandler.setLogic(this);
        unitHandler.setLogic(this);
        upgradeHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        gameInputHandler.setupInput();
        moneyHandler.configure();
        musicPlayer.playMusic();
        unitHandler.setup();
        upgradeHandler.configure();
    }

    @Override
    public void update(float delta) {
        endConditionChecker.update();
        enemySpawner.update(delta);
        moneyHandler.update(delta);
        puffHandler.update(delta);
        unitHandler.update(delta);
        upgradeHandler.update();
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        catSpawner.setAssets(gameAssets);
        enemySpawner.setAssets(gameAssets);
        musicPlayer.setAssets(gameAssets);
        puffHandler.setAssets(gameAssets);
        unitHandler.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        catSpawner.setStuff(gameStuff);
        endConditionChecker.setStuff(gameStuff);
        enemySpawner.setStuff(gameStuff);
        moneyHandler.setStuff(gameStuff);
        puffHandler.setStuff(gameStuff);
        unitHandler.setStuff(gameStuff);
        upgradeHandler.setStuff(gameStuff);
    }

    public CatSpawner getCatSpawner() {
        return catSpawner;
    }

    public MoneyHandler getMoneyHandler() {
        return moneyHandler;
    }

    public PuffHandler getPuffHandler() {
        return puffHandler;
    }

    public UpgradeHandler getUpgradeHandler() {
        return upgradeHandler;
    }
}