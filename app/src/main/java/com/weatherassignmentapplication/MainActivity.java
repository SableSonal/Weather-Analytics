package com.weatherassignmentapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.weatherassignmentapplication.data.DatabaseClient;
import com.weatherassignmentapplication.data.WeatherDetailsEntity;
import com.weatherassignmentapplication.data.Webservice;

import org.json.JSONArray;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private Context context;
    private String name, region, country, lat, lon, tz_id, localtime_epoch,
            localtime, last_updated_epoch, last_updated, temp_c, temp_f, is_day,
            text, icon, code, wind_mph, wind_kph, wind_degree, wind_dir, pressure_mb, pressure_in,
            precip_mm, precip_in, humidity, cloud, feelslike_c, feelslike_f,
            vis_km, vis_miles, uv, gust_mph, gust_kph,
            responseWeather;
    @BindView(R.id.txtGust)
    TextView txtGust;

    @BindView(R.id.txtUvIndex)
    TextView txtUvIndex;

    @BindView(R.id.txtCity)
    TextView txtCity;
    @BindView(R.id.txtWind)
    TextView txtWind;
    @BindView(R.id.txtWindDegree)
    TextView txtWindDegree;
    @BindView(R.id.txtWindDir)
    TextView txtWindDir;
    @BindView(R.id.txtPressure)
    TextView txtPressure;
    @BindView(R.id.txtFeelsLike)
    TextView txtFeelsLike;
    @BindView(R.id.txtVisibility)
    TextView txtVisibility;
    @BindView(R.id.txtPrecip)
    TextView txtPrecip;
    @BindView(R.id.txtCloud)
    TextView txtCloud;
    @BindView(R.id.txtHumidity)
    TextView txtHumidity;
    @BindView(R.id.txtTemperature)
    TextView txtTemperature;
    @BindView(R.id.layNoRecord)
    LinearLayout layNoRecord;

    @BindView(R.id.layParent)
    ScrollView layParent;


    private boolean doubleBackToExitPressedOnce;


    //on back press
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //get the reference of views
            context = this;
            ButterKnife.bind(this);

            //load weather data

            layParent.setVisibility(View.VISIBLE);
            layNoRecord.setVisibility(View.GONE);

            LoadWeatherData loadWeatherData = new LoadWeatherData();
            loadWeatherData.execute(null, null);

        } catch (Exception e) {
            e.printStackTrace();
            //set error
            Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
            layParent.setVisibility(View.GONE);
            layNoRecord.setVisibility(View.VISIBLE);
            return;
        }


    }

    public void FetchDataFromServer() {
        try {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.apixu.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Webservice service = retrofit.create(Webservice.class);
            Call<ResponseBody> res = service.jquery();

            res.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    try {

                        String responseData = response.body().string();
                        Log.i("RESPONSE_OK", responseData);


                        if (responseData == null || responseData.equals("")) {

                            //set error
                            Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
                            layParent.setVisibility(View.GONE);
                            layNoRecord.setVisibility(View.VISIBLE);
                            return;

                        } else {

                            //parse the data

                            JSONObject resObject = new JSONObject(responseData);
                            JSONObject locationObj = resObject.getJSONObject("location");
                            name = locationObj.getString("name");
                            region = locationObj.getString("region");
                            country = locationObj.getString("country");

                            lat = locationObj.getString("lat");
                            lon = locationObj.getString("lon");
                            tz_id = locationObj.getString("tz_id");

                            localtime_epoch = locationObj.getString("localtime_epoch");
                            localtime = locationObj.getString("localtime");


                            JSONObject currentObj = resObject.getJSONObject("current");
                            last_updated = currentObj.getString("last_updated");
                            last_updated_epoch = currentObj.getString("last_updated_epoch");
                            temp_c = currentObj.getString("temp_c");
                            temp_f = currentObj.getString("temp_f");
                            is_day = currentObj.getString("is_day");

                            wind_mph = currentObj.getString("wind_mph");
                            wind_kph = currentObj.getString("wind_kph");
                            wind_degree = currentObj.getString("wind_degree");
                            wind_dir = currentObj.getString("wind_dir");
                            pressure_mb = currentObj.getString("pressure_mb");
                            pressure_in = currentObj.getString("pressure_in");
                            precip_mm = currentObj.getString("precip_mm");
                            precip_in = currentObj.getString("precip_in");
                            humidity = currentObj.getString("humidity");
                            cloud = currentObj.getString("cloud");
                            feelslike_c = currentObj.getString("feelslike_c");
                            feelslike_f = currentObj.getString("feelslike_f");
                            vis_km = currentObj.getString("vis_km");
                            vis_miles = currentObj.getString("vis_miles");
                            uv = currentObj.getString("uv");
                            gust_mph = currentObj.getString("gust_mph");
                            gust_kph = currentObj.getString("gust_kph");


                            JSONObject conditionObj = currentObj.getJSONObject("condition");
                            text = conditionObj.getString("text");
                            code = conditionObj.getString("code");
                            icon = conditionObj.getString("icon");


                            //set values to textview

                            //temperature
                            if (temp_c == null || temp_c.equals("") || temp_c.equals("null")) {
                                txtTemperature.setText("0 \u00B0 C");
                            } else {
                                txtTemperature.setText("" + temp_c + " \u00B0 C");
                            }

                            //cloud
                            if (cloud == null || cloud.equals("") || cloud.equals("null")) {
                                txtCloud.setText("0");
                            } else {
                                txtCloud.setText(cloud);
                            }

                            //humidity
                            if (humidity == null || humidity.equals("") || humidity.equals("null")) {
                                txtHumidity.setText("0 %");
                            } else {
                                txtHumidity.setText(humidity + " %");
                            }

                            //wind
                            if (wind_mph == null || wind_mph.equals("") || wind_mph.equals("null")) {
                                txtWind.setText("0 mph");
                            } else {
                                txtWind.setText(wind_mph + " mph");
                            }

                            //wind degree
                            if (wind_degree == null || wind_degree.equals("") || wind_degree.equals("null")) {
                                txtWindDegree.setText("0");
                            } else {
                                txtWindDegree.setText(wind_degree);
                            }

                            //wind direction
                            if (wind_dir == null || wind_dir.equals("") || wind_dir.equals("null")) {
                                txtWindDir.setText("-");
                            } else {
                                txtWindDir.setText(wind_dir);
                            }

                            //pressure
                            if (pressure_in == null || pressure_in.equals("") || pressure_in.equals("null")) {
                                txtPressure.setText(" 0 psi");
                            } else {
                                txtPressure.setText(  pressure_in + " psi");
                            }

                            //visibility
                            if (vis_miles == null || vis_miles.equals("") || vis_miles.equals("null")) {
                                txtVisibility.setText("Visibility: 0 mi");
                            } else {
                                txtVisibility.setText("Visibility: " + vis_miles + " mi");
                            }

                            //feels like
                            if (feelslike_c == null || feelslike_c.equals("") || feelslike_c.equals("null")) {
                                txtFeelsLike.setText("Feels Like: 0 \u00B0 C");
                            } else {
                                txtFeelsLike.setText("Feels Like: " + feelslike_c + " \u00B0 C");
                            }


                            //precip
                            if (precip_in == null || precip_in.equals("") || precip_in.equals("null")) {
                                txtPrecip.setText("Precip: 0 in");
                            } else {
                                txtPrecip.setText("Precip: " + precip_in + " in");
                            }

                            //city
                            if (localtime == null || localtime.equals("") || localtime.equals("null")) {
                                txtCity.setText("Pune , DateTime -");
                            } else {
                                txtCity.setText("Pune , " + localtime);
                            }

                            //uv index
                            if (uv == null || uv.equals("") || uv.equals("null")) {
                                txtUvIndex.setText("UV Index: 0 ");
                            } else {
                                txtUvIndex.setText("UV Index: " + uv);
                            }

                            //gust
                            if (gust_mph == null || gust_mph.equals("") || gust_mph.equals("null")) {
                                txtGust.setText("Gust: 0 mPh");
                            } else {
                                txtGust.setText("Gust: " + gust_mph + " mPh");
                            }


                            //save the database
                            SaveWeatherDetails saveWeatherDetails = new SaveWeatherDetails();
                            saveWeatherDetails.execute(null, null);


                        }
                    } catch (Exception e) {

                        e.printStackTrace();
                        //set error
                        Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
                        layParent.setVisibility(View.GONE);
                        layNoRecord.setVisibility(View.VISIBLE);
                        return;
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                    try {

                        Log.e("RESPONSE", t.getMessage());
                        responseWeather = "";
                        //set error
                        Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
                        layParent.setVisibility(View.GONE);
                        layNoRecord.setVisibility(View.VISIBLE);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class SaveWeatherDetails extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {

            try {

                //creating a pojo
                WeatherDetailsEntity detailsEntity = new WeatherDetailsEntity();
                detailsEntity.setName(name);
                detailsEntity.setRegion(region);
                detailsEntity.setCountry(country);
                detailsEntity.setLat(lat);
                detailsEntity.setLon(lon);
                detailsEntity.setTz_id(tz_id);
                detailsEntity.setLocaltime_epoch(localtime_epoch);
                detailsEntity.setLocaltime(localtime);
                detailsEntity.setLast_updated_epoc(last_updated_epoch);
                detailsEntity.setLast_updated(last_updated);
                detailsEntity.setTemp_c(temp_c);
                detailsEntity.setTemp_f(temp_f);
                detailsEntity.setIs_day(is_day);
                detailsEntity.setText(text);
                detailsEntity.setIcon(icon);
                detailsEntity.setCode(code);
                detailsEntity.setWind_kph(wind_kph);
                detailsEntity.setWind_mph(wind_mph);
                detailsEntity.setWind_degree(wind_degree);
                detailsEntity.setWind_dir(wind_dir);
                detailsEntity.setPrecip_mm(precip_mm);
                detailsEntity.setPressure_in(pressure_in);
                detailsEntity.setPressure_mb(pressure_mb);
                detailsEntity.setPrecip_in(precip_in);
                detailsEntity.setHumidity(humidity);
                detailsEntity.setCloud(cloud);
                detailsEntity.setFeelslike_c(feelslike_c);
                detailsEntity.setFeelslike_f(feelslike_f);
                detailsEntity.setVis_km(vis_km);
                detailsEntity.setVis_miles(vis_miles);
                detailsEntity.setUv(uv);
                detailsEntity.setGust_kph(gust_kph);
                detailsEntity.setGust_mph(gust_mph);


                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .weatherDetailsDao()
                        .insert(detailsEntity);

            } catch (Exception e) {
                e.printStackTrace();
                //set error
                Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
                layParent.setVisibility(View.GONE);
                layNoRecord.setVisibility(View.VISIBLE);

            }
            return null;
        }
    }


    public class LoadWeatherData extends AsyncTask<String, String, String> {
        @Override
        protected void onPostExecute(String entityList) {
            super.onPostExecute(entityList);

            try {
                if (responseWeather == null || responseWeather.equals("[]") || responseWeather.length() == 0) {

                    //load the data from server
                    FetchDataFromServer();

                } else {


                    Log.d("LOAD_STORED", "" + responseWeather);

                    //parse the data from database

                    JSONArray resArray = new JSONArray(responseWeather);
                    JSONObject resObject = resArray.getJSONObject(0);

                    name = resObject.getString("name");
                    region = resObject.getString("region");
                    country = resObject.getString("country");
                    lat = resObject.getString("lat");
                    lon = resObject.getString("lon");
                    tz_id = resObject.getString("tz_id");
                    localtime_epoch = resObject.getString("localtime_epoch");
                    localtime = resObject.getString("localtime");
                    last_updated = resObject.getString("last_updated");
                    temp_c = resObject.getString("temp_c");
                    temp_f = resObject.getString("temp_f");
                    is_day = resObject.getString("is_day");
                    wind_mph = resObject.getString("wind_mph");
                    wind_kph = resObject.getString("wind_kph");
                    wind_degree = resObject.getString("wind_degree");
                    wind_dir = resObject.getString("wind_dir");
                    pressure_mb = resObject.getString("pressure_mb");
                    pressure_in = resObject.getString("pressure_in");
                    precip_mm = resObject.getString("precip_mm");
                    precip_in = resObject.getString("precip_in");
                    humidity = resObject.getString("humidity");
                    cloud = resObject.getString("cloud");
                    feelslike_c = resObject.getString("feelslike_c");
                    feelslike_f = resObject.getString("feelslike_f");
                    vis_km = resObject.getString("vis_km");
                    vis_miles = resObject.getString("vis_miles");
                    uv = resObject.getString("uv");
                    gust_mph = resObject.getString("gust_mph");
                    gust_kph = resObject.getString("gust_kph");
                    text = resObject.getString("text");
                    code = resObject.getString("code");
                    icon = resObject.getString("icon");


                    //set values to textview

                    //temperature
                    if (temp_c == null || temp_c.equals("") || temp_c.equals("null")) {
                        txtTemperature.setText("0 \u00B0 C");
                    } else {
                        txtTemperature.setText("" + temp_c + " \u00B0 C");
                    }

                    //cloud
                    if (cloud == null || cloud.equals("") || cloud.equals("null")) {
                        txtCloud.setText("0");
                    } else {
                        txtCloud.setText(cloud);
                    }

                    //humidity
                    if (humidity == null || humidity.equals("") || humidity.equals("null")) {
                        txtHumidity.setText("0 %");
                    } else {
                        txtHumidity.setText(humidity + " %");
                    }

                    //wind
                    if (wind_mph == null || wind_mph.equals("") || wind_mph.equals("null")) {
                        txtWind.setText("0 mph");
                    } else {
                        txtWind.setText(wind_mph + " mph");
                    }

                    //wind degree
                    if (wind_degree == null || wind_degree.equals("") || wind_degree.equals("null")) {
                        txtWindDegree.setText("0");
                    } else {
                        txtWindDegree.setText(wind_degree);
                    }

                    //wind direction
                    if (wind_dir == null || wind_dir.equals("") || wind_dir.equals("null")) {
                        txtWindDir.setText("-");
                    } else {
                        txtWindDir.setText(wind_dir);
                    }

                    //pressure
                    if (pressure_in == null || pressure_in.equals("") || pressure_in.equals("null")) {
                        txtPressure.setText(" 0 psi");
                    } else {
                        txtPressure.setText(  pressure_in + " psi");
                    }

                    //visibility
                    if (vis_miles == null || vis_miles.equals("") || vis_miles.equals("null")) {
                        txtVisibility.setText("Visibility: 0 mi");
                    } else {
                        txtVisibility.setText("Visibility: " + vis_miles + " mi");
                    }

                    //feels like
                    if (feelslike_c == null || feelslike_c.equals("") || feelslike_c.equals("null")) {
                        txtFeelsLike.setText("Feels Like: 0 \u00B0 C");
                    } else {
                        txtFeelsLike.setText("Feels Like: " + feelslike_c + " \u00B0 C");
                    }


                    //precip
                    if (precip_in == null || precip_in.equals("") || precip_in.equals("null")) {
                        txtPrecip.setText("Precip: 0 in");
                    } else {
                        txtPrecip.setText("Precip: " + precip_in + " in");
                    }

                    //city
                    if (localtime == null || localtime.equals("") || localtime.equals("null")) {
                        txtCity.setText("Pune , DateTime -");
                    } else {
                        txtCity.setText("Pune , " + localtime);
                    }

                    //uv index
                    if (uv == null || uv.equals("") || uv.equals("null")) {
                        txtUvIndex.setText("UV Index: 0 ");
                    } else {
                        txtUvIndex.setText("UV Index: " + uv);
                    }

                    //gust
                    if (gust_mph == null || gust_mph.equals("") || gust_mph.equals("null")) {
                        txtGust.setText("Gust: 0 mPh");
                    } else {
                        txtGust.setText("Gust: " + gust_mph + " mPh");
                    }


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                //fetch the data from database
                responseWeather = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .weatherDetailsDao()
                        .getAll().toString();

                return responseWeather;

            } catch (Exception e) {
                e.printStackTrace();
                //set error
                Toast.makeText(context, "Sorry unable to load weather details!", Toast.LENGTH_SHORT).show();
                layParent.setVisibility(View.GONE);
                layNoRecord.setVisibility(View.VISIBLE);

            }
            return null;
        }
    }

}
