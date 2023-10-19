package com.firstProject.pollService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@FeignClient(
        name = "PollServiceClient",
        url = "http://localhost:8081",
        path = "PollServiceClient"
)
public interface PollServiceClient {

    @DeleteMapping(value = "/delete/{userAnswerId}")
    void deleteUserAnswerById(@PathVariable Long userAnswerId);
}
