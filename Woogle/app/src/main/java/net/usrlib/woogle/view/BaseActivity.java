package net.usrlib.woogle.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.usrlib.woogle.R;

/**
 * Created by rgr-myrg on 12/28/16.
 */

public class BaseActivity extends AppCompatActivity {
	public void setSupportActionBarHomeEnabled(final boolean hasHomeEnabled) {
		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		if (hasHomeEnabled) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
}
