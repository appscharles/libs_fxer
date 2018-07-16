package com.appscharles.libs.fxer.tables.cells;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The type Action button table cell.
 *
 * @param <S> the type parameter
 */
public class ActionButtonTableCell<S> extends TableCell<S, Button> {

    private final Button actionButton;

    /**
     * Instantiates a new Action button table cell.
     *
     * @param label        the label
     * @param onClick      the on click
     * @param onInitialize the on initialize
     */
    public ActionButtonTableCell(String label, Function< S, S> onClick, Consumer<Button> onInitialize) {
        this.getStyleClass().add("action-button-table-cell");

        this.actionButton = new Button(label);
        this.actionButton.setOnAction((ActionEvent e) -> {
            onClick.apply(getCurrentItem());
        });
        this.actionButton.setMaxWidth(Double.MAX_VALUE);
        if (onInitialize != null){
            onInitialize.accept(this.actionButton);
        }
    }

    /**
     * Gets current item.
     *
     * @return the current item
     */
    public S getCurrentItem() {
        return (S) getTableView().getItems().get(getIndex());
    }

    /**
     * For table column callback.
     *
     * @param <S>          the type parameter
     * @param label        the label
     * @param onClick      the on click
     * @param onInitialize the on initialize
     * @return the callback
     */
    public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> forTableColumn(String label, Function< S, S> onClick, Consumer<Button> onInitialize) {
        return param -> new ActionButtonTableCell<>(label, onClick, onInitialize);
    }

    /**
     * For table column callback.
     *
     * @param <S>     the type parameter
     * @param label   the label
     * @param onClick the on click
     * @return the callback
     */
    public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> forTableColumn(String label, Function< S, S> onClick) {
        return forTableColumn(label, onClick, null);
    }
    @Override
    public void updateItem(Button item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(actionButton);
        }
    }

    /**
     * Gets action button.
     *
     * @return the action button
     */
    public Button getActionButton() {
        return actionButton;
    }
}
