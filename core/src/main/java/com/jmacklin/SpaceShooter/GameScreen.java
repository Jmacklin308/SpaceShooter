package com.jmacklin.SpaceShooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.w3c.dom.Text;
import sun.security.x509.OtherName;

public class GameScreen implements Screen{

    //screen
    private Camera camera;
    private Viewport viewport;


    //graphics
    private final SpriteBatch batch;
    private Texture[] backgrounds;

    //timing & movement
    //private int backgroundOffset = 0;
    private float[] backgroundOffsets = {0,0,0,0};
    private float backgroundMaxScrollSpeed;


    //world params
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;


    //game screen constructor
    GameScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT,camera);


        //Setup our background images
        backgrounds = new Texture[4]; // create a new array of textures that holds 4
        backgrounds[0] = new Texture("StarScape00.png");
        backgrounds[1] = new Texture("StarScape01.png");
        backgrounds[2] = new Texture("StarScape02.png");
        backgrounds[3] = new Texture("StarScape03.png");


        //setup scrolling speed
        backgroundMaxScrollSpeed = (float)(WORLD_HEIGHT / 4); //every quarter of the screen heigh is 1 sec


        //list of images of sorts
        batch = new SpriteBatch();
    }


    @Override
    public void render(float delta)
    {
        //region start/end drawing batch
        batch.begin();
            renderBackground(delta);
        batch.end();
        //endregion ----------------------------------------
    }

    private void renderBackground(float delta)
    {
        //Set the speed
        backgroundOffsets[0] += delta * backgroundMaxScrollSpeed / 8; // make far background 1/8 speed
        backgroundOffsets[1] += delta * backgroundMaxScrollSpeed / 4;
        backgroundOffsets[2] += delta * backgroundMaxScrollSpeed / 2;
        backgroundOffsets[3] += delta * backgroundMaxScrollSpeed;

        //draw each layer with their speeds each frame
        for (int layer = 0; layer < backgroundOffsets.length; layer++)
        {
            if (backgroundOffsets[layer] > WORLD_HEIGHT)
            {
                backgroundOffsets[layer] = 0;
            }
            //draw the layers
            batch.draw(backgrounds[layer],0,-backgroundOffsets[layer], WORLD_WIDTH, WORLD_HEIGHT);
            batch.draw(backgrounds[layer],0,-backgroundOffsets[layer] + WORLD_HEIGHT, WORLD_WIDTH, WORLD_HEIGHT);
        }
    }


    @Override
    public void resize(int width, int height)
    {
        //Runs at the beginning of the application
        viewport.update(width, height,true);
        batch.setProjectionMatrix(camera.combined);

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }


    @Override
    public void show()
    {

    }
}
