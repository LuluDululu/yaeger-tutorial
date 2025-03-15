package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.*;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.Bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.shark.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;

public class GameLevel extends DynamicScene {
    Waterworld waterworld;

    public GameLevel(Waterworld waterworld){
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var swordFish = new SwordFish(new Coordinate2D(getWidth(), getHeight() / 2));
        addEntity(swordFish);
        var healthText = new HealthText(new Coordinate2D(40, 20));
        addEntity(healthText);
        var hanny = new Hanny(new Coordinate2D(20, 40), healthText, waterworld);
        addEntity(hanny);
        var sharky = new Sharky(new Coordinate2D(0, getHeight() - 50));
        addEntity(sharky);
        var bubble = new AirBubble(new Coordinate2D(150, 300), 4);
        addEntity(bubble);
    }
}
