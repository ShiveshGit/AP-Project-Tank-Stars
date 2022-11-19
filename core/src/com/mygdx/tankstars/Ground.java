package com.mygdx.tankstars;

import java.util.ArrayList;

public class Ground {

    private ArrayList<Integer> YCoords;

    Ground(){
        YCoords=new ArrayList<>(1200);
        {
            for(int i=0;i<1200;i++)
            {
                YCoords.set(i,300);
            }
        }

    }
}
