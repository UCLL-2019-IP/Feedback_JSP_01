package be.ucll.feedback.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FeedbackService {
    List<Feedback> feedbacks = new ArrayList<Feedback>();
    // thread safe int to set id in feedback
    private AtomicInteger nextId = new AtomicInteger();

    // hardcode some values, definitively not the way to go !!!!
    public FeedbackService() {
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Rudy","Dat kan hier veel beter!"));
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Elke","Dit is het beste wat je kan krijgen!"));
        feedbacks.add(new Feedback(nextId.incrementAndGet(), "Rudi","Dat gaat hier niet vooruit!"));
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
        feedback.setId(nextId.incrementAndGet());
        feedbacks.add(feedback);
    }

    public void deleteFeedback(Feedback feedback) {
        feedbacks.remove(feedback);
    }
}
