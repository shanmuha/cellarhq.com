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
public class CellaredDrinkDao extends org.jooq.impl.DAOImpl<com.cellarhq.generated.tables.records.CellaredDrinkRecord, com.cellarhq.generated.tables.pojos.CellaredDrink, java.lang.Long> {

	/**
	 * Create a new CellaredDrinkDao without any configuration
	 */
	public CellaredDrinkDao() {
		super(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK, com.cellarhq.generated.tables.pojos.CellaredDrink.class);
	}

	/**
	 * Create a new CellaredDrinkDao with an attached configuration
	 */
	public CellaredDrinkDao(org.jooq.Configuration configuration) {
		super(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK, com.cellarhq.generated.tables.pojos.CellaredDrink.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(com.cellarhq.generated.tables.pojos.CellaredDrink object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchById(java.lang.Long... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.cellarhq.generated.tables.pojos.CellaredDrink fetchOneById(java.lang.Long value) {
		return fetchOne(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.ID, value);
	}

	/**
	 * Fetch records that have <code>version IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByVersion(java.lang.Integer... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.VERSION, values);
	}

	/**
	 * Fetch records that have <code>cellar_id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByCellarId(java.lang.Long... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.CELLAR_ID, values);
	}

	/**
	 * Fetch records that have <code>drink_id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByDrinkId(java.lang.Long... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.DRINK_ID, values);
	}

	/**
	 * Fetch records that have <code>style_id IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByStyleId(java.lang.Long... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.STYLE_ID, values);
	}

	/**
	 * Fetch records that have <code>bottle_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByBottleDate(java.time.LocalDate... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.BOTTLE_DATE, values);
	}

	/**
	 * Fetch records that have <code>size IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchBySize(java.lang.String... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.SIZE, values);
	}

	/**
	 * Fetch records that have <code>quantity IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByQuantity(java.lang.Integer... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.QUANTITY, values);
	}

	/**
	 * Fetch records that have <code>notes IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByNotes(java.lang.String... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.NOTES, values);
	}

	/**
	 * Fetch records that have <code>drink_by_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByDrinkByDate(java.time.LocalDate... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.DRINK_BY_DATE, values);
	}

	/**
	 * Fetch records that have <code>private IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByPrivate(java.lang.Boolean... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.PRIVATE, values);
	}

	/**
	 * Fetch records that have <code>created_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByCreatedDate(java.sql.Timestamp... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.CREATED_DATE, values);
	}

	/**
	 * Fetch records that have <code>modified_date IN (values)</code>
	 */
	public java.util.List<com.cellarhq.generated.tables.pojos.CellaredDrink> fetchByModifiedDate(java.sql.Timestamp... values) {
		return fetch(com.cellarhq.generated.tables.CellaredDrink.CELLARED_DRINK.MODIFIED_DATE, values);
	}
}