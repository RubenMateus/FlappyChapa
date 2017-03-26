package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.FlappyChapa;

/**
 * Created by Ruben on 25/03/2017.
 */
public class GameOverState extends State {

    private Texture backGround;
    private Texture gameOver;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyChapa.WIDTH / 2, FlappyChapa.HEIGHT / 2);
        backGround = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
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
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        backGround.dispose();
        gameOver.dispose();
    }
}
