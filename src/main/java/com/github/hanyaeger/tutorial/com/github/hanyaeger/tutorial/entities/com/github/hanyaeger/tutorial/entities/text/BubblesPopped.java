package com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;


public class BubblesPopped extends TextEntity {

    public BubblesPopped(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKBLUE);
    }

    public void setBubblesPopped(int bubblesPopped) {
        setText("Bubbles Popped: " + bubblesPopped);
    }
}
