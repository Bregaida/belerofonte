package br.com.belerofonte.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.belerofonte.model.ApplicationCategory;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class ApplicationCategoryDAO {

	private Session session;

	public ApplicationCategoryDAO(Session session) {
		this.session = session;
	}

	public void save(ApplicationCategory category) {
		this.session.save(category);
	}

	public void update(ApplicationCategory category) {
		this.session.update(category);
	}

	public ApplicationCategory load(Long id) {
		return (ApplicationCategory) this.session.load(ApplicationCategory.class, id);
	}

	public void remove(ApplicationCategory category) {
		this.session.delete(category);
	}

	public ApplicationCategory findByName(String name) {
		return (ApplicationCategory) this.session
		.createCriteria(ApplicationCategory.class)
		.add(Restrictions.eq("name", name))
		.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ApplicationCategory> list() {
		return this.session.createCriteria(ApplicationCategory.class).addOrder(Order.asc("name")).list();
	}

	public boolean containsCategoryWithName(String name) {
		return !this.session.createCriteria(ApplicationCategory.class).add(Restrictions.eq("name", name)).list().isEmpty();
	}
}