package org.academiadecodigo.bootcamp.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by codecadet on 3/15/17.
 */
public class GameStateManager {
    private Stack<State> states;
    private SpriteBatch spriteBatch;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch spriteBatch){
        states.peek().render(spriteBatch);
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }
}
