package com.mygdx.tankstars;

import java.io.Serializable;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

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
}
