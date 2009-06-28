package com.ejd.common.datapage;

public abstract class PagedBaseBean {
	public abstract int getTotalCount();
	/*public int getTotalCount() {
		   Query q = em.createQuery("select count(*) from UrlResource urls");
		   Object result = q.getSingleResult();
		   return Integer.parseInt(result.toString());
		}*/
	public abstract DataPage getDataPage(int startRow, int pageSize);
	/*public DataPage getDataPage(int startRow, int pageSize) {
		   Query q = em
		     .createQuery("from UrlResource urls order by urls.updateDate desc");
		   q.setFirstResult(startRow);
		   q.setMaxResults(pageSize);
		   DataPage dataPage = new DataPage(getTotalCount(), startRow, q
		     .getResultList());
		   return dataPage;
		}*/
	//public abstract void getDataModel();
	/*public void getDataModel() {
		   if (pageDataModel == null) {
		    pageDataModel = new PagedListDataModel(20) {
		     public DataPage fetchPage(int startRow, int pageSize) {
		      return getDataPage(startRow, pageSize);
		     }
		    };
		   }
		}*/
}
