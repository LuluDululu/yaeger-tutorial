package com.github.hanyaeger.tutorial.entities.Bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.Hanny;
import javafx.scene.paint.Color;

import java.util.List;

public class PoisonBubble extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher, Collider {
    int speed;

    public PoisonBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        setFill(Color.DARKBLUE);
        this.speed = speed;
        setBrightness(0.3);
        setHue(0.3);
        setSaturation(0.3);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(2);  // Adjusted stroke width to be reasonable
        setMotion(4, 180);    // Set motion of the bubble
        setRadius(10);      // Use setRadius directly instead of setShape
        setVisible(true);
    }

    @Override
    public void onCollision(List<Collider> list) {
        var popSound = new SoundClip("audio/pop.mp3");
        popSound.play();

        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
