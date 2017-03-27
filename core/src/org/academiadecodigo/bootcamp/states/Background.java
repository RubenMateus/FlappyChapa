package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyChapa;

/**
 * Created by codecadet on 3/16/17.
 */
public class Background {

    private static float DIGIT_WIDTH = 0.1f;
    private static float DIGIT_HEIGHT = 0.1f;

    private static float DIGIT_Y = 0;
    private static float DIGIT_X = 0;

    private Sprite sprite;
    private Sprite spriteClone;
    private Texture texture;

    private OrthographicCamera camera;

//    private float cameraWidth;
//    private float cameraHeight;
    private boolean start;


    private int score;

    public Background(OrthographicCamera camera) {

        score = 0;

        this.camera = camera;
        this.texture = new Texture("bg.png");

        this.sprite = new Sprite(texture);
        this.sprite.setSize(texture.getWidth(),texture.getHeight());
        this.sprite.setPosition(0, 0);

        this.spriteClone = new Sprite(texture);
        this.spriteClone.setSize(texture.getWidth(),texture.getHeight());
        this.spriteClone.setPosition((FlappyChapa.WIDTH +
                FlappyChapa.WIDTH/2) - 15f, 0);

    }



    public void move(float dt) {

        if (start) {
            score++;

            if (camera.position.x - (camera.viewportWidth / 2) > sprite.getX() + sprite.getWidth()) {
                sprite.setPosition(sprite.getWidth() * 2, 0);
            }
            if (camera.position.x - (camera.viewportWidth / 2) > spriteClone.getX() + spriteClone.getWidth()) {
                spriteClone.setPosition(spriteClone.getWidth() * 2, 0);
            }


//            if (this.sprite.getY() < 0) {
//
//                if (this.spriteClone.getY() + this.spriteClone.getHeight() > cameraHeight) {
//
//                    this.spriteClone.translate(0, dt / DELAY);
//
//                }
//
//                this.sprite.translate(0, dt / DELAY);
//
//                if ((this.spriteClone.getY() + this.spriteClone.getHeight()) >= cameraHeight && this.sprite.getY() >= 0) {
//                    this.spriteClone.setPosition(0, (-cameraHeight * 2) + 0.05f);
//                }
//
//
//            } else if (this.spriteClone.getY() <= 0) {
//                if (this.sprite.getY() + this.sprite.getHeight() >= cameraHeight) {
//
//                    this.sprite.translate(0, dt / DELAY);
//
//                }
//
//                this.spriteClone.translate(0, dt / DELAY);
//
//                if ((this.sprite.getY() + this.sprite.getHeight()) > cameraHeight && this.spriteClone.getY() > 0) {
//                    this.sprite.setPosition(0, (-cameraHeight * 2) + 0.05f);
//                }
//            }
       }
    }


    public void render(SpriteBatch batch) {

        this.sprite.draw(batch);
        this.spriteClone.draw(batch);

    }

    public void start() {
        this.start = true;
    }

    public void stop() {
        this.start = false;
    }

    public void dispose() {

        this.sprite.getTexture().dispose();
        this.spriteClone.getTexture().dispose();

    }


}
