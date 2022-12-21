package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Slider
{
    public float increase(float amt);
    public float decrease(float amt);
    public void renderthis(SpriteBatch batch);
}
