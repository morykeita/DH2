package com.dhub.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="FILTERS")
public class Filters implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6113120527447169991L;

	@Id
	@Column(name="FILTER_ID")
	@SequenceGenerator(name="FILTER_SEQ", sequenceName="FILTER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILTER_SEQ")
	private Integer filterId;
	
	@Column(name="FILTER_NAME")
	private String filter; 
	
	@OneToMany
	@JoinColumn(name="FILTER_ID")
	private List<FilterSubtypes> filters;


	public Filters() {
		
	}
	
	public Filters(String filter) {
		super();
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "Filters [filterId=" + filterId + ", filter=" + filter + ", filters=" +  "]";
	}
	
	public Integer getFilterId() {
		return filterId;
	}

	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public List<FilterSubtypes> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterSubtypes> filters) {
		this.filters = filters;
	}	

}
