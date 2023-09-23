package com.firstProject.pollService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PollService",
        url = "${externalApi.pollService.url}"
)
public interface PollService {
    @DeleteMapping(value = "/userAnswers/deleteAnswers/{userId}")
    void deleteAnswersByUserId(@PathVariable Long userId);
}
