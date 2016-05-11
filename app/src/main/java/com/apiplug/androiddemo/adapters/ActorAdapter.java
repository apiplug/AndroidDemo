package com.apiplug.androiddemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apiplug.androiddemo.models.Actor;
import com.apiplug.androiddemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Custom ArrayAdapter Actor Adapter for displaying list items in listview
 *
 * @author APIPlug
 * @version v1.0
 *
 */
public class ActorAdapter extends ArrayAdapter<Actor> {

    private static class ViewHolder {
        TextView title;
        TextView name;
        ImageView imageView;
    }

    public ActorAdapter(Context context, List<Actor> actors) {
        super(context, 0, actors);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Actor actor = getItem(position);

        ViewHolder viewHolder; //check for cache
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_actor, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the actor object
        viewHolder.name.setText(actor.getFirst_name()+" "+actor.getLast_name());

        /*
        If your item has image you could load it dynamicaly with Picasso
        if(actor.getImagePath()!=""){
            Picasso.with(getContext())
                    .load(actor.getImagePath())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.imageView);
        }
        */

        // Return the completed view to render on screen
        return convertView;

    }
}
