package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;

public class Tank1 extends Tanks
{

    Tank1(){
        int x=200;
        int y=200;
        int a=0;
        if(x==800){
            a=180;
        }
        this.HP=100;
        this.Body=new Texture("Tank1.png");
        this.BodyFlipped=new Texture("Tank1Flipped.png");
        this.xCordBody=x;
        this.yCordBody=y;
        this.Lenght=150;
        this.Height=70;
        this.nozzle=new Nozzle("Nozzle1.png",x-20,y+45,a);
    }
    Tank1(int x,int y){
        int a=0;
        if(x==800){
            a=180;
        }
        this.HP=100;
        this.Body=new Texture("Tank1.png");
        this.BodyFlipped=new Texture("Tank1Flipped.png");
        this.xCordBody=x;
        this.yCordBody=y;
        this.Lenght=150;
        this.Height=70;
        this.nozzle=new Nozzle("Nozzle1.png",x-20,y+45,a);
    }

}