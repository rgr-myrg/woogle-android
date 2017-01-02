package net.usrlib.woogle.view;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import net.usrlib.woogle.R;
import net.usrlib.woogle.model.NameAnalysisResults;
import net.usrlib.woogle.model.NumericalAlphabet;
import net.usrlib.woogle.presenter.Presenter;
import net.usrlib.woogle.util.UiUtil;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

/**
 * Created by rgr-myrg on 12/31/16.
 */

@Fullscreen
@EActivity(R.layout.activity_enter_name)
@WindowFeature(Window.FEATURE_NO_TITLE)

public class EnterNameActivity extends AppCompatActivity {
	@ViewById(R.id.name_entry)
	protected TextView mNameEntry;

	@ViewById(R.id.birthdate_entry)
	protected TextView mBirthdateEntry;

	@Background
	protected void insertNameResults(final NameAnalysisResults results) {
		Presenter.insertNameResults(results, getApplicationContext(), success -> {
			onInsertNameResults(success);
		});
	}

	@UiThread
	protected void onInsertNameResults(final boolean success) {

	}
//	protected void displayComputedValues(final NameAnalysisResults nameAnalysisResults) {
//		mNameEntry.setText(nameAnalysisResults.getName());
//
//		final ArrayList<Integer> computedValues = nameAnalysisResults.getComputedValues();
//		Log.d("ENTER", "name: " + nameAnalysisResults.getName() + ":" + nameAnalysisResults.getCompoundValue());
//
//		for (int value : computedValues) {
//			mHandler.postDelayed(() -> {
//				String results = String.format("%s +", mNameResults.getText() + String.valueOf(value));
//				mNameResults.setText( results);
//			}, 1000);
//		}
//	}

	public void onEnterNameClicked(final View view) {
		UiUtil.showNewItemAlertDialog(
				view.getContext(),
				null,
				(String value) -> {
					mNameEntry.setText(value);
					final NameAnalysisResults results = NumericalAlphabet.computeNameValues(value);
					insertNameResults(results);
				}
		);
	}

	public void onEnterBirthdateClicked(final View view) {
		UiUtil.showNewItemAlertDialog(
				view.getContext(),
				"MM/DD/YYYY",
				(String value) -> {
					mBirthdateEntry.setText(value);
				}
		);
	}
}
