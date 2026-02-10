package com.vaadin.dx.upload;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

/**
 * DX Test View for Custom Upload functionality.
 * <p>
 * Your goal is to build a file upload interface where the UI components are
 * placed in <b>different areas of the layout</b>:
 * <ul>
 *   <li>A <b>toolbar</b> at the top contains the upload button</li>
 *   <li>The <b>main content area</b> has a drop zone spanning the available width</li>
 *   <li>A <b>sidebar</b> on the right shows the file list with upload progress</li>
 * </ul>
 *
 * <pre>
 * ┌─────────────────────────────────────────────────────────────┐
 * │  TOOLBAR                                                    │
 * │  ┌─────────────────┐                                        │
 * │  │  Upload Button  │                                        │
 * │  └─────────────────┘                                        │
 * ├─────────────────────────────────────────────┬───────────────┤
 * │                                             │  SIDEBAR      │
 * │  MAIN CONTENT                               │               │
 * │  ┌────────────────────────────────────────┐ │  File List:   │
 * │  │                                        │ │  ┌─────────┐  │
 * │  │           DROP ZONE                    │ │  │ file1   │  │
 * │  │        (Drop files here)               │ │  │ ███░░░  │  │
 * │  │                                        │ │  ├─────────┤  │
 * │  └────────────────────────────────────────┘ │  │ file2   │  │
 * │                                             │  │ █████░  │  │
 * │                                             │  └─────────┘  │
 * └─────────────────────────────────────────────┴───────────────┘
 * </pre>
 *
 * This layout requires the upload components to be placed in separate locations,
 * which cannot be achieved with the regular Upload component. Find the appropriate
 * Vaadin components/APIs to build this modular upload UI.
 *
 * <h2>Task 1. Building a custom upload UI</h2>
 * <ol>
 *   <li>Set up the upload functionality that stores uploaded files in memory
 *       and logs the file name when upload completes</li>
 *   <li>Create the layout structure (toolbar, main content area, sidebar)</li>
 *   <li>Add an upload button in the toolbar</li>
 *   <li>Add a drop zone in the main content area (with text "Drop files here")</li>
 *   <li>Add a file list in the sidebar showing upload progress</li>
 * </ol>
 *
 * <h2>Task 2. Configuring upload constraints</h2>
 * <ol>
 *   <li>Limit the upload to accept only image files</li>
 *   <li>Limit the maximum file size to 5 MB</li>
 *   <li>Limit the number of files to 3</li>
 * </ol>
 *
 * <h2>Task 3. Handling events</h2>
 * <ol>
 *   <li>When a file is rejected (e.g., wrong type, too large, too many files),
 *       show a notification with the file name and reason</li>
 *   <li>When a file is removed by the user, log the file name to the console</li>
 *   <li>When all uploads have finished, show a notification saying
 *       "All uploads complete"</li>
 * </ol>
 *
 * <h2>Task 4. Disabling uploads</h2>
 * <ol>
 *   <li>Add a checkbox that enables/disables the upload functionality</li>
 *   <li>Make sure uploads are securely prevented when disabled
 *       (not just UI-level)</li>
 * </ol>
 *
 * <h2>Task 5. Manual upload control</h2>
 * <ol>
 *   <li>Disable auto-upload so files are not uploaded immediately after
 *       selection</li>
 *   <li>Clear all files from the file list when a "Clear" button is clicked</li>
 * </ol>
 */
@Route("")
@Menu(title = "Custom Upload View")
public class CustomUploadView extends VerticalLayout {

    public CustomUploadView() {
        // Implement the tasks here
        add("This is the Custom Upload View. Implement the tasks as described in the JavaDoc.");
    }
}
