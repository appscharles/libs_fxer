package com.appscharles.libs.fxer.tables.cells;

import com.appscharles.libs.fxer.consumers.CallableConsumer;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * The type Universal table cell.
 *
 * @param <S> the type parameter
 */
public class UniversalTableCell<S, T> extends TableCell<S, T> {


    private CallableConsumer<T, Node> onUpdate;

    public UniversalTableCell() {
    }

    /**
     * Instantiates a new Universal table cell.
     *
     * @param onUpdate the on update
     */
    public UniversalTableCell(CallableConsumer<T, Node> onUpdate) {

        this.onUpdate = onUpdate;
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
     * @param <S>      the type parameter
     * @param onUpdate the on update
     * @return the callback
     */
    public <S> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(CallableConsumer<T, Node> onUpdate) {
        return param -> new UniversalTableCell<>(onUpdate);
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(this.onUpdate.accept(item));
        }
    }
}
