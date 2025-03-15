package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.QuitButton;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.StartButton;
import com.github.hanyaeger.api.YaegerGame;

public class GameOverScene extends StaticScene {

    Waterworld waterworld;

    public GameOverScene(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
        setBackgroundAudio("audio/ocean.mp3");
    }

    @Override
    public void setupEntities() {
        var newStartButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), waterworld, "Play Again");
        addEntity(newStartButton);
        addEntity(new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50), "Quit Game", waterworld));
    }
}
