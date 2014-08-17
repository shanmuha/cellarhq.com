/**
 * This class is generated by jOOQ
 */
package com.cellarhq.generated.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CategoryDao extends org.jooq.impl.DAOImpl<com.cellarhq.generated.tables.records.CategoryRecord, com.cellarhq.generated.tables.pojos.Category, java.lang.Long> {

	/**
	 * Create a new CategoryDao without any configuration
	 */
	public CategoryDao() {
		super(com.cellarhq.generated.tables.Category.CATEGORY, com.cellarhq.generated.tables.pojos.Category.class);
	}

	/**
	 * Create a new CategoryDao with an attached configuration
	 */
	public CategoryDao(org.jooq.Configuration configuration) {
		super(com.cellarhq.generated.tables.Category.CATEGORY, com.cellarhq.generated.tables.pojos.Category.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(com.cellarhq.generated.tables.pojos.Category object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchById(java.lang.Long... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.cellarhq.generated.tables.pojos.Category fetchOneById(java.lang.Long value) {
		return fetchOne(com.cellarhq.generated.tables.Category.CATEGORY.ID, value);
	}

	/**
	 * Fetch records that have <code>version IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByVersion(java.lang.Integer... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.VERSION, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByName(java.lang.String... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.NAME, values);
	}

	/**
	 * Fetch records that have <code>description IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByDescription(java.lang.String... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.DESCRIPTION, values);
	}

	/**
	 * Fetch records that have <code>searchable IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchBySearchable(java.lang.Boolean... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.SEARCHABLE, values);
	}

	/**
	 * Fetch records that have <code>brewery_db_id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByBreweryDbId(java.lang.String... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.BREWERY_DB_ID, values);
	}

	/**
	 * Fetch records that have <code>brewery_db_last_updated IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByBreweryDbLastUpdated(java.sql.Timestamp... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.BREWERY_DB_LAST_UPDATED, values);
	}

	/**
	 * Fetch records that have <code>created_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByCreatedDate(java.sql.Timestamp... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.CREATED_DATE, values);
	}

	/**
	 * Fetch records that have <code>modified_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.Category> fetchByModifiedDate(java.sql.Timestamp... values) {
		return fetch(com.cellarhq.generated.tables.Category.CATEGORY.MODIFIED_DATE, values);
	}
}