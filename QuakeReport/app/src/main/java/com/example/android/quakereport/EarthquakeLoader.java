package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Admin on 27-Mar-17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Quake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Quake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Quake> quakesList = QueryUtils.fetchEarthquakeData(mUrl);
        return quakesList;
    }
}
