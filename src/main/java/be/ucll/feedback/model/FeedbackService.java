package be.ucll.feedback.model;

//import be.ucll.feedback.repository.FeedbackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
/* Elke
    @Autowired
    private FeedbackRepository feedbackRepository; // = new feedbackRepository();
*/

    List<Feedback> feedbacks = new ArrayList<Feedback>();

    public FeedbackService() {
        feedbacks.add(new Feedback(1, "Rudy","Dat kan hier veel beter!"));
        feedbacks.add(new Feedback(2, "Elke","Dit is het beste wat je kan krijgen!"));
        feedbacks.add(new Feedback(3, "Rudi","Dat gaat hier niet vooruit!"));
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }

    public Feedback findFeedbackById(int id) {
        for(Feedback feedback : feedbacks){
            if(feedback.getId() == id){
                return feedback;
            }
        }
        return null;
        // beter nog: throw exception!
    }

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
