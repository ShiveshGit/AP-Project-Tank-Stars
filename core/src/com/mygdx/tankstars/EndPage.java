package com.mygdx.tankstars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
// import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
public class EndPage implements Screen
{

    private buttons restartGame;
    private buttons exit;
    private MainGame game;

    public EndPage(MainGame mgame){
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,100);
        this.restartGame=new buttons("Restart.png","RestartClicked.png",320,160,440,460);
        this.game=mgame;
    }
    @Override
    public void show() 
    {

    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        int yval=game.getScreenY();
        if(Gdx.input.getX()>=440 && Gdx.input.getX()<=760 && Gdx.input.getY()<=yval-100 && Gdx.input.getY()>=yval-260)
        {
            game.batch.draw(exit.getClickedTexture(),exit.getXCoord(),exit.getYCoord(),exit.getLength(),exit.getHeight());
        }
        else
        {
            game.batch.draw(exit.getTexture(),exit.getXCoord(),exit.getYCoord(),exit.getLength(),exit.getHeight());
        }
        if(Gdx.input.getX()>=440 && Gdx.input.getX()<=760 && Gdx.input.getY()<=yval-460 && Gdx.input.getY()>=yval-620)
        {
            game.batch.draw(restartGame.getClickedTexture(),restartGame.getXCoord(),restartGame.getYCoord(),restartGame.getLength(),restartGame.getHeight());
        }
        else
        {
            game.batch.draw(restartGame.getTexture(),restartGame.getXCoord(),restartGame.getYCoord(),restartGame.getLength(),restartGame.getHeight());
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}