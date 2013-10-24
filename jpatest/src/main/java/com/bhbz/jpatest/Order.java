/**
 * 
 */
package com.bhbz.jpatest;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
class OrderPk implements Serializable {

    private static final long serialVersionUID = -3141399782502968891L;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "category")
    private int category;

    public OrderPk() {

    }

    /**
     * @param orderId
     * @param category
     */
    public OrderPk(long orderId, int category) {
	this.orderId = orderId;
	this.category = category;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "OrderPk [orderId=" + orderId + ", category=" + category + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + category;
	result = prime * result + (int) (orderId ^ (orderId >>> 32));
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	OrderPk other = (OrderPk) obj;
	if (category != other.category)
	    return false;
	if (orderId != other.orderId)
	    return false;
	return true;
    }

}

/**
 * @author macbook
 * 
 *         2013年10月23日
 */
@Entity(name = "t_order")
public class Order {

    public Order() {

    }

    @EmbeddedId
    private OrderPk orderPk;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "description")
    private String description;

    /**
     * @param orderPk
     * @param name
     * @param description
     */
    public Order(long orderId, int category, String name, String description,
	    Date date) {
	this.orderPk = new OrderPk(orderId, category);
	this.name = name;
	this.description = description;
	this.date = date;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Order [orderPk=" + orderPk + ", name=" + name
		+ ", description=" + description + "]";
    }

}
