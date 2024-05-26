package com.guuri11.lotrascii.helpers.Network;

import java.util.List;

import dev.ai4j.openai4j.OpenAiClient;
import dev.ai4j.openai4j.chat.AssistantMessage;
import dev.ai4j.openai4j.chat.ChatCompletionModel;
import dev.ai4j.openai4j.chat.ChatCompletionRequest;
import dev.ai4j.openai4j.chat.Message;

public class NetworkManager {

    public interface NetworkCallback {
        void onCommandSuccess(String response);
        void onCommandError(String error);
    }

    public void sendToGPT(List<Message> messages, NetworkCallback callback) {
        String openAiKey = "OPEN_AI_KEY_PASTED_HERE";
        OpenAiClient client = OpenAiClient.builder()
                .openAiApiKey(openAiKey)
                .build();

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model(ChatCompletionModel.GPT_3_5_TURBO_0125)
                .messages(messages)
                .build();

        client.chatCompletion(request)
                .onResponse(response -> {
                    messages.add(AssistantMessage.from(response.content()));
                    callback.onCommandSuccess(response.content());
                })
                .onError(error -> callback.onCommandError(error.getMessage()))
                .execute();
    }
}
