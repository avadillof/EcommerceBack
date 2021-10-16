package com.freelandsite.back.model.jpa;

import java.util.List;

public class DataMateriales {

	
	private int totalpages;
	private Long totalrows;
	private List<Cyca_Materialesproductosfaricacion> rows;
	
	
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
	public List<Cyca_Materialesproductosfaricacion> getRows() {
		return rows;
	}
	public void setRows(List<Cyca_Materialesproductosfaricacion> rows) {
		this.rows = rows;
	}
	
	
}
