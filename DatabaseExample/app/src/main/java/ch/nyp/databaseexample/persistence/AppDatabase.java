package ch.nyp.databaseexample.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import ch.nyp.databaseexample.model.User;
@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

	private static final String DB_NAME = "DemoDb";
	private static AppDatabase appDb;

	public static AppDatabase getAppDb(Context context) {
		if (appDb == null) {
			appDb = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
					.fallbackToDestructiveMigration()
					.allowMainThreadQueries()
					.build();
		}
		return appDb;
	}

	public abstract UserDao getUserDao();
}

