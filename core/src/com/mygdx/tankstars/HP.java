package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class HP {
    private Texture fill;
    private Texture empty;
    private int Xcoord;
    private int Ycoord;
    private int length;
    private int height;
    private float fillPercent;

    HP(Boolean player){
        this.fill=new Texture("HP_fill.png");
        this.empty=new Texture("HP_empty.png");
        this.Ycoord=825;
        this.length=120;
        this.height=15;
        this.fillPercent=100;
        if(player){
            this.Xcoord=380;
        }
        else{
            this.Xcoord=700;
        }
    }
    void renderthis(MainGame game){

        game.batch.draw(empty,Xcoord,Ycoord,length,height);
        game.batch.draw(fill,Xcoord,Ycoord,(int)(length*(fillPercent/100.0)),height);

    }
}
