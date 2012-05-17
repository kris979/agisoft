package patterns.mediator;

/**
 * 
 * 
 */
public abstract class Race implements NegotiableRace {

    protected Mediator mediator;

    Race(Mediator m) {
        this.mediator = m;
    }

    @Override
    public void startNegotiations() {
        mediator.negotiateWithOthers();
    }

}
