package com.vaadin.dx.solutions;

import com.vaadin.dx.CustomChatInput;
import com.vaadin.dx.RecipeHelper;
import com.vaadin.flow.component.ai.component.AiInput;
import com.vaadin.flow.component.ai.component.InputSubmitListener;
import com.vaadin.flow.component.ai.orchestrator.AiOrchestrator;
import com.vaadin.flow.component.ai.provider.LangChain4JLLMProvider;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.upload.UploadButton;
import com.vaadin.flow.component.upload.UploadFileList;
import com.vaadin.flow.component.upload.UploadManager;
import com.vaadin.flow.router.Route;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

@Route("solution6")
public class Solution6View extends Div {

    public Solution6View() {
        var messageList = new MessageList();
        var customInput = new UpdatedCustomChatInput();
        var upload = new UploadManager(this);
        var uploadButton = new UploadButton(upload);
        uploadButton.setText("Upload");
        var uploadFileList = new UploadFileList(upload);

        var provider = new LangChain4JLLMProvider(
                OpenAiStreamingChatModel.builder()
                        .modelName("gpt-4o-mini")
                        .apiKey(System.getenv("OPENAI_API_KEY")).build());

        var orchestrator = AiOrchestrator
                .builder(provider,
                        "You are a helpful cooking assistant. You help users "
                                + "with recipes, cooking techniques, ingredient "
                                + "substitutions, and meal planning. Be friendly "
                                + "and enthusiastic about food.")
                .withMessageList(messageList).withInput(customInput)
                .withFileReceiver(upload).withUserName("Chef")
                .withAiName("Sous Chef")
                .withTools(new RecipeLookupTool()).build();

        var salmonSoupButton = new NativeButton("Get Salmon Soup Recipe",
                e -> orchestrator
                        .prompt("Give me a salmon soup recipe"));

        add(messageList, uploadButton, uploadFileList, salmonSoupButton,
                customInput);
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

    public static class RecipeLookupTool {

        @Tool("Look up a recipe by name. Returns the recipe details including ingredients and instructions.")
        public String lookupRecipe(String recipeName) {
            return RecipeHelper.getRecipe(recipeName);
        }
    }
}
