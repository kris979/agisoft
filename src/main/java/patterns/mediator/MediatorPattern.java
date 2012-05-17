package patterns.mediator;

/**
 * Communication between mediators and colleagues
 * 
 * There are different ways to realize the communication between the colleagues and its mediator: One of the most used
 * methods is to use the Observer pattern. The mediator can be also an observer and the Colleagues can be implement an
 * observable object. Each time an change is made in the state of the observable object, the observer(mediator) gets
 * notified and it notify all other colleagues objects. Alternative methods can be used to send messages to the
 * mediator. For example a simple delegation can be used and specialised methods can be exposed by the mediator In more
 * complex implementations asynchronous messages can be added to to a message queue, from where they can be picked up by
 * the mediator object
 *
 */
public class MediatorPattern {
    
    public static void main(String[] args) {

        Mediator mediator = new Mediator();
        NegotiableRace human = new Human(mediator);
        NegotiableRace zerg = new Zerg(mediator);
        NegotiableRace protos = new Protos(mediator);
        
        mediator.participateInNegotiations(human);
        mediator.participateInNegotiations(zerg);
        mediator.participateInNegotiations(protos);
        
    
        //if mediator was actually changing this request then it would become Adapter pattern
        human.startNegotiations();
        
        /**
         * if mediator is only active class and all races are passive (i.e. we only call methods on mediator) then
         * it actually becomes a facade design pattern
         */
        mediator.negotiateWithOthers();
        
    }
}
