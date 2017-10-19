/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 1
 */

package di.unipi.ase.doodleservice;

/**
 * Vote class (given by the professor):
 * in addition some exceptions have been handled and the comments have been added to the code.
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
     * @throws IllegalArgumentException if the name or the option are null parameters
     */
    public Vote(String name, String option) {
        if (name == null || option == null) throw new IllegalArgumentException("One or both arguments are null.");
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
