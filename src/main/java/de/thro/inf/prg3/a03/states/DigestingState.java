package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

public class DigestingState extends State {

    private final int remainingWakeTime;

    public DigestingState(int duration,int remainingWakeTime) {
        super(duration);
        this.remainingWakeTime=remainingWakeTime;
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(remainingWakeTime-cat.getDigest());
    }
}
