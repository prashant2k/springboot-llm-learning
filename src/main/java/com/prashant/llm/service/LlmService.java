package com.prashant.llm.service;

import com.prashant.llm.dto.ChatRequest;
import com.prashant.llm.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class LlmService {

    @Value("${app.ai.system-prompt}")
    private String systemPrompt;

    private final ChatClient chatClient;

    public LlmService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public ChatResponse chat(ChatRequest request) {

        String response = chatClient
                .prompt()
                .system(systemPrompt)
                .user(request.getPrompt())
                .call()
                .content();

        return new ChatResponse(response);
    }
}