package com.appscharles.libs.fxer.switchers;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

/**
 * The type Pane view switcher.
 */
public class PaneViewSwitcher {


    private Pane pane;

    private Boolean resize;

    /**
     * Instantiates a new Pane view switcher.
     *
     * @param pane the pane
     */
    public PaneViewSwitcher(Pane pane) {
        this.pane = pane;
        this.resize = false;
    }

    /**
     * Switch to.
     *
     * @param child the child
     */
    public void switchTo(Parent child) {
        this.pane.getChildren().clear();
        this.pane.getChildren().add(child);
        Region region = (Region)child;
        this.pane.widthProperty().addListener((args, oldVal, newVal)->{
            region.setPrefWidth(newVal.doubleValue());
        });
        this.pane.heightProperty().addListener((args, oldVal, newVal)->{
            region.setPrefHeight(newVal.doubleValue());
        });
        if (this.resize){
            region.setPrefWidth(this.pane.getWidth());
            region.setPrefHeight(this.pane.getHeight());
        }
    }

    /**
     * Enable resize pane view switcher.
     *
     * @return the pane view switcher
     */
    public PaneViewSwitcher enableResize() {
        this.resize = true;
        return this;
    }
}
