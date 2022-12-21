package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Shape;

public class Power implements Slider
{
    private Texture fill;
    private Texture empty;
    private int Xcoord;
    private int Ycoord;
    private float length;
    private float height;
    private float fillPercent;
   
    Power()
    {
        this.fill=new Texture("HP_fill.png");
        this.empty=new Texture("HP_empty.png");
        this.Ycoord=-11;
        this.length=7f;
        this.height=1.8f;
        this.fillPercent=100;
    }
    Power(Boolean player)
    {
        this.fill=new Texture("HP_fill.png");
        this.empty=new Texture("HP_empty.png");
        this.Ycoord=-11;
        this.length=7f;
        this.height=1.8f;
        this.fillPercent=100;
        if(player){
            this.Xcoord=-15;
        }
        else{
            this.Xcoord=8;
        } 
    }
    @Override
    public float decrease(float amt)
    {
        this.fillPercent-=amt;
        if(fillPercent>100){
            this.fillPercent=100;
        }
        else if(fillPercent<0){
            this.fillPercent=0;
        }
        return this.fillPercent;
    }
    @Override
    public float increase(float amt)
    {
        this.fillPercent+=amt;
        if(fillPercent>100){
            this.fillPercent=100;
        }
        else if(fillPercent<0){
            this.fillPercent=0;
        }
        return this.fillPercent;
    }
    @Override
    public void renderthis(SpriteBatch batch)
    {
        batch.draw(empty,Xcoord,Ycoord,length,height);
        batch.draw(fill,Xcoord,Ycoord,(float)(length*(fillPercent/100.0)),height);
    }
    public float getPower()
    {
        return this.fillPercent;
    }
    public void setfillpercent(float power)
    {
        this.fillPercent=power;
    }
}
