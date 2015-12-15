package com.example.toddemo;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		StickyListHeadersListView lvTasks = (StickyListHeadersListView) findViewById(R.id.lvTasks);
		String[] stringArray = this.getResources().getStringArray(R.array.countries);

		StickListTaskAdapter taskAdapter = new StickListTaskAdapter(this, stringArray);
		lvTasks.setAdapter(taskAdapter);
		lvTasks.setDrawingListUnderStickyHeader(true);
		lvTasks.setAreHeadersSticky(true);

		// 设置监听
		OnItemLongClickListener onItemLongClickListener = null;
		lvTasks.setOnItemLongClickListener(onItemLongClickListener);
		
		OnItemClickListener onItemClickListener = null;
		lvTasks.setOnItemClickListener(onItemClickListener);
	}
}
