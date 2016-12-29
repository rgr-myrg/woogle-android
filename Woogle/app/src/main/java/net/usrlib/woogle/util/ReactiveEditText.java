package net.usrlib.woogle.util;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by rgr-myrg on 12/12/16.
 */

public class ReactiveEditText {
	public static final ActiveEditText onTextChanges(final EditText editText) {
		return new ActiveEditText(editText);
	}

	public static final class ActiveEditText {
		private EditText mEditText;
		private int mInterval = 1000;
		private boolean mStartUp = false;
		private Handler mHandler = new Handler();
		private OnTextChanged mCallback = null;

		public ActiveEditText(EditText editText) {
			mEditText = editText;
			mEditText.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}

				@Override
				public void afterTextChanged(Editable text) {
					if (!mStartUp) {
						mStartUp = true;

						mHandler.postDelayed(() -> {
							mStartUp = false;
							mCallback.run(text.toString());
						}, mInterval);
					}
				}
			});
		}

		public ActiveEditText notifyInterval(final int milliseconds) {
			mInterval = milliseconds;
			return this;
		}

		public ActiveEditText subscribe(final OnTextChanged onTextChanged) {
			mCallback = onTextChanged;
			return this;
		}
	}

	public interface OnTextChanged {
		void run(String text);
	}
}
