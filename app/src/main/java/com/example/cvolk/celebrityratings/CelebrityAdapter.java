package com.example.cvolk.celebrityratings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cvolk.celebrityratings.model.Celebrity;

import java.util.ArrayList;

public class CelebrityAdapter extends ArrayAdapter<Celebrity> {
    public CelebrityAdapter(Context context, ArrayList<Celebrity> celebrities) {
        super(context,0, celebrities);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Celebrity celebrity = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvCelebrity = convertView.findViewById(R.id.tvCelebrity);

        tvCelebrity.setText(celebrity.getFirstName().toString() + " " + celebrity.getLastName().toString() + " " + celebrity.getAge() + " / " + celebrity.getGender().toString());

        return convertView;
    }
}
