package net.usrlib.woogle.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import net.usrlib.woogle.R;
import net.usrlib.woogle.presenter.Presenter;
import net.usrlib.woogle.util.UiUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.WindowFeature;

/**
 * Created by rgr-myrg on 12/29/16.
 */

@Fullscreen
@EActivity(R.layout.activity_splash_screen)
@WindowFeature(Window.FEATURE_NO_TITLE)

public class SplashScreenActivity extends AppCompatActivity {
	@AfterViews
	@Background
	protected void onAfterViews() {
		Presenter.performDataInstall(getApplicationContext(), success -> {
			startNextActivity(success);
		});
	}

	@UiThread
	protected void startNextActivity(final boolean success) {
		if (!success) {
			UiUtil.makeSnackbar(
					findViewById(android.R.id.content),
					getString(R.string.splash_screen_error_message)
			);

			return;
		}

		//TODO: Need a switch for starting profile vs enter name activity.
		startActivity(
				new Intent(getBaseContext(), EnterNameActivity_.class)
		);

		finish();
	}
}
