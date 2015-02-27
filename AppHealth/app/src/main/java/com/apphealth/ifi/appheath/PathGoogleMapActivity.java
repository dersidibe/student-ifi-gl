package com.apphealth.ifi.appheath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.apphealth.ifi.parser.PathJSONParser;
import com.apphealth.utils.HttpConnection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class PathGoogleMapActivity extends FragmentActivity {

    private LatLng Depart, Destination;
    private String DepLatitude,DepLongitude, DestLatitude,DestLongitude,nom;
	GoogleMap googleMap;
	final String TAG = "PathGoogleMapActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_path_google_map);
        Intent intent = getIntent();
        DepLatitude = intent.getStringExtra("DepLatitude");
        DepLongitude = intent.getStringExtra("DepLongitude");
        DestLatitude = intent.getStringExtra("DestLatitude");
        DestLongitude = intent.getStringExtra("DestLongitude");
        nom = intent.getStringExtra("nom");
        Depart = new LatLng(Double.parseDouble(DepLatitude),Double.parseDouble(DepLongitude));
        Destination = new LatLng(Double.parseDouble(DestLatitude),Double.parseDouble(DestLongitude));

	}

    @Override
    protected  void onStart(){

        super.onStart();

        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = fm.getMap();

        MarkerOptions options = new MarkerOptions();
        options.position(Depart);
        options.position(Destination);
        googleMap.addMarker(options);
        String url = getMapsApiDirectionsUrl();
        ReadTask downloadTask = new ReadTask();
        downloadTask.execute(url);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Destination,13));
        addMarkers();

    }

	private String getMapsApiDirectionsUrl() {

        String waypoints = "waypoints=optimize:true|"
                + DepLatitude + "," + DepLongitude
                + "|" + "|" +DestLatitude + ","
                + DestLongitude;

		String sensor = "sensor=false";
		String params = waypoints + "&" + sensor;
		String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?"+"origin="+ DepLatitude + "," +DepLongitude+"&destination="+DestLatitude+ ","
                + DestLongitude+"&" + params;
		return url;
	}

	private void addMarkers() {

		if (googleMap != null) {

            googleMap.addMarker(new MarkerOptions().position(Destination).title(nom));
            googleMap.addMarker(new MarkerOptions().position(Depart).title("Me"));
		}
	}

	private class ReadTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... url) {

			String data = "";
			try {
				HttpConnection http = new HttpConnection();
				data = http.readUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return data;
		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
			new ParserTask().execute(result);
		}
	}

	private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		@Override
		protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {


			JSONObject jObject;
			List<List<HashMap<String, String>>> routes = null;

			try {

				jObject = new JSONObject(jsonData[0]);
				PathJSONParser parser = new PathJSONParser();
				routes = parser.parse(jObject);
			} catch (Exception e) {

				e.printStackTrace();
			}
			return routes;
		}

		@Override
		protected void onPostExecute(List<List<HashMap<String, String>>> routes) {

			ArrayList<LatLng> points = null;
			PolylineOptions polyLineOptions = null;

			// traversing through routes
			for (int i = 0; i < routes.size(); i++) {

				points = new ArrayList<LatLng>();
				polyLineOptions = new PolylineOptions();
				List<HashMap<String, String>> path = routes.get(i);

				for (int j = 0; j < path.size(); j++) {

					HashMap<String, String> point = path.get(j);

					double lat = Double.parseDouble(point.get("lat"));
					double lng = Double.parseDouble(point.get("lng"));
					LatLng position = new LatLng(lat, lng);

					points.add(position);
				}

				polyLineOptions.addAll(points);
				polyLineOptions.width(2);
				polyLineOptions.color(Color.BLUE);
			}

			googleMap.addPolyline(polyLineOptions);
		}
	}
}
