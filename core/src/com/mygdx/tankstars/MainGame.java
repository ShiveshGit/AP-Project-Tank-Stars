package com.mygdx.tankstars;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
// import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
// import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame extends Game implements Serializable
{
	SpriteBatch batch;
	public BitmapFont fontcheck;
	Texture img;
	Camera camera;
	Viewport viewport;
	private final int ScreenX=1200;
	private final int ScreenY=900;
	private doSave save;
	private New newGame;
	private ArrayList<String> dates;
	private DateFormat df;
	public void setNew(New n)
    {
		this.newGame=n;
	}
	public void SaveS(int i)
	{
		try {
			this.save=new doSave(newGame,i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getScreenX()
	{
		return ScreenX;
	}
	public int getScreenY()
	{
		return ScreenY;
	}
	@Override
	public void create ()
	{
		System.out.println("In create");
		batch = new SpriteBatch();
		this.dates=new ArrayList<>();
		getdata();
		this.setScreen(new MainPage(this));
		// this.setScreen(new New(this,1,2));
		System.out.println("In create");

		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		super.render();
		// ScreenUtils.clear(1, 0, 0, 1);
		// batch.begin();
		// batch.draw(img, 0, 0);
		// batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	private void getdata()
	{
		String pattern="dd-MM-yyyy";
		this.df=new SimpleDateFormat(pattern);
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
		this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");

//		ObjectInputStream ois=null;
//		for(int i=0;i<5;i++)
//		{
//			String str="";
//			str+=i;
//			str+=".txt";
//			SaveState st=null;
//			try
//			{
//				// ois=new ObjectInputStream(new FileInputStream(str));
//				ois=new ObjectInputStream(new FileInputStream(str));
//				if(ois.readObject()==null)
//				{
//					this.dates.add("Last Saved\n DD-MM-YYYY Hrs:sec\n");
//				}
//				else
//				{
//					st=(SaveState)ois.readObject();
//					this.dates.add(df.format(st.getDate()));
//				}
//			}
//			catch(EOFException e){
//				// this.dates.add(df.format(st.getDate()));
//			}
//			catch(Exception e)
//			{
//			}
//			// finally
//			// {
//			// 	ois.close();
//
//			// }
//		}
	}
	public ArrayList<String> getDates()
	{
		return this.dates;
	}
	public void setDates(int i)
	{
		this.dates.set(i,df.format(new Date()));
	}
}