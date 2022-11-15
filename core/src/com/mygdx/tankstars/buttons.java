package com.mygdx.tankstars;
import com.badlogic.gdx.graphics.Texture;
public class buttons 
{
        private Texture image;        
        private Texture imageClicked;

        private int length;
        private int height;
        private final float XCoord;
        private final float YCoord;
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
