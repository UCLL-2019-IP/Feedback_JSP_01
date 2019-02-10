package ucll.be.feedback.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ucll.be.feedback.model.Feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class FeedbackController {
    // list to keep track of all the feeback
    private List<Feedback> feedbacks = new ArrayList<Feedback>();
    // thread save int to set id in feedback
    private AtomicInteger nextId = new AtomicInteger();

    @GetMapping("/hello")
    public String getHelloMessage(){
        return "Hello from Spring Boot!";
    }

    // this method receives a feedback and stores it
    // note that the name of the method doesn't matter all that much!
    // need the @RequestBody to know where the feedback is supposed to come from
    @PostMapping("/feedback") // don't forget the slash!!!
    @ResponseStatus(HttpStatus.CREATED) // give the correct status back!
    public Feedback createNewFeedback(@RequestBody Feedback feedback){
        // set id with nextId, first increment, then get, so...
        feedback.setId(nextId.incrementAndGet());
        feedbacks.add(feedback);
        return feedback;
    }

    // this method returns all the available feedbacks
    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback(){
        return feedbacks;
    }

    // this method returns a specific feedback, based on the id the user provided
    // need the @PathVariable("id") to know where the feedbackId is supposed to come from
    @GetMapping("/feedback/{id}") // don't forget the slashes!!!
    public Feedback getSpecificFeedback(@PathVariable("id") int feedbackId){
        for(Feedback feedback : feedbacks){
            if(feedback.getId() == feedbackId){
                return feedback;
            }
        }
        // return null if nothing found. Not the best idea ever!
        //return null;

        // better way: throw an error
        throw new IllegalArgumentException("You really messed up your numbers now!");
    }

    // this method lets you update a specific feedback, based on the id the user provided
    // need the @PathVariable("id") to know where the feedbackId is supposed to come from
    // need the @RequestBody to know where the feedback is supposed to come from
    @PutMapping("/feedback/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT) // give the correct status back!
    public Feedback editSpecificFeedback(@PathVariable("id") int feedbackId, @RequestBody Feedback changedFeedback){
        for(Feedback feedback : feedbacks){
            if(feedback.getId() == feedbackId){
                feedback.setId(feedbackId); // use this because otherwise the user could change the id in the new feedback
                feedback.setName(changedFeedback.getName());
                feedback.setFeedback(changedFeedback.getFeedback());
                return feedback;
            }
        }

        // throw exception if not found!
        // this gives a 500 error, which is a server error, and actually, it's not the server...
        throw new IllegalArgumentException("You really messed up your numbers now!");
    }

    // give the correct error back with this handler, 400 in stead of 500
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        // really nothing to do here
    }

}

