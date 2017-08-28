package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 22-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Professors extends Fragment implements
        AdapterView.OnItemClickListener {


    private static final String[] titles = new String[]{"DM", "DC", "DP",
            "DM", "H&M",
            "ECE",
            "COE", "ICE", "MPAE", "IT", "BT", "SAS"};

    private static final String[] full = new String[]{
            "DEPARTMENT OF MANAGEMENT", "DEPARTMENT OF CHEMISTRY", "DEPARTMENT OF PHYSICS",
            "DEPARTMENT OF MATHS", "School Of Humanities & Management",
            "Division Of Electronics & Communication Engg",
            "Division Of Computer Engg", "Division Of Instrumentation & Control Engg",
            "Division Of Manufacturing Processes & Automation Engg",
            "Division Of Information Technology",
            "Division Of Bio-Technology", "School Of Applied Sciences"
    };

    private ListView listView;
    private List<RowItem> rowItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    private Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof, container, false);


        rowItems = new ArrayList<RowItem>();

        int len1 = titles.length;
        for (int i = 0; i < len1; i++) {
            RowItem item = new RowItem(titles[i].toUpperCase(), full[i]);
            rowItems.add(item);
        }

        listView = (ListView) rootView.findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(activity,
                rowItems);
        if (activity != null)
            listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return rootView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent mFragment = new Intent(activity, ProfList.class);
        mFragment.putExtra("dept", position);
        startActivity(mFragment);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

        Context context;

        public CustomListViewAdapter(Context context,
                                     List<RowItem> items) {
            super(context, R.layout.department_list_item, items);
            this.context = context;
        }

        /*private view holder class*/
        private class ViewHolder {
            //        ImageView imageView;
            TextView txtTitle;
            TextView txtDesc;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            RowItem rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.department_list_item, parent, false);
                holder = new ViewHolder();
                holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
                holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.txtDesc.setText(rowItem.getDesc());
            holder.txtTitle.setText(rowItem.getTitle());
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation slide = new TranslateAnimation(-200, 0, -200, 0);
            slide.setInterpolator(new DecelerateInterpolator(5.0f));
            slide.setDuration(300);
            Animation fade = new AlphaAnimation(0, 1.0f);
            fade.setInterpolator(new DecelerateInterpolator(5.0f));
            fade.setDuration(300);
            set.addAnimation(slide);
            set.addAnimation(fade);
            convertView.startAnimation(set);
            return convertView;
        }
    }

}
