package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.FlappyChapa;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

/**
 * Created by codecadet on 3/15/17.
 */
public class PlayState extends State {
    //Constants
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;

    private Bird bird;
    private Background backGround;
    private Texture ground;
    private Vector2 groundPos1;
    private Vector2 groundPos2;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, FlappyChapa.WIDTH / 2, FlappyChapa.HEIGHT / 2);
        Texture texture = new Texture("bg.png");
        backGround = new Background(camera);
        ground = new Texture("ground.png");
//        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
//        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);
        tubes = new Array<Tube>();
        for (int i = 0; i < TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
//        updateGround();
        bird.update(dt);

        camera.position.x = bird.getPosition().x + 80;

        backGround.move(dt);
        backGround.start();

        for (int i = 0; i < tubes.size; i++) {
            Tube tube = tubes.get(i);

            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if (tube.collides(bird.getBounds())) {
                gsm.set(new GameOverState(gsm));
            }
        }

//        if(bird.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET){
//            gsm.set(new GameOverState(gsm));
//        }

        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        //spriteBatch.draw(backGround, camera.position.x - (camera.viewportWidth / 2), 0);
        backGround.render(spriteBatch);
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);

        for (Tube tube : tubes) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

//        spriteBatch.draw(ground, groundPos1.x, groundPos1.y);
//        spriteBatch.draw(ground, groundPos2.x, groundPos2.y);

        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backGround.dispose();
        bird.dispose();
        ground.dispose();

        for (Tube tube : tubes) {
            tube.dispose();
        }
    }

    private void updateGround() {
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth()) {
            groundPos1.add(ground.getWidth() * 2, 0);
        }
        if (camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth()) {
            groundPos2.add(ground.getWidth() * 2, 0);
        }
    }
}

