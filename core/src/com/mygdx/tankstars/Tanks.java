package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;

public abstract class Tanks {
    private int HP;
    private int Fuel;
    private Texture Body;
    private int xCordBody;
    private int yCordBody;
    private Projectile Bullet;
    private final int speed=20;
    
    public class Nozzle
    {
        public Texture Pipe;
        public int angle;
        public int xCoordinate;
        public int yCoordinate;
    }

    public abstract void move();
    public abstract void fire();
}
