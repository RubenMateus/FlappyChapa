package org.academiadecodigo.bootcamp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.states.GameStateManager;
import org.academiadecodigo.bootcamp.states.MenuState;

public class FlappyChapa extends ApplicationAdapter {

    //THIS SHOULD GO TO CONSTANTS
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Flappy Chapa";

    private GameStateManager gsm;
    private SpriteBatch batch;
    private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
		initMusic();
        gsm.push(new MenuState(gsm));
	}

	private void initMusic() {
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}
