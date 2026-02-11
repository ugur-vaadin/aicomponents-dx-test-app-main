/*
 * Copyright 2000-2026 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.dx;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ai.component.InputSubmitEvent;
import com.vaadin.flow.component.ai.component.InputSubmitListener;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

import java.io.Serializable;
import java.util.EventListener;

/**
 * A pre-built custom chat input component using native HTML elements.
 */
public class CustomChatInput extends Div {

    private final Element textarea;
    private final NativeButton sendButton;
    private String value = "";

    public CustomChatInput() {
        // Create a native textarea element
        textarea = new Element("textarea");
        textarea.setAttribute("placeholder", "Type a message...");
        textarea.setAttribute("rows", "2");
        textarea.getStyle().set("flex", "1").set("padding", "8px")
                .set("font-size", "14px").set("border", "1px solid #ccc")
                .set("border-radius", "4px").set("resize", "none");

        // Sync value from client to server on input
        textarea.addPropertyChangeListener("value", "input", event -> {
            value = (String) event.getValue();
        });

        sendButton = new NativeButton("Send");
        sendButton.getStyle().set("padding", "8px 16px")
                .set("background", "#1676F3").set("color", "white")
                .set("border", "none").set("border-radius", "4px")
                .set("cursor", "pointer").set("font-size", "14px");

        // Layout: row with textarea and button
        getStyle().set("display", "flex").set("gap", "8px")
                .set("align-items", "flex-end").set("width", "100%");

        getElement().appendChild(textarea);
        add(sendButton);
    }

    /**
     * Returns the current value of the textarea.
     */
    public String getValue() {
        return value;
    }

    /**
     * Clears the textarea.
     */
    public void clear() {
        value = "";
        textarea.setProperty("value", "");
    }

    /**
     * Returns the Send button for attaching click listeners.
     */
    public NativeButton getSendButton() {
        return sendButton;
    }

    public Registration addChatInputSubmitListener(ChatInputSubmitListener listener) {
        return sendButton.addClickListener(event -> listener.onChatInputSubmit(() -> value));
    }

    /**
     * Returns the textarea element for subclasses to attach event listeners
     * (e.g., keyboard shortcuts).
     */
    protected Element getTextarea() {
        return textarea;
    }

    @FunctionalInterface
    public interface ChatInputSubmitListener extends Serializable {
        void onChatInputSubmit(ChatInputSubmitEvent event);
    }

    public interface ChatInputSubmitEvent extends Serializable {
        String getValue();
    }
}
