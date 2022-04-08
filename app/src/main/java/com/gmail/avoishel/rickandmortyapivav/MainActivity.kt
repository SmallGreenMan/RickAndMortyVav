package com.gmail.avoishel.rickandmortyapivav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.gmail.avoishel.rickandmortyapivav.DataClasses.GetCharacterByIdResponse
import com.squareup.picasso.Picasso
import retrofit2.*
import com.gmail.avoishel.rickandmortyapivav.NetworkLayer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val headerImageView = findViewById<ImageView>(R.id.headerImageView)
        val genderImageView = findViewById<ImageView>(R.id.genderImageView)
        val aliveTextView = findViewById<TextView>(R.id.aliveTextView)
        val originTextView = findViewById<TextView>(R.id.originTextView)
        val speciesTextView = findViewById<TextView>(R.id.speciesTextView)


        NetworkLayer.apiClient.getCharacterById(54)

        rickAppCompatActivity.getCharacterById(3).enqueue(object : Callback<GetCharacterByIdResponse> {
            override fun onResponse(call: Call<GetCharacterByIdResponse>, response: Response<GetCharacterByIdResponse>) {
                Log.i("MainActivity", response.toString())

                if (!response.isSuccessful){
                    Toast.makeText(this@MainActivity, "Unsuccessful network call", Toast.LENGTH_SHORT).show()
                    return
                }

                val body = response.body()!!

                nameTextView.text = body.name
                aliveTextView.text = body.status
                speciesTextView.text = body.species
                originTextView.text = body.origin.name

                if (body.gender.equals("male", true)){
                    genderImageView.setImageResource(R.drawable.ic_male_24)
                } else {
                    genderImageView.setImageResource(R.drawable.ic_female_24)
                }

                Picasso
                    .get()
                    .load(body.image)
                    .into(headerImageView);
            }

            override fun onFailure(call: Call<GetCharacterByIdResponse>, t: Throwable) {
                Log.i("MainActivity", t.message ?: "Null message")
            }

        })
    }
}