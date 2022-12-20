package com.mygdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;

import javax.swing.*;
import java.util.ArrayList;

public class New implements Screen {
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

    public New(MainGame game, int p1Tank, int p2Tank) {
        this.game = game;
        // tank1 = new Tank1(200, 200);
        // tank2 = new Tank2(800, 200);
        this.ground=Ground.getInstance();
        this.P1=new Player(p1Tank,true,200,200);
        this.P2=new Player(p2Tank,false,800,200);

    }


    @Override
    public void show() {

        batch = new SpriteBatch();
        world=new World(new Vector2(0,-10),true);
        world.setContactListener(new ContactListner());
        dbr=new Box2DDebugRenderer();
        cam=new OrthographicCamera(Gdx.graphics.getWidth()/30,Gdx.graphics.getHeight()/30);

        BodyDef bdef=new BodyDef();
        FixtureDef fdef=new FixtureDef();

        PolygonShape rect1=new PolygonShape();
        rect1.setAsBox(1,0.45f);

        CircleShape ball1=new CircleShape();
        ball1.setRadius(0.5f);
        ball1.setPosition(new Vector2(1f,0));

        CircleShape ball2=new CircleShape();
        ball2.setRadius(0.5f);
        ball2.setPosition(new Vector2(-1f,0));

        //box
        bdef.type=BodyDef.BodyType.DynamicBody;
        bdef.position.set(-5,5);

        fdef.density=2.5f;
        fdef.friction=0.5f;
        fdef.restitution=0f;
        fdef.shape=rect1;
        // P1.getPlayerBody()=world.createBody(bdef);
        P1.createBody(world, bdef);
        Sprite t1=new Sprite(P1.getTank().Body);    //
        t1.setSize(3,2);
        t1.setOriginCenter();
        // P1.getPlayerBody().setUserData(t1);
        P1.setData(t1);
        P1.getPlayerBody().createFixture(fdef);
        P1.setFixture(fdef);
        fdef.shape=ball1;
        P1.getPlayerBody().createFixture(fdef);
        P1.setFixture(fdef);
        fdef.shape=ball2;
        P1.getPlayerBody().createFixture(fdef);
        P1.setFixture(fdef);
        
        bdef.position.set(5,5);
        P2.createBody(world, bdef);
        Sprite t2=new Sprite(P2.getTank().BodyFlipped);//
        t2.setSize(3,2);
        t2.setOriginCenter();
        P2.setData(t2);
        fdef.shape=rect1;
        P2.setFixture(fdef);
        fdef.shape=ball1;
        P2.setFixture(fdef);
        fdef.shape=ball2;
        P2.setFixture(fdef);
        float t=(float)(Math.random()*0.3f);
        for(float i=-25;i<25;i+=0.1f){
            BodyDef bd=new BodyDef();
            bd.type= BodyDef.BodyType.KinematicBody;
            float rand=(float)0.3 + (float)0.7 * (float)Math.sin(i/3);
            float rand1=(float)0.3 + t * (float)Math.sin(i/2);
            bd.position.set(i,-12+rand+rand1);

            //shape
            PolygonShape ps=new PolygonShape();
            ps.setAsBox(0.05f,10);
//            if(Math.round(i)==-21 || Math.round(i)==21){
//                ps.setAsBox(0.05f,20);
//            }

            //fixture
            FixtureDef fd=new FixtureDef();
            fd.density=2.5f;
            fd.friction=1f;
            fd.restitution=0f;
            fd.shape=ps;
            Body b=world.createBody(bd);
            b.createFixture(fd);
            ground.add(b);
            ps.dispose();
        }
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
//        batch.draw(backImg,-20,-15,40,30);
        Array<Body> bodies=new Array<Body>();
        world.getBodies(bodies);
        for(Body b:bodies) {
            if (b != null && b.getUserData() instanceof Sprite) {
                Sprite s = (Sprite) b.getUserData();
                s.setPosition(b.getPosition().x-s.getWidth()/2, b.getPosition().y-s.getHeight()/3);
                s.setRotation(b.getAngle() * MathUtils.radiansToDegrees);
                s.draw(batch);
            }
        }
        batch.end();
//        int a=world.getBodyCount();
//        System.out.println(a);
        dbr.render(world,cam.combined);
        world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATIONS);
        cam.update();

    }

    private void update_bodies(float deltaTime) {
        Player p=P2;
        if(turn){
            p=P1;
        }
        if(!(projectile.isFired())){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            {
                p.getPlayerBody().setLinearVelocity(-1,0);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            {
                p.getPlayerBody().setLinearVelocity(1,0);
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
        projectile.setBody(player);
        projectile.Fire(player.getPower(),player.getAngle());
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
}


