package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Projectile {

    private Texture bullet;
    private Body bulletBody;
    private boolean isActive;

    private float power;
    private float angle;

    private World world;
    Projectile(Texture bullet,World world)
    {
        this.world=world;
        this.bullet=bullet;
    }

    public void delete() {
        System.out.println("Deleted");
        world.destroyBody(bulletBody);
        this.isActive=false;
    }

    public boolean isFired() {
        return isActive;

    }

    public Texture getBullet()
    {
        return bullet;
    }
    public Body getBody()
    {
        return bulletBody;
    }
    void damage(Player P2){

    }
    void damage(Ground ground){
        
    }
    public void setBody(Player player) {
        Body body=player.getPlayerBody();
        BodyDef bdef=new BodyDef();
        bdef.type=BodyDef.BodyType.DynamicBody;
        bdef.position.set(body.getPosition().x,body.getPosition().y+1.5f);
        CircleShape cs=new CircleShape();
        cs.setRadius(0.2f);
        FixtureDef fdef=new FixtureDef();
        fdef.shape=cs;
        fdef.density=5f;
        fdef.friction=0.5f;
        fdef.restitution=0.1f;
        bulletBody=world.createBody(bdef);
        bulletBody.createFixture(fdef).setUserData(this);
        cs.dispose();
        System.out.println("Bullet body set");
    }
    public void Fire(float power,float angle)
    {
        float p=power/20;
        isActive=true;
        System.out.println(p*MathUtils.cosDeg(angle)+" "+p*MathUtils.sinDeg(angle));
        bulletBody.applyLinearImpulse(new Vector2(p*MathUtils.cosDeg(angle),p*MathUtils.sinDeg(angle)),bulletBody.getWorldCenter(),true);
    }

    public void checkProjectile(){

    }
}
