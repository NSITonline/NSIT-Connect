package nsit.app.com.nsitapp.Calendar;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.SubjectObject;
import nsit.app.com.nsitapp.R;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private final Activity context;
    private final ArrayList<String> day;
    private final ArrayList<SubjectObject> p0, p1, p2, p3, p4, p5, p6, p7, p8, p9;

    CalendarAdapter(Activity context, ArrayList<String> d, ArrayList<SubjectObject> b0, ArrayList<SubjectObject> b1, ArrayList<SubjectObject> b2, ArrayList<SubjectObject> b3, ArrayList<SubjectObject> b4,
                    ArrayList<SubjectObject> b5, ArrayList<SubjectObject> b6, ArrayList<SubjectObject> b7
            , ArrayList<SubjectObject> b8, ArrayList<SubjectObject> b9) {
        this.context = context;
        day = d;
        p0 = b0;
        p1 = b1;
        p2 = b2;
        p3 = b3;
        p4 = b4;
        p5 = b5;
        p6 = b6;
        p7 = b7;
        p8 = b8;
        p9 = b9;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //mon0 tue1 wed2 thu3 fri4 sat5 sun6
        holder.dat.setText(day.get(position));
        if (position < p1.size()) {
            add(p0.get(position), holder.t0);
            add(p1.get(position), holder.t1);
            add(p2.get(position), holder.t2);
            add(p3.get(position), holder.t3);
            add(p4.get(position), holder.t4);
            add(p5.get(position), holder.t5);
            add(p6.get(position), holder.t6);
        }
        if (position < p7.size())
            add(p7.get(position), holder.t7);
        if (position < p8.size())
            add(p8.get(position), holder.t8);
        if (position < p9.size())
            add(p9.get(position), holder.t9);
    }

    @Override
    public int getItemCount() {
        return p0.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.day)
        TextView dat;
        @BindView(R.id.p0)
        TextView t0;
        @BindView(R.id.p1)
        TextView t1;
        @BindView(R.id.p2)
        TextView t2;
        @BindView(R.id.p3)
        TextView t3;
        @BindView(R.id.p4)
        TextView t4;
        @BindView(R.id.p5)
        TextView t5;
        @BindView(R.id.p6)
        TextView t6;
        @BindView(R.id.p7)
        TextView t7;
        @BindView(R.id.p8)
        TextView t8;
        @BindView(R.id.p9)
        TextView t9;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void add(SubjectObject subjectObject, TextView textView) {
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/food_icons.ttf");
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(" ");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

        if (!subjectObject.value.contains("break"))
            if (subjectObject.value.contains("theory"))
                textView.setText(subjectObject.subfh + "\n" + subjectObject.roomfh);
            else
                textView.setText(subjectObject.subfh + "," + subjectObject.subsh + "\n" + subjectObject.roomfh + "," + subjectObject.roomsh);
        else {
            if (subjectObject.value.contains("lunch")) {
                textView.setTypeface(custom_font);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                textView.setText("BOH");
            } else {

                textView.setTypeface(Typeface.DEFAULT);
                textView.setText(" ");
            }
        }
    }
}