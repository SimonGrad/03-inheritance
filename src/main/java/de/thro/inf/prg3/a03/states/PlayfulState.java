package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

public class PlayfulState extends State {

    protected PlayfulState(int duration) {
        super(duration);
    }


    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        return new SleepingState(cat.getSleep());
    }
}
