package edu.uncc.assignment04.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import edu.uncc.assignment04.R;

public class MainActivity extends AppCompatActivity implements IdentificationFragment.IdentificationInfoListener, DemographicFragment.DemographicListener,SelectEducationFragment.EducationInfoListener {

    ArrayList<Response> responses = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new MainFragment()) // Replace the fragment container with MainFragment
                .addToBackStack(null) // Add MainFragment to the back stack
                .commit();
    }

    @Override
    public void gotoSetResponse() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new DemographicFragment())
                .addToBackStack(null) // Add to back stack to allow navigation back to the previous fragment
                .commit();
    }

    @Override
    public void gotoSelectEducationFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectEducationFragment())
                .addToBackStack(null) // Add to back stack to allow navigation back to the previous fragment
                .commit();
    }

    public void popEducationFragment() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelEducationLevel() {

    }

    private Response createResponseWithEducationLevel(String educationLevel) {
        // Create the Response object with only the education level
        return new Response(null, null, null, educationLevel, null, null, 0);
    }

    private Response createResponse(String name, String email, String role, String educationLevel, String maritalStatus, String livingStatus, Integer householdIncome) {
        // Create the Response object using the provided parameters
        return new Response(name, email, role, educationLevel, maritalStatus, livingStatus, householdIncome);
    }
}