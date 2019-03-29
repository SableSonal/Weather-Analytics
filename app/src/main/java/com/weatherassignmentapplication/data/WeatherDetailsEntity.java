package com.weatherassignmentapplication.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class WeatherDetailsEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "precip_in")
    private String precip_in ;

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    @ColumnInfo(name = "feelslike_c")
    private String feelslike_c ;

    @ColumnInfo(name = "feelslike_f")
    private String feelslike_f ;

    @ColumnInfo(name = "cloud")
    private String cloud ;

    @ColumnInfo(name = "vis_km")
    private String vis_km ;

    @ColumnInfo(name = "uv")
    private String uv ;

    @ColumnInfo(name = "vis_miles")
    private String vis_miles ;

    @ColumnInfo(name = "gust_mph")
    private String gust_mph ;

    public String getVis_km() {
        return vis_km;
    }

    public void setVis_km(String vis_km) {
        this.vis_km = vis_km;
    }

    public String getVis_miles() {
        return vis_miles;
    }

    public void setVis_miles(String vis_miles) {
        this.vis_miles = vis_miles;
    }

    @ColumnInfo(name = "gust_kph")
    private String gust_kph ;






    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public String getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(String feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public String getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(String precip_in) {
        this.precip_in = precip_in;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @ColumnInfo(name = "humidity")
    private String humidity ;

    @ColumnInfo(name = "name")
    private String name ;

    @ColumnInfo(name = "region")
    private String region;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "lat")
    private String lat;

    @ColumnInfo(name = "lon")
    private String lon;

    @ColumnInfo(name = "tz_id")
    private String tz_id;

    @ColumnInfo(name = "localtime_epoch")
    private String localtime_epoch;

    @ColumnInfo(name = "localtime")
    private String localtime;

    @ColumnInfo(name = "last_updated_epoc")
    private String last_updated_epoc;

    @ColumnInfo(name = "last_updated")
    private String last_updated;

    @ColumnInfo(name = "temp_c")
    private String temp_c;

    @ColumnInfo(name = "temp_f")
    private String temp_f;

    @ColumnInfo(name = "is_day")
    private String is_day;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "icon")
    private String icon;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "wind_mph")
    private String wind_mph;

    @ColumnInfo(name = "wind_kph")
    private String wind_kph ;

    @ColumnInfo(name = "wind_degree")
    private String wind_degree;

    @ColumnInfo(name = "wind_dir")
    private String wind_dir;

    @ColumnInfo(name = "pressure_mb")
    private String pressure_mb;

    @ColumnInfo(name = "pressure_in")
    private String pressure_in;

    @ColumnInfo(name = "precip_mm")
    private String precip_mm;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", precip_in:'" + precip_in + '\'' +
                ", feelslike_c:'" + feelslike_c + '\'' +
                ", feelslike_f:'" + feelslike_f + '\'' +
                ", cloud:'" + cloud + '\'' +
                ", vis_km='" + vis_km + '\'' +
                ", uv:'" + uv + '\'' +
                ", gust_mph:'" + gust_mph + '\'' +
                ", gust_kph:'" + gust_kph + '\'' +
                ", humidity:'" + humidity + '\'' +
                ", name:'" + name + '\'' +
                ", region:'" + region + '\'' +
                ", country:'" + country + '\'' +
                ", lat:'" + lat + '\'' +
                ", lon:'" + lon + '\'' +
                ", tz_id:'" + tz_id + '\'' +
                ", localtime_epoch:'" + localtime_epoch + '\'' +
                ", localtime:'" + localtime + '\'' +
                ", last_updated_epoc:'" + last_updated_epoc + '\'' +
                ", last_updated:'" + last_updated + '\'' +
                ", temp_c:'" + temp_c + '\'' +
                ", temp_f:'" + temp_f + '\'' +
                ", is_day:'" + is_day + '\'' +
                ", text:'" + text + '\'' +
                ", icon:'" + icon + '\'' +
                ", code:'" + code + '\'' +
                ", wind_mph:'" + wind_mph + '\'' +
                ", wind_kph:'" + wind_kph + '\'' +
                ", wind_degree:'" + wind_degree + '\'' +
                ", wind_dir:'" + wind_dir + '\'' +
                ", pressure_mb:'" + pressure_mb + '\'' +
                ", pressure_in:'" + pressure_in + '\'' +
                ", precip_mm:'" + precip_mm + '\'' +
                ", vis_miles:'" + vis_miles + '\'' +
                '}';
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public String getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(String localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getLast_updated_epoc() {
        return last_updated_epoc;
    }

    public void setLast_updated_epoc(String last_updated_epoc) {
        this.last_updated_epoc = last_updated_epoc;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(String temp_f) {
        this.temp_f = temp_f;
    }

    public String getIs_day() {
        return is_day;
    }

    public void setIs_day(String is_day) {
        this.is_day = is_day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(String wind_mph) {
        this.wind_mph = wind_mph;
    }

    public String getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(String wind_kph) {
        this.wind_kph = wind_kph;
    }

    public String getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(String wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(String pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public String getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(String pressure_in) {
        this.pressure_in = pressure_in;
    }

    public String getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(String precip_mm) {
        this.precip_mm = precip_mm;
    }



    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getGust_mph() {
        return gust_mph;
    }

    public void setGust_mph(String gust_mph) {
        this.gust_mph = gust_mph;
    }

    public String getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(String gust_kph) {
        this.gust_kph = gust_kph;
    }
}
