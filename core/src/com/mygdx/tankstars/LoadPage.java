//Load Game


package com.mygdx.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoadPage implements Screen {
    private buttons Game1;
    private buttons Game2;
    private buttons Game3;
    private buttons Game4;
    private buttons Game5;
    private buttons Back;
    private MainGame game;

    private BitmapFont font;
    private GlyphLayout layout;

    private String text;

    private BitmapFont mainFont;

    private GlyphLayout mainLayout;

    private String mainText;

    public LoadPage(MainGame game){
        this.Game1=new buttons("Game1.png","Game1Clicked.png", 300, 100, 100, 598);
        this.Game2=new buttons("Game2.png","Game2Clicked.png", 300, 100, 100, 454);
        this.Game3=new buttons("Game3.png","Game3Clicked.png", 300, 100, 100, 310);
        this.Game4=new buttons("Game4.png","Game4Clicked.png", 300, 100, 100, 160);
        this.Game5=new buttons("Game5.png","Game5Clicked.png", 300, 100, 100, 22);
        this.Back=new buttons("Back.png","BackClicked.png",100,50,1050,10);
        this.game=game;
        this.text="Last Saved:\nDD-MM-YYYY Hrs:Sec\n(Functionality will be added afterwards)";
        this.mainText="Load Game";
        this.mainFont=new BitmapFont(Gdx.files.internal("MainPage.fnt"));
        this.font=new BitmapFont(Gdx.files.internal("SavePage.fnt"));
        this.mainLayout=new GlyphLayout();
        this.layout=new GlyphLayout();
        mainLayout.setText(mainFont,mainText);
        layout.setText(font,text);
        
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        mainFont.draw(game.batch,mainText,210,870);
        font.draw(game.batch,text,500,688);
        font.draw(game.batch,text,500,544);
        font.draw(game.batch,text,500,400);
        font.draw(game.batch,text,500,256);
        font.draw(game.batch,text,500,112);
        int yval=game.getScreenY();
        Game1.renderthis(game, yval);
        Game2.renderthis(game, yval);
        Game3.renderthis(game, yval);
        Game4.renderthis(game, yval);
        Game5.renderthis(game, yval);
        if(Back.renderthis(game, yval)==true){
            this.dispose();
            this.game.setScreen(new MainPage(this.game));
            
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
