package com.mygdx.tankstars;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;

public class Player implements Serializable
{
    private boolean turn;
    private boolean playerval;
    private Tank1 tank1;
    private Tank2 tank2;
    private Tank3 tank3;
    private int tankchooser;
    private HP hp;
    Player(Ground ground,int tankchooser,boolean player)
    {
        this.tankchooser=tankchooser;
        this.playerval=player;
        this.hp=new HP(player);
        int x=800;
        turn=false;
        if(player){
            turn=true;
            x=200;
            
        }

        if(tankchooser==1){
            tank1=new Tank1(x,ground.getYCoord(x));
        }
        if(tankchooser==2){
            tank2=new Tank2(x,ground.getYCoord(x));
        }
        if(tankchooser==3){
            tank3=new Tank3(x,ground.getYCoord(x));
        }
    }

    public Texture getTankTexture() {
        if(tankchooser==1){
            return tank1.getTexture();
        }
        else if(tankchooser==2){
            return tank2.getTexture();
        }
        else{
            return tank3.getTexture();
        }
    }

    public float getTankX() {
        if(tankchooser==1){
            return tank1.getXCoord();
        }
        else if(tankchooser==2){
            return tank2.getXCoord();
        }
        else{
            return tank3.getXCoord();
        }

    }

    public float getTankY() {
        if(tankchooser==1){
            return tank1.getYCoord();
        }
        else if(tankchooser==2){
            return tank2.getYCoord();
        }
        else{
            return tank3.getYCoord();
        }

    }

    public float getTankLeghth() {
        if(tankchooser==1){
            return tank1.getLength();
        }
        else if(tankchooser==2){
            return tank2.getLength();
        }
        else{
            return tank3.getLength();
        }

    }

    public float getTankHeight() {
        if(tankchooser==1){
            return tank1.getHeight();
        }
        else if(tankchooser==2){
            return tank2.getHeight();
        }
        else{
            return tank3.getHeight();
        }

    }

    public void drawHP(MainGame game){
        this.hp.renderthis(game);
    }

    public void drawTank(MainGame game){
        if(tankchooser==1){
            tank1.renderthis(game, playerval);
        }
        else if(tankchooser==2){
            tank2.renderthis(game, playerval);
        }
        else{
            tank3.renderthis(game, playerval);
        }        
    }

    public void move(){

    }

    public void fire(Player p2){

    }
}