//Load Game


package com.mygdx.tankstars;

import com.badlogic.gdx.Screen;

public class LoadPage implements Screen {
    private buttons Game1;
    private buttons Game2;
    private buttons Game3;
    private buttons Game4;
    private buttons Game5;
    private MainGame game;

    public LoadPage(MainGame game){
        this.Game1=new buttons("Game1.png","Game1Clicked.png", 300, 100, 100, 598);
        this.Game2=new buttons("Game2.png","Game2Clicked.png", 300, 100, 100, 454);
        this.Game3=new buttons("Game3.png","Game3Clicked.png", 300, 100, 100, 310);
        this.Game4=new buttons("Game4.png","Game4Clicked.png", 300, 100, 100, 160);
        this.Game5=new buttons("Game5.png","Game5Clicked.png", 300, 100, 100, 22);
        this.game=game;
        
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
