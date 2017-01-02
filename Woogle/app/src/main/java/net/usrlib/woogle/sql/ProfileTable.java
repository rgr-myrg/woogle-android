package net.usrlib.woogle.sql;

import net.usrlib.woogle.model.Profile;

/**
 * Created by rgr-myrg on 12/29/16.
 */

public class ProfileTable {
	public static final String TABLE_NAME = "Profile";
	public static final String CREATE_TABLE = String.format(
			"CREATE TABLE IF NOT EXISTS %s ("
					+ "%s INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "%s TEXT NOT NULL,"
					+ "%s TEXT,"
					+ "%s INTEGER,"
					+ "%s INTEGER,"
					+ "%s TEXT,"
					+ "%s TEXT,"
					+ "%s INTEGER DEFAULT %d,"
					+ "%s INTEGER DEFAULT %d,"
					+ "%s INTEGER DEFAULT %d,"
					+ "%s INTEGER DEFAULT %d,"
					+ "%s INTEGER DEFAULT %d,"
					+ "%s DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL"
					+ ")",
			TABLE_NAME,
			Profile.ID,
			Profile.NAME,
			Profile.BIRTHDATE,
			Profile.COMPOUNDKEY,
			Profile.SINGLEKEY,
			Profile.ZODIAC,
			Profile.TAGLINE,
			Profile.FRIENDS, TrinaryBoolean.NONE.ordinal(),
			Profile.DATING, TrinaryBoolean.NONE.ordinal(),
			Profile.MARRIAGE, TrinaryBoolean.NONE.ordinal(),
			Profile.STATUS, Profile.MaritalStatus.NOT_ANSWERED.ordinal(),
			Profile.PRIVATE, TrinaryBoolean.FALSE.ordinal(),
			Profile.TIMESTAMP
	);
}
