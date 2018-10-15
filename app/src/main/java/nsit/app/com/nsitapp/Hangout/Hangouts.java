package nsit.app.com.nsitapp.Hangout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import nsit.app.com.nsitapp.R;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class Hangouts extends Fragment implements View.OnClickListener {

    public static final String CHOICE_TYPE = "Choice";
    private int choice = -1;

    @BindView(R.id.hang_college) LinearLayout hcollege;
    @BindView(R.id.hang_restaurant) LinearLayout hresturant;
    @BindView(R.id.hang_cafe) LinearLayout hcafes;
    @BindView(R.id.hang_nightclub) LinearLayout hnightclub;
    @BindView(R.id.hang_shoppingmalls) LinearLayout hmalls;
    @BindView(R.id.hang_bowling) LinearLayout hbowling;
    @BindView(R.id.hang_movies) LinearLayout hmovies;
    @BindView(R.id.hang_food) LinearLayout hfood;
    @BindView(R.id.hang_amusment) LinearLayout hapark;
    @BindView(R.id.hang_park) LinearLayout hpark;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooview = inflater.inflate(R.layout.fragment_hangouts, container, false);
        ButterKnife.bind(this, rooview);
//        LinearLayout hcollege = rooview.findViewById(R.id.hang_college);
//        LinearLayout hresturant = rooview.findViewById(R.id.hang_restaurant);
//        LinearLayout hcafes = rooview.findViewById(R.id.hang_cafe);
//        LinearLayout hnightclub = rooview.findViewById(R.id.hang_nightclub);
//        LinearLayout hmalls = rooview.findViewById(R.id.hang_shoppingmalls);
//        LinearLayout hbowling = rooview.findViewById(R.id.hang_bowling);
//        LinearLayout hmovies = rooview.findViewById(R.id.hang_movies);
//        LinearLayout hfood = rooview.findViewById(R.id.hang_food);
//        LinearLayout hapark = rooview.findViewById(R.id.hang_amusment);
//        LinearLayout hpark = rooview.findViewById(R.id.hang_park);

        hcollege.setOnClickListener(this);
        hresturant.setOnClickListener(this);
        hcafes.setOnClickListener(this);
        hnightclub.setOnClickListener(this);
        hmalls.setOnClickListener(this);
        hbowling.setOnClickListener(this);
        hmovies.setOnClickListener(this);
        hfood.setOnClickListener(this);
        hapark.setOnClickListener(this);
        hpark.setOnClickListener(this);
        return rooview;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hang_college:
                choice = 0;
                break;
            case R.id.hang_restaurant:
                choice = 1;
                break;
            case R.id.hang_cafe:
                choice = 2;
                break;
            case R.id.hang_nightclub:
                choice = 3;
                break;
            case R.id.hang_shoppingmalls:
                choice = 4;
                break;
            case R.id.hang_bowling:
                choice = 5;
                break;
            case R.id.hang_movies:
                choice = 6;
                break;
            case R.id.hang_food:
                choice = 7;
                break;
            case R.id.hang_amusment:
                choice = 8;
                break;
            case R.id.hang_park:
                choice = 9;
                break;
        }
        if (choice != 0) {
            Intent intent = new Intent(getActivity(), HangoutsTypeDisplay.class);
            intent.putExtra(CHOICE_TYPE, choice - 1);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getActivity(), HangoutCollegeLocations.class);
            startActivity(intent);
        }

    }
}
