package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CountryDAO;
import edu.utfpr.cp.sa.entity.Country;
import java.util.Set;

public class CountryBusiness {
	private CountryDAO countryDAO;
	
	public CountryBusiness()
	{
		countryDAO = new CountryDAO();
	}
	
	public void create(Country c) throws Exception
	{
		countryDAO.create(c);
	}
	
	public Set<Country> read()
	{
		return countryDAO.read();
	}
	
	public void update(Country c) throws Exception
	{
		countryDAO.update(c);
	}
	
	public void delete(long id) throws Exception
	{
		countryDAO.delete(id);
	}
}
