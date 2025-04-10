package com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text.BubblesPopped;
import com.github.hanyaeger.tutorial.com.github.hanyaeger.tutorial.entities.com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.Bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.Bubble.PoisonBubble;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.tutorial.*;
import org.checkerframework.checker.units.qual.Speed;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {

    private HealthText healthText;
    private int health = 5;
    private BubblesPopped bubblesPoppedText;
    private int bubblesPopped = 0;


    private Waterworld waterworld;


    public Hanny(Coordinate2D location, HealthText healthText, Waterworld waterworld, BubblesPopped bubblesPoppedText) {
        super("sprites/hanny.png", location, new Size(20, 40), 1, 2);
        this.healthText = healthText;
        healthText.setHealthText(health);
        this.waterworld = waterworld;
        this.bubblesPoppedText = bubblesPoppedText;
        bubblesPoppedText.setBubblesPopped(bubblesPopped);


    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, 0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var airBubbleCollision = false;
        var enemyCollision = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof AirBubble) {
                airBubbleCollision = true;
            } else if(collider instanceof Coral) {
                setMotion(0, 0);
            }

            else {
                enemyCollision = true;
            }
        }

        if (airBubbleCollision) {
            bubblesPoppedText.setText("Bubbles popped: " + String.valueOf(++bubblesPopped));
        }
        if (enemyCollision) {
            healthText.setText("Health: " + String.valueOf(--health));

            if (health == 0) {
                this.waterworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight()))));
            }
        }
    }
}
