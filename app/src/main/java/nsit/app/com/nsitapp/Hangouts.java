package nsit.app.com.nsitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class Hangouts extends Fragment implements View.OnClickListener {

    public static final String CHOICE_TYPE = "Choice";
    private int choice = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooview = inflater.inflate(R.layout.fragment_hangouts, container, false);
        LinearLayout hcollege = (LinearLayout) rooview.findViewById(R.id.hang_college);
        LinearLayout hresturant = (LinearLayout) rooview.findViewById(R.id.hang_restaurant);
        LinearLayout hcafes = (LinearLayout) rooview.findViewById(R.id.hang_cafe);
        LinearLayout hnightclub = (LinearLayout) rooview.findViewById(R.id.hang_nightclub);
        LinearLayout hmalls = (LinearLayout) rooview.findViewById(R.id.hang_shoppingmalls);
        LinearLayout hbowling = (LinearLayout) rooview.findViewById(R.id.hang_bowling);
        LinearLayout hmovies = (LinearLayout) rooview.findViewById(R.id.hang_movies);
        LinearLayout hfood = (LinearLayout) rooview.findViewById(R.id.hang_food);
        LinearLayout hapark = (LinearLayout) rooview.findViewById(R.id.hang_amusment);
        LinearLayout hpark = (LinearLayout) rooview.findViewById(R.id.hang_park);

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
            Intent intent = new Intent(getActivity(), Hangout_collegeLocations.class);
            startActivity(intent);
        }

    }
}
