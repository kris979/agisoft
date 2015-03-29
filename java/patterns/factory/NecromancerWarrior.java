package patterns.factory;


/**
 * 
 *
 */
public class NecromancerWarrior implements Warrior {


    static {
        WarriorFactory.registerNewWarrior(new NecromancerWarrior());
    }
    
    /* (non-Javadoc)
     * @see patterns.factory.Warrior#attack()
     */
    @Override
    public void attack() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see patterns.factory.Warrior#move()
     */
    @Override
    public void move() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see patterns.factory.Warrior#summon()
     */
    @Override
    public Warrior summon() {
        return new NecromancerWarrior();
    }

}
