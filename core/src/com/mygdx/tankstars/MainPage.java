/*
Tank Stars Heading =>180
Every button => 240*3 (for 3 buttons)
After removing padding => 180
Height=> 180
Width => 360
*/
package com.mygdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainPage implements Screen
{
    private buttons newGame;
    private buttons resumeGame;
    private buttons exit;
    private MainGame game;

    private BitmapFont font;

    private String mainText;

    private GlyphLayout layout;

    public MainPage(MainGame game)
    {
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,40);
        this.newGame=new buttons("Playgame.png","Playclicked.png",320,160,440,520);
        this.resumeGame=new buttons("ResumeGame.png","Resumeclicked.png",320,160,440,280);
        
        // this.resumeGame=new buttons();
        // this.exit=new buttons();
        this.game=game;
        System.out.println("Main Page created");
        this.font=new BitmapFont(Gdx.files.internal("MainPageFont.fnt"));
        this.mainText="Tank Stars";
        this.layout=new GlyphLayout();
        layout.setText(font,mainText);

    }
    @Override
    public void show()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(float delta) 
    {
        // TODO Auto-generated method stub
        // System.out.println("Main Page should show");
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        font.draw(game.batch, mainText,360,830);
        font.getData().setScale(1.3f);
        int yval=game.getScreenY();
        if(Gdx.input.getX()>=440 && Gdx.input.getX()<=760 && Gdx.input.getY()<=(yval-40) && Gdx.input.getY()>=(yval-200))
        {
            // Get the clicked variant
            game.batch.draw(exit.getClickedTexture(),exit.getXCoord(),exit.getYCoord(),exit.getLength(),exit.getHeight());
        }
        else
        {
            // Get Unclicked variant
            game.batch.draw(exit.getTexture(),exit.getXCoord(),exit.getYCoord(),exit.getLength(),exit.getHeight());

        }
        if(Gdx.input.getX()>=440 && Gdx.input.getX()<=760 && Gdx.input.getY()<=(yval-520) && Gdx.input.getY()>=(yval-680))
        {
            game.batch.draw(newGame.getClickedTexture(),newGame.getXCoord(),newGame.getYCoord(),newGame.getLength(),newGame.getHeight());
        }
        else
        {
            game.batch.draw(newGame.getTexture(),newGame.getXCoord(),newGame.getYCoord(),newGame.getLength(),newGame.getHeight());
            
        }
        if(Gdx.input.getX()>=440 && Gdx.input.getX()<=760 && Gdx.input.getY()<=(yval-280) && Gdx.input.getY()>=(yval-440))
        {
            game.batch.draw(resumeGame.getClickedTexture(),resumeGame.getXCoord(),resumeGame.getYCoord(),resumeGame.getLength(),resumeGame.getHeight());
        
        }
        else
        {
            game.batch.draw(resumeGame.getTexture(),resumeGame.getXCoord(),resumeGame.getYCoord(),resumeGame.getLength(),resumeGame.getHeight());
        
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
    
}
