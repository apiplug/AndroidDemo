package com.apiplug.androiddemo.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.apiplug.androiddemo.R;
import com.apiplug.androiddemo.adapters.ActorAdapter;
import com.apiplug.androiddemo.models.Actor;
import com.apiplug.androiddemo.models.ActorResults;
import com.apiplug.androiddemo.rest.APIPlug;
import com.apiplug.androiddemo.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Actors Fragment
 *
 * @author APIPlug
 * @version v1.0
 *
 */
public class ActorsFragment extends Fragment {


    private List<Actor> actors;
    private ListView listView;



    public ActorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActorsFragment newInstance() {
        ActorsFragment fragment = new ActorsFragment();
        Bundle args = new Bundle();
        //If your fragment needs params add them in here
        //args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //If your fragment needs params add them in here
            //mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_actors, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        getActorsList();

        return view;
    }


    private void getActorsList() {
        final ProgressDialog loading = ProgressDialog.show(getActivity(),getContext().getString(R.string.loading_title),getContext().getString(R.string.loading_please_wait),false,false);

        Call<ActorResults> call = ApiClient.get().getActors();

        call.enqueue(new Callback<ActorResults>() {
            @Override
            public void onFailure(Call<ActorResults> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

                loading.dismiss();
            }

            @Override
            public void onResponse(Call<ActorResults> call, Response<ActorResults> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                loading.dismiss();

                actors=response.body().results;

                if(actors.size()>0) {
                    showList();
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    //Our method to show list
    private void showList() {
        Log.d("APIPlug", "Show List");

        ActorAdapter adapter = new ActorAdapter(getActivity(), actors);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Actor clickedObj = (Actor) parent.getItemAtPosition(position);

                //If you have detail activity about your object define in here
                /*
                Intent detail = new Intent(getContext(), ActorDetail.class);
                detail.putExtra("actorObject", clickedObj);
                startActivity(detail);
                */
            }});

    }







}
