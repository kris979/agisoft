package patterns.templatemethod;

/**
 * A template method defines an algorithm in a base class using abstract operations that subclasses override to provide
 * concrete behaviour.
 * 
 * when refactoring is performed and common behaviour is identified among classes. A abstract base class containing all
 * the common code (in the template method) should be created to avoid code duplication.
 * 
 * 
 * TEMPLATE METHOD VS. STRATEGY
 * 
 * The main difference between the two is when the concrete algorithm is chosen.
 * 
 * With the Template method pattern this happens at compile-time by subclassing the template. Each subclass provides a
 * different concrete algorithm by implementing the template’s abstract methods. When a client invokes methods of the
 * template’s external interface the template calls its abstract methods (its internal interface) as required to invoke
 * the algorithm.
 * 
 * In contrast, the Strategy pattern allows an algorithm to be chosen at runtime by containment. The concrete algorithms
 * are implemented by separate classes or functions which are passed to the strategy as a parameter to its constructor
 * or to a setter method. Which algorithm is chosen for this parameter can vary dynamically based on the program’s state
 * or inputs. In summary:
 * 
 * Template method pattern: compile-time algorithm selection by subclassing 
 *        Strategy pattern: run-time algorithm selection by containment
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {

        Warrior w = new Barbarian();
        w.goIntoBattle();

        w = new Sorcerer();
        w.goIntoBattle();
    }
}
