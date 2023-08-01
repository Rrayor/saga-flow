package com.rrayor.sagaflowbackend.test;

import com.rrayor.sagaflowbackend.test.internal.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public final class TestController {
    private final TestService testService;

    @PostMapping("")
    public void createTest(@RequestBody final CreateTestDto dto) {
        testService.createTest(dto);
    }

    @GetMapping("/{id}")
    public GetTestDto getTest(@PathVariable final Long id) {
        return testService.getTest(id);
    }
}
