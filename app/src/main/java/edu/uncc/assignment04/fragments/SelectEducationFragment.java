package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.assignment04.R;

import edu.uncc.assignment04.databinding.FragmentSelectEducationBinding;


public class SelectEducationFragment extends Fragment {


    private Response mResponse;

    public SelectEducationFragment() {

    }

    FragmentSelectEducationBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectEducationBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Response response = bundle.getParcelable("response");
            // Now you can use the response object
        }
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Education Info");
        mResponse = getArguments().getParcelable("response");
        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelEducationLevel();
            }
        });


        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.radioGroup.getCheckedRadioButtonId() == -1) {
                    // No radio button is selected, display an error message
                    Toast.makeText(getContext(), "Please select an education level", Toast.LENGTH_SHORT).show();
                    return; // Exit the method early
                }
                String educationLevel;

                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();

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

                // Pass the educationLevel to the listener along with the existing Response object
                mResponse.setEducationLevel(educationLevel);
                mListener.popEducationFragment(mResponse);
                //Response educationResponse = new Response(null, null, null, educationLevel, null, null, 0);
                //mListener.popEducationFragment(educationResponse);
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
    void popEducationFragment(Response response);
    void cancelEducationLevel();
}

}
