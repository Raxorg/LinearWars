package com.epicness.battlesquicks.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.battlesquicks.AssetPaths.ATTACK_PATH;
import static com.epicness.battlesquicks.AssetPaths.BACKGROUND_PATH;
import static com.epicness.battlesquicks.AssetPaths.BASE_PATH;
import static com.epicness.battlesquicks.AssetPaths.BATTLE_THEME_PATH;
import static com.epicness.battlesquicks.AssetPaths.CAT_ICON_FRAME_PATH;
import static com.epicness.battlesquicks.AssetPaths.CAT_ICON_PATH;
import static com.epicness.battlesquicks.AssetPaths.CAT_PATH;
import static com.epicness.battlesquicks.AssetPaths.DOGE_PATH;
import static com.epicness.battlesquicks.AssetPaths.PIXEL_FONT_PATH;
import static com.epicness.battlesquicks.AssetPaths.PUFF_PATH;
import static com.epicness.battlesquicks.AssetPaths.SMALL_PIXEL_FONT_PATH;

public class GameAssets extends Assets {

    // Audio
    private Music battleTheme;
    private Sound attack;
    // Fonts
    private BitmapFont pixelFont, smallPixelFont;
    // Sprites
    private Sprite background;
    private Sprite base;
    private Sprite[] catWalkFrames, catAttackFrames;
    private Sprite[] dogeWalkFrames, dogeAttackFrames;
    private Sprite[] puffFrames;
    private Sprite catIcon, catIconFrame;

    @Override
    public void queueAssetLoading() {
        assetManager.load(BATTLE_THEME_PATH, Music.class);

        assetManager.load(ATTACK_PATH, Sound.class);

        assetManager.load(PIXEL_FONT_PATH, BitmapFont.class);
        assetManager.load(SMALL_PIXEL_FONT_PATH, BitmapFont.class);

        assetManager.load(BACKGROUND_PATH, Texture.class);
        assetManager.load(BASE_PATH, Texture.class);
        assetManager.load(CAT_PATH, Texture.class);
        assetManager.load(DOGE_PATH, Texture.class);
        assetManager.load(PUFF_PATH, Texture.class);
        assetManager.load(CAT_ICON_PATH, Texture.class);
        assetManager.load(CAT_ICON_FRAME_PATH, Texture.class);
    }

    @Override
    public boolean loadAssets() {
        assetManager.finishLoading();
        return true;
    }

    @Override
    public void initializeAssets() {
        battleTheme = assetManager.get(BATTLE_THEME_PATH, Music.class);

        attack = assetManager.get(ATTACK_PATH, Sound.class);

        pixelFont = assetManager.get(PIXEL_FONT_PATH, BitmapFont.class);
        pixelFont.getData().setScale(6f);

        smallPixelFont = assetManager.get(SMALL_PIXEL_FONT_PATH, BitmapFont.class);
        smallPixelFont.getData().setScale(3f);

        background = new Sprite(assetManager.get(BACKGROUND_PATH, Texture.class));

        base = new Sprite(assetManager.get(BASE_PATH, Texture.class));
        base.getTexture().setFilter(Linear, Linear);

        Texture cat = assetManager.get(CAT_PATH, Texture.class);
        cat.setFilter(Linear, Linear);
        catWalkFrames = new Sprite[3];
        catWalkFrames[0] = new Sprite(cat, 0, 0, 46, 50);       // Para cada cuadro de la animación del gato caminando
        catWalkFrames[1] = new Sprite(cat, 49, 0, 46, 50);      // indico la posición y tamaño exactos del cuadrado
        catWalkFrames[2] = new Sprite(cat, 98, 0, 46, 50);      // que engloba el sprite "x, y, ancho, alto"
        catAttackFrames = new Sprite[4];
        catAttackFrames[0] = new Sprite(cat, 0, 52, 43, 56);
        catAttackFrames[1] = new Sprite(cat, 45, 52, 43, 56);
        catAttackFrames[2] = new Sprite(cat, 91, 52, 46, 56);
        catAttackFrames[3] = new Sprite(cat, 140, 52, 46, 56);

        Texture doge = assetManager.get(DOGE_PATH, Texture.class);
        doge.setFilter(Linear, Linear);
        dogeWalkFrames = new Sprite[3];
        dogeWalkFrames[0] = new Sprite(doge, 0, 0, 50, 55);
        dogeWalkFrames[1] = new Sprite(doge, 53, 0, 50, 55);
        dogeWalkFrames[2] = new Sprite(doge, 106, 0, 50, 55);
        dogeAttackFrames = new Sprite[4];
        dogeAttackFrames[0] = new Sprite(doge, 0, 56, 50, 56);
        dogeAttackFrames[1] = new Sprite(doge, 53, 56, 50, 56);
        dogeAttackFrames[2] = new Sprite(doge, 106, 56, 50, 56);
        dogeAttackFrames[3] = new Sprite(doge, 160, 56, 50, 56);

        Texture puffs = assetManager.get(PUFF_PATH, Texture.class);
        puffFrames = new Sprite[3];
        puffFrames[0] = new Sprite(puffs, 0, 0, 26, 26);
        puffFrames[1] = new Sprite(puffs, 26, 0, 26, 26);
        puffFrames[2] = new Sprite(puffs, 52, 0, 26, 26);

        catIcon = new Sprite(assetManager.get(CAT_ICON_PATH, Texture.class));
        catIcon.getTexture().setFilter(Linear, Linear);
        catIconFrame = new Sprite(assetManager.get(CAT_ICON_FRAME_PATH, Texture.class));
        catIconFrame.getTexture().setFilter(Linear, Linear);
    }

    // Audio
    public Music getBattleTheme() {
        return battleTheme;
    }

    public Sound getAttack() {
        return attack;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    public BitmapFont getSmallPixelFont() {
        return smallPixelFont;
    }

    // Sprites
    public Sprite getBackground() {
        return background;
    }

    public Sprite getBase() {
        return base;
    }

    public Sprite[] getCatWalkFrames() {
        return catWalkFrames;
    }

    public Sprite[] getCatAttackFrames() {
        return catAttackFrames;
    }

    public Sprite[] getDogeWalkFrames() {
        return dogeWalkFrames;
    }

    public Sprite[] getDogeAttackFrames() {
        return dogeAttackFrames;
    }

    public Sprite[] getPuffFrames() {
        return puffFrames;
    }

    public Sprite getCatIcon() {
        return catIcon;
    }

    public Sprite getCatIconFrame() {
        return catIconFrame;
    }
}