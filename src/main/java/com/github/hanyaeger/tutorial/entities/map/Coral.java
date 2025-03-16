package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.List;

public class Coral extends SpriteEntity implements Collider {
    public Coral(Coordinate2D initialLocation, Size size, String config) {
        super(config, initialLocation, size);
    }
}
