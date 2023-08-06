package com.rrayor.sagaflow.test;

import com.rrayor.sagaflow.test.internal.dto.CreateTestDto;
import com.rrayor.sagaflow.test.internal.dto.GetTestDto;
import com.rrayor.sagaflow.test.internal.service.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("test")
@RequiredArgsConstructor
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final TestService testService;

    @GetMapping("")
    public String test() {
        return "Test is alive!";
    }

    @PostMapping("")
    public void createTest(@RequestBody final CreateTestDto dto) {
        testService.createTest(dto);
    }

    @GetMapping("/{id}")
    public GetTestDto getTest(@PathVariable final Long id) {
        log.info("Test request");
        return testService.getTest(id);
    }
}
