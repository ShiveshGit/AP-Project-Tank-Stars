package com.mygdx.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
public class TankChooser implements Screen
{
    private BitmapFont font;
    private String myText;
    private MainGame game;
    private buttons ChooseP1_1;
    private buttons ChooseP1_2;
    private buttons ChooseP1_3;
    private buttons ChooseP2_1;
    private buttons ChooseP2_2;
    private buttons ChooseP2_3;
    private Texture Tank1;
    private Texture Tank2;
    private Texture Tank3;

    public TankChooser(MainGame game){
        this.ChooseP1_1=new buttons("Choose.png","ChooseClicked.png",300,70,50,460);
        this.ChooseP1_2=new buttons("Choose.png","ChooseClicked.png",300,70,450,460);
        this.ChooseP1_3=new buttons("Choose.png","ChooseClicked.png",300,70,850,460);
        this.ChooseP2_1=new buttons("Choose.png","ChooseClicked.png",300,70,50,10);
        this.ChooseP2_2=new buttons("Choose.png","ChooseClicked.png",300,70,450,10);
        this.ChooseP2_3=new buttons("Choose.png","ChooseClicked.png",300,70,850,10);
        this.Tank1=new Texture("Tank1.png");
        this.Tank2=new Texture("Tank2.png");
        this.Tank3=new Texture("Tank3.png");
        

        this.game=game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        int yval=game.getScreenY();
        game.batch.draw(Tank1,50,90,300,200);
        game.batch.draw(Tank2,450,90,300,200);
        game.batch.draw(Tank3,850,90,300,200);
        game.batch.draw(Tank1,50,540,300,200);
        game.batch.draw(Tank2,450,540,300,200);
        game.batch.draw(Tank3,850,540,300,200);
        
        ChooseP1_1.renderthis(game, yval);
        ChooseP1_2.renderthis(game, yval);
        ChooseP1_3.renderthis(game, yval);
        ChooseP2_1.renderthis(game, yval);
        ChooseP2_2.renderthis(game, yval);
        ChooseP2_3.renderthis(game, yval);

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