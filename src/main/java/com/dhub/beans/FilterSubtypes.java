package com.dhub.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="FILTER_SUBTYPES")
public class FilterSubtypes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8282088368246586860L;

	@Id
	@Column(name="FILTER_SUBTYPE_ID")
	@SequenceGenerator(name="SUBTYPE_SEQ", sequenceName="SUBTYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUBTYPE_SEQ")
	private Integer filterSubtypeId;
	
	@Column(name="FILTER_SUBTYPE")
	private String FilterSubtype;
	
	@ManyToOne
	@JoinColumn(name="FILTER_ID")
	private Filters filter;
	
	@OneToMany
	@JoinTable(name="USER_FILTERS",
		joinColumns = @JoinColumn(name = "FILTER_SUBTYPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private List<Users> users;

	public FilterSubtypes() {
		
	}	
	
	public FilterSubtypes(String filterSubtype) {
		super();
		FilterSubtype = filterSubtype;
	}

	@Override
	public String toString() {
		return "FilterSubtypes [filterSubtypeId=" + filterSubtypeId + ", FilterSubtype=" + FilterSubtype + ", filter="
				+ filter + "]";
	}

	public Integer getFilterSubtypeId() {
		return filterSubtypeId;
	}	

	public void setFilterSubtypeId(Integer filterSubtypeId) {
		this.filterSubtypeId = filterSubtypeId;
	}

	public String getFilterSubtype() {
		return FilterSubtype;
	}

	public void setFilterSubtype(String filterSubtype) {
		FilterSubtype = filterSubtype;
	}

	public Filters getFilter() {
		return filter;
	}

	public void setFilter(Filters filter) {
		this.filter = filter;
	}	
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
