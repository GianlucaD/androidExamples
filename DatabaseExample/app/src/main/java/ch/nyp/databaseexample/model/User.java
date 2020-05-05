package ch.nyp.databaseexample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

@Entity
public class User{

	//Autoincrement
	@PrimaryKey(autoGenerate = true)
	private int id;

	//Spalte heisst in der DB account_name
	@ColumnInfo(name="account_name")
	private String accountName;

	//Wenn nicht angegeben, heisst Spalte in der DB wie Variable, d.h. hier firstName.
	private String firstName;

	private String lastName;

	//@Ignore bedeutet, dass für diese Variable keine Spalte in der DB erzeugt werden soll.
	@Ignore
	private Bitmap image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}
}
