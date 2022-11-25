package com.mygdx.tankstars;
import com.badlogic.gdx.graphics.Texture;

public class Tank3 extends Tanks
{
    Tank3(int x,int y){
        int a=0;
        if(x==800){
            a=180;
        }

        this.HP=200;
        this.Body=new Texture("Tank3.png");
        this.BodyFlipped=new Texture("Tank3Flipped.png");

        this.xCordBody=x;
        this.yCordBody=y;
        this.Lenght=150;
        this.Height=70;
        this.nozzle=new Nozzle("Nozzle3.png",x-20,y+45,a);
    }

    @Override
    public void move()
    {

    }
    @Override
    public void fire()
    {

    }

}