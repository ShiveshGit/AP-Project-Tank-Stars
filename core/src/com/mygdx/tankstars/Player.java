package com.mygdx.tankstars;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Player implements Serializable
{
    private Power power;
    private float angle;
    private boolean playerval;
    private Tank1 tank1;
    private Tank2 tank2;
    private Tank3 tank3;
    private int tankchooser;
    private HP hp;
    private Body player;
    private Fuel fuel;

    private Sprite sprite;
    Player(int tankchooser,boolean player,int x,int y)
    {
        this.tankchooser=tankchooser;
        this.playerval=player;
        this.hp=new HP(player);
        this.fuel=new Fuel(player);
        if(player){
            x=200;
        }
        // Tanks.CreateTank(tankchooser);
        if(tankchooser==1){
            // tank1=new Tank1(x,y);
            tank1=(Tank1)Tanks.CreateTank(tankchooser);
        }
        else if(tankchooser==2)
        {
            tank2=(Tank2)Tanks.CreateTank(tankchooser);
        }
        else
        {
            tank3=(Tank3)Tanks.CreateTank(tankchooser);
        }
        // if(tankchooser==2){
            // tank2=new Tank2(x,y);
        // }
        // if(tankchooser==3){
            // tank3=new Tank3(x,y);
        // }
        this.power=new Power(player);
        this.angle=0f;
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
    public void createBody(World world,boolean turn)
    {
        BodyDef bdef=new BodyDef();
        FixtureDef fdef=new FixtureDef();

//       PolygonShape rect1=(PolygonShape)createShape(1,1f,0.45f,0f);
         PolygonShape rect1=new PolygonShape();
         rect1.setAsBox(1,0.45f);

//       CircleShape ball1=(CircleShape)createShape(2,0.5f,1f,0f);
         CircleShape ball1=new CircleShape();
          ball1.setRadius(0.5f);
          ball1.setPosition(new Vector2(1f,0));

//       CircleShape ball3=(CircleShape)createShape(2,0.4f,0f,45f);
         CircleShape ball3=new CircleShape();
          ball3.setRadius(0.4f);
          ball3.setPosition(new Vector2(0,0.45f));
//
//       CircleShape ball2=(CircleShape)createShape(2,0.5f,-1f,0f);
         CircleShape ball2=new CircleShape();
          ball2.setRadius(0.5f);
          ball2.setPosition(new Vector2(-1f,0));
        // ball2.setRadius(0.5f);
        // ball2.setPosition(new Vector2(-1f,0));

        //box
        bdef.type=BodyDef.BodyType.DynamicBody;

        fdef.density=5f;
        fdef.friction=0.5f;
        fdef.restitution=0.1f;
        fdef.shape=rect1;
        Sprite t1;
        if(turn){
            bdef.position.set(-5,3);
            if(tankchooser==1){
                t1=new Sprite(tank1.getTexture());    //
            }
            else if(tankchooser==2){
                t1=new Sprite(tank2.getTexture());    //
            }
            else{
                t1=new Sprite(tank3.getTexture());    //
            }
        }
        else{
            bdef.position.set(5,3);
            if(tankchooser==1){
                t1=new Sprite(tank1.getTextureFlipped());    //
            }
            else if(tankchooser==2){
                t1=new Sprite(tank2.getTextureFlipped());    //
            }
            else{
                t1=new Sprite(tank3.getTextureFlipped());    //
            }

        }
        t1.setSize(3,2);
        t1.setOriginCenter();
        this.sprite=t1;
        Body b=world.createBody(bdef);
        b.createFixture(fdef).setUserData(this);
        fdef.shape=ball1;
        b.createFixture(fdef).setUserData(this);;
        fdef.shape=ball2;
        b.createFixture(fdef).setUserData(this);;
        fdef.shape=ball3;
        b.createFixture(fdef).setUserData(this);;
        this.player=b;
        b.setUserData(this);
    }

    public void incPower(float i) 
    {
        power.increase(i);
        if(power.getPower()>99f){
            power.setfillpercent(99f);
        }
        if(power.getPower()<0f){
            power.setfillpercent(0f);
        }
        
    }

    public void incAngle(float i) {
        angle+=i;
        if(angle>180){
            angle=180;
        }
        if(angle<0){
            angle=0;
        }
        System.out.println(angle);
    }

    public Power getPower() {
        return power;
    }

    public float getAngle() {
        return angle;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public HP getHP() {
        return hp;
    }
    public Shape createShape(int need,float a,float b,float c)
    {
        if(need==1)
        {
            PolygonShape rect=new PolygonShape();
            rect.setAsBox(a,b);
            return rect;
        }
        else
        {
            CircleShape circle=new CircleShape();
            circle.setRadius(a);
            circle.setPosition(new Vector2(b,c));
            return circle;
            
        }
    }
    public Sprite getNozzle(){
        if(tankchooser==1){
            return tank1.getNozzle();
        }
        else if(tankchooser==2){
            return tank2.getNozzle();
        }
        else{
            return tank3.getNozzle();
        }
    }
    public int getTankChooser()
    {
        return this.tankchooser;
    }

    public Vector2 getPosition() {
        return player.getPosition();
    }
    public boolean getP()
    {
        return this.playerval;
    }

    public Fuel getFuel() {
        return fuel;
    }
}
