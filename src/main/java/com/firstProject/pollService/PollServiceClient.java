package com.firstProject.pollService;

import com.firstProject.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PollService",
        url = "http://localhost:8081"
)
public interface PollServiceClient {

    @DeleteMapping(value = "/answerByUserId/deleteAnswers/{userId}")
    void deleteAnswersByUserId(@PathVariable Long userId);

    @GetMapping(value = "/user")
    UserResponse getUserResponseByEmail(@PathVariable String email);
}
