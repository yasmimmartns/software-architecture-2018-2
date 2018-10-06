 package edu.utfpr.cp.sa.entity;

import lombok.Data;

@Data
public class Customer {
	
        private Long id;
	private String name;
	private String phone;
	private int age;
	private double creditLimit;
	
	private Country country;
        
        public Customer () {}
        
        public Customer (Long id, String name, String phone, int age, double creditLimit, Country country) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.creditLimit = creditLimit;
            this.country = country;
        }

	public void setName(String name){
		this.name = name;
	}

	public void setPhone(String phone) throws Exception {
		
		if (this.getCountry() == null)
			throw new Exception("Country must be defined!");
		
		this.phone = phone;
	}

	public void setAge(int age) {
					
		this.age = age;
	}

	public void setCountry(Country country) throws Exception {
		
		if (country == null || country.getName().length() < 1)
			throw new Exception("Country must be informed!");
			
		this.country = country;
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Customer other = (Customer) obj;
		
		return this.getName().equalsIgnoreCase(other.getName());
	}

}
