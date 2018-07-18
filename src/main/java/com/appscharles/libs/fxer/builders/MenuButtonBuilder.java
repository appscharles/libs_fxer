package com.appscharles.libs.fxer.builders;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.util.function.Consumer;

/**
 * The type Menu button builder.
 */
public class MenuButtonBuilder {

    private MenuButton menuButton;

    private MenuButtonBuilder() {

    }

    /**
     * Create menu button builder.
     *
     * @param text the text
     * @return the menu button builder
     */
    public static MenuButtonBuilder create(String text) {
        MenuButtonBuilder instance = new MenuButtonBuilder();
        instance.menuButton = new MenuButton(text);
        return instance;
    }

    /**
     * Add menu item menu button builder.
     *
     * @param text     the text
     * @param onAction the on action
     * @return the menu button builder
     */
    public MenuButtonBuilder addMenuItem(String text, Consumer<ActionEvent> onAction) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction((ActionEvent event) -> {
            onAction.accept(event);
        });
        this.menuButton.getItems().add(menuItem);
        return this;
    }

    /**
     * Build menu button.
     *
     * @return the menu button
     */
    public MenuButton build() {
        return this.menuButton;
    }

    /**
     * Gets menu button.
     *
     * @return the menu button
     */
    public MenuButton getMenuButton() {
        return this.menuButton;
    }
}
