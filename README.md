# AI Components DX Test App

This is a DX test application for Vaadin AI Components. Participants progressively build an AI-powered chat interface in a single workspace view, with each task building on the previous one.

## Running the Application

To start the application in development mode, import it into your IDE and run the `Application` class.
You can also start the application from the command line by running:

```bash
mvn spring-boot:run
```

Then open: http://localhost:8080

## Instructions for Facilitators

1. Have participants open the application
2. Read each task description from `AI_COMPONENTS_DX_TESTS.md`
3. Participants implement all tasks in `TaskView.java`, building on their previous work

## File Structure

```
src/main/java/com/vaadin/dx/
├── CustomChatInput.java    # Pre-built input
└── TaskView.java           # Participant workspace
```
