package nsit.app.com.nsitapp.professor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import models.ProfListRowItem;
import nsit.app.com.nsitapp.R;

import static functions.Utils.setAnimation;

public class ProfListCustomListViewAdapter extends ArrayAdapter<ProfListRowItem> {

    private final Context context;
    private final List<ProfListRowItem> profListRowItems;

    ProfListCustomListViewAdapter(Context context, List<ProfListRowItem> items) {
        super(context, R.layout.prof_list_item, items);
        this.context = context;
        profListRowItems = items;
    }

    private class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        TextView txtEmail;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        final ProfListRowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.prof_list_item, parent, false);
            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.tvname);
            holder.txtPhone = convertView.findViewById(R.id.tvphone);
            holder.txtEmail = convertView.findViewById(R.id.tvemail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(rowItem.getName());
        holder.txtPhone.setText(rowItem.getPhone());
        holder.txtPhone.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            String[] x = rowItem.getPhone().split("(DID)");
            String p = "tel:" + x[0];
            i.setData(Uri.parse(p));
            getContext().startActivity(i);
        });

        holder.txtEmail.setText(rowItem.getEmail());
        holder.txtEmail.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{rowItem.getEmail()});
            intent.putExtra(Intent.EXTRA_SUBJECT, " ");
            intent.putExtra(Intent.EXTRA_TEXT, rowItem.getName());
            getContext().startActivity(Intent.createChooser(intent, context.getString(R.string.choose_class)));
        });

        setAnimation(convertView);
        return convertView;
    }
}