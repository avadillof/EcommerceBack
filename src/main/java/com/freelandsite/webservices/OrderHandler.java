package com.freelandsite.webservices;



public class OrderHandler {
	private String fieldSort;
	private String sortDirection;
	private String filter;

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getFieldSort() {
		return fieldSort;
	}

	public void setFieldSort(String fieldSort) {
		this.fieldSort = fieldSort;
	}		
	
	@Override
	public String toString() {
		return fieldSort + " "+ sortDirection;
	}

	public String getFilter() {
		if(filter==null || filter.equals("null")) {
			setFilter("");
		}
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}
