/*
Tank Stars Heading =>180
Every button => 240*3 (for 3 buttons)
After removing padding => 180
Height=> 180
Width => 360
*/
package com.mygdx.tankstars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainPage implements Screen
{
    private buttons newGame;
    private buttons resumeGame;
    private buttons exit;
    private Sprite newSprite;
    private Sprite resumeSprite;
    private Sprite exitSprite;
    private Texture newGameTexture;
    private Texture resumeGameTexture;
    private Texture exitGameTexture;
    public MainPage()
    {
        this.newGame=new buttons();
        this.loadGame=new buttons();
        this.exit=new buttons();
        this.sprite=new Sprite();

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
        ScreenUtils.clear(0,0,0,1);

        
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