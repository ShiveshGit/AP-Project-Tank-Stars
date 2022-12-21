package com.mygdx.tankstars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClassTests
{
    @Test
    public void checkHP()
    {
        HP hp=new HP();
        float health=hp.decrease(1f);
        float healthExpected=99f;
        assertEquals((int)health,(int)healthExpected);
    }   
    @Test
    public void checkPower()
    {
        Power P=new Power();
        float power1=P.decrease(1f);
        float powerExpected=99f;
        assertEquals((int)power1,(int)powerExpected);
    }
}