package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HP implements Slider{
    private Texture fill;
    private Texture empty;
    private int Xcoord;
    private int Ycoord;
    private float length;
    private float height;
    private float fillPercent;


    HP(){
        this.fill=new Texture("HP_fill.png");
        this.empty=new Texture("HP_empty.png");
        this.Ycoord=12;
        this.length=3f;
        this.height=0.5f;
        this.fillPercent=100;
    }

    HP(Boolean player){
        this.fill=new Texture("HP_fill.png");
        this.empty=new Texture("HP_empty.png");
        this.Ycoord=12;
        this.length=3f;
        this.height=0.5f;
        this.fillPercent=100;
        if(player){
            this.Xcoord=-5;
        }
        else{
            this.Xcoord=5;
        }
    }

    @Override
    public void renderthis(SpriteBatch batch){

        batch.draw(empty,Xcoord,Ycoord,length,height);
        batch.draw(fill,Xcoord,Ycoord,(float)(length*(fillPercent/100.0)),height);

    }
    @Override
    public float decrease(float damage)
    {
        this.fillPercent-=damage;
        if(fillPercent>100){
            this.fillPercent=100;
        }
        else if(fillPercent<0){
            this.fillPercent=0;
        }
        return this.fillPercent;
    }
    @Override
    public float increase(float damage)
    {
        this.fillPercent+=damage;
        if(fillPercent>100){
            this.fillPercent=100;
        }
        else if(fillPercent<0){
            this.fillPercent=0;
        }
        return this.fillPercent;
    }
    public float getHealth()
    {
        return this.fillPercent;
    }
}
