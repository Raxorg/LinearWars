package com.epicness.fundamentals.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.epicness.fundamentals.SharedConstants.PIXEL_PATH;
import static com.epicness.fundamentals.SharedConstants.SQUARE_32_INVERTED_PATH;
import static com.epicness.fundamentals.SharedConstants.SQUARE_32_PATH;
import static com.epicness.fundamentals.SharedConstants.WEIRD_SHAPE_PATH;

public class SharedAssets extends Assets {

    // Sprites
    private Sprite pixel;
    private Sprite square, squareInverted;
    private Sprite weirdShape;

    @Override
    public void queueAssetLoading() {
        assetManager.load(PIXEL_PATH, Texture.class);
        assetManager.load(SQUARE_32_PATH, Texture.class);
        assetManager.load(SQUARE_32_INVERTED_PATH, Texture.class);
        assetManager.load(WEIRD_SHAPE_PATH, Texture.class);
    }

    @Override
    public boolean loadAssets() {
        return assetManager.update();
    }

    public void finishLoading() {
        assetManager.finishLoading();
    }

    @Override
    public void initializeAssets() {
        pixel = new Sprite(assetManager.get(PIXEL_PATH, Texture.class));
        square = new Sprite(assetManager.get(SQUARE_32_PATH, Texture.class));
        squareInverted = new Sprite(assetManager.get(SQUARE_32_INVERTED_PATH, Texture.class));
        weirdShape = new Sprite(assetManager.get(WEIRD_SHAPE_PATH, Texture.class));
    }

    // Sprites
    public Sprite getPixel() {
        return pixel;
    }

    public Sprite getSquare() {
        return square;
    }

    public Sprite getSquareInverted() {
        return squareInverted;
    }

    public Sprite getWeirdShape() {
        return weirdShape;
    }
}