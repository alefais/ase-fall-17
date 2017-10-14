/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 1
 */

package di.unipi.ase.doodleservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Doodle class (given by the professor): comments have been added.
 */
public class Doodle {
    private String title;
    private ArrayList<String> options;
    private HashMap<String, ArrayList<String>> votes;

    /**
     * Empty constructor.
     */
    public Doodle() { }

    /**
     * Construct a new doodle given the title and the options.
     * @param title the title of the doodle
     * @param options the options of the doodle
     */
    public Doodle(String title, List<String> options) {
        this.title = title;
        this.options = new ArrayList<>(options);
        this.votes = new HashMap<>();
        for (String option : options){
            votes.put(option, new ArrayList<>());
        }
    }

    /**
     * Construct a new doodle given a doodle object.
     * @param doodle the doodle in input
     */
    public Doodle(Doodle doodle) {
        this.title = doodle.getTitle();
        this.options = doodle.getOptions();
        this.votes = new HashMap<>();
        for (String option : options){
            votes.put(option, new ArrayList<>());
        }
    }

    /**
     * Get the options of the doodle.
     * @return the options collection
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     * Get the title of the doodle.
     * @return the title string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the votes associated to each option of the doodle.
     * @return the votes collection
     */
    public HashMap<String, ArrayList<String>> getVotes() {
        return votes;
    }

    /**
     * Add the vote of the voter for the chosen option in the doodle.
     * @param vote the vote
     * @return the name of the voter if the vote is valid, null otherwise
     */
    public String addVote(Vote vote){
        String voter = vote.getName();
        String result = null;

        if (isValidVoteOption(vote)) {
            if (hasAlreadyVoted(vote)) {
                removeVote(voter);
            }
            votes.get(vote.getOption()).add(voter);
            result = vote.getName();
        }

        return result;
    }

    /**
     * Check if the doodle contains the option of the vote.
     * @param vote vote containing an option and the voter
     * @return true if the doodle contains the option, false otherwise
     */
    private boolean isValidVoteOption(Vote vote) {
        return options.contains(vote.getOption());
    }

    /**
     * Check if the voter has already voted an option in the doodle.
     * @param vote the vote
     * @return true if the voter has already voted, false otherwise
     */
    private boolean hasAlreadyVoted(Vote vote) {
        String voter = vote.getName();
        String previouslyChosenOption = findPreviousVote(voter);

        return (previouslyChosenOption != null);
    }

    /**
     * Check if the voter has already voted an option in the doodle.
     * @param name the voter
     * @return true if the voter has already voted, false otherwise
     */
    private boolean hasAlreadyVoted(String name){
        String previouslyChosenOption = findPreviousVote(name);

        return (previouslyChosenOption != null);
    }

    /**
     * Check the option of the doodle voted by the user, if any.
     * @param name the voter
     * @return null if the voter has never voted, the option he voted otherwise
     */
    public String findPreviousVote(String name){
        for (String option : votes.keySet()){
            if (votes.get(option).contains(name)){
                return option;
            }
        }
        return null;
    }

    /**
     * Remove the vote of the given voter, if any.
     * @param name the voter
     * @return true if the voter has already voted, false, otherwise
     */
    public boolean removeVote(String name) {
        if(hasAlreadyVoted(name)) {
            String previouslyChosenOption = findPreviousVote(name);
            votes.get(previouslyChosenOption).remove(name);
            return true;
        } else {
            return false;
        }
    }
}
