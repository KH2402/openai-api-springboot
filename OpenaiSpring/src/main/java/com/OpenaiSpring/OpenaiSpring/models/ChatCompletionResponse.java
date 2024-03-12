package com.OpenaiSpring.OpenaiSpring.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionResponse {

    private List<Choice> choices;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice{
        private int index;
        private ChatMessage message;
    }
}
