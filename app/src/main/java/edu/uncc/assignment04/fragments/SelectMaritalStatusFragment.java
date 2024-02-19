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

import edu.uncc.assignment04.databinding.FragmentSelectMaritalStatusBinding;

public class SelectMaritalStatusFragment extends Fragment {
    private Response mResponse;

    public SelectMaritalStatusFragment() {
        // Required empty public constructor
    }

    FragmentSelectMaritalStatusBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_marital_status, container, false);
        binding = FragmentSelectMaritalStatusBinding.inflate(inflater, container, false);

        // Get the arguments passed to this fragment
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
        getActivity().setTitle("Select Marital Status");

        // Retrieve the Response object from arguments
        mResponse = getArguments().getParcelable("response");

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelMaritalStatus();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.radioGroup.getCheckedRadioButtonId() == -1) {
                    // No radio button is selected, display an error message
                    Toast.makeText(getContext(), "Please select a marital status", Toast.LENGTH_SHORT).show();
                    return; // Exit the method early
                }

                String maritalStatus;
                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == R.id.radioButtonNotMarried) {
                    maritalStatus = "Not Married";
                } else if (selectedRadioButtonId == R.id.radioButtonMarried) {
                    maritalStatus = "Married";
                } else if (selectedRadioButtonId == R.id.radioButtonPreferNotToSay) {
                    maritalStatus = "Prefer Not to say";
                } else {
                    maritalStatus = ""; // Default value if no radio button is selected
                }

                // Update the Response object with the selected marital status
                mResponse.setMaritalStatus(maritalStatus);

                // Pass the updated Response object to the listener
                mListener.popMaritalStatusFragment(mResponse);
            }
        });
    }

    MaritalStatusListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (MaritalStatusListener) context;
    }

    interface MaritalStatusListener {
        void popMaritalStatusFragment(Response response);
        void cancelMaritalStatus();
    }
}
