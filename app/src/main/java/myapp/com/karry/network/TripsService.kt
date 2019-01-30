package myapp.com.karry.network

import android.util.Log
import myapp.com.karry.modules.ApiManager
import okhttp3.*
import java.io.IOException

class TripsService {

    companion object {
        fun create(tripJson: String, success: (response: Response) -> Unit, failure: () -> Unit) {
            val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), tripJson)
            val request = okhttp3.Request.Builder().url(ApiManager.URL.TRIP_CREATE).post(body).build()
            Log.d("JSON", tripJson)
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    if (response.code() == 200) {
                        success(response)
                    } else {
                        failure()
                    }
                }
                override fun onFailure(call: Call, e: IOException) {
                    failure()
                }
            })
        }

        fun searchByCity(city: String, success: (response: Response) -> Unit, failure: () -> Unit) {
            val request = okhttp3.Request.Builder().url(ApiManager.URL.TRIP_SEARCH + "?destinationCity=$city").build()

            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    if (response.code() == 200) {
                        success(response)
                    } else {
                        failure()
                    }
                }
                override fun onFailure(call: Call, e: IOException) {
                    failure()
                }
            })

        }
    }


}