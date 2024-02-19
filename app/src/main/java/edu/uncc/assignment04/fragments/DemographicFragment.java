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
import edu.uncc.assignment04.databinding.FragmentDemographicBinding;
import edu.uncc.assignment04.databinding.FragmentIdentificationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemographicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemographicFragment extends Fragment {

    private Response mresponse;
public void setResponse(Response response){
    mresponse = response;
}
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentDemographicBinding binding;


    public DemographicFragment() {
        // Required empty public constructor
    }


    public static DemographicFragment newInstance(String param1, String param2) {
        DemographicFragment fragment = new DemographicFragment();
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
            mresponse = getArguments().getParcelable("response");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDemographicBinding.inflate(inflater, container, false);

        // Check if the response object is null
        if (mresponse != null) {
            // Update your UI with the response values


           binding.textViewEducation.setText(mresponse.getEducationLevel() != null ? mresponse.getEducationLevel() : "N/A");
            binding.textViewMaritalStatus.setText(mresponse.getMaritalStatus() != null ? mresponse.getMaritalStatus() : "N/A");
            binding.textViewLivingStatus.setText(mresponse.getLivingStatus() != null ? mresponse.getLivingStatus() : "N/A");
            binding.textViewIncomeStatus.setText(mresponse.getHouseholdIncome() != 0 ? String.valueOf(mresponse.getHouseholdIncome()) : "N/A");

        } else {
            // Handle the case where the response object is null
            // For example, display a message or log an error
        }

        return binding.getRoot();
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Demographic Info");

        binding.buttonSelectEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectEducationFragment(mresponse);
            }
        });

        binding.buttonSelectMarital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectMaritalFragment(mresponse); }
        });

        binding.buttonSelectLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectLivingFragment(mresponse); }
        });

        binding.buttonSelectIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoSelectIncomeFragment(mresponse); }
        });
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoProfileFragment(mresponse); }
        });
    }
    DemographicListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DemographicListener) {
            mListener = (DemographicListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement DemographicListener");
        }
    }
    interface DemographicListener{
        void gotoSelectEducationFragment(Response response);
        void gotoSelectMaritalFragment(Response response);

        void gotoSelectLivingFragment(Response response);

        void gotoSelectIncomeFragment(Response response);

        void gotoProfileFragment(Response response);
    }

}


