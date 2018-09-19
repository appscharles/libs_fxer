package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.models.MenuItemTreeView;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;

/**
 * The type Menu tree cell.
 */
public class MenuTreeCellFactory extends TreeCell<MenuItemTreeView> {

    private Node node;

    private IMenuItemNodeFactory menuItemNodeBuilder;

    public MenuTreeCellFactory(IMenuItemNodeFactory menuItemNodeBuilder){
        this.menuItemNodeBuilder = menuItemNodeBuilder;
    }

    @Override
    protected void updateItem(MenuItemTreeView item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            if (this.node == null){
                this.node = this.menuItemNodeBuilder.create(this);
            }
            setGraphic(this.node);
        } else {
            setText("");
            setGraphic(null);
        }
    }
}
