package ch.nyp.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ch.nyp.databaseexample.model.User;
import ch.nyp.databaseexample.persistence.AppDatabase;
import ch.nyp.databaseexample.persistence.UserDao;

public class MainActivity extends AppCompatActivity {

	private UserDao mUserDao;
	private static String TAG = "MainActivity";

	private View.OnClickListener mSaveUsersOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View openActivityButton) {
			List<User> usersToSave = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
				User user = new User();
				user.setFirstName("Gianluca" + i);
				user.setLastName("Daffré" + i);
				usersToSave.add(user);
			}
			// delete all users since we dont want thousands of them...
			mUserDao.deleteAll();
			Log.d(TAG, "UserCount: " + mUserDao.countUsers());
			mUserDao.insertAll(usersToSave);
		}
	};

	private View.OnClickListener mDisplayUsersOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View openActivityButton) {
			List<User> usersFromDatabase = mUserDao.getAll();
			String textToDisplay = "";
			for (User user : usersFromDatabase) {
				textToDisplay += "ID: " + user.getId() + "; Vorname: " + user.getFirstName()
						+ "; Nachname: " + user.getLastName() + "\n";
			}
			Toast.makeText(MainActivity.this, textToDisplay, Toast.LENGTH_LONG).show();

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button saveUserButton = findViewById(R.id.button_main_saveUsers);
		saveUserButton.setOnClickListener(mSaveUsersOnClickListener);

		Button displayUsersButton = findViewById(R.id.button_main_displayUsers);
		displayUsersButton.setOnClickListener(mDisplayUsersOnClickListener);

		mUserDao = AppDatabase.getAppDb(getApplicationContext()).getUserDao();
	}
}
