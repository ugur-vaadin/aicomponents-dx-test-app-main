package com.vaadin.dx.upload.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.UploadButton;
import com.vaadin.flow.component.upload.UploadDropZone;
import com.vaadin.flow.component.upload.UploadFileList;
import com.vaadin.flow.component.upload.UploadManager;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.UploadHandler;

/**
 * Solution for Task 3: Handling events
 * (includes Tasks 1-2 solutions)
 */
@Route("solution/3")
@Menu(title = "Solution 3 - Events")
public class CustomUploadViewSolution3 extends VerticalLayout {

    private static final Logger logger = LoggerFactory.getLogger(CustomUploadViewSolution3.class);

    public CustomUploadViewSolution3() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        // Task 1: Basic setup
        var manager = new UploadManager(this,
                UploadHandler.inMemory((metadata, data) -> {
                    logger.info("Uploaded file: {}", metadata.fileName());
                }));

        // Task 2: Constraints
        manager.setAcceptedFileTypes("image/*");
        manager.setMaxFileSize(5 * 1024 * 1024);
        manager.setMaxFiles(3);

        // Task 3.1: When a file is rejected, show a notification with the file
        // name and reason
        manager.addFileRejectedListener(event -> {
            Notification.show(event.getFileName() + ": " + event.getErrorMessage());
        });

        // Task 3.2: When a file is removed by the user, log the file name to
        // the console
        manager.addFileRemovedListener(event -> {
            logger.info("File removed: {}", event.getFileName());
        });

        // Task 3.3: When all uploads have finished, show a notification
        manager.addAllFinishedListener(event -> {
            Notification.show("All uploads complete");
        });

        // Toolbar
        var toolbar = new HorizontalLayout();
        toolbar.setWidthFull();
        toolbar.setPadding(true);

        var uploadButton = new UploadButton(manager);
        uploadButton.setText("Upload Files");
        toolbar.add(uploadButton);

        // Main content and sidebar container
        var contentContainer = new HorizontalLayout();
        contentContainer.setSizeFull();
        contentContainer.setSpacing(false);

        // Main content area
        var mainContent = new VerticalLayout();
        mainContent.setPadding(true);

        var dropZone = new UploadDropZone(manager);
        dropZone.add(new Span("Drop files here"));
        dropZone.setSizeFull();
        dropZone.setMinHeight("200px");
        mainContent.addAndExpand(dropZone);

        // Sidebar
        var sidebar = new VerticalLayout();
        sidebar.setWidth("280px");
        sidebar.setPadding(true);
        sidebar.setSpacing(true);

        sidebar.add(new H4("Uploads"));
        var fileList = new UploadFileList(manager);
        sidebar.add(fileList);

        contentContainer.addAndExpand(mainContent);
        contentContainer.add(sidebar);

        add(toolbar);
        addAndExpand(contentContainer);
    }
}
