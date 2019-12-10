package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

public class SleepingState extends State {

    public SleepingState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting hungry");
        return new HungryState(cat.getAwake());
    }
}
