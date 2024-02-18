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
import edu.uncc.assignment04.databinding.FragmentIdentificationBinding;


public class IdentificationFragment extends Fragment {



    public IdentificationFragment() {
        // Required empty public constructor
    }




    FragmentIdentificationBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentIdentificationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Identification Info");

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.editTextName.getText().toString();
                String email = binding.editTextEmail.getText().toString();
                String role = "Student";
                if(binding.radioGroup.getCheckedRadioButtonId()==  R.id.radioButtonEmployee) {
                    role = "Employee";
                } else if (binding.radioGroup.getCheckedRadioButtonId()==  R.id.radioButtonOther) {
                    role = "Other";
                }

                if (name.isEmpty()|| email.isEmpty()) {
                    // Display an error message to the user
                    Toast.makeText(getContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                } else {

                    mListener.gotoSetResponse();
                }
            }
        });
    }
    IdentificationInfoListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (IdentificationInfoListener) context;
    }

    interface IdentificationInfoListener{
        void gotoSetResponse();
    }

}