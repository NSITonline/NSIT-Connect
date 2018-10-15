package nsit.app.com.nsitapp.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.OJManager;
import models.OnlineJudge;
import nsit.app.com.nsitapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineJudgeListFragment extends Fragment {

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_online_judge_list, container, false);

        RecyclerView mOnlineJudgesList = view.findViewById(R.id.onlinejudge_recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mOnlineJudgesList.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mOnlineJudgeListAdapter = new OnlineJudgeListAdapter();
        mOnlineJudgesList.setAdapter(mOnlineJudgeListAdapter);

        return view;
    }


    class OnlineJudgeListAdapter extends
            RecyclerView.Adapter<OnlineJudgeListAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.onlineJudge_cover) ImageView mOnlineJudgeCover;
            @BindView(R.id.onlineJudge_name) TextView mOnlineJudgeName;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
//                mOnlineJudgeCover = view.findViewById(R.id.onlineJudge_cover);
//                mOnlineJudgeName = view.findViewById(R.id.onlineJudge_name);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.onlinejudge_list_item, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
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
