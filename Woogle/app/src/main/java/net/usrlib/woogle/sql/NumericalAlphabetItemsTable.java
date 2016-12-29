package net.usrlib.woogle.sql;

import net.usrlib.woogle.model.NumericalAlphabetItem;

/**
 * Created by rgr-myrg on 12/27/16.
 */

public class NumericalAlphabetItemsTable {
	public static final String TABLE_NAME = "NumericalAlphabetItemsTable";

	public static final String CREATE_TABLE = String.format(
			"CREATE TABLE IF NOT EXISTS %s ("
					+ "%s INTEGER PRIMARY KEY,"
					+ "%s TEXT NOT NULL,"
					+ "%s TEXT NOT NULL,"
					+ "%s TEXT NOT NULL,"
					+ "%s TEXT NOT NULL"
					+ ")",
			TABLE_NAME,
			NumericalAlphabetItem.ID,
			NumericalAlphabetItem.TITLE,
			NumericalAlphabetItem.DESCRIPTION,
			NumericalAlphabetItem.SUBTITLE,
			NumericalAlphabetItem.CONTENT
	);

	public static final String DROP_TABLE = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

	public static final String SELECT_ALL = String.format(
			"SELECT * FROM %s", TABLE_NAME
	);

	public static final String WHERE_ITEM_ID = String.format(
			"%s = ?", NumericalAlphabetItem.ID
	);
}
