package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.getters.MaxImageGetter;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * The type Menu item node factory.
 */
public class MenuItemNodeFactory implements IMenuItemNodeFactory {

    private Double iconMaxWidth;

    private Double iconMaxHeight;

    /**
     * Instantiates a new Menu item node factory.
     */
    public MenuItemNodeFactory() {
        this.iconMaxWidth = 15.0;
        this.iconMaxHeight = 15.0;
    }

    @Override
    public Node create(MenuTreeCellFactory treeCell) {
        HBox hBox = new HBox();
        if (treeCell.getTreeItem().getParent() != treeCell.getTreeView().getRoot()) {
            treeCell.getStyleClass().add("sub-tree-item");
        }
        hBox.setSpacing(3);
        if (treeCell.getItem().getResourceIcon() != null) {
            // for gimp: 100, 100, -50
            Image image = new MaxImageGetter(treeCell.getItem().getResourceIcon(), this.iconMaxWidth, this.iconMaxHeight).get();
            hBox.getChildren().add(new ImageView(image));
        }
        hBox.getChildren().add(new Label(treeCell.getItem().getText()));
        if (treeCell.getItem().getSwitchPane() != null) {
            hBox.setOnMouseClicked(event -> {
                ExceptionDialogThrowSneaker.sneaky(() -> {
                    treeCell.getItem().getSwitchPane().run();
                });
            });
        }
        return hBox;
    }

    /**
     * Set icon max size menu item node factory.
     *
     * @param width  the width
     * @param height the height
     * @return the menu item node factory
     */
    public MenuItemNodeFactory setIconMaxSize(Double width, Double height){
        this.iconMaxWidth = width;
        this.iconMaxHeight = height;
        return this;
    }
}
