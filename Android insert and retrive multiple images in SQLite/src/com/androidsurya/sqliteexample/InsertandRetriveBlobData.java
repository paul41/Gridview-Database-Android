package com.androidsurya.sqliteexample;

import java.util.ArrayList;

import com.androidsurya.sqliteexample.R;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class InsertandRetriveBlobData extends Activity {
	private DBhelper DbHelper;
	public static final String EMP_ID = "id";
	public static final String EMP_NAME = "name";
	public static final String EMP_AGE = "age";
	public static final String EMP_PHOTO = "photo";
	ArrayList<Employee> employeeList = new ArrayList<Employee>();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_layout);
		DbHelper = new DBhelper(this);
		//Employee employee_One = new Employee(BitmapFactory.decodeResource(
			//	getResources(), R.drawable.employeeone), "Surya", 25);
		Employee employee_Two = new Employee(BitmapFactory.decodeResource(
				getResources(), R.drawable.employeeone), "Bondada", 23);
		Employee employee_Twoo = new Employee(BitmapFactory.decodeResource(
				getResources(), R.drawable.employeetwo), "Siliguri", 26);
		Employee employee_Tw = new Employee(BitmapFactory.decodeResource(
				getResources(), R.drawable.ic_launcher), "Jalpaiguri", 36);
		
		
		DbHelper.open();
		DbHelper.Reset();
		// insert first employee one details
		//DbHelper.insertEmpDetails(employee_One);
		// insert first employee two details
		DbHelper.insertEmpDetails(employee_Twoo);
		DbHelper.insertEmpDetails(employee_Two);
		DbHelper.insertEmpDetails(employee_Tw);
		employeeList = DbHelper.retriveallEmpDetails();
		DbHelper.close();
		//ListView lv=(ListView)findViewById(R.id.uuu);
		//lv.setAdapter(new ImageAdapter(this, employeeList));
		GridView gridView = (GridView) findViewById(R.id.grid_view);
		// Instance of ImageAdapter Class
		//gridView.setAdapter(new CustomGridViewAdapter(this,R.layout.row_grid,employeeList));
		gridView.setAdapter(new ImageAdapter(this, employeeList));

	}
}
