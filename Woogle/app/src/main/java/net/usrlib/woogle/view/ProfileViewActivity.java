package net.usrlib.woogle.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import net.usrlib.woogle.R;

public class ProfileViewActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.profile_activity);

		CollapsingToolbarLayout collapsingToolbarLayout =
			(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

		collapsingToolbarLayout.setTitle("Epic 2017");

		setSupportActionBarHomeEnabled(true);
	}

//	public static void start(Context c) {
//		c.startActivity(new Intent(c, ProfileViewActivity.class));
//	}
}
