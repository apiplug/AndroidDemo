package com.apiplug.androiddemo.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.apiplug.androiddemo.R;
import com.apiplug.androiddemo.adapters.CountryAdapter;
import com.apiplug.androiddemo.adapters.FilmAdapter;
import com.apiplug.androiddemo.models.Country;
import com.apiplug.androiddemo.models.CountryResults;
import com.apiplug.androiddemo.models.Film;
import com.apiplug.androiddemo.models.FilmResults;
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
public class FilmFragment extends Fragment {


    private List<Film> films;
    private ListView listView;



    public FilmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmFragment newInstance() {
        FilmFragment fragment = new FilmFragment();
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
        View view = inflater.inflate(R.layout.fragment_films, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        getFilmsList();

        return view;
    }


    private void getFilmsList() {
        final ProgressDialog loading = ProgressDialog.show(getActivity(),getContext().getString(R.string.loading_title),getContext().getString(R.string.loading_please_wait),false,false);

        Call<FilmResults> call = ApiClient.get().getFilms();

        call.enqueue(new Callback<FilmResults>() {
            @Override
            public void onFailure(Call<FilmResults> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

                loading.dismiss();
            }

            @Override
            public void onResponse(Call<FilmResults> call, Response<FilmResults> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                loading.dismiss();

                films=response.body().results;

                if(films.size()>0) {
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

        FilmAdapter adapter = new FilmAdapter(getActivity(), films);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Film clickedObj = (Film) parent.getItemAtPosition(position);

                //If you have detail activity about your object define in here
                /*
                Intent detail = new Intent(getContext(), ObjectDetail.class);
                detail.putExtra("filmObject", clickedObj);
                startActivity(detail);
                */
            }});

    }







}
