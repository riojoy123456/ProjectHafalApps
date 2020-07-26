package com.example.hafalapps.notifications;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAbmPD-n4:APA91bG6v5ymGw9uJyNFx-L26VjAPRpOnpKT2eB6cZz2ar64hSKJDcHsO4XQnbOocg3pCt5HT1WvfTLyzi-ZG_pSrz2H1im75hwjlSJtisF1juv-8z9G3eod11x5dunqOG34S2MI7sB3"
    })

    @POST("fcm/send")
    Call<Response> sendNotification(@Body Sender body);
}
