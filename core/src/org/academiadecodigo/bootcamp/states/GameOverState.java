package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.academiadecodigo.bootcamp.FlappyChapa;
import org.academiadecodigo.bootcamp.sprites.Animation;

/**
 * Created by Ruben on 25/03/2017.
 */
public class GameOverState extends State {

    private Texture backGround;
    private Texture gameOver;
    private Texture chapaTriggered;
    private Texture texture;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyChapa.WIDTH / 2, FlappyChapa.HEIGHT / 2);
        backGround = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
        chapaTriggered = new Texture("chapaTriggered.png");
        texture = new Texture("chapaicon.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        spriteBatch.draw(backGround, 0, 0);
        spriteBatch.draw(gameOver, camera.position.x - gameOver.getWidth() / 2, camera.position.y);
        spriteBatch.draw(chapaTriggered, camera.position.x - chapaTriggered.getWidth() / 2, camera.position.y / 1.5f);
        spriteBatch.draw(texture, camera.position.x - texture.getWidth() / 2, camera.position.y + 60);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        backGround.dispose();
        gameOver.dispose();
    }
}
