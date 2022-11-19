package com.mygdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Camera;
// import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
// import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGame extends Game
{
	SpriteBatch batch;
	public BitmapFont fontcheck;
	Texture img;
	Camera camera;
	Viewport viewport;
	private final int ScreenX=1200;
	private final int ScreenY=900;
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
		batch = new SpriteBatch();
		this.setScreen(new SavePage(this));
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
}