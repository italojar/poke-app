package website.italojar.pokeapi.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constatnts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}