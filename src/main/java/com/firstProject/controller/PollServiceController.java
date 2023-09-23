package com.firstProject.controller;

import com.firstProject.pollService.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollServiceController {
    @Autowired
    private PollService pollService;

    @DeleteMapping(value = "/delete/pollAnswers/{customerId}")
    public void deleteAnswersById(@PathVariable Long userId) {
        pollService.deleteAnswersByUserId(userId);
    }
}
