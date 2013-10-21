/**
 * 
 */
package com.bhbz.jpatest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author macbook
 * 
 *         2013年10月21日
 */
@Entity(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ADDRESS")
    private String address;

    protected Customer() {

    }

    /**
     * @param userName
     * @param age
     * @param address
     */
    public Customer(String userName, int age, String address) {
	this.userName = userName;
	this.age = age;
	this.address = address;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Customer [id=" + id + ", userName=" + userName + ", age=" + age
		+ ", address=" + address + "]";
    }

}
