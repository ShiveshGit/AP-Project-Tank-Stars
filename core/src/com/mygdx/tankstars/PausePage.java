//Pause


/*
Tank Stars Heading =>180
Every button => 240*3 (for 3 buttons)
After removing padding => 180
Height=> 180
Width => 360
*/
package com.mygdx.tankstars;

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
    // private buttons Back;
    private buttons exit;
    private MainGame game;
    private BitmapFont font;
    private String mainText;
    private GlyphLayout layout;
    private float elapsed;
    private boolean flag;
    private Texture backImg;
    private SpriteBatch batch1;

    public PausePage(MainGame game)
    {
        this.game=game;
    }
    @Override
    public void show()
    {
        // TODO Auto-generated method stub
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,40);
        this.saveGame=new buttons("SaveGame.png","SaveGameClicked.png",320,160,440,520);
        this.resumeGame=new buttons("ResumeGame.png","Resumeclicked.png",320,160,440,280);
        // this.Back=new buttons("Back.png","BackClicked.png",100,50,1050,10);
        // this.resumeGame=new buttons();
        // this.exit=new buttons();
        this.mainText="Game Paused";
        this.font=new BitmapFont(Gdx.files.internal("MainPage.fnt"));
        this.layout=new GlyphLayout();
        layout.setText(font,mainText);
        batch1=new SpriteBatch();
        backImg=new Texture("Background.jpg");
        this.elapsed=0.0f;
        flag=false;

    }

    @Override
    public void render(float delta) 
    {
        // TODO Auto-generated method stub
        // System.out.println("Main Page should show");
        ScreenUtils.clear(0.6f,0.8f,0.8f,1);
        game.batch.begin();
        batch1.begin();
        batch1.draw(backImg,0,0,1200,900);
        batch1.end();
        font.draw(game.batch, mainText,210,835);
        int yval=game.getScreenY();
        if(exit.renderthis(game, yval)==true)
        {
            flag=true;

            // this.game.create();
        }
        if(saveGame.renderthis(game, yval)==true)
        {
            this.dispose();
            this.game.setScreen(new SavePage(this.game));
        }
        if(resumeGame.renderthis(game, yval)==true)
        {
            this.dispose();
            // to be added
            // this.game.setScreen(new SavePage());
        }
        game.batch.end();
        if(flag)
        {       
            this.elapsed+=delta;
            System.out.println(elapsed);
            if(this.elapsed>0.5f)
            {
                this.dispose();
                this.game.setScreen(new MainPage(game));
            }
        }
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