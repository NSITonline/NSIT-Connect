package nsit.app.com.nsitapp;

/**
 * Created by dhruvmullick on 09/07/14.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfListCustomListViewAdapter extends ArrayAdapter<ProfListRowItem> {

    Context context;

    public ProfListCustomListViewAdapter(Context context, int resourceId,
                                         List<ProfListRowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView txtName;
        TextView txtRoom;
        TextView txtPhone;
        TextView txtEmail;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ProfListRowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
//            System.out.println("Convert View is Null");
            convertView = mInflater.inflate(R.layout.prof_list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.tvname);
            holder.txtRoom = (TextView) convertView.findViewById(R.id.tvroom);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvphone);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.tvemail);

            convertView.setTag(holder);
        } else {
//            System.out.println("Not Null");

            holder = (ViewHolder) convertView.getTag();
        }


//        System.out.println(rowItem.getDesc());

        holder.txtName.setText(rowItem.getName());
        holder.txtRoom.setText(rowItem.getRoom());
        holder.txtPhone.setText(rowItem.getPhone());
        holder.txtEmail.setText(rowItem.getEmail());


        return convertView;
    }
}
