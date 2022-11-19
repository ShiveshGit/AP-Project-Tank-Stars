//Game Over!!


package com.mygdx;

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

    public EndPage(MainGame mgame){
        this.exit=new buttons("Exit.png","Exitclicked.png",320,160,440,100);
        this.restartGame=new buttons("Restart.png","RestartClicked.png",320,160,440,460);
        this.game=mgame;
        this.mainText="Game Over !!!";
        this.font=new BitmapFont(Gdx.files.internal("MainPage.fnt"));
        this.layout=new GlyphLayout();
        layout.setText(font,mainText);
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
        font.draw(game.batch,mainText,210,830);
        exit.renderthis(game, yval);
        restartGame.renderthis(game, yval);

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