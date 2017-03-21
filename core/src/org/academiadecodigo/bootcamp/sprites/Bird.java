package org.academiadecodigo.bootcamp.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by codecadet on 3/15/17.
 */
public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle bounds;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");

        bounds = new Rectangle(x,y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt) {
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);

        position.add(MOVEMENT * dt, velocity.y, 0);
        velocity.scl(1 / dt);
        bounds.setPosition(position.x,position.y);

        if (position.y < 0) {
            position.y = 0;
        }
    }

    public void jump() {
        velocity.y = 350;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }
}
