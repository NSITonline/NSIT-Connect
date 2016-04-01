package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 22-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import functions.Constant;


public class ProfList extends AppCompatActivity implements Constant {
    EditText s;
    public static final String[] full = new String[]{
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_proflist);


        Intent i = getIntent();
        int dept = i.getIntExtra("dept", 0);

        setTitle("Professors");

        ListView listView;
        listView = (ListView) findViewById(R.id.profListView);
        listView.setTextFilterEnabled(true);
        TextView tv = (TextView) findViewById(R.id.textView);


        List<ProfListRowItem> profe = new ArrayList<ProfListRowItem>();

        tv.setText(full[dept]);

        final ProfListCustomListViewAdapter adapter;


        String[] name = new String[100], ids = new String[100], contact = new String[100];
        int k = 0;
        JSONArray ar;
        JSONObject ob;

        try {
            ar = new JSONArray(pro);
            ob = ar.getJSONObject(dept);
            ar = ob.getJSONArray("ContentArray");
            for (int j = 0; j < ar.length(); j++) {

                name[k] = ar.getJSONObject(j).getString("Name");
                if (ar.getJSONObject(j).getString("Designation") != "")
                    name[k] = name[k] + " , " + ar.getJSONObject(j).getString("Designation");
                ids[k] = ar.getJSONObject(j).getString("Email");
                contact[k] = ar.getJSONObject(j).getString("ContactNo");
                k++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < k; j++) {
            ProfListRowItem item = new ProfListRowItem(name[j], ids[j], contact[j]);
            profe.add(item);

        }

        adapter = new ProfListCustomListViewAdapter(this, R.layout.prof_list_item, profe);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public class ProfListCustomListViewAdapter extends ArrayAdapter<ProfListRowItem> {

        Context context;
        List<ProfListRowItem> it;

        //private ProfFilter filter;
        public ProfListCustomListViewAdapter(Context context, int resourceId,
                                             List<ProfListRowItem> items) {
            super(context, resourceId, items);
            this.context = context;
            it = items;
        }

        /*private view holder class*/
        private class ViewHolder {
            TextView txtName;
            TextView txtPhone;
            TextView txtEmail;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            final ProfListRowItem rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
//            System.out.println("Convert View is Null");
                convertView = mInflater.inflate(R.layout.prof_list_item, null);
                holder = new ViewHolder();
                holder.txtName = (TextView) convertView.findViewById(R.id.tvname);
                holder.txtPhone = (TextView) convertView.findViewById(R.id.tvphone);
                holder.txtEmail = (TextView) convertView.findViewById(R.id.tvemail);

                convertView.setTag(holder);
            } else {

                holder = (ViewHolder) convertView.getTag();
            }


            holder.txtName.setText(rowItem.getName());
            holder.txtPhone.setText(rowItem.getPhone());
            holder.txtPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    String[] x = rowItem.getPhone().split("(DID)");
                    String p = "tel:" + x[0];
                    i.setData(Uri.parse(p));
                    getContext().startActivity(i);
                }
            });
            holder.txtEmail.setText(rowItem.getEmail());
            holder.txtEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{rowItem.getEmail()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                    intent.putExtra(Intent.EXTRA_TEXT, rowItem.getName());
                    getContext().startActivity(Intent.createChooser(intent, "ChooseClass..."));
                }
            });

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
