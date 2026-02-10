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
 * Solution for Task 1: Building a custom upload UI with separated layout
 */
@Route("solution/1")
@Menu(title = "Solution 1 - Basic Setup")
public class CustomUploadViewSolution1 extends VerticalLayout {

    private static final Logger logger = LoggerFactory.getLogger(CustomUploadViewSolution1.class);

    public CustomUploadViewSolution1() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);

        // Task 1.1: Set up upload functionality that stores files in memory
        // and logs the file name when upload completes
        var manager = new UploadManager(this,
                UploadHandler.inMemory((metadata, data) -> {
                    logger.info("Uploaded file: {}", metadata.fileName());
                }));

        // Task 1.2: Create the layout structure

        // Toolbar at the top
        var toolbar = new HorizontalLayout();
        toolbar.setWidthFull();
        toolbar.setPadding(true);

        // Task 1.3: Add an upload button in the toolbar
        var uploadButton = new UploadButton(manager);
        uploadButton.setText("Upload Files");
        toolbar.add(uploadButton);

        // Main content and sidebar container
        var contentContainer = new HorizontalLayout();
        contentContainer.setSizeFull();
        contentContainer.setSpacing(false);

        // Main content area with drop zone
        var mainContent = new VerticalLayout();
        mainContent.setPadding(true);

        // Task 1.4: Add a drop zone in the main content area
        var dropZone = new UploadDropZone(manager);
        dropZone.add(new Span("Drop files here"));
        dropZone.setSizeFull();
        dropZone.setMinHeight("200px");
        mainContent.addAndExpand(dropZone);

        // Sidebar with file list
        var sidebar = new VerticalLayout();
        sidebar.setWidth("280px");
        sidebar.setPadding(true);
        sidebar.setSpacing(true);

        // Task 1.5: Add a file list in the sidebar
        sidebar.add(new H4("Uploads"));
        var fileList = new UploadFileList(manager);
        sidebar.add(fileList);

        contentContainer.addAndExpand(mainContent);
        contentContainer.add(sidebar);

        add(toolbar);
        addAndExpand(contentContainer);
    }
}
