package net.usrlib.woogle.model;

/**
 * Created by rgr-myrg on 12/29/16.
 */

public class Profile {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String BIRTHDATE = "birthdate";
	public static final String COMPOUNDKEY = "compound_key";
	public static final String SINGLEKEY = "single_key";
	public static final String ZODIAC = "zodiac";
	public static final String TAGLINE = "tagline";
	public static final String FRIENDS = "friends";
	public static final String DATING = "dating";
	public static final String MARRIAGE = "marriage";
	public static final String STATUS = "status";
	public static final String PRIVATE = "private";
	public static final String TIMESTAMP = "timestamp";

	public static enum MaritalStatus {
		SINGLE,
		DIVORCED,
		RELATIONSHIP,
		DATING_CASUALLY,
		NOT_ANSWERED
	}
}
