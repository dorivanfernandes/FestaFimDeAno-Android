package com.example.festafimdeano.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.Data.SecurityPreferences;
import com.example.festafimdeano.R;
import com.example.festafimdeano.constants.FimDeAnoConstants;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);
        this.mViewHolder.CheckParticipate = findViewById(R.id.checkbox_participate);
        this.mViewHolder.CheckParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.checkbox_participate){
            if(this.mViewHolder.CheckParticipate.isChecked()){
                this.mSecurityPreferences.StoreString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_YES);
            }else{
                this.mSecurityPreferences.StoreString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox CheckParticipate;
    }

    private void loadDataFromActivity(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            if(extras.getString(FimDeAnoConstants.PRESENCE_KEY).equals(FimDeAnoConstants.CONFIRMATION_YES)){
                this.mViewHolder.CheckParticipate.setChecked(true);
            }else{
                this.mViewHolder.CheckParticipate.setChecked(false);
            }
        }
    }
}
