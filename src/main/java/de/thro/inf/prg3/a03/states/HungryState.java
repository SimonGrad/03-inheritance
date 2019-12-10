package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HungryState extends State {
    Logger logger=LogManager.getLogger();

     HungryState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
         logger.info("I've been starving for a too long time");
        return new DeathState();
    }

    public State feed(Cat cat){
         logger.info("Om nom nom");
         return new DigestingState(cat.getDigest(),duration-time);
    }

}