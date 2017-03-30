package org.academiadecodigo.bootcamp;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by rute_ on 30/03/2017.
 */
public class Hud {

    public Stage stage;
    private Viewport viewport;

    private Integer score;
    private int counter;

    private Label scoreLabel;
    private Label scoreTextLabel;

    public Hud(SpriteBatch sb) {

        score = 0;

        viewport = new FitViewport(FlappyChapa.WIDTH/2, FlappyChapa.HEIGHT/2, new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreTextLabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(scoreTextLabel);
        table.add(scoreLabel);

        stage.addActor(table);    }

    public void addScore(int value) {
        counter++;

        if(counter % 60 == 0) {
            score += value;
            scoreLabel.setText(String.format("%06d", score));
        }
    }

}
