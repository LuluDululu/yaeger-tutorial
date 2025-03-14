package com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SwordFish extends DynamicSpriteEntity {
    protected SwordFish(Coordinate2D location) {
        super("sprites/swordfish.png", location);
    }
}
