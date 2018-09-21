package com.appscharles.libs.fxer.hidders;

import com.google.common.collect.Lists;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import org.reactfx.value.Val;

import java.util.List;

/**
 * The type Pane auto hidder.
 */
public class PaneAutoHidder {

    /**
     * Auto hide.
     *
     * @param pane the pane
     */
    public static void autoHide(Pane pane){
        pane.setVisible(false);
        pane.setManaged(false);
        Val<Boolean> showing = Val.flatMap(pane.sceneProperty(), Scene::windowProperty).flatMap(Window::showingProperty);
        showing.addListener((args, oldVal, newVal)->{
            List<Node> assigned = Lists.newArrayList();
            pane.getChildren().addListener((ListChangeListener<Node>) list->{
                assign(pane, assigned,  Lists.newArrayList(list.getList()));
            });
            assign(pane, assigned, pane.getChildren());
        });
    }

    private static void assign(Pane pane, List<Node> assigned, List<Node> list) {
        for (Node child : list) {
            if (assigned.contains(child)){
                continue;
            }
            child.visibleProperty().addListener((args, oldVal, newVal)->{
                Boolean childVisible = false;
                for (Node widgetsContainerPaneChild : pane.getChildren()) {
                    if (widgetsContainerPaneChild.isVisible()){
                        childVisible = true;
                    }
                }
                pane.setVisible(childVisible);
                pane.setManaged(childVisible);
            });
            assigned.add(child);
        }
    }


}
