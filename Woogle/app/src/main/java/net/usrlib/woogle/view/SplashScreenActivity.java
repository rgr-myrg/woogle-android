package net.usrlib.woogle.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.usrlib.woogle.R;
import net.usrlib.woogle.presenter.Presenter;
import net.usrlib.woogle.util.Preferences;
import net.usrlib.woogle.util.UiUtil;

/**
 * Created by rgr-myrg on 12/29/16.
 */

public class SplashScreenActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		Presenter.onCreate(getApplicationContext(), success -> {
			startNextActivity(success);
		});
	}

	protected void startNextActivity(final boolean success) {
		if (!success) {
			UiUtil.makeSnackbar(
					findViewById(android.R.id.content),
					getString(R.string.splash_screen_error_message)
			);

			return;
		}

		Preferences.setHasDataInstall(getApplicationContext(), success);

		runOnUiThread(() -> {
			startActivity(
					new Intent(getBaseContext(), ProfileViewActivity.class)
			);

			finish();
		});
	}
}
