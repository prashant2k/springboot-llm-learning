package com.prashant.llm.service;

import com.prashant.llm.dto.ChatRequest;
import com.prashant.llm.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class LlmService {

    private final ChatClient chatClient;

    public LlmService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public ChatResponse chat(ChatRequest request) {

        String response = chatClient
                .prompt()
                .user(request.getPrompt())
                .call()
                .content();

        return new ChatResponse(response);
    }
}