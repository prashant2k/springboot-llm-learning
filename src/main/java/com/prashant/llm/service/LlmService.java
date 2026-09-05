package com.prashant.llm.service;

import com.prashant.llm.dto.ChatRequest;
import com.prashant.llm.dto.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class LlmService {

    public ChatResponse chat(ChatRequest request) {

        return new ChatResponse(
                "You asked: " + request.getPrompt()
        );
    }
}