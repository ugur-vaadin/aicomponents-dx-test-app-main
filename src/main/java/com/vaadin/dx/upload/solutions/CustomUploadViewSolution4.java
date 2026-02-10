package com.vaadin.dx.upload.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.checkbox.Checkbox;
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
 * Solution for Task 4: Disabling uploads
 * (includes Tasks 1-3 solutions)
 */
@Route("solution/4")
@Menu(title = "Solution 4 - Disabling")
public class CustomUploadViewSolution4 extends VerticalLayout {

    private static final Logger logger = LoggerFactory.getLogger(CustomUploadViewSolution4.class);

    public CustomUploadViewSolution4() {
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

        // Task 3: Events
        manager.addFileRejectedListener(event -> {
            Notification.show(event.getFileName() + ": " + event.getErrorMessage());
        });

        manager.addFileRemovedListener(event -> {
            logger.info("File removed: {}", event.getFileName());
        });

        manager.addAllFinishedListener(event -> {
            Notification.show("All uploads complete");
        });

        // Toolbar
        var toolbar = new HorizontalLayout();
        toolbar.setWidthFull();
        toolbar.setPadding(true);
        toolbar.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        var uploadButton = new UploadButton(manager);
        uploadButton.setText("Upload Files");

        // Task 4.1 & 4.2: Add a checkbox that enables/disables the upload
        // functionality securely (at manager level, not just UI)
        var enabledCheckbox = new Checkbox("Enable uploads", true);
        enabledCheckbox.addValueChangeListener(event -> {
            // Using manager.setEnabled() ensures uploads are securely prevented,
            // not just at the UI level
            manager.setEnabled(event.getValue());
        });

        toolbar.add(uploadButton, enabledCheckbox);

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
