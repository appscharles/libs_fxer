package com.appscharles.libs.fxer.factories;

import com.appscharles.libs.fxer.getters.MaxImageGetter;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 19.09.2018
 * Time: 08:48
 * Project name: getter
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class MenuItemNodeFactory implements IMenuItemNodeFactory {

    @Override
    public Node create(MenuTreeCellFactory treeCell) {
        HBox hBox = new HBox();
        if (treeCell.getTreeItem().getParent() != treeCell.getTreeView().getRoot()) {
            treeCell.getStyleClass().add("sub-tree-item");
        }
        hBox.setSpacing(3);
        if (treeCell.getItem().getResourceIcon() != null) {
            // for gimp: 100, 100, -50
            Image image = new MaxImageGetter(treeCell.getItem().getResourceIcon(), 15.0, 15.0).get();
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
}
