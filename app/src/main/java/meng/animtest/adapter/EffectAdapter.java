package meng.animtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;

/**
 * Created by meng on 16/6/28.
 */
public class EffectAdapter extends BaseAdapter {

    private Context mContext;

    public EffectAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Techniques.values().length;
    }

    @Override
    public Object getItem(int position) {
        return Techniques.values()[position].getAnimator();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null, false);
        }
        TextView nameView = (TextView) convertView;
        Object o = getItem(position);
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        String name = o.getClass().getName().substring(start);
        nameView.setText(name);
        nameView.setTag(Techniques.values()[position]);
        return convertView;
    }
}
