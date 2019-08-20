package Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.homejek.ui.R;

import java.util.HashMap;
import java.util.List;

public class AProposAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<String>> _listDataChild;

    public AProposAdapter(Context _context, List<String> _listDataHeader, HashMap<String, List<String>> _listDataChild) {
        this._context = _context;
        this._listDataHeader = _listDataHeader;
        this._listDataChild = _listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_apropos, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeaderAPropos);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        ImageView hide = convertView.findViewById(R.id.hide);

        if (isExpanded){
            hide.setBackgroundResource(R.drawable.arrow_up);
        }
        else {
            hide.setBackgroundResource(R.drawable.arrow_down);

        }


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if(groupPosition == 0){
            Log.e("POSITION 0",childText);
        }
        else {
            Log.e("POSITION else",childText);

        }
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_apropos, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.about_txt);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
