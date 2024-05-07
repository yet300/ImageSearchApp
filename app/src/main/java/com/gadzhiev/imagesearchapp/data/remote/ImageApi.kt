package com.gadzhiev.imagesearchapp.data.remote

import com.gadzhiev.imagesearchapp.data.remote.model.ImageDto
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * [Documentation api](https://serper.dev/playground)
 */
interface ImageApi {
    @POST("./images")
    suspend fun searchImages(
        @Query("q") query: String? = "Images",
        @Query("num") number: Int = 10,
        @Query("page") page: Int = 1
    ): ImageDto
}

fun ImageApi(
    baseUrl: String,
    apiKey: String
): ImageApi {

    // создаём клиент с интерсептором, добавляющим заголовок для передачи ключа
    val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request =
            chain.request().newBuilder()
                .addHeader("X-API-KEY", apiKey)
                .addHeader("Content-Type", "application/json")
                .build()
        chain.proceed(request)
    }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ImageApi::class.java)
}
