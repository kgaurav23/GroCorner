package `in`.grocorner.model.network.api

import `in`.grocorner.model.network.UrlConstants.Companion.BASE_URL
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkProvider {

    fun getApiService(context: Context): Service {
        val retrofit = getRetrofit(context)
        return retrofit.create(Service::class.java)
    }

    private fun getOkHttpBuilder(context: Context): OkHttpClient.Builder {
        val builder = with(OkHttpClient.Builder()) {
            connectTimeout(1, TimeUnit.MINUTES)
            writeTimeout(1, TimeUnit.MINUTES)
            readTimeout(1, TimeUnit.MINUTES)
            followRedirects(true)
            followSslRedirects(true)
        }
        for (interceptor in getInterceptors(context)) {
            builder.addInterceptor(interceptor)
        }
        for (interceptor in getNetworkInterceptors()) {
            builder.addNetworkInterceptor(interceptor)
        }
        return builder
    }

    private fun getOkHttpClient(context: Context): OkHttpClient {
        val okHttpBuilder = getOkHttpBuilder(context)
        return okHttpBuilder.build()
    }

    private fun getRetrofit(context: Context): Retrofit {
        val okHttpClient = getOkHttpClient(context)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private fun getInterceptors(context: Context) : List<Interceptor> {
        return listOf(
            ChuckerInterceptor(context),
            HttpLoggingInterceptor()
        )
    }

    private fun getNetworkInterceptors() : List<Interceptor> {
        return listOf()
    }

}