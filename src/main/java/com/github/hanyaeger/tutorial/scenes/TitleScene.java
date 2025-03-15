package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private Waterworld waterworld;

    public TitleScene(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Waterworld"
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.LIGHTBLUE);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterworldText);
        addEntity(new StartButton(new Coordinate2D(getWidth()/2, getHeight() / 2 + 100), waterworld, "Start Game"));
    }
}
