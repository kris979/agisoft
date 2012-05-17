package patterns.templatemethod;

/**
 * CONCRETE BASE CLASS 
 * It is not necessary to have the superclass as a abstract class. It can be a concrete class
 * containing a method (template method) and some default functionality. In this case the primitive methods can not be
 * abstract and this is a flaw because it is not so clear which methods have to be overridden and which not. A concrete
 * base class should be used only when customizations hooks are implemented.
 * 
 * TEMPLATE METHOD CAN NOT BE OVERRIDDEN 
 * The template method implemented by the base class should not be overridden. The
 * specific programming language modifiers should be used to ensure this.
 */
public abstract class Warrior {

    /**
     * The template method implemented by the base class should not be overridden. The specific programming language
     * modifiers should be used to ensure this.
     * 
     * When there is a method in the base class that should contain default some code, but on the other side it's
     * necessary to be extended in the subclasses it should be split in 2 methods: one abstract and one concrete. We can
     * not rely in the fact that the subclasses will override the method and will call the super implementation in it
     */
    public final void goIntoBattle() {
        prepare();
        move();
        attack();
    }

    protected abstract void attack();

    protected abstract void move();

    protected abstract void prepare();
}
