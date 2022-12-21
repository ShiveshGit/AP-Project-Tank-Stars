package com.mygdx.tankstars;

import com.badlogic.gdx.physics.box2d.*;

public class ContactListner implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        System.out.println("Contact");
        if(fa.getUserData() instanceof  Projectile) {
            if(fb.getUserData() instanceof  Player){
                ((Projectile) fa.getUserData()).damage((Player) fb.getUserData());
            }
            else if(fb.getUserData() instanceof  Ground){
                ((Projectile) fa.getUserData()).damage((Ground) fb.getUserData());
            }
            System.out.println("Projectile hit");
            Object a=fa.getUserData();
            Projectile p=(Projectile) fa.getUserData();
            p.getBody().setLinearVelocity(0,10000);
        }
        else if(fb.getUserData() instanceof  Projectile) {
            if(fa.getUserData() instanceof  Player){
                ((Projectile) fb.getUserData()).damage((Player) fa.getUserData());
            }
            else if(fa.getUserData() instanceof  Ground){
                ((Projectile) fb.getUserData()).damage((Ground) fa.getUserData());
            }
            System.out.println("Projectile hit");
            Object a=fb.getUserData();
            Projectile p = (Projectile) fb.getUserData();
            p.getBody().setLinearVelocity(0,1000);
        }
        }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
