package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.databinding.FragmentSelectIncomeBinding;

public class SelectIncomeFragment extends Fragment {

    private Response mResponse;
    private FragmentSelectIncomeBinding binding;

    public SelectIncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectIncomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Select Household Income");

        mResponse = getArguments().getParcelable("response");

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelIncomeSelection();
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int householdIncome = (binding.seekBar.getProgress() + 1) * 5000;
                mResponse.setHouseholdIncome(householdIncome);
                mListener.popIncomeFragment(mResponse);
            }
        });

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int householdIncome = (progress + 1) * 5000;
                binding.textViewHouseHoldIncome.setText(getString(R.string.household_income_format, householdIncome));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed
            }
        });
    }

    private IncomeListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IncomeListener) {
            mListener = (IncomeListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement IncomeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    interface IncomeListener {
        void popIncomeFragment(Response response);
        void cancelIncomeSelection();
    }
}
