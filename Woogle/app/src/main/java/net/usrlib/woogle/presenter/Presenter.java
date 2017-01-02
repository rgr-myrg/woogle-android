package net.usrlib.woogle.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import net.usrlib.woogle.BuildConfig;
import net.usrlib.woogle.model.NameAnalysisResults;
import net.usrlib.woogle.model.NumericalAlphabetItem;
import net.usrlib.woogle.model.Profile;
import net.usrlib.woogle.sql.NumericalAlphabetItemsTable;
import net.usrlib.woogle.sql.ProfileTable;
import net.usrlib.woogle.util.DbHelper;
import net.usrlib.woogle.util.JsonLoader;
import net.usrlib.woogle.util.Preferences;

import org.json.JSONException;

/**
 * Created by rgr-myrg on 12/29/16.
 */

public class Presenter {
	public static final String TAG = Presenter.class.getSimpleName();

	public static final void performDataInstall(
			final Context context,
			final OnSqlTransactionComplete callback) {

		if (Preferences.hasDataInstall(context)) {
			if (BuildConfig.DEBUG) Log.i(TAG, "performDataInstall hasDataInstall is true.");
			callback.run(true);

			return;
		}

		final DbHelper dbHelper = DbHelper.getInstance(context);
		final String jsonString = JsonLoader.loadNumericalAlphabet(context);

		try {
			final int rows = dbHelper.bulkInsert(
					NumericalAlphabetItemsTable.TABLE_NAME,
					NumericalAlphabetItem.fromJsonStringToContentValues(jsonString)
			);

			if (rows > 0) {
				callback.run(true);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			callback.run(false);
		}
	}

	public static final void insertNameResults(
			final NameAnalysisResults results,
			final Context context,
			final OnSqlTransactionComplete callback) {

		final ContentValues contentValues = new ContentValues();
		contentValues.put(Profile.NAME, results.getName());
		contentValues.put(Profile.COMPOUNDKEY, results.getCompoundValue());
		contentValues.put(Profile.SINGLEKEY, results.getSingleValue());

		final long newRecordId = DbHelper.getInstance(context).insert(
				ProfileTable.TABLE_NAME, contentValues
		);

		callback.run(newRecordId > 0);
	}

	public interface OnSqlTransactionComplete {
		void run(boolean success);
	}
}
