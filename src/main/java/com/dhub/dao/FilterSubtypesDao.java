package com.dhub.dao;

import java.util.List;

import com.dhub.beans.FilterSubtypes;

public interface FilterSubtypesDao {
	public List<FilterSubtypes> getAllFilterSubtypes();
	public void createFilterSubtype(FilterSubtypes fs);
	public void updateFilterSubtype(FilterSubtypes fs);
	public void deleteFilterSubtype(FilterSubtypes fs);
}
