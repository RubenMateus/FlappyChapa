package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.FlappyBird;

/**
 * Created by codecadet on 3/15/17.
 */
public class MenuState extends State {

    private Texture backGround;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
        backGround = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
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
        System.out.println("MenuState disposed");
    }
}
