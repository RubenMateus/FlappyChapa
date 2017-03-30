package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.bootcamp.FlappyChapa;
import org.academiadecodigo.bootcamp.sprites.*;

/**
 * Created by codecadet on 3/15/17.
 */
public class PlayState extends State {
    //Constants
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;

    private Chapa chapa;
    private org.academiadecodigo.bootcamp.sprites.Background backGround;
    private Texture ground;
    private Vector2 groundPos1;
    private Vector2 groundPos2;

    Label scoreLabel;
    private int score;
    private Table table;
    private long startTime;

    private Array<Tube> tubes;
    private Anto anto;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        score = 0;
        chapa = new Chapa(50, 300);
        camera.setToOrtho(false, FlappyChapa.WIDTH / 2, FlappyChapa.HEIGHT / 2);
        Texture texture = new Texture("bg.png");
        backGround = new org.academiadecodigo.bootcamp.sprites.Background(camera);
        backGround.start();
        ground = new Texture("ground.png");
        /*table = new Table();
        table.setPosition(camera.position.x,camera.position.y);
        //table.setBounds(camera.position.x,camera.position.y,camera.viewportWidth,camera.viewportHeight/10);
        table.setFillParent(true);*/
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel.setPosition(camera.position.x,0);
        startTime = TimeUtils.nanoTime();
        anto = new Anto(camera);
        anto.repositionAnto(camera.position.x,camera.position.y);
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
            chapa.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
//        updateGround();
        chapa.update(dt);

        camera.position.x = chapa.getPosition().x + 80;

        if (TimeUtils.timeSinceNanos(startTime) > 1500000000) {
            score++;

            startTime = TimeUtils.nanoTime();
        }

        backGround.move(dt);

        int random = (int)Math.floor(Math.random()*10)+1;
        System.out.println(random);

        for (int i = 0; i < tubes.size; i++) {
            Tube tube = tubes.get(i);

            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if (tube.collides(chapa.getBounds())) {
                score = 0;
                gsm.set(new GameOverState(gsm));
            }

        }

//        if(chapa.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET){
//            gsm.set(new GameOverState(gsm));
//        }
        scoreLabel.setPosition(camera.position.x-20,camera.viewportHeight-15);
        scoreLabel.setText(String.format("%06d", score));
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        //spriteBatch.draw(backGround, camera.position.x - (camera.viewportWidth / 2), 0);
        backGround.render(spriteBatch);

        spriteBatch.draw(chapa.getTexture(), chapa.getPosition().x, chapa.getPosition().y);

        for (Tube tube : tubes) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        anto.render(spriteBatch);
//        spriteBatch.draw(ground, groundPos1.x, groundPos1.y);
//        spriteBatch.draw(ground, groundPos2.x, groundPos2.y);

        //table.draw(spriteBatch,1f);
        scoreLabel.draw(spriteBatch,1);
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        backGround.dispose();
        chapa.dispose();
        ground.dispose();
        scoreLabel.remove();
        anto.dispose();

        for (Tube tube : tubes) {
            tube.dispose();
        }
    }

}

