//Player 1
//Player 2



package com.mygdx.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
public class TankChooser implements Screen
{
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
    private int p1Tank;
    private int p2Tank;
    private BitmapFont font;
    private String text1;
    private String text2;
    private GlyphLayout layout1;
    private GlyphLayout layout2;
    private Boolean check1;
    private Boolean check2;
    private Texture Rectangle;
    private float   elapsed;
    
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
        this.text1="Player 1";
        this.text2="Player 2";
        this.font=new BitmapFont(Gdx.files.internal("TankChooserPage.fnt"));
        this.layout1=new GlyphLayout();
        this.layout2=new GlyphLayout();
        layout1.setText(font,text1);
        layout2.setText(font,text2);
        this.p1Tank=0;
        this.p2Tank=0;
        this.check1=false;
        this.check2=false;
        this.Rectangle=new Texture("Rectangle.png");
        this.elapsed=0f;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.2f,0.9f,0.9f,1);
        game.batch.begin();
        font.draw(game.batch,text1,100,850);
        font.draw(game.batch,text2,100,400);
        int yval=game.getScreenY();
        Boolean p1val1=ChooseP1_1.renderthis(game, yval);
        Boolean p1val2=ChooseP1_2.renderthis(game,yval);
        Boolean p1val3=ChooseP1_3.renderthis(game,yval);
        Boolean p2val3=ChooseP2_3.renderthis(game,yval);
        Boolean p2val1=ChooseP2_1.renderthis(game,yval);
        Boolean p2val2=ChooseP2_2.renderthis(game,yval);
        if(p1val1==true)
        {
            p1Tank=1;
            this.check1=true;
        }
        else if(p1val2==true)
        {
            p1Tank=2;
            this.check1=true;

        }
        else if(p1val3==true)
        {
            p1Tank=3;
            this.check1=true;
        }
        if(p2val1==true)
        {
            p2Tank=1;
            this.check2=true;
        }
        else if(p2val2==true)
        {
            p2Tank=2;
            this.check2=true;
        }
        else if(p2val3==true)
        {
            p2Tank=3;
            this.check2=true;
        }
        switch(p1Tank)
        {
            case 1:
                game.batch.draw(Rectangle,45,445,310,310);
                break;

            case 2:
                game.batch.draw(Rectangle,445,445,310,310);
                break;

            case 3:
                game.batch.draw(Rectangle,845,445,310,310);
                break;
        }
        switch(p2Tank)
        {
            case 1:
                  game.batch.draw(Rectangle,45,5,310,310);
                break;
            case 2:
                  game.batch.draw(Rectangle,445,5,310,310);
                break;
            case 3:
                  game.batch.draw(Rectangle,845,5,310,310);
                break;
        }
        game.batch.draw(Tank1,50,90,300,200);
        game.batch.draw(Tank2,450,90,300,200);
        game.batch.draw(Tank3,850,90,300,200);
        game.batch.draw(Tank1,50,540,300,200);
        game.batch.draw(Tank2,450,540,300,200);
        game.batch.draw(Tank3,850,540,300,200);
        if(this.check1==true && this.check2==true)
        {
            this.elapsed+=delta;
            this.dispose();
            // System.out.println("P1 Tank= "+p1Tank+"P2 Tank = "+p2Tank);
            if(this.elapsed>1.2f)
            this.game.setScreen(new TankGame(this.game,p1Tank,p2Tank));
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