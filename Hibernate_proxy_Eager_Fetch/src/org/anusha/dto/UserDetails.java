package org.anusha.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))

	private Collection<Address>ListOfAddresses = new ArrayList<Address>();


		
	public Collection<Address> getListOfAddresses() {
		return ListOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		ListOfAddresses = listOfAddresses;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
