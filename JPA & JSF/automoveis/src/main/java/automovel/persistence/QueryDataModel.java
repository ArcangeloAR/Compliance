package automovel.persistence;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class QueryDataModel<T> extends LazyDataModel<T> {
	

	private static final long serialVersionUID = 1L;
	
	private String jpql;

	public QueryDataModel(String jpql, String jpqlCount) {
		this.jpql = jpql;
		Long count = (Long) JPAUtil.getEntityManager().createQuery(jpqlCount).getSingleResult();
		setRowCount(count.intValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		return JPAUtil.getEntityManager().createQuery(jpql).setFirstResult(first).setMaxResults(pageSize).getResultList();
	}
}
