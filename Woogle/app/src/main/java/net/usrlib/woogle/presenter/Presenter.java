package net.usrlib.woogle.presenter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import net.usrlib.woogle.BuildConfig;
import net.usrlib.woogle.model.NumericalAlphabetItem;
import net.usrlib.woogle.sql.NumericalAlphabetItemsTable;
import net.usrlib.woogle.util.DbHelper;
import net.usrlib.woogle.util.JsonLoader;
import net.usrlib.woogle.util.Preferences;

import org.json.JSONException;

/**
 * Created by rgr-myrg on 12/29/16.
 */

public class Presenter {
	public static final String TAG = Presenter.class.getSimpleName();
	public static Handler sHandler = new Handler();

	public static final void onCreate(
			final Context context,
			final OnSqlTransactionComplete callback) {

		if (Preferences.hasDataInstall(context)) {
			if (BuildConfig.DEBUG) Log.i(TAG, "onCreate hasDataInstall is true.");
			callback.run(true);
		}

		bulkInsertDataItems(context, callback);
	}

	public static final void bulkInsertDataItems(
			final Context context,
			final OnSqlTransactionComplete callback) {

		if (BuildConfig.DEBUG) Log.i(TAG, "bulkInsertDataItems starts up.");

		sHandler.post(() -> {
			DbHelper.getInstance(context).createTable(NumericalAlphabetItemsTable.CREATE_TABLE);

			final String jsonString = JsonLoader.loadNumericalAlphabet(context);

			try {
				final int rows = DbHelper.getInstance(context).bulkInsert(
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
		});
	}

	public interface OnSqlTransactionComplete {
		void run(boolean success);
	}
}
