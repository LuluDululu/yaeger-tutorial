package com.github.hanyaeger.tutorial.entities.Bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class AirBubble extends DynamicCircleEntity implements Collided {
    int speed;

    public AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        setFill(Color.DARKBLUE);
        this.speed = speed;
        setBrightness(1);
        setHue(1);
        setSaturation(1);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(5);  // Adjusted stroke width to be reasonable
        setMotion(4, 180);    // Set motion of the bubble
        setRadius(10);      // Use setRadius directly instead of setShape
        setVisible(true);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
