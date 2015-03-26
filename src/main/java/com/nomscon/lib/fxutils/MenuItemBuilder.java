package com.nomscon.lib.fxutils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import com.nomscon.lib.utils.OSUtils;

public final class MenuItemBuilder {
    private MenuItem menuItem;

    public MenuItemBuilder() { menuItem = new MenuItem(); }
    public MenuItemBuilder(String text) { menuItem = new MenuItem(text); }
    public MenuItemBuilder(String text, Node graphic) { menuItem = new MenuItem(text, graphic); }

    public static MenuItemBuilder start() { return new MenuItemBuilder(); }
    public static MenuItemBuilder start(String text) { return new MenuItemBuilder(text); }
    public static MenuItemBuilder start(String text, Node graphic) { return new MenuItemBuilder(text, graphic); }

    // Just for balance
    public static SeparatorMenuItem buildSeparator() { return new SeparatorMenuItem(); }

    public MenuItem build() {
        return menuItem;
    }

    public MenuItemBuilder setText(String text) {
        if (text == null || text.isEmpty())
            throw new IllegalArgumentException();
        menuItem.setText(text);
        return this;
    }

    public MenuItemBuilder setGraphic(Node value) {
        if (value == null)
            throw new IllegalArgumentException();
        menuItem.setGraphic(value);
        return this;
    }

    public MenuItemBuilder setAccelerator(String keyComboString) {
        if (keyComboString == null)
            throw new IllegalArgumentException();
        menuItem.setAccelerator(KeyCombination.valueOf(keyComboString));
        return this;
    }

    public MenuItemBuilder setAccelerator(String defaultKeyComboString, String keyComboStringForMacOSX) {
        if(defaultKeyComboString != null && !OSUtils.isMac())
            menuItem.setAccelerator(KeyCombination.valueOf(defaultKeyComboString));
        else if (keyComboStringForMacOSX != null && OSUtils.isMac())
            menuItem.setAccelerator(KeyCombination.valueOf(keyComboStringForMacOSX));
        return this;
    }

    public MenuItemBuilder setOnAction(EventHandler<ActionEvent> handler) {
        menuItem.setOnAction(handler);
        return this;
    }
}
