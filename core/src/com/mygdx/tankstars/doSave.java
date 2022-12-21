package com.mygdx.tankstars;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class doSave implements Serializable
{
    private New newGame;
    public doSave(New newGame,int file) throws FileNotFoundException, IOException
    {
        SaveState S=new SaveState(newGame);
        String Str="";
        Str+=file;
        Str+=".txt";
        ObjectOutputStream oos=null;
        try
        {
            oos=new ObjectOutputStream(new FileOutputStream(Str));
            ArrayList<Float> XCoords=new ArrayList<>();
            for(int i=0;i<newGame.getGround().getGroundInstance().size();i++)
            {
                XCoords.add(newGame.getGround().getGroundInstance().get(i).getPosition().x);
            }
            Player P1=newGame.getPlayer1();
            Player P2=newGame.getPlayer2();
            SaveState st=new SaveState(XCoords,P1.getHP().getHealth(),P1.getPosition().x,P1.getTankChooser(),P1.getP(),P2.getHP().getHealth(),P2.getPosition().x,P2.getTankChooser(),P2.getP());
            oos.writeObject(st);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                oos.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public void load(int file) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String i="";
        i+=file;
        i+=".txt";
        ObjectInputStream in=null;
        try
        {
            in=new ObjectInputStream(new FileInputStream(i));
            SaveState st=(SaveState)(in.readObject());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            
            try
            {
                in.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    
        }
    }
}