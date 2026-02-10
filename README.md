# Upload Manager DX Test Application

This is a test application for DX testing the new modular upload feature in Vaadin 25.1.

## Prerequisites

- Java 21 or later
- Maven 3.8 or later

## Running the Application

```bash
mvn spring-boot:run
```

The application will start at http://localhost:8080

## Project Structure

- `src/main/java/com/vaadin/dx/upload/CustomUploadView.java` - The main view where participants implement the tasks
- `src/main/java/com/vaadin/dx/upload/solutions/` - Solution views for each task (for facilitators only)

## Views

| Route         | Description                                   |
| ------------- | --------------------------------------------- |
| `/`           | Main view for participants to implement tasks |
| `/solution/1` | Solution for Task 1 - Basic Setup             |
| `/solution/2` | Solution for Task 2 - Constraints             |
| `/solution/3` | Solution for Task 3 - Events                  |
| `/solution/4` | Solution for Task 4 - Disabling               |
| `/solution/5` | Solution for Task 5 - Manual Control          |

## Notes for Facilitators

- Solutions are cumulative - each solution includes all previous task implementations
- The solutions package is in a separate folder to avoid participants accidentally seeing them
- Navigate to solution views only when needed to help participants
