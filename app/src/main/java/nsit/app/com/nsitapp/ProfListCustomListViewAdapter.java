package nsit.app.com.nsitapp;

/**
 * Created by dhruvmullick on 09/07/14.
 */

import android.app.Activity;
import android.content.Context;
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

/*
    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new ProfFilter();
        }
        return filter;
    }


    private class ProfFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                List<ProfListRowItem> filteredItems = new List<ProfListRowItem>() {
                    @Override
                    public void add(int i, ProfListRowItem profListRowItem) {

                    }

                    @Override
                    public boolean add(ProfListRowItem profListRowItem) {
                        return false;
                    }

                    @Override
                    public boolean addAll(int i, Collection<? extends ProfListRowItem> collection) {
                        return false;
                    }

                    @Override
                    public boolean addAll(Collection<? extends ProfListRowItem> collection) {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public boolean contains(Object o) {
                        return false;
                    }

                    @Override
                    public boolean containsAll(Collection<?> collection) {
                        return false;
                    }

                    @Override
                    public ProfListRowItem get(int i) {
                        return null;
                    }

                    @Override
                    public int indexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @NonNull
                    @Override
                    public Iterator<ProfListRowItem> iterator() {
                        return null;
                    }

                    @Override
                    public int lastIndexOf(Object o) {
                        return 0;
                    }

                    @NonNull
                    @Override
                    public ListIterator<ProfListRowItem> listIterator() {
                        return null;
                    }

                    @NonNull
                    @Override
                    public ListIterator<ProfListRowItem> listIterator(int i) {
                        return null;
                    }

                    @Override
                    public ProfListRowItem remove(int i) {
                        return null;
                    }

                    @Override
                    public boolean remove(Object o) {
                        return false;
                    }

                    @Override
                    public boolean removeAll(Collection<?> collection) {
                        return false;
                    }

                    @Override
                    public boolean retainAll(Collection<?> collection) {
                        return false;
                    }

                    @Override
                    public ProfListRowItem set(int i, ProfListRowItem profListRowItem) {
                        return null;
                    }

                    @Override
                    public int size() {
                        return 0;
                    }

                    @NonNull
                    @Override
                    public List<ProfListRowItem> subList(int i, int i1) {
                        return null;
                    }

                    @NonNull
                    @Override
                    public Object[] toArray() {
                        return new Object[0];
                    }

                    @NonNull
                    @Override
                    public <T> T[] toArray(T[] ts) {
                        return null;
                    }
                };

                for(int i = 0, l = it.size(); i < l; i++)
                {
                    ProfListRowItem p = it.get(i);
                    if(p.getName().toString().toLowerCase().contains(constraint)) {
                        filteredItems.add(p);
                        Log.e("fa",p.getName().toString());
                    }
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = it;
                    result.count = it.size();
                }
            }
            Log.e("gergverdvd", "" + result.getClass().toString());
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            List<ProfListRowItem> filteredItems = (List<ProfListRowItem>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = filteredItems.size(); i < l; i++) {
                add(filteredItems.get(i));

            }
            notifyDataSetInvalidated();
        }
    }*/

}
