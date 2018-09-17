package com.appscharles.libs.fxer.models;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.09.2018
 * Time: 10:07
 * Project name: stocker
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class BootstrapCloserContainer {

    private Integer order;

    private Runnable onClose;

    public BootstrapCloserContainer(Integer order, Runnable onClose) {
        this.order = order;
        this.onClose = onClose;
    }

    /**
     * Getter for property 'order'.
     *
     * @return Value for property 'order'.
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Setter for property 'order'.
     *
     * @param order Value to set for property 'order'.
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * Getter for property 'onClose'.
     *
     * @return Value for property 'onClose'.
     */
    public Runnable getOnClose() {
        return onClose;
    }

    /**
     * Setter for property 'onClose'.
     *
     * @param onClose Value to set for property 'onClose'.
     */
    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }
}
