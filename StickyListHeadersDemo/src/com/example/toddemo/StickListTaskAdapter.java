/**
 * StickListTaskAdapter.java [V 1.0.0]
 * classes:com.example.toddemo.StickListTaskAdapter
 * Zlang Create at 2015-12-15.下午12:31:53 
 */
package com.example.toddemo;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * com.example.toddemo.StickListTaskAdapter
 * 
 * @author ZLang <br/>
 *         create at 2015-12-15 下午12:31:53
 */
public class StickListTaskAdapter extends BaseAdapter implements StickyListHeadersAdapter
{

	private LayoutInflater layoutInflater;
	private String[] tasks;

	public StickListTaskAdapter(Context context, String[] tasks)
	{
		layoutInflater = LayoutInflater.from(context);

		this.tasks = tasks;

	}

	public void refresh(String[] tasks)
	{
		this.tasks = tasks;

		notifyDataSetChanged();
	}

	@Override
	public int getCount()
	{
		return tasks.length;
	}

	@Override
	public Object getItem(int position)
	{
		return tasks[position];
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder;
		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.task_item, null);

			viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.tvTitle.setText(tasks[position]);

		return convertView;
	}

	@Override
	public View getHeaderView(int position, View convertView, ViewGroup parent)
	{
		HeaderViewHolder hvh;
		if (convertView == null)
		{
			hvh = new HeaderViewHolder();
			convertView = layoutInflater.inflate(R.layout.task_header, null);
			hvh.tvHeader = (TextView) convertView.findViewById(R.id.tvHeader);
			convertView.setTag(hvh);
		} else
		{
			hvh = (HeaderViewHolder) convertView.getTag();
		}

		String headerText = "" + tasks[position].subSequence(0, 1).charAt(0);

		hvh.tvHeader.setText(headerText);
		return convertView;
	}

	@Override
	public long getHeaderId(int position)
	{
		return tasks[position].subSequence(0, 1).charAt(0);

	}

	class ViewHolder
	{

		TextView tvTitle;
		// TextView tvCreateTime;
	}

	class HeaderViewHolder
	{
		TextView tvHeader;
	}

}
