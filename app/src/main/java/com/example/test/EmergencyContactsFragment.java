package com.example.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EmergencyContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_emergency_contacts, container, false);

        // Find TextViews
        TextView EmgAmbulance = view.findViewById(R.id.textView19);
        TextView ambulance = view.findViewById(R.id.textView22);
        TextView suicidePrevent = view.findViewById(R.id.textView20);
        TextView police = view.findViewById(R.id.textView21);

        // Set up click listeners for dialing
        setupDialer(EmgAmbulance, "1990");
        setupDialer(ambulance, "110");
        setupDialer(suicidePrevent, "1333");
        setupDialer(police, "119");

        return view;
    }

    private void setupDialer(TextView textView, String phoneNumber) {
        if (textView != null) {
            textView.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            });
        }
    }
}
