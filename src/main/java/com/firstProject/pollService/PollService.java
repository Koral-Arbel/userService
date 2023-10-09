package com.firstProject.pollService;

import com.firstProject.model.UserResponse;
import org.h2.engine.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "PollService",
        url = "${externalApi.pollService.url}"
)
public interface PollService {


    @DeleteMapping(value = "/answerByUserId/deleteAnswers/{userId}")
    void deleteAnswersByUserId(@PathVariable Long userId);

    @GetMapping(value = "/user")
    UserResponse getUserByEmail(@RequestParam String email);
}
