package com.mygdx.tankstars;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class TankGame implements Screen,Serializable{
    private Ground ground;
    private MainGame game;
    private Player p1;
    private Player p2;
    private	ShapeRenderer shapeRenderer;
    private Texture backImg;
    private SpriteBatch batch1;
    
    TankGame(MainGame game,int player1tank,int player2tank){
        this.ground = new Ground();
        this.game=game;
        this.p1=new Player(ground,player1tank,true);
        this.p2=new Player(ground,player2tank,false);
        this.shapeRenderer=new ShapeRenderer();

        batch1=new SpriteBatch();
        backImg=new Texture("Background.jpg");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.2f,0.6f,0.6f,1);
        game.batch.begin();
        batch1.begin();
        batch1.draw(backImg,0,200,1200,900);
        batch1.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BROWN);

        shapeRenderer.rect(0,0,1200,300); // Creates a filled rectangle of white color

        // ground.createGround();
        p1.drawHP(game);
        p2.drawHP(game);
        p1.drawTank(game);        
        p2.drawTank(game);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            this.dispose();
            this.game.setScreen(new PausePage(game));
        }
        game.batch.end();
        shapeRenderer.end();
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
