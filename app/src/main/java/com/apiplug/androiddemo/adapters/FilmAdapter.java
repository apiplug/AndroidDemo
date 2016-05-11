package com.apiplug.androiddemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apiplug.androiddemo.R;
import com.apiplug.androiddemo.models.Country;
import com.apiplug.androiddemo.models.Film;

import java.util.List;

/**
 * Custom ArrayAdapter Actor Adapter for displaying list items in listview
 *
 * @author APIPlug
 * @version v1.0
 *
 */
public class FilmAdapter extends ArrayAdapter<Film> {

    private static class ViewHolder {
        TextView title;
        TextView description;
        ImageView imageView;
    }

    public FilmAdapter(Context context, List<Film> films) {
        super(context, 0, films);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Film film = getItem(position);

        ViewHolder viewHolder; //check for cache
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_films, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the film object
        viewHolder.title.setText(film.getTitle()+" ("+film.getRelease_year()+")");
        viewHolder.description.setText(film.getDescription());

        /*
        If your item has image you could load it dynamicaly with Picasso
        if(film.getImagePath()!=""){
            Picasso.with(getContext())
                    .load(film.getImagePath())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.imageView);
        }
        */

        // Return the completed view to render on screen
        return convertView;

    }
}
