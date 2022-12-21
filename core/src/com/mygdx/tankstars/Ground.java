package com.mygdx.tankstars;

import java.io.Serializable;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static java.lang.Math.abs;

public class Ground implements Serializable{

    private static ArrayList<Body> groundInstance;
    private static Ground ground=null;
    public static Ground getInstance()
    {
        if(ground==null)
        {
            groundInstance=new ArrayList<>();
            ground=new Ground();
        }
        return ground;
    }
    public void add(Body b)
    {
        groundInstance.add(b);
    }
    private Ground()
    {
        
    }

    public void decrease(float v, Vector2 position) {
        float x=position.x;
        for(int i=0;i<groundInstance.size();i++)
        {
            Body b=groundInstance.get(i);

            float a=1;
            float d=b.getPosition().x;
            if(x-1<d && d<x+1)
            {
                float c=abs(x-b.getPosition().x);
                a-=c;
                System.out.println("before");
                b.setLinearVelocity(0,(-1.5f*a));
                System.out.println("after");
            }
        }
    }

    public void checkvelocity(){
        for(int i=0;i<groundInstance.size();i++)
        {
            Body b=groundInstance.get(i);
            if(b.getLinearVelocity().y<0)
            {
                b.setLinearVelocity(0,b.getLinearVelocity().y+0.05f);
            }
            if(b.getLinearVelocity().y>0)
            {
                b.setLinearVelocity(0,0);
            }
        }
    }

    public void createBody(World world) {
        float t=(float)(Math.random()*0.3f);
        for(float i=-25;i<25;i+=0.1f){
            BodyDef bd=new BodyDef();
            bd.type= BodyDef.BodyType.KinematicBody;
            float rand=(float)0.3 + (float)0.7 * (float)Math.sin(i/3);
            float rand1=(float)0.3 + t * (float)Math.sin(i/2);
            bd.position.set(i,-12+rand+rand1);

            //shape
            PolygonShape ps=new PolygonShape();
            ps.setAsBox(0.05f,10);
//            if(Math.round(i)==-21 || Math.round(i)==21){
//                ps.setAsBox(0.05f,20);
//            }

            //fixture
            FixtureDef fd=new FixtureDef();
            fd.density=2.5f;
            fd.friction=1f;
            fd.restitution=0f;
            fd.shape=ps;
            Body b=world.createBody(bd);;
            b.createFixture(fd).setUserData(this);
            Sprite s=new Sprite(new Texture("Ground.png"));
            s.setSize(0.1f,15);
            // s.setPosition(i,-14);
            s.setOriginCenter();
            b.setUserData(s);
            ground.add(b);
            ps.dispose();
        }
    }
    public void clearArray(){
        groundInstance.clear();
    }
    public ArrayList<Body> getGroundInstance() {
        return groundInstance;
    }
}
