/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 1
 */

package di.unipi.ase.doodleservice;

/**
 * Vote class (given by the professor): comments have been added.
 */
public class Vote {
    private String name;
    private String option;

    /**
     * Empty constructor.
     */
    public Vote() { }

    /**
     * Construct a new vote given the name of the voter and the chosen option.
     * @param name the voter
     * @param option the option that the voter wants to vote
     */
    public Vote(String name, String option){
        this.name = name;
        this.option = option;
    }

    /**
     * Get the name of the voter.
     * @return the voter
     */
    public String getName() {
        return name;
    }

    /**
     * Get the option voted.
     * @return the option
     */
    public String getOption() {
        return option;
    }
}
