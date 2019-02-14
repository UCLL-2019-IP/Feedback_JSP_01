package be.ucll.feedback.controller;

import be.ucll.feedback.model.Feedback;
import be.ucll.feedback.model.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class FeedbackController implements WebMvcConfigurer {
    @Autowired
    private FeedbackService feedbackService; //= new feedbackService();

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/feedback")
    public String feedback(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "feedbacks";
    }

    @GetMapping("/feedback/add")
    public String addFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "addFeedback";
    }

    @PostMapping("/feedback/add")
    public String addFeedback(@Valid Feedback feedback, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "addFeedback";
        } else {
            feedbackService.addFeedback(feedback);
            model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
            return "feedbacks";
        }
    }
}
