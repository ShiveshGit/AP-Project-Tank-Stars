package com.mygdx;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
public class buttons 
{
        private Texture image;        
        private Texture imageClicked;

        private int length;
        private int height;
        private final float XCoord;
        private final float YCoord;

        public void renderthis(MainGame game,int yval){
                if(Gdx.input.getX()>=XCoord && Gdx.input.getX()<=XCoord+length && Gdx.input.getY()<=yval-YCoord && Gdx.input.getY()>=yval-YCoord-height)
                {
                    game.batch.draw(imageClicked,XCoord,YCoord,length,height);
                }
                else
                {
                    game.batch.draw(image,XCoord,YCoord,length,height);
                }
        }

        public buttons(String imagePath,String imageClickedPath,int length,int height,float XCoord,float YCoord)
        {
                this.image=new Texture(imagePath);
                this.imageClicked=new Texture(imageClickedPath);
                this.length=length;
                this.height=height;
                this.XCoord=XCoord;
                this.YCoord=YCoord;
        }
        public int getLength()
        {
                return this.length;
        }
        public int getHeight()
        {
                return this.height;
        }
        public float getXCoord()
        {
                return this.XCoord;
        }
        public float getYCoord()
        {
                return this.YCoord;
        }
        public Texture getTexture()
        {
                return this.image;
        }
        public Texture getClickedTexture()
        {
                return this.imageClicked;
        }
}
