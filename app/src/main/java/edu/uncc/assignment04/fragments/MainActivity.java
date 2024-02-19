package edu.uncc.assignment04.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import edu.uncc.assignment04.R;

public class MainActivity extends AppCompatActivity implements IdentificationFragment.IdentificationInfoListener, DemographicFragment.DemographicListener, SelectEducationFragment.EducationInfoListener, SelectMaritalStatusFragment.MaritalStatusListener, SelectLivingStatusFragment.LivingStatusListener, SelectIncomeFragment.IncomeListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new MainFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSetResponse(Response response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response);

        DemographicFragment demographicFragment = new DemographicFragment();
        demographicFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, demographicFragment, "demographic_fragment_tag")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSelectMaritalFragment(Response response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response);

        SelectMaritalStatusFragment fragment = new SelectMaritalStatusFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSelectLivingFragment(Response response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response);

        SelectLivingStatusFragment fragment = new SelectLivingStatusFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoSelectIncomeFragment(Response response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response);

        SelectIncomeFragment fragment = new SelectIncomeFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoProfileFragment(Response response) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response); // Pass the Response object here

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void gotoSelectEducationFragment(Response response) {

        Bundle bundle = new Bundle();
        bundle.putParcelable("response", response);

        SelectEducationFragment fragment = new SelectEducationFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, fragment)
                .addToBackStack(null)
                .commit();

    }



    @Override
    public void popEducationFragment(Response response) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("demographic_fragment_tag");
        if (fragment != null) {
            fragment.setResponse(response);
        }

        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelEducationLevel() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void popMaritalStatusFragment(Response response) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("demographic_fragment_tag");
        if (fragment != null) {
            fragment.setResponse(response);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelMaritalStatus() {
        getSupportFragmentManager().popBackStack();
    }





    @Override
    public void popLivingStatusFragment(Response response) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("demographic_fragment_tag");
        if (fragment != null) {
            fragment.setResponse(response);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelLivingStatus() {
        getSupportFragmentManager().popBackStack();
    }




    @Override
    public void popIncomeFragment(Response response) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("demographic_fragment_tag");
        if (fragment != null) {
            fragment.setResponse(response);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelIncomeSelection() {
        getSupportFragmentManager().popBackStack();
    }


}
