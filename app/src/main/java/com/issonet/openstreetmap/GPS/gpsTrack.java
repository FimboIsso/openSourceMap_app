package com.issonet.openstreetmap.GPS;



import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

/**
 * Created by IssoNet on 2/12/2018.
 */

public class gpsTrack implements LocationListener {

    Context context;

    public gpsTrack(Context context){
        this.context = context;
    }

    //la geolocation dans jaujja
    public Location getLocation(){

        // verification de la permission dans le manifest
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context,"PERMISION NOT GRANTED", Toast.LENGTH_LONG).show();
            return null;
        }

        //jrusuofi
        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        // verification si le le gps est activer
        boolean isGPSenable = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSenable){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,1 ,this);
            //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minimum temps de mise en jour en miliseconde 1000,10 minimun distance en mettre,this);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            //Toast.makeText(context,location.getLatitude()+"",Toast.LENGTH_LONG).show();
//            new enregistrementPosition(new mouvementPositions(0,currentUsers.getCurrentUsersTaximent(context).getCode(),
//                    String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()),"--")).execute();
            return location;
        }else {
            Toast.makeText(context,"Veuillez activer votre GPS", Toast.LENGTH_LONG).show();
        }
        return null;
    }


    @Override
    public void onLocationChanged(Location location) {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                // Actions to do after 10 seconds
//                if(currentUsers.getIsTaximen(context)){
//                    new enregistrementPosition(new mouvementPositions(0,currentUsers.getCurrentUsersTaximent(context).getCode(),
//                            String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()),"--")).execute();
//                }
//
//            }
//        }, 10000);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


//    private class enregistrementPosition extends AsyncTask<String,Void,String>{
////        mouvementPositions mouvementPositionsObject;
////
////        public enregistrementPosition(mouvementPositions mouvementPositionsObject) {
////            this.mouvementPositionsObject = mouvementPositionsObject;
////        }
////
////        @Override
////        protected String doInBackground(String... strings) {
////            return mouvementPositions.save(context,mouvementPositionsObject);
////        }
//    }
}
