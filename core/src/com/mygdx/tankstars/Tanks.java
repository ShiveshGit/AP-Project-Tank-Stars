package com.mygdx.tankstars;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Tanks implements Serializable{
    protected int HP;
    protected int Fuel;
    protected Texture Body;
    protected Texture BodyFlipped;
    protected int xCordBody;
    protected int yCordBody;
    protected int Lenght;
    protected int Height;
    protected Projectile Bullet;
    protected final int speed=20;
    protected Nozzle nozzle;
    protected SpriteBatch bodySprite;


    public Texture getTexture() {
        return Body;
    }

    public float getLength() {
        return Lenght;
    }

    public float getHeight() {
        return Height;
    }

    public float getXCoord() {
        return xCordBody;
    }

    public float getYCoord() {
        return yCordBody;
    }

    public class Nozzle implements Serializable
    {
        public Texture Pipe;
        public Sprite pipeSprite;
        public int angle;
        public int xCoordinate;
        public int yCoordinate;
        public int Lenght;
        public int Height;
        public SpriteBatch NozzleBatch;

        Nozzle(String path,int x,int y,int a){
            this.Pipe =new Texture(path);
            this.angle=a;
            this.Lenght=200;
            this.Height=10;
            this.xCoordinate=x;
            this.yCoordinate=y;
            this.pipeSprite=new Sprite(Pipe);
            this.NozzleBatch=new SpriteBatch();
        
        }



        public Texture getPipe() {
            return Pipe;
        }

        public float getxCoordinate() {
            return xCoordinate;
        }

        public float getyCoordinate() {
            return yCoordinate;
        }

        public float getLenght() {
            return Lenght;
        }

        public float getHeight() {
            return Height;
        }
    }

    void renderthis(MainGame game,boolean p1){
        nozzle.NozzleBatch.begin();
        // nozzle.pipeSprite.set
        nozzle.pipeSprite.setRotation((float)nozzle.angle);
        // nozzle.pipeSprite.setSize(nozzle.getLenght(),getHeight());
        // nozzle.pipeSprite.setPosition(nozzle.getxCoordinate(), nozzle.getyCoordinate());
        if(nozzle.angle<90)
        {
            // nozzle.pipeSprite.draw(nozzle.NozzleBatch);
            nozzle.NozzleBatch.draw(nozzle.pipeSprite,nozzle.getxCoordinate(),nozzle.getyCoordinate(),100,5,nozzle.getLenght(),nozzle.getHeight(),1f,1f,nozzle.pipeSprite.getRotation());
            game.batch.draw(Body,xCordBody,yCordBody,Lenght,Height);

        }
        else{
            // nozzle.pipeSprite.draw(nozzle.NozzleBatch);

            nozzle.NozzleBatch.draw(nozzle.pipeSprite,nozzle.getxCoordinate(),nozzle.getyCoordinate(),100,5,nozzle.getLenght(),nozzle.getHeight(),1f,1f,nozzle.pipeSprite.getRotation());
            game.batch.draw(BodyFlipped,xCordBody,yCordBody,Lenght,Height);

        }
        nozzle.NozzleBatch.end();
    }

    public abstract void move();
    public abstract void fire();
}
/*
length=200
height=10


 */