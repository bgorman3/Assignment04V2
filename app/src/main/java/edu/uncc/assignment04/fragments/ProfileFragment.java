package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Response mResponse;

    FragmentProfileBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mResponse = getArguments().getParcelable("response");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        // Check if the response object is null
        if (mResponse != null) {
            // Update your UI with the response values

            binding.textViewName.setText(mResponse.getName() != null ? mResponse.getName() : "N/A");
            binding.textViewEmail.setText(mResponse.getEmail() != null ? mResponse.getEmail() : "N/A");
            binding.textViewEdu.setText(mResponse.getEducationLevel() != null ? mResponse.getEducationLevel() : "N/A");
            binding.textViewMaritalStatus.setText(mResponse.getMaritalStatus() != null ? mResponse.getMaritalStatus() : "N/A");
            binding.textViewLivingStatus.setText(mResponse.getLivingStatus() != null ? mResponse.getLivingStatus() : "N/A");
            binding.textViewIncomeValue.setText(String.valueOf(mResponse.getHouseholdIncome()));
        } else {
            // Handle the case where the response object is null
            // For example, display a message or log an error
        }

        return binding.getRoot();
    }

    // Other methods if needed...

}
