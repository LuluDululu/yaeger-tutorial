package com.github.hanyaeger.tutorial.entities.shark;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {

    public Sharky(Coordinate2D initialLocation) {
        super("sprites/sharky.png", initialLocation, new Size(100, 70), 1, 19);
        setAutoCycle(200, -1);
        setMotion(8, 90);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        Random randomY = new Random();
        setAnchorLocationX(0);
        setAnchorLocationY(randomY.nextDouble(getSceneHeight() - 70));
    }
}
