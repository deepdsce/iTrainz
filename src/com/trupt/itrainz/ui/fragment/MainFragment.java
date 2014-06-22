package com.trupt.itrainz.ui.fragment;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.trupt.itrainz.R;
import com.trupt.itrainz.model.Menu;
import com.trupt.itrainz.util.MenuUtil;


public class MainFragment extends BaseFragment {
	
	private ListView listViewMainMenu;
	private ArrayList<Menu> listMenus;
	private MainMenuAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, null);
		init(view);
		setup(view);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	private void init(View view) {
		listViewMainMenu = (ListView) view.findViewById(R.id.listViewMainMenu);
		listMenus = new ArrayList<>();
		adapter = new MainMenuAdapter();
		listViewMainMenu.setAdapter(adapter);
	}
	
	private void setup(View view) {
		listMenus.addAll(MenuUtil.getMenus());
		adapter.notifyDataSetChanged();
	}
	
	
	private class MainMenuAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return listMenus.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			if(view == null) {
				view = ((LayoutInflater) MainFragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.listview_main_menu, null);
			}
			TextView textViewMenuTitle = (TextView) view.findViewById(R.id.textViewMenuTitle);
			String title = listMenus.get(position).getName();
			textViewMenuTitle.setText(title);
			return view;
		}
		
	}

}
