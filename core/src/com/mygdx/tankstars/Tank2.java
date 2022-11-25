package com.mygdx.tankstars;
import com.badlogic.gdx.graphics.Texture;

public class Tank2 extends Tanks
{

    // this is shit
    Tank2(int x,int y){
        int a=0;
        if(x==800){
            a=180;
        }

        this.HP=150;
        this.Body=new Texture("Tank2.png");
        this.BodyFlipped=new Texture("Tank2Flipped.png");
        this.xCordBody=x;
        this.yCordBody=y;
        this.Lenght=150;
        this.Height=70;
        this.nozzle=new Nozzle("Nozzle2.png",x-20,y+45,a);


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