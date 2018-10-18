package nsit.app.com.nsitapp.professor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.RowItem;
import nsit.app.com.nsitapp.R;

import static functions.Utils.setAnimation;


public class ProfessorsFragment extends Fragment implements
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    private Activity activity;
    @BindView(R.id.list) ListView listView;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity)activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof, container, false);
        ButterKnife.bind(this, rootView);

        List<RowItem> rowItems = new ArrayList<>();

        int len1 = titles.length;
        for (int i = 0; i < len1; i++) {
            RowItem item = new RowItem(titles[i].toUpperCase(), full[i]);
            rowItems.add(item);
        }
        CustomListViewAdapter adapter = new CustomListViewAdapter(activity,
                rowItems);
        if (activity != null)
            listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return rootView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent mFragment = new Intent(activity, ProfessorsList.class);
        mFragment.putExtra("dept", position);
        startActivity(mFragment);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

        final Context context;

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

        @NonNull
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            RowItem rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.department_list_item, parent, false);
                holder = new ViewHolder();
                holder.txtDesc = convertView.findViewById(R.id.desc);
                holder.txtTitle = convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            holder.txtDesc.setText(rowItem.getDesc());
            holder.txtTitle.setText(rowItem.getTitle());
            setAnimation(convertView);
            return convertView;
        }
    }

}
