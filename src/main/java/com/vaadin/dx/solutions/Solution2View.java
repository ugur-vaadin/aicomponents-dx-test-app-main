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

@Route("solution2")
public class Solution2View extends Div {

    public Solution2View() {
        var messageList = new MessageList();
        var customInput = new UpdatedCustomChatInput();

        var provider = new LangChain4JLLMProvider(
                OpenAiStreamingChatModel.builder()
                        .modelName("gpt-4o-mini")
                        .apiKey(System.getenv("OPENAI_API_KEY")).build());

        AiOrchestrator.builder(provider)
                .withMessageList(messageList)
                .withInput(customInput).build();

        add(messageList, customInput);
    }

    private static class UpdatedCustomChatInput extends CustomChatInput implements AiInput {

        @Override
        public void addSubmitListener(InputSubmitListener inputSubmitListener) {
            addChatInputSubmitListener(e -> inputSubmitListener.onSubmit(e::getValue));
        }
    }
}
