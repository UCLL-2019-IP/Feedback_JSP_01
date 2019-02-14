package be.ucll.feedback.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    List<Feedback> feedbacks = new ArrayList<Feedback>();

    // hardcode some values, definitively not the way to go !!!!
    public FeedbackService() {
        feedbacks.add(new Feedback(1, "Rudy","Dat kan hier veel beter!"));
        feedbacks.add(new Feedback(2, "Elke","Dit is het beste wat je kan krijgen!"));
        feedbacks.add(new Feedback(3, "Rudi","Dat gaat hier niet vooruit!"));
    }

    // just return the whole list, JSP page takes care of presentation
    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

    // look for a feedback by id (see controller)
    public Feedback findFeedbackById(int id) {
        for(Feedback feedback : feedbacks){
            if(feedback.getId() == id){
                return feedback;
            }
        }
        //return null;
        // beter nog: throw exception!
        throw new IllegalArgumentException("You really messed up your numbers!");
    }

    // look for a feedback by name (see controller)
    public Feedback findFeedbackByName(String name) {
        for(Feedback feedback : feedbacks){
            if(name.equals(feedback.getName())){
                return feedback;
            }
        }
        return null;
        // beter nog: throw exception!
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public void deleteFeedback(Feedback feedback) {
        feedbacks.remove(feedback);
    }
}
