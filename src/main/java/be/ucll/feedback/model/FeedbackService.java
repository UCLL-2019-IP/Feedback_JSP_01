package be.ucll.feedback.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FeedbackService {
    private List<Feedback> feedbacks = new ArrayList<Feedback>();
    private AtomicInteger nextId = new AtomicInteger();

    public FeedbackService() {
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Rudy", "Dat kan hier veel beter!"));
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Elke", "Dit is het beste wat je kunt krijgen!"));
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Rudi", "Dat gaat hier niet vooruit!"));
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbacks;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public Feedback findFeedbackById(int id) {
        for(Feedback feedback : feedbacks){
            if(feedback.getId() == id){
                return feedback;
            }
        }

        // return null;

        throw new IllegalArgumentException("You really messed up your numbers!");
    }
}
