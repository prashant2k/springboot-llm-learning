package com.prashant.llm.controller;

import com.prashant.llm.dto.ChatRequest;
import com.prashant.llm.dto.ChatResponse;
import com.prashant.llm.service.LlmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class LlmController {

    private final LlmService llmService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(
            @Valid @RequestBody ChatRequest request) {

        return ResponseEntity.ok(llmService.chat(request));
    }
}