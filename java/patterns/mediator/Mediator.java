package patterns.mediator;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract Mediators
 * 
 * There is no need to create an Abstract Mediator class or an interface as long as the colleagues are going to use only
 * one mediator. The definition of an abstract Mediator is required only if the colleagues needs to work with different
 * mediators.
 * 
 * Complexity of Mediator object
 * 
 * The mediator object handles all the interaction between the participants objects. One potential problem is complexity
 * of the mediator when the number of participants is a high and the different participant classes is high. If you
 * created custom dialogs for GUI applications you remember that after some time the dialogs classes become really
 * complex because they had to manage a lot of operations.
 */
public class Mediator {

    private Set<NegotiableRace> racesInNegotiations = new HashSet<NegotiableRace>();

    public void participateInNegotiations(NegotiableRace negotiableRace) {
        racesInNegotiations.add(negotiableRace);
    }

    public void negotiateWithOthers() {
        for (NegotiableRace race : racesInNegotiations) {
            race.negotiate();
        }
    }
}
