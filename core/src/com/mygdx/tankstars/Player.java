package com.mygdx.tankstars;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player implements Serializable
{
    private int power;
    private int angle;
    private boolean playerval;
    private Tank1 tank1;
    private Tank2 tank2;
    private Tank3 tank3;
    private int tankchooser;
    private HP hp;
    private Body player;
    Player(int tankchooser,boolean player,int x,int y)
    {
        this.tankchooser=tankchooser;
        this.playerval=player;
        this.hp=new HP(player);
        if(player){
            x=200;
        }
        if(tankchooser==1){
            tank1=new Tank1(x,y);
        }
        if(tankchooser==2){
            tank2=new Tank2(x,y);
        }
        if(tankchooser==3){
            tank3=new Tank3(x,y);
        }
    }
    public Body getPlayerBody()
    {
        return player;
    }
    public Tanks getTank()
    {
        if(this.tankchooser==1)
        {
            return tank1;
        }
        else if(this.tankchooser==2)
        {
            return tank2;
        }
        else
        {
            return tank3;
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
    public void createBody(World world,BodyDef bdef)
    {
        this.player=world.createBody(bdef);
    }
    public void setData(Sprite tank)
    {
        this.player.setUserData(tank);
    }
    public void setFixture(FixtureDef fdef)
    {
        this.player.createFixture(fdef);
    }

    public void incPower(int i) {
        power+=i;
        if(power>100){
            power=100;
        }
        if(power<0){
            power=0;
        }
        System.out.println(power);
    }

    public void incAngle(int i) {
        angle+=i;
        if(angle>180){
            angle=180;
        }
        if(angle<0){
            angle=0;
        }
        System.out.println(angle);
    }

    public float getPower() {
        return power;
    }

    public float getAngle() {
        return angle;
    }
}