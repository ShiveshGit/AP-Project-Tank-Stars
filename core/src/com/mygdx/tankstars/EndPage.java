//Game Over!!


package com.mygdx.tankstars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
// import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
public class EndPage implements Screen
{

    private buttons restartGame;
    private buttons exit;
    private MainGame game;

    private BitmapFont font;
    private String mainText;
    private GlyphLayout layout;
    private int win;

    private Texture backImg;
    private SpriteBatch batch1;


    public EndPage(MainGame mgame,int win){
        this.game=mgame;
        this.win=win;

    }
    @Override
    public void show() 
    {
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,100);
        this.restartGame=new buttons("Restart.png","RestartClicked.png",320,160,440,460);
        // this.mainText="Game Over !!!";
        if(win==1)
        {
            this.mainText="Player-1 Wins";
        }
        else
        {
            this.mainText="Player-2 Wins";
        }
        this.font=new BitmapFont(Gdx.files.internal("MainPage.fnt"));
        this.layout=new GlyphLayout();
        layout.setText(font,mainText);
        batch1=new SpriteBatch();
        backImg=new Texture("Background.jpg");

    }
    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        batch1.begin();
        batch1.draw(backImg,0,0,1200,900);
        batch1.end();

        int yval=game.getScreenY();
        font.draw(game.batch,mainText,210,830);
        if(exit.renderthis(game, yval)==true)
        {
           System.exit(1);
        }
        if(restartGame.renderthis(game, yval)==true)
        {
            this.dispose();
            this.game.setScreen(new TankChooser(this.game));
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