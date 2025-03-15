package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public SwordFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(15, 270);
    }

    @Override
    protected void setupEntities() {
        var swordfishSprite = new SwordfishSprite(new Coordinate2D(getWidth(), getHeight()/2));
        var hitbox = new HitBox(new Coordinate2D(0, 38));
        addEntity(swordfishSprite);
        addEntity(hitbox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        Random randomY = new Random();
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(randomY.nextDouble(getSceneHeight()- 50));
    }
}

