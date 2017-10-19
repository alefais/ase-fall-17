/*
 * Created by Alessandra Fais
 * Mat. 481017
 * MCSN - ASE 2017/18 - Homework 1
 */

package di.unipi.ase.doodleservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Controller class that defines the behaviour of the RESTful Web API for the Doodle service.
 * The annotations for the methods indicate the URI and the REST method to which the functionality is mapped.
 */
@RestController //annotation for Spring
public class DoodleController {
    private int id = 0; //counts the opened doodles
    private HashMap<Integer, Doodle> doodles = new HashMap<>(); //currently opened doodles

    // Operations on the doodles

    /**
     * Create a new doodle and insert it in the list of the currently opened doodles.
     * @param d the JSON representation of the doodle contained in the HTTP request body
     * @return the JSON representation of the poll ID
     */
    @RequestMapping(value = "/doodles", method = RequestMethod.PUT)
    public int createDoodle(@RequestBody Doodle d) {
        doodles.put(id, new Doodle(d));
        id++;
        return (id - 1);
    }

    /**
     * Create a new doodle and insert it in the list of the currently opened doodles.
     * @param title the JSON representation of the title contained in the HTTP request body
     * @param opt the JSON representation of the list of options contained in the HTTP request body
     * @return the JSON representation of the poll ID
     */
    @RequestMapping(value = "/doodles", method = RequestMethod.PUT)
    public int createDoodleExplicit(@RequestBody String title, @RequestBody List<String> opt) {
        doodles.put(id, new Doodle(title, opt));
        id++;
        return (id - 1);
    }

    /**
     * Get the currently opened doodles.
     * @return the doodles
     */
    @RequestMapping(value = "/doodles", method = RequestMethod.GET)
    public HashMap<Integer, Doodle> getDoodles() {
        return doodles;
    }

    /**
     * Get the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @return the doodle
     */
    @RequestMapping(value = "/doodles/{id}", method = RequestMethod.GET)
    public Doodle getDoodle(@PathVariable("id") int id) {
        return doodles.get(id);
    }

    /**
     * Get the title of the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @return the title of the doodle
     */
    @RequestMapping(value = "/doodles/{id}", method = RequestMethod.GET)
    public String getDoodleTitle(@PathVariable("id") int id) {
        return doodles.get(id).getTitle();
    }

    /**
     * Get the options of the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @return the list of the options of the doodle
     */
    @RequestMapping(value = "/doodles/{id}", method = RequestMethod.GET)
    public ArrayList<String> getDoodleOptions(@PathVariable("id") int id) {
        return doodles.get(id).getOptions();
    }

    /**
     * Get the votes of the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @return the votes for each option of the doodle
     */
    @RequestMapping(value = "/doodles/{id}", method = RequestMethod.GET)
    public HashMap<String, ArrayList<String>> getDoodleVotes(@PathVariable("id") int id) {
        return doodles.get(id).getVotes();
    }

    /**
     * Remove the doodle identified by the specific ID.
     * @param id the ID of the doodle
     */
    @RequestMapping(value = "doodles/{id}", method = RequestMethod.DELETE)
    public void deleteDoodle(@PathVariable("id") int id) {
        doodles.remove(id);
    }

    // Operations on the votes

    /**
     * Create a new vote in the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @param v the JSON representation of the vote contained in the HTTP request body
     * @return the name of the voter if the vote is valid, null otherwise
     */
    @RequestMapping(value = "/doodles/{id}/vote", method = RequestMethod.PUT)
    public String addVote(@PathVariable("id") int id, @RequestBody Vote v) {
        if (doodles.containsKey(id) && doodles.get(id).findPreviousVote(v.getName()) == null)
            return doodles.get(id).addVote(v);
        return null;
    }

    /**
     * Get the option voted by the given user in the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @param name the voter
     * @return the option voted by the voter in the doodle, null if the voter has never voted
     */
    @RequestMapping(value = "/doodles/{id}/vote/{name}", method = RequestMethod.GET)
    public String getVote(@PathVariable("id") int id, @PathVariable("name") String name) {
        if (doodles.containsKey(id)) return doodles.get(id).findPreviousVote(name);
        return null;
    }

    /**
     * Post an update to the previous vote of the given user in the doodle identified by the specific ID
     * (it has effect only if the voter already voted in the doodle).
     * @param id the ID of the doodle
     * @param name the voter
     * @param v the JSON representation of the vote contained in the HTTP request body
     * @return the name of the voter if the vote is valid, null otherwise
     */
    @RequestMapping(value = "/doodles/{id}/vote/{name}", method = RequestMethod.POST)
    public String updateVote(@PathVariable("id") int id, @PathVariable("name") String name, @RequestBody Vote v) {
        if (doodles.containsKey(id) && name.equals(v.getName()) &&
                doodles.get(id).findPreviousVote(v.getName()) != null)
            return doodles.get(id).addVote(v);
        return null;
    }

    /**
     * Delete the vote of the given user in the doodle identified by the specific ID.
     * @param id the ID of the doodle
     * @param name the voter
     */
    @RequestMapping(value = "/doodles/{id}/vote/{name}", method = RequestMethod.DELETE)
    public void deleteVote(@PathVariable("id") int id, @PathVariable("name") String name) {
        if (doodles.containsKey(id)) doodles.get(id).removeVote(name);
    }
}
