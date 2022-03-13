package com.example.medicalreminder.addingmed.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.myhealth.Model.Medicine;
import com.example.myhealth.R;

public class howoften_notEveryday extends Fragment {
    NavController navController;
    Medicine medicine;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view= inflater.inflate(R.layout.howoften_not_every_day,container,false);
        Bundle bundle = this.getArguments();
        medicine= (Medicine) bundle.getSerializable("obj");

        view.findViewById(R.id.once_a_week).setOnClickListener(this::nexttochooseday);
        view.findViewById(R.id.every2days).setOnClickListener(this::every2day);
        view.findViewById(R.id.two_days_aweek).setOnClickListener(this::nexttochooseday);
        view.findViewById(R.id.threedaysaweek).setOnClickListener(this::nexttochooseday);
        view.findViewById(R.id.every28day).setOnClickListener(this::every28day);

        return  view;
    }

    private void nexttochooseday(View view) {
        String count;
        Button holder = view.findViewById(view.getId());
        count= holder.getText().toString();
        medicine.setHow_often(count);
        int counter=0;
        if(view.getId() == R.id.two_days_aweek ) counter = 2;
        if(view.getId() == R.id.threedaysaweek ) counter = 3;
        Bundle Sendbundle = new Bundle();
        Sendbundle.putSerializable("obj",medicine);
        Sendbundle.putInt("count",counter);

        navController = Navigation.findNavController(view);
        NavDirections navDirections = howoften_notEverydayDirections.actionHowoftennoteverydayToChooseTheDays();
        navController.navigate(R.id.choose_theDays,Sendbundle);
    }

    private void every2day(View view) {
        navController = Navigation.findNavController(view);
        Bundle Sendbundle = new Bundle();
        Sendbundle.putSerializable("obj",medicine);
        Sendbundle.putInt("intervaloftime",2);
        NavDirections navDirections = howoften_notEverydayDirections.actionHowoftennoteverydatToSetStartDate();
        navController.navigate(R.id.SetStartDate,Sendbundle);
    }

    private void every28day(View view) {
        navController = Navigation.findNavController(view);
        Bundle Sendbundle = new Bundle();
        Sendbundle.putSerializable("obj",medicine);
        Sendbundle.putInt("intervaloftime",28);
        NavDirections navDirections = howoften_notEverydayDirections.actionHowoftennoteverydatToSetStartDate();
        navController.navigate(R.id.SetStartDate,Sendbundle);
    }
}
