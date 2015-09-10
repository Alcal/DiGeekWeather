package com.cetys.digeekweather;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.cetys.digeekweather.com.cetys.digeekweather.model.CurrentWeather;
import com.cetys.digeekweather.dataaccess.ForecastDAO;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnCurrentWeatherInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CurrentWeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentWeatherFragment extends Fragment {
    private static final String CITY = "city";

    private String mCity;

    private OnCurrentWeatherInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param city Parameter 1.
     * @return A new instance of fragment CurrentWeatherFragment.
     */
    public static CurrentWeatherFragment newInstance(String city) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle args = new Bundle();
        args.putString(CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCity = getArguments().getString(CITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
            R.array.cities, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCurrentWeatherInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnCurrentWeatherInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        WeatherTask weatherTask = new WeatherTask();

        weatherTask.execute("Ensenada");
    }

    public void DisplayWeather(CurrentWeather weather)
    {
        TextView cityTextView = (TextView)getView().findViewById(R.id.txtCity);
        TextView weatherTextView = (TextView)getView().findViewById(R.id.txtWeather);
        TextView weatherDescTextView = (TextView)getView().findViewById(R.id.txtWeatherDesc);
        TextView tempTextView = (TextView)getView().findViewById(R.id.txtTemp);

        cityTextView.setText(weather.getName());
        weatherTextView.setText(weather.getWeather()[0].getMain());
        weatherDescTextView.setText(weather.getWeather()[0].getDescription());
        tempTextView.setText(String.valueOf(weather.getMainW().getTemp() - 273.15));
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCurrentWeatherInteractionListener {
        // TODO: Update argument type and name
        public void onCurrentWeatherInteraction(Uri uri);
    }

    protected class WeatherTask extends AsyncTask<String, Void, CurrentWeather>
    {
        public ForecastDAO forecastDAO = new ForecastDAO();

        @Override
        protected CurrentWeather doInBackground(String... city) {
            Log.i("HOME", "retrieving alumno!");
            return forecastDAO.getCurrentWeather(city[0]);
        }

        @Override
        public void onPostExecute(CurrentWeather weather) {
            Log.i("ALEX", weather.getName());
            DisplayWeather(weather);
        }

    }

}
