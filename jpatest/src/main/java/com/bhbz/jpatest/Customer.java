/**
 * 
 */
package com.bhbz.jpatest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author macbook
 * 
 *         2013年10月21日
 */

class CustomerPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5246613685339770430L;

	private int id;

	private int type;
	
	public CustomerPk() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerPk other = (CustomerPk) obj;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


}

@IdClass(CustomerPk.class)
@Entity(name = "CUSTOMER")
public class Customer {


	@Id
	@Column(name = "ID")
	private int id;

	@Id
	@Column(name = "TYPE")
	private int type;

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
	public Customer(int id, String userName, int age, String address, int type) {
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.address = address;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", type=" + type + ", userName="
				+ userName + ", age=" + age + ", address=" + address + "]";
	}

	

}
