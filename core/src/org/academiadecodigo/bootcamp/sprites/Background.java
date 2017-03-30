package org.academiadecodigo.bootcamp.sprites;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.FlappyChapa;

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

        this.camera = camera;
        this.texture = new Texture("bg.png");

        this.sprite = new Sprite(texture);
        this.sprite.setSize(texture.getWidth(),texture.getHeight());
        this.sprite.setPosition(0, 0);

        this.spriteClone = new Sprite(texture);
        this.spriteClone.setSize(texture.getWidth(),texture.getHeight());
        this.spriteClone.setPosition((FlappyChapa.WIDTH +
                FlappyChapa.WIDTH/2) - 20f, 0);

    }



    public void move(float dt) {

        if (start) {

            if (camera.position.x - (camera.viewportWidth / 2) > sprite.getX() + sprite.getWidth()) {
                sprite.setPosition(camera.position.x + spriteClone.getWidth() - camera.viewportWidth, 0);
            }
            if (camera.position.x - (camera.viewportWidth / 2) > spriteClone.getX() + spriteClone.getWidth()) {
                spriteClone.setPosition(camera.position.x + spriteClone.getWidth() - camera.viewportWidth, 0);
            }

//            System.out.println("cameraX " + camera.position.x );
//            System.out.println("spriteX " + sprite.getX());
//            System.out.println("spriteCloneX " + spriteClone.getX());

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
