package net.usrlib.woogle.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rgr-myrg on 12/27/16.
 */

public class NumericalAlphabetItem {
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String SUBTITLE = "subtitle";
	public static final String CONTENT = "content";

	private int id;

	private String title;
	private String description;
	private String subTitle;
	private String text;

	public NumericalAlphabetItem(
			int id,
			String title,
			String description,
			String subTitle,
			String text) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.subTitle = subTitle;
		this.text = text;
	}

	public ContentValues toContentValues() {
		ContentValues values = new ContentValues();

		values.put(ID, id);
		values.put(TITLE, title);
		values.put(DESCRIPTION, DatabaseUtils.sqlEscapeString(description));
		values.put(SUBTITLE, subTitle);
		values.put(CONTENT, DatabaseUtils.sqlEscapeString(text));

		return values;
	}

	public static ContentValues[] fromJsonStringToContentValues(final String jsonString)
			throws JSONException {

		final JSONArray jsonArray  = new JSONArray(jsonString);
		final ContentValues[] list = new ContentValues[jsonArray.length()];

		for (int i = 0; i < jsonArray.length(); i++) {
			try {
				list[i] = fromJsonObject(jsonArray.getJSONObject(i)).toContentValues();
			} catch (JSONException e) {
				e.printStackTrace();
				continue;
			}
		}

		return list;
	}

	public static NumericalAlphabetItem fromJsonObject(final JSONObject jsonObject) throws JSONException {
		if (jsonObject == null) {
			return null;
		}

		return new NumericalAlphabetItem(
				jsonObject.getInt(ID),
				jsonObject.getString(TITLE),
				jsonObject.getString(DESCRIPTION),
				jsonObject.getString(SUBTITLE),
				jsonObject.getString(CONTENT)
		);
	}

	public static NumericalAlphabetItem fromDbCursor(final Cursor cursor) {
		if (cursor == null) {
			return null;
		}

		return new NumericalAlphabetItem(
				cursor.getInt(cursor.getColumnIndex(ID)),
				cursor.getString(cursor.getColumnIndex(TITLE)),
				cursor.getString(cursor.getColumnIndex(DESCRIPTION)),
				cursor.getString(cursor.getColumnIndex(SUBTITLE)),
				cursor.getString(cursor.getColumnIndex(CONTENT))
		);
	}
}
