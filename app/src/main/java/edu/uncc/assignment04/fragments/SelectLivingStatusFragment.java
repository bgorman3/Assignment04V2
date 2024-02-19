package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.databinding. FragmentSelectLivingStatusBinding;


public class SelectLivingStatusFragment extends Fragment {
    private Response mResponse;

    public SelectLivingStatusFragment() {
        // Required empty public constructor
    }




    FragmentSelectLivingStatusBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_living_status, container, false);
        binding = FragmentSelectLivingStatusBinding.inflate(inflater, container, false);


        // Get the arguments passed to this fragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            Response response = bundle.getParcelable("response");
            // Now you can use the response object
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Select Living Status");

// Retrieve the Response object from arguments
        mResponse = getArguments().getParcelable("response");

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelLivingStatus();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.radioGroup.getCheckedRadioButtonId() == -1) {
                    // No radio button is selected, display an error message
                    Toast.makeText(getContext(), "Please select a living status", Toast.LENGTH_SHORT).show();
                    return; // Exit the method early
                }


                String livingStatus;
                int selectedRadioButtonId = binding.radioGroup.getCheckedRadioButtonId();



                if (selectedRadioButtonId == R.id.radioButtonHomeOwner) {
                    livingStatus = "Home Owner";
                } else if (selectedRadioButtonId == R.id.radioButtonRenter) {
                    livingStatus = "Renter";
                } else if (selectedRadioButtonId == R.id.radioButtonLessee) {
                    livingStatus = "Lessee";
                } else if (selectedRadioButtonId == R.id.radioButtonOther) {
                    livingStatus = "Other";
                } else if (selectedRadioButtonId == R.id.radioButtonPreferNotToSay) {
                    livingStatus = "Prefer Not to say";
                } else {
                    livingStatus = ""; // Default value if no radio button is selected
                }



                // Perform any action needed with the selected living status
                mResponse.setLivingStatus(livingStatus);
                mListener.popLivingStatusFragment(mResponse);
            }
        });
    }

     LivingStatusListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectLivingStatusFragment. LivingStatusListener) context;
    }

    interface LivingStatusListener {
        void popLivingStatusFragment(Response response);
        void cancelLivingStatus();
    }
}