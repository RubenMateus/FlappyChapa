package org.academiadecodigo.bootcamp.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by codecadet on 3/15/17.
 */
public class Tube {
    private Texture topTube;
    private Texture bottomTube;
    private Vector2 posTopTube;
    private Vector2 posBotTube;
//    private Ran random;

    public Tube(float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
    }

    public void update(float dt){

    }
}
