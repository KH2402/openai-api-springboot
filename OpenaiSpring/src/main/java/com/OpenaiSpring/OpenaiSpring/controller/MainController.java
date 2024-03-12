package com.OpenaiSpring.OpenaiSpring.controller;

import com.OpenaiSpring.OpenaiSpring.dto.RequestBodyDto;
import com.OpenaiSpring.OpenaiSpring.models.ChatCompletionRequest;
import com.OpenaiSpring.OpenaiSpring.models.ChatCompletionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/hitOpenaiApi")
    public String getOpenaiResponse(@RequestBody RequestBodyDto requestBodyDto){
        ChatCompletionRequest chatCompletionRequest=new ChatCompletionRequest("gpt-3.5-turbo",requestBodyDto.getPrompt());
        ChatCompletionResponse response=this.restTemplate.postForObject("https://api.openai.com/v1/chat/completions",chatCompletionRequest,ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
