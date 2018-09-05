package com.appscharles.libs.fxer.adders;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * The type Children pane order adder.
 */
public class ChildrenPaneOrderAdder {

    /**
     * Add.
     *
     * @param containerPane the container pane
     * @param child         the child
     * @param order         the order
     */
    public static void add(Pane containerPane, Parent child, Integer order) {
        if (containerPane.getChildren().size() >= order + 1){
            containerPane.getChildren().add(order, child);
        } else {
            containerPane.getChildren().add(child);
        }
    }
}
