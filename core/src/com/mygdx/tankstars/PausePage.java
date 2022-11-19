//Pause


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

public class PausePage implements Screen
{
    private buttons saveGame;
    private buttons resumeGame;
    private buttons exit;
    private MainGame game;
    private BitmapFont font;
    private String mainText;
    private GlyphLayout layout;
    public PausePage(MainGame game)
    {
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,40);
        this.saveGame=new buttons("SaveGame.png","SaveGameClicked.png",320,160,440,520);
        this.resumeGame=new buttons("ResumeGame.png","Resumeclicked.png",320,160,440,280);
        
        // this.resumeGame=new buttons();
        // this.exit=new buttons();
        this.game=game;
        this.mainText="Game Paused";
        this.font=new BitmapFont(Gdx.files.internal("MainPage.fnt"));
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
        ScreenUtils.clear(0.6f,0.8f,0.8f,1);
        game.batch.begin();
        font.draw(game.batch, mainText,210,835);
        int yval=game.getScreenY();
        exit.renderthis(game, yval);
        saveGame.renderthis(game, yval);
        resumeGame.renderthis(game, yval);


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