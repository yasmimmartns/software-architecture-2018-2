package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CustomerDAO;
import edu.utfpr.cp.sa.entity.Customer;
import java.util.Set;

public class CustomerBusiness {
	
	private CustomerDAO customerDAO;
	private Customer customer;
	
	
	public CustomerBusiness()
	{
		customerDAO = new CustomerDAO();
	}
		
	private void adjustCreditLimit()
	{
		if (customer.getAge() <= 18)
			customer.setCreditLimit(customer.getCreditLimit() + 100.0);
		
		else if (customer.getAge() <= 35)
			customer.setCreditLimit(customer.getCreditLimit() + 300.0);
		
		else
			customer.setCreditLimit(customer.getCreditLimit() + 500.0);
		
		
		if (customer.getCountry().getName().equalsIgnoreCase("Brazil"))
			customer.setCreditLimit(customer.getCreditLimit() + 100.0);
		
	}
	
	private void checkPhoneLength() throws Exception
	{
		if (customer.getPhone().length() != customer.getCountry().getPhoneDigits())
			throw new Exception("Phone does not conform to country!");
	}
	
	private void checkName() throws Exception
	{
		if (customer.getName().length() < 5)
			throw new Exception("Sorry, name must be 5 characters in length!");
	}
	
	private void checkCustomer() throws Exception
	{
		checkName();
		adjustCreditLimit();
		checkPhoneLength();
	}
	
	public void create(Customer c) throws Exception
	{
        customer = c;
		checkCustomer();
		customerDAO.create(customer);
	}
	
	public Set<Customer> read()
	{
		return customerDAO.read();
	}
	
	public void update(Customer c) throws Exception
	{
		customer = c;
		checkCustomer();
		customerDAO.update(customer);
	}
	
	public void delete(long id) throws Exception
	{
		customerDAO.delete(id);
	}
}
