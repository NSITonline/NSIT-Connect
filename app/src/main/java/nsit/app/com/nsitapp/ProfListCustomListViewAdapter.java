package nsit.app.com.nsitapp;

/**
 * Created by dhruvmullick on 09/07/14.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.widget.Filter;
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
        holder.txtEmail.setText(rowItem.getEmail());
        holder.txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { rowItem.getEmail() });
                intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                intent.putExtra(Intent.EXTRA_TEXT, rowItem.getName());
                getContext().startActivity(Intent.createChooser(intent, "Choose..."));
            }
        });
        return convertView;
    }



}
