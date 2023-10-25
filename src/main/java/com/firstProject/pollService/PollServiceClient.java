package com.firstProject.pollService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@FeignClient(
        name = "PollServiceClient",
        url = "${PollServiceClient.url}"
)
public interface PollServiceClient {

    @DeleteMapping("/userAnswer/delete/{userAnswerId}")
    void deleteUserAnswerById(@PathVariable Long id);
}
