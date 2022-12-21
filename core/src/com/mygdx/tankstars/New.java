package com.mygdx.tankstars;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class New implements Screen {
    public Preferences getGround;
    private World world;
    private Box2DDebugRenderer dbr;
    private OrthographicCamera cam;

    private SpriteBatch batch;

    private final float TIMESTEP = 1/60f;
    private final int VELOCITYITERATIONS = 6;
    private final int POSITIONITERATIONS = 2;

    private MainGame game;
                    

    private Player P1;
    private Player P2;

    private Ground ground;
    private Texture backImg;

    private Projectile projectile;

    private boolean turn;
    private BitmapFont font;
    private String str;
    private ArrayList<Texture> numbers;
    public New(MainGame game, int p1Tank, int p2Tank) {
        this.game = game;
        // tank1 = new Tank1(200, 200);
        // tank2 = new Tank2(800, 200);
        this.ground=Ground.getInstance();
        this.ground.clearArray();
        this.P1=new Player(p1Tank,true,200,200);
        this.P2=new Player(p2Tank,false,800,200);
        this.font=new BitmapFont((Gdx.files.internal("InGame.fnt")));
        this.numbers=new ArrayList<Texture>();
        for(int i=0;i<10;i++)
        {
            String str="";
            str+=i;
            str+=".png";
            Texture T=new Texture(str);
            numbers.add(T);
        }
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        world=new World(new Vector2(0,-10),true);
        world.setContactListener(new ContactListner());
        dbr=new Box2DDebugRenderer();
        cam=new OrthographicCamera(Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/30);

        P1.createBody(world,true);
        P2.createBody(world,false);
        ground.createBody(world);
        projectile=new Projectile(new Texture("badlogic.jpg"),world);
        backImg=new Texture("Background.jpg");

    }

    @Override
    public void render(float delta) {
//        System.out.println("In render");
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        update_bodies(Gdx.graphics.getDeltaTime());

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(backImg,-20,-15,40,30);
        Array<Body> bodies=new Array<Body>();
        world.getBodies(bodies);
        for(Body b:bodies) {
            DisplaySprites(b);
        }
        // this.str="";
        // this.str+=(int)P1.getAngle();
        // font.draw(batch,str,-15,-12);
        // font.getData().setScale(0.01f, 0.01f);
        // this.str="";
        // this.str+=(int)P2.getAngle();
        // font.draw(batch,str,15,-12);
        P1.getHP().renderthis(batch);
        P2.getHP().renderthis(batch);
        P1.getPower().renderthis(batch);
        P2.getPower().renderthis(batch);
        P1.getFuel().renderthis(batch);
        P2.getFuel().renderthis(batch);
        float p1=P1.getAngle();
        float p2=P2.getAngle();
        int a=(int)p1;
        int b=(int)p2;
        int onesDigit;
        int tensDigit;
        int hundredsDigit;
        if(a>99)
        {
            onesDigit=a%10;
            tensDigit=(a/10)%10;
            hundredsDigit=a/100;  
        }
        else
        {
            onesDigit=(a%10);
            tensDigit=(a/10)%10;
            hundredsDigit=0;
        }
//        System.out.println(p1+" "+onesDigit+" "+tensDigit+" "+hundredsDigit);
        batch.draw(numbers.get(onesDigit),-14f,-13f,1f,1f);
        batch.draw(numbers.get(tensDigit),-15f,-13f,1f,1f);
        batch.draw(numbers.get(hundredsDigit),-16f,-13f,1f,1f);
        if(b>99)
        {
            onesDigit=(b%10);
            tensDigit=(b/10)%10;
            hundredsDigit=(b/100);
        }
        else
        {
            onesDigit=(b%10);
            tensDigit=(b/10)%10;
            hundredsDigit=0;
        }
//        System.out.println(p2+" "+onesDigit+"-"+tensDigit+"-"+hundredsDigit);
        batch.draw(numbers.get(onesDigit),14f,-13f,1f,1f);
        batch.draw(numbers.get(tensDigit),13f,-13f,1f,1f);
        batch.draw(numbers.get(hundredsDigit),12f,-13f,1f,1f);
        if(P1.getHP().getHealth()<=0)
        {
            game.setScreen(new EndPage(game,2));
        }
        if(P2.getHP().getHealth()<=0)
        {
            game.setScreen(new EndPage(game,1));
        }
        
        // font.getData().setScale(0.01f, 0.01f);``
        // font.getData().setScale(0.01f);
        batch.end();
//        int a=world.getBodyCount();
//        System.out.println(a);
        // dbr.render(world,cam.combined);
        ground.checkvelocity();
        world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATIONS);
        cam.update();

    }

    private void DisplaySprites(Body b) {
        if (b != null && b.getUserData() instanceof Sprite) {
            Sprite s = (Sprite) b.getUserData();
            s.setPosition(b.getPosition().x-s.getWidth()/2, b.getPosition().y-s.getHeight()/3);
            s.setRotation(b.getAngle() * MathUtils.radiansToDegrees);
            s.draw(batch);
        }
        else if (b != null && b.getUserData() instanceof Projectile) {
            Projectile p = (Projectile) b.getUserData();
            Sprite s=p.getSprite();
            s.setPosition(b.getPosition().x-s.getWidth()/2, b.getPosition().y-s.getHeight()/3);
            s.setRotation(b.getAngle() * MathUtils.radiansToDegrees);
            s.draw(batch);
        }
        if (b != null && b.getUserData() instanceof Player) {
            Player p = (Player) b.getUserData();
            Sprite s=p.getSprite();
            Sprite s1=p.getNozzle();
            s1.setPosition(b.getPosition().x-s1.getWidth()/2, b.getPosition().y-s1.getHeight()/3+0.7f);
            s1.setRotation(5);
            System.out.println(p.getAngle());
            s1.setSize(3f, 0.5f);
            s.setPosition(b.getPosition().x-s.getWidth()/2, b.getPosition().y-s.getHeight()/3);
            s.setRotation(b.getAngle() * MathUtils.radiansToDegrees);
            batch.draw(s1,b.getPosition().x-s1.getWidth()/2,b.getPosition().y-s1.getHeight()/3+0.7f,1.5f,0.2f,3f,0.4f,1f,1f,p.getAngle());
            s1.draw(batch);
            s.draw(batch);
        }

    }

    private void update_bodies(float deltaTime) {
        Player p=P2;
        if(turn){
            p=P1;
        }
        if(!(projectile.isFired())){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            {
                if(p.getFuel().getFuel()>0)
                {
                    p.getPlayerBody().setLinearVelocity(-1,0);
                    p.getFuel().decrease(1f);
                }
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            {
                if(p.getFuel().getFuel()>0)
                {
                    p.getPlayerBody().setLinearVelocity(1,0);
                    p.getFuel().decrease(1f);
                }
            }
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
            {
                FireProjectile(p);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP))
            {
                p.incPower(1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            {
                p.incPower(-1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.COMMA))
            {
                p.incAngle(1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.PERIOD))
            {
                p.incAngle(-1);
            }
        }
        checkprojectile();
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            game.setScreen(new PausePage(game));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.I))
        {
            cam.zoom+=0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.O))
        {
            cam.zoom-=0.02;
        }


    }
    private void checkprojectile() {
        int a=24;
        if(projectile.isFired()){
            if(projectile.getBody().getPosition().x>a || projectile.getBody().getPosition().x<-a || projectile.getBody().getPosition().y>a || projectile.getBody().getPosition().y<-a){
                projectile.delete();
            }

        }
    }


    private void FireProjectile(Player player) {
        player.getFuel().increase(100);
        projectile.setBody(player);
        projectile.Fire(player.getPower().getPower(),player.getAngle());
        turn=!turn;
    }


    @Override
    public void resize(int width, int height) {
        cam.viewportWidth=width/30;
        cam.viewportHeight=height/30;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        dbr.dispose();
    }

    public Player getPlayer1() {
        return P1;
    }

    public Player getPlayer2() {
        return P2;
    }

    public Ground getGround() {
        return ground;
    }
}


