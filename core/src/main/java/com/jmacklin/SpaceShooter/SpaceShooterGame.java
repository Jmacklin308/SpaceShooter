package com.jmacklin.SpaceShooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SpaceShooterGame extends Game
{
    //Create our game screen
    GameScreen gameScreen;

    @Override
    public void create()
    {
        gameScreen = new GameScreen(); // create our game screen object from our class
        setScreen(gameScreen);
    }

    @Override
    public void resize(int width, int height) // For desktop usage
    {
        gameScreen.resize(width, height);
    }

    @Override
    public void render() //Draw it out
    {
        super.render();
    }

    @Override
    public void dispose() //Clean it up
    {
        gameScreen.dispose();
    }

}