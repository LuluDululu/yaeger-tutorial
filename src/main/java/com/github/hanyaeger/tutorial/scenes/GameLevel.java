package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.*;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text.BubblesPopped;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.Bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.Bubble.BubbleSpawner;
import com.github.hanyaeger.tutorial.entities.Bubble.PoisonBubble;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.shark.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;
import org.checkerframework.checker.units.qual.C;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
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
        var bubblesPopped = new BubblesPopped(new Coordinate2D(450, 20));
        addEntity(bubblesPopped);
        var hanny = new Hanny(new Coordinate2D(20, 40), healthText, waterworld, bubblesPopped);
        addEntity(hanny);
        var sharky = new Sharky(new Coordinate2D(0, getHeight() - 50));
        addEntity(sharky);

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(800, 600));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());
    }
}
