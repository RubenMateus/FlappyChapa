package org.academiadecodigo.bootcamp.sprites;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by rute_ on 30/03/2017.
 */
public class Anto {

    private Sprite sprite;
    private Texture texture;

    private OrthographicCamera camera;
    private Rectangle boundsTop;
    boolean showUp;

    public Anto(OrthographicCamera camera){

        this.camera = camera;
        this.texture = new Texture("Antoninho.png");
        this.showUp = false;
        this.sprite = new Sprite(texture);
        this.sprite.setSize(camera.viewportWidth/2,texture.getHeight()/2);
        this.sprite.setPosition(0, 0);
        boundsTop = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }

    public void spawnAnto(int x,int y, Texture texture){
        this.texture = texture;
        this.showUp = true;
        this.sprite = new Sprite(texture);
        this.sprite.setSize(camera.viewportWidth/2,texture.getHeight()/2);
        this.sprite.setPosition(x, y);

    }

    public boolean collides(Rectangle bird){

        if(bird.overlaps(boundsTop)){
            return true;
        }

        return false;
    }

    public void repositionAnto(float x, float y){
        this.showUp=true;
        this.sprite.setPosition(x,y);
        boundsTop.setPosition(x,y);
    }

    public void render(SpriteBatch batch) {

        this.sprite.draw(batch);

    }


    public void dispose() {

        this.sprite.getTexture().dispose();

    }
}
