package com.example.rusili.unit3midassessment.recycler.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.unit3midassessment.R;
import com.example.rusili.unit3midassessment.display.DisplayActivity;

/**
 * Created by rusi.li on 11/27/17.
 */

public class SharedPrefsViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private String value = null;

    public SharedPrefsViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.viewholder_textview);
        setOnClickListener();
    }

    private void setOnClickListener() {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDisplayActivity = new Intent(itemView.getContext(), DisplayActivity.class);
                toDisplayActivity.putExtra(itemView.getContext().getString(R.string.intent_key_display_activity), value);
                itemView.getContext().startActivity(toDisplayActivity);
            }
        });
    }

    public void bind(Object o) {
        value = o.toString();
        textView.setText(value);
    }
}
