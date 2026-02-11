package com.vaadin.dx.solutions;

import com.vaadin.dx.CustomChatInput;
import com.vaadin.flow.component.ai.component.AiInput;
import com.vaadin.flow.component.ai.component.InputSubmitListener;
import com.vaadin.flow.component.ai.orchestrator.AiOrchestrator;
import com.vaadin.flow.component.ai.provider.LangChain4JLLMProvider;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.router.Route;

import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

@Route("solution3")
public class Solution3View extends Div {

    public Solution3View() {
        var messageList = new MessageList();
        var customInput = new UpdatedCustomChatInput();

        var provider = new LangChain4JLLMProvider(
                OpenAiStreamingChatModel.builder()
                        .modelName("gpt-4o-mini")
                        .apiKey(System.getenv("OPENAI_API_KEY")).build());

        AiOrchestrator
                .builder(provider,
                        "You are a helpful cooking assistant. You help users "
                                + "with recipes, cooking techniques, ingredient "
                                + "substitutions, and meal planning. Be friendly "
                                + "and enthusiastic about food.")
                .withMessageList(messageList).withInput(customInput)
                .withUserName("Chef").withAiName("Sous Chef").build();

        add(messageList, customInput);
    }

    private static class UpdatedCustomChatInput extends CustomChatInput
            implements AiInput {

        @Override
        public void addSubmitListener(
                InputSubmitListener inputSubmitListener) {
            addChatInputSubmitListener(
                    e -> inputSubmitListener.onSubmit(e::getValue));
        }
    }
}
