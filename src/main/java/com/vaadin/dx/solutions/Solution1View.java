package com.vaadin.dx.solutions;

import com.vaadin.flow.component.ai.orchestrator.AiOrchestrator;
import com.vaadin.flow.component.ai.provider.LangChain4JLLMProvider;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.router.Route;

import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

@Route("solution1")
public class Solution1View extends Div {

    public Solution1View() {
        var messageList = new MessageList();
        var messageInput = new MessageInput();

        var provider = new LangChain4JLLMProvider(
                OpenAiStreamingChatModel.builder()
                        .modelName("gpt-4o-mini")
                        .apiKey(System.getenv("OPENAI_API_KEY")).build());

        AiOrchestrator.builder(provider).withMessageList(messageList)
                .withInput(messageInput).build();

        add(messageList, messageInput);
    }
}
