package nsit.app.com.nsitapp;
/**
 * CREATED BY SAISUMIT(aka SUMIT  VOHRA) on 9-Sept-2015
 * **/

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**CREATED BY SAISUMIT **/

/**  CREATED BY SAISUMIT   **/



public class User_Info extends AppCompatActivity implements Serializable {
    private final static String LOG_TAG = "THIS IS MY LIFE";


    public static class  User  {
        String handle =null;
        String email = null;
        String vkId = null;
        String openId = null;
        String firstName = null;
        String lastName = null;
        String country = null;
        String city = null;
        String organization = null;
        int contribution = 0;
        String rank = null;
        int rating = 0;
        String maxRank = null;
        int maxRating = 0;
        int lastOnlineTimeSeconds = 0;
        int registrationTimeSeconds = 0;


    }

    public static class contest_ratings {
        int contestId=0;
        int index=0;
        String contestName=null;
        int rank=0;
        int newRating=0;
        int ratingChange=0;

    }
   public  ArrayList<contest_ratings> user_ratings_data;
    public static User user_info = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__info);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.user_info, new PlaceholderFragment())
                    .commit();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();

        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        private class ButtonAnimation {
            public void animateButton(View v, Context context){
                Animation pressAnim = AnimationUtils.loadAnimation(context, R.anim.button_press_anim);
                v.startAnimation(pressAnim);
            }
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_user_info, container, false);

            return rootView;

        }
        /*
                *
        * */

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            Button mybtn = (Button) getActivity().findViewById(R.id.codeforces_search_button);
            mybtn.setOnClickListener(

                    new Button.OnClickListener() {

                        public void onClick(View view) {

                            ButtonAnimation btn1=new ButtonAnimation();
                            btn1.animateButton(view, getActivity());
                            update_user_info();


                        }
                    }


            );
           /* mybtn= (Button)getActivity().findViewById(R.id.codeforces_rating__search_button);
            mybtn.setOnClickListener(

                    new Button.OnClickListener() {

                        public void onClick(View view) {

                            ButtonAnimation btn1=new ButtonAnimation();
                            btn1.animateButton(view, getActivity());
                            update_user_ratings();


                        }
                    }


            );
           /* mybtn= (Button)getActivity().findViewById(R.id.codeforces_submission_search_button);
            mybtn.setOnClickListener(

                    new Button.OnClickListener() {

                        public void onClick(View view) {

                            ButtonAnimation btn1=new ButtonAnimation();
                            btn1.animateButton(view, getActivity());
                            update_user_submissions();


                        }
                    }


            );*/





            super.onViewCreated(view, savedInstanceState);
        }

        private void update_user_info() {
            FetchCodeForcesTask CodeForcesTask = new FetchCodeForcesTask();//CREATES A NEW FETCH_WEATHER OBJECT NAMED WEATHER_TASK

            EditText codeforceshandle = (EditText) getActivity().findViewById(R.id.handleeditText);
            String handle = codeforceshandle.getText().toString();
            // Log.v("this is my string   "+handle,"set");
              CodeForcesTask.execute(handle); //CALLING THE EXECUTE METHOD ON THAT OBJECT


        }

        private void update_user_ratings(){
            FetchCodeForcesTask_2 CodeForcesTask_2 = new FetchCodeForcesTask_2();
            EditText codeforceshandle = (EditText) getActivity().findViewById(R.id.handleeditText);
            String handle = codeforceshandle.getText().toString();
            CodeForcesTask_2.execute(handle);

        }

        private void update_user_submissions(){

        }



        public class FetchCodeForcesTask extends AsyncTask<String, Void, User> {

            protected User doInBackground(String... params) {
                if (params.length == 0)
                    return null;
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String forecastJsonStr = null;
                String format = "json";
                try {
                    final String CODEFORCES_BASE_URL = "http://codeforces.com/api/user.info?";
                    final String USERNAME_PARAM = "handles";
                    Uri builtUri = Uri.parse(CODEFORCES_BASE_URL).buildUpon()
                            .appendQueryParameter(USERNAME_PARAM, params[0]).build();
                    URL url = new URL(builtUri.toString());
                    Log.v("THIS is URL", "Built URI " + builtUri.toString());
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        forecastJsonStr = null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        forecastJsonStr = null;
                    }
                    forecastJsonStr = buffer.toString();


                    Log.v(LOG_TAG, "Forecast JSON String" + forecastJsonStr);
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Error ", e);
                    forecastJsonStr = null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(LOG_TAG, "Error closing stream", e);
                        }
                    }
                }

                try { if(forecastJsonStr!=null)
                          {User parseddata=getCodeForcesDataFromJson(forecastJsonStr);
                                    Log.v("Data!=null","something else");
                                  Log.v("Data!=null","parseddata.country");
                                              return parseddata;}

                        else

                {  SnackbarManager.show(
                        Snackbar.with(getActivity().getApplicationContext())
                                .text("User Not Found")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), getActivity());

                    throw new JSONException("username not exist");}
                          }



                 catch (JSONException e) {

                   // Toast.makeText(getActivity(),"User Does Not Exist",Toast.LENGTH_SHORT).show();


                    e.printStackTrace();
                    Log.e("wicket ", e.getMessage(), e);


                }
                return null;


            }

            private User getCodeForcesDataFromJson(String forecastJsonStr)
            throws JSONException{
                Log.v("status1",forecastJsonStr);
                JSONObject forecastJson = new JSONObject(forecastJsonStr);



                   JSONArray Users = forecastJson.getJSONArray("result");



                    JSONObject UserData = Users.getJSONObject(0);
                if(!UserData.isNull("handle"))
                    user_info.handle = (String)UserData.get("handle");
                else  user_info.handle=null;

                Log.v("COUNTRY",user_info.country+"2");
                if(!UserData.isNull("firstName"))
                user_info.firstName = (String)UserData.get("firstName");
                else  user_info.firstName=null;
                Log.v("COUNTRY",user_info.country+"2");
                if(!UserData.isNull("lastName"))
                    user_info.lastName =(String)UserData.get("lastName");
                else  user_info.lastName=null;
                Log.v("COUNTRY",user_info.country+"2");
                if(!UserData.isNull("country"))
                    user_info.country = (String)UserData.get("country");
                else user_info.country=null;
                Log.v("COUNTRY",user_info.country+"2");
                if(!UserData.isNull("email"))
                user_info.email =   (String)UserData.get("email");
                else user_info.email=null;
                Log.v("COUNTRY",user_info.country+"52");
                if(!UserData.isNull("city"))
                      user_info.city =  (String)UserData.get("city");
                else user_info.city=null;
                      Log.v("COUNTRY",user_info.country+"98");
                if(!UserData.isNull("organization"))
                    user_info.organization = (String)UserData.get("organization");
                else  user_info.organization=null;
                        Log.v("COUNTRY",user_info.country+"16");
                if(!UserData.isNull("contribution"))
                    user_info.contribution = (int) UserData.get("contribution");
                else  user_info.contribution=0;
                        Log.v("COUNTRY",user_info.country+"255");
                if(!UserData.isNull("rank"))
                    user_info.rank =   (String)UserData.get("rank");
                else user_info.rank=null;
                Log.v("COUNTRY",user_info.country+"3");
                if(!UserData.isNull("maxRating"))
                    user_info.maxRating = (int)UserData.get("maxRating");
                else user_info.maxRating=0;
                          Log.v("COUNTRY",user_info.country+"4");
                if(!UserData.isNull("maxRank"))
                    user_info.maxRank =(String)UserData.get("maxRank");
                else user_info.maxRank=null;
                Log.v("COUNTRY",user_info.country+"5");
                if(!UserData.isNull("rating"))
                    user_info.rating = (int)UserData.get("rating");
                else user_info.rating=0;
                          Log.v("Data!=null","something else5");

                return user_info;



            }


            @Override
            protected void onPostExecute(User result) {
               super.onPostExecute(result);
                if(result!=null)
                {try{  Log.v("aise hi","result.firstName");
                   Intent intent=new Intent(getActivity(),usr_list.class);
                         //intent.putExtra("MyClass",  result);

                    startActivity(intent);
                 /*   android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();

                     user_info_list kl=new user_info_list();
                    Log.v("aise hi",result.firstName);
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    Log.v("aise hi",result.firstName);
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Log.v("aise hi",result.firstName);
                    fragmentTransaction.replace(kl);

                    getSupportActionBar().setTitle("User Information");
*/



                }catch (Exception e)
                { Log.e("frustated",e.getMessage());
                   e.printStackTrace();


                }


                }
            }
        }


        public class FetchCodeForcesTask_2 extends  AsyncTask< String, Void, ArrayList<contest_ratings> >{
            protected ArrayList<contest_ratings> doInBackground(String... params) {
                if (params.length == 0)
                    return null;
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String forecastJsonStr = null;
                String format = "json";
                try {
                    final String CODEFORCES_BASE_URL = "http://codeforces.com/api/user.rating?";
                    final String USERNAME_PARAM = "handle";
                    Uri builtUri = Uri.parse(CODEFORCES_BASE_URL).buildUpon()
                            .appendQueryParameter(USERNAME_PARAM, params[0]).build();
                    URL url = new URL(builtUri.toString());
                    Log.v("THIS is URL", "Built URI " + builtUri.toString());
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    // User newuser=urlConnection.getContent(User);

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        forecastJsonStr = null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                        // But it does make debugging a *lot* easier if you print out the completed
                        // buffer for debugging.
                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        forecastJsonStr = null;
                    }
                    forecastJsonStr = buffer.toString();


                    Log.v(LOG_TAG, "Forecast JSON String" + forecastJsonStr);
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Error ", e);
                    // If the code didn't successfully get the weather data, there's no point in attemping
                    // to parse it.

                    forecastJsonStr = null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(LOG_TAG, "Error closing stream", e);
                        }
                    }
                }

                try { if(forecastJsonStr!=null)
                {ArrayList<contest_ratings> parseddata=getCodeForcesDataFromJson_2(forecastJsonStr);
                    Log.v("Data!=null","something else");
                    Log.v("Data!=null","parseddata.country");
                    return parseddata;}

                else

                {  SnackbarManager.show(
                        Snackbar.with(getActivity().getApplicationContext())
                                .text("User Not Found")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), getActivity());

                    throw new JSONException("username not exist");}
                }



                catch (JSONException e) {
                    // Toast.makeText(getActivity(),"User Does Not Exist",Toast.LENGTH_SHORT).show();


                    e.printStackTrace();
                    Log.e("wicket ", e.getMessage(), e);


                }
                return null;


            }


            private ArrayList<contest_ratings> getCodeForcesDataFromJson_2(String forecastJsonStr)
                    throws JSONException{
                Log.v("status1",forecastJsonStr);
                ArrayList<contest_ratings> ratings_info = new ArrayList<>();
                contest_ratings obj= new contest_ratings();
                JSONObject forecastJson = new JSONObject(forecastJsonStr);

                JSONArray ratings = forecastJson.getJSONArray("result");

                int len= ratings.length();
                Log.v("length2",Integer.toString(len));
                for(int i=0;i<len;i++)
                { JSONObject UserData = ratings.getJSONObject(i);
                       obj.index= i;
                       obj.contestId= (int)UserData.get("contestId");
                       obj.contestName=(String)UserData.get("contestName");
                       obj.newRating=(int)UserData.get("newRating");
                       obj.rank=(int)UserData.get("rank");
                       obj.ratingChange= obj.newRating-(int)UserData.get("oldRating");
                    ratings_info.add(obj);

                }
               Log.v("Data_parsed_success",ratings_info.get(0).contestName);
               user_ratings_data = ratings_info;
                return ratings_info;


            }


            @Override
            protected void onPostExecute(ArrayList<contest_ratings> result) {
                super.onPostExecute(result);
                if(result!=null)
                {try{  Log.v("aise hi","result.firstName");

                    Intent intent=new Intent(getActivity(),ratings_change.class);
                    //intent.putExtra("MyClass",  result);

                    startActivity(intent);




                }catch (Exception e)
                { Log.e("frustated",e.getMessage());
                    e.printStackTrace();


                }


                }


        }
    }




    }

}