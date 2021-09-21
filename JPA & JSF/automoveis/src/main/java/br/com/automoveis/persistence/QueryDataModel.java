package br.com.automoveis.persistence;

import java.util.List;
import java.util.Map;

import org.hibernate.ScrollableResults;
import org.hibernate.ejb.QueryImpl;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class QueryDataModel<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	private String jpql;

	@SuppressWarnings("unchecked")
	public QueryDataModel(String jpql) {
		this.jpql = jpql;

		QueryImpl<T> query = (QueryImpl<T>) JpaUtil.getEntityManager().createQuery(jpql);
		ScrollableResults scroll = query.getHibernateQuery().scroll();
		scroll.last();
		int count = scroll.getRowNumber();
		setRowCount(count);
	}

	@SuppressWarnings("unchecked")
	public List<T> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		return JpaUtil.getEntityManager().createQuery(jpql).setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}
}