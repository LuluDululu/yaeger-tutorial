package com.github.hanyaeger.tutorial.entities.Bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.checkerframework.checker.units.qual.C;

import java.util.Random;


public class BubbleSpawner extends EntitySpawner {

        private final double sceneWidth;
        private final double sceneHeight;

        public BubbleSpawner(double sceneWidth, double sceneHeight) {
            super(450);
            this.sceneWidth = sceneWidth;
            this.sceneHeight = sceneHeight;
        }

    @Override
    protected void spawnEntities(){
        if(new Random().nextInt(10) < 4){
            spawn(new PoisonBubble(randomLocation(), 2));
        } else {
            spawn(new AirBubble(randomLocation(), 2));
        }
    }

        private Coordinate2D randomLocation() {
            double x = new Random().nextInt((int) sceneWidth);
            return new Coordinate2D(x, sceneHeight);
        }
    }


