package nsit.app.com.nsitapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.model.OJManager;
import nsit.app.com.nsitapp.model.OnlineJudge;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineJudgeListFragment extends Fragment {

    RecyclerView mOnlineJudgesList;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mOnlineJudgeListAdapter;

    private ArrayList<OnlineJudge> mOnlineJudges;

    public OnlineJudgeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnlineJudges = OJManager.getInstance().getOnlineJudges();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_online_judge_list, container, false);

        mOnlineJudgesList = (RecyclerView) view.findViewById(R.id.onlinejudge_recyclerView);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mOnlineJudgesList.setLayoutManager(mLayoutManager);

        mOnlineJudgeListAdapter = new OnlineJudgeListAdapter();
        mOnlineJudgesList.setAdapter(mOnlineJudgeListAdapter);

        return view;
    }


    private class OnlineJudgeListAdapter extends
            RecyclerView.Adapter<OnlineJudgeListAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView mOnlineJudgeCover;
            public TextView mOnlineJudgeName;

            public ViewHolder(View view) {
                super(view);
                mOnlineJudgeCover = (ImageView) view.findViewById(R.id.onlineJudge_cover);
                mOnlineJudgeName = (TextView) view.findViewById(R.id.onlineJudge_name);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.onlinejudge_list_item, parent, false);

            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.mOnlineJudgeName.setText(mOnlineJudges.get(position).getName());
            viewHolder.mOnlineJudgeCover.setImageResource(mOnlineJudges.get(position).
                    getCoverResource());
        }

        @Override
        public int getItemCount() {
            return mOnlineJudges.size();
        }

    }


}
