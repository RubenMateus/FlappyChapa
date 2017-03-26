package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.FlappyChapa;

/**
 * Created by codecadet on 3/15/17.
 */
public class MenuState extends State {

    private Texture backGround;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyChapa.WIDTH / 2, FlappyChapa.HEIGHT / 2);
        backGround = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
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
        spriteBatch.draw(playButton, camera.position.x - playButton.getWidth() / 2, camera.position.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        backGround.dispose();
        playButton.dispose();
    }
}
