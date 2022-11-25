package com.mygdx.tankstars;

import java.io.Serializable;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ground implements Serializable{

    private ArrayList<Integer> YCoords;
    private	ShapeRenderer shapeRenderer;

    Ground(){
        YCoords=new ArrayList<>();
        {
            for(int i=0;i<1200;i++)
            {
                YCoords.add(i,300);
            }
        }
        shapeRenderer=new ShapeRenderer();

    }

    public void createGround(){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BROWN);
        for(int i=0;i<1200;i++){
            // System.out.println(YCoords.get(i));
            shapeRenderer.rect(i,0,1,YCoords.get(i)); // Creates a filled rectangle of white color
        }
        shapeRenderer.end();

		
    }

    public int getYCoord(int x) {
        return YCoords.get(x);
    }
}
