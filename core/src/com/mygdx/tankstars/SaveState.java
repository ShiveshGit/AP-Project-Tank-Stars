package com.mygdx.tankstars;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class SaveState implements Serializable{
    private Date date;
    private ArrayList<Float> XGround;
    private float hp1;
    private float xPerson1;
    private int tankChooser1;
    private boolean player1;
    private float hp2;
    private float xPerson2;
    private int tankChooser2;
    private boolean player2;

    // private DateFormat
    SaveState(ArrayList<Float> Xcoord,float hp1,float xPerson1,int tankChooser1,boolean player1,float hp2,float xPerson2,int tankChooser2,boolean player2)
    {
        Date date=new Date();
        this.XGround=new ArrayList<>(Xcoord);
        this.hp1=hp1;
        this.xPerson1=xPerson1;
        this.tankChooser1=tankChooser1;
        this.player1=player1;
        this.xPerson2=xPerson2;
        this.player2=player2;
        this.tankChooser2=tankChooser2;

    }
	public SaveState(New newGame) {
	}    
    public Date getDate()
    {
        return this.date;
    }
}