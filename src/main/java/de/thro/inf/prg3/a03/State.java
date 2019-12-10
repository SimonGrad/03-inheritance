package de.thro.inf.prg3.a03;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class State {

    protected static final Logger logger= LogManager.getLogger();

    protected int time=0;
    protected final int duration;

    protected State(int duration){
        this.duration=duration;
    }

    protected State tick(Cat cat){
        if(duration<0){
            return this;
        }
        // time goes by...
        time++;

        if(time<duration){
            logger.info("Still in {}",getClass().getSimpleName());
            return this;
        }else{
            return successor(cat);
        }
    }

    public abstract State successor(Cat cat);

}
