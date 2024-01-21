package com.verint.assignment.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class CheckoutDTO {
	
	private int itemId;

    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Full Name should only contain letters A-Z, a-z, and spaces")
    private String fullName;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Phone Number should be in the format xxx-xxx-xxxx")
    private String phoneNumber;
    
    @Pattern(regexp = "\\d{19}", message = "Credit card should be 19 digits long and contain only digits")
    private String creditCardNumber;
    
    private String address;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
