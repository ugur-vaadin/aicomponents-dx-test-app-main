package com.vaadin.dx;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class TaskView extends Div {

    // =============================================================
    // TASK 1: Building a basic AI chat interface
    // =============================================================
    //
    // 1) Build a simple AI chat interface where:
    //
    // - There is a message list that displays the conversation
    // - There is an input field where the user can type and
    // submit messages
    // - The full response appears at once
    //
    // Use only built-in Vaadin components for this task.
    //
    // 2) Update the implementation so that the response keeps
    // appending to the text over time until it is complete.
    //
    // =============================================================
    // TASK 2: Custom components
    // =============================================================
    //
    // 1) A pre-built custom input component called CustomChatInput
    // is available. Replace the standard message input from the
    // previous task with this custom component.
    //
    // =============================================================
    // TASK 3: Configuring the assistant
    // =============================================================
    //
    // 1) Give the assistant a cooking assistant persona so that its
    // behavior is guided by instructions you define.
    //
    // 2) Change the display names so that the user appears as
    // "Chef" and the assistant as "Sous Chef" instead of the
    // defaults.
    //
    // =============================================================
    // TASK 4: File attachments
    // =============================================================
    //
    // 1) Add file upload support.
    //
    // 2) Upload the photo "runeberginTorttu.jpeg" under resources
    // and ask the assistant to identify.
    //
    // =============================================================
    // TASK 5: Programmatical requests
    // =============================================================
    //
    // 1) Add a button for requesting a salmon soup recipe from the
    // assistant.
    //
    // =============================================================
    // TASK 6: Using tools
    // =============================================================
    //
    // 1) Add a recipe lookup tool with a few recipes that the
    // assistant can call to find recipe details. You can use the
    // RecipeHelper class to create the tool.
    //
    // 2) Ask for a recipe specified in the tool.

    public TaskView() {
        // TODO implement here
    }
}
