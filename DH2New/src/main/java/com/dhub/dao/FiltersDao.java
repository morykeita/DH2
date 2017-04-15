package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Filters;

public interface FiltersDao {
	public List<Filters> getAllFilters();
	public void createFilter(Filters f);
	public void updateFilter(Filters f);
	public void deleteFilter(Filters f);
}
