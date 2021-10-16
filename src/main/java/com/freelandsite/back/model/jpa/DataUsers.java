package com.freelandsite.back.model.jpa;

import java.util.List;

public class DataUsers {

	
	private int totalpages;
	private Long totalrows;
	private List<Cyca_Usuarios> rows;
	
	
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public Long getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(Long totalrows) {
		this.totalrows = totalrows;
	}
	public List<Cyca_Usuarios> getRows() {
		return rows;
	}
	public void setRows(List<Cyca_Usuarios> rows) {
		this.rows = rows;
	}
	
	
}
