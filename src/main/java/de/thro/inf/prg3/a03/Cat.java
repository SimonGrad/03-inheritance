package de.thro.inf.prg3.a03;
import de.thro.inf.prg3.a03.State;
import de.thro.inf.prg3.a03.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static de.thro.inf.prg3.a03.Cat.*;

public class Cat {
	private static final Logger logger = LogManager.getLogger();


	// initially, animals are sleeping
	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.state=new SleepingState(sleep);
	}

	public void tick(){
		this.state=state.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		// change state and reset the timer
		this.state=((HungryState) state).feed(this);
		timeDigesting = 0;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}

	public int getSleep() {
		return sleep;
	}

	public int getTime() {
		return time;
	}

	public int getTimeDigesting() {
		return timeDigesting;
	}

	public boolean isAsleep() {
		return state.getClass().equals(SleepingState.class);
	}

	public boolean isPlayful() {
		return state.getClass().equals(PlayfulState.class);
	}

	public boolean isHungry() {
		return state.getClass().equals(HungryState.class);
	}

	public boolean isDigesting() {
		return state.getClass().equals(DigestingState.class);
	}

	public boolean isDead() {
		return state.getClass().equals(DeathState.class);
	}

	@Override
	public String toString() {
		return "Name" + name;
	}
}
