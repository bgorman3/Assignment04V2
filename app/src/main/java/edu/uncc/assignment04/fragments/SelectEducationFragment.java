package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uncc.assignment04.R;

import edu.uncc.assignment04.databinding.FragmentSelectEducationBinding;


public class SelectEducationFragment extends Fragment {


    private Response response;

    public SelectEducationFragment() {
        this.response = response;// Required empty public constructor
    }

    FragmentSelectEducationBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectEducationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Education Info");



        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String educationLevel;

                // Get the ID of the selected radio button
                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();

                // Set educationLevel based on the selected radio button
                if (selectedRadioButtonId == R.id.radioButtonBHS) {
                    educationLevel = "Below High School";
                } else if (selectedRadioButtonId == R.id.radioButtonHS) {
                    educationLevel = "High School";
                } else if (selectedRadioButtonId == R.id.radioButtonBS) {
                    educationLevel = "Bachelor's Degree";
                } else if (selectedRadioButtonId == R.id.radioButtonMS) {
                    educationLevel = "Master's Degree";
                } else if (selectedRadioButtonId == R.id.radioButtonPHD) {
                    educationLevel = "Ph.D. or higher";
                } else if (selectedRadioButtonId == R.id.radioButtonTS) {
                    educationLevel = "Trade School";
                } else if (selectedRadioButtonId == R.id.radioButtonPreferNotToSay) {
                    educationLevel = "Prefer not to say";
                } else {
                    educationLevel = ""; // Default value if no radio button is selected
                }

                // Create a Response object with educationLevel


                // Pass the response to the listener
                mListener.popEducationFragment();

            }
        });
    }
    EducationInfoListener mListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (EducationInfoListener) context;
    }

interface EducationInfoListener{
    void popEducationFragment();
    void cancelEducationLevel();
}

}
