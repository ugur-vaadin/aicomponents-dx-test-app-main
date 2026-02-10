package com.vaadin.dx.upload.solutions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
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
 * Solution for Task 2: Configuring upload constraints
 * (includes Task 1 solution)
 */
@Route("solution/2")
@Menu(title = "Solution 2 - Constraints")
public class CustomUploadViewSolution2 extends VerticalLayout {

    private static final Logger logger = LoggerFactory.getLogger(CustomUploadViewSolution2.class);

    public CustomUploadViewSolution2() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        // Task 1: Basic setup
        var manager = new UploadManager(this,
                UploadHandler.inMemory((metadata, data) -> {
                    logger.info("Uploaded file: {}", metadata.fileName());
                }));

        // Task 2.1: Limit the upload to accept only image files
        manager.setAcceptedFileTypes("image/*");

        // Task 2.2: Limit the maximum file size to 5 MB
        manager.setMaxFileSize(5 * 1024 * 1024);

        // Task 2.3: Limit the number of files to 3
        manager.setMaxFiles(3);

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
