package com.appscharles.libs.fxer.guis.popup.controllerExtends;

import com.appscharles.libs.fxer.switchers.PaneViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * The type 10 popup pane controller extend.
 */
public class _10_PopupPaneControllerExtend extends _5_ViewFactoryControllerExtend {


    @FXML
    private StackPane popupPane;

    /**
     * The Content main view switcher.
     */
    protected PaneViewSwitcher contentMainViewSwitcher;

    /**
     * Instantiates a new 10 popup pane controller extend.
     */
    protected _10_PopupPaneControllerExtend(){
        this.addOnInitializeWithSneakyThrow((resourceBundle)->{
            this.contentMainViewSwitcher = new PaneViewSwitcher(this.popupPane);
            this.contentMainViewSwitcher.switchTo(this.viewFactory.create());
        });
    }
}
