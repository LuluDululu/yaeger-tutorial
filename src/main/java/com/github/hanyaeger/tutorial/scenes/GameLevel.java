package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.SwordFish;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var swordFish = new SwordFish(new Coordinate2D(getWidth(), getHeight() / 2));
        addEntity(swordFish);
        var hanny = new Hanny(new Coordinate2D(20, 40));
        addEntity(hanny);
    }
}
