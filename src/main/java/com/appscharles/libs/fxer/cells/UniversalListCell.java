package com.appscharles.libs.fxer.cells;

import com.appscharles.libs.fxer.exceptions.CallableOneConsumer;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * The type Universal list cell.
 *
 * @param <T> the type parameter
 */
public class UniversalListCell<T> extends ListCell<T> {

    private CallableOneConsumer<T, Node> onUpdate;

    /**
     * Instantiates a new Universal list cell.
     */
    public UniversalListCell() {
    }

    /**
     * Instantiates a new Universal list cell.
     *
     * @param onUpdate the on update
     */
    public UniversalListCell(CallableOneConsumer<T, Node> onUpdate) {
        this.onUpdate = onUpdate;
    }

    /**
     * Gets current item.
     *
     * @return the current item
     */
    public T getCurrentItem() {
        return this.getListView().getItems().get(this.getIndex());
    }

    /**
     * For list cell callback.
     *
     * @param <T>      the type parameter
     * @param onUpdate the on update
     * @return the callback
     */
    public <T> Callback<ListView<T>, ListCell<T>> forCellFactory(CallableOneConsumer<T, Node> onUpdate) {
        return (param) -> {
            return new UniversalListCell(onUpdate);
        };
    }

    public <T> ListCell<T> forButtonCell(CallableOneConsumer<T, Node> onUpdate) {
        return new UniversalListCell(onUpdate);
    }

    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            this.setGraphic(null);
        } else {
            this.setGraphic(this.onUpdate.accept(item));
        }

    }
}
