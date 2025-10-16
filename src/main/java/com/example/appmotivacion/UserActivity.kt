package com.example.appmotivacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var buttonSalvar = findViewById<Button>(R.id.button_salvar)

        buttonSalvar.setOnClickListener{
            var nomeText = findViewById<EditText>(R.id.edit_text_nome).text
            if(nomeText.isEmpty()){
            Toast.makeText(this,"Digite o seu nome",Toast.LENGTH_LONG).show()
        }else{
            this.getSharedPreferences("Motivacao", MODE_PRIVATE).edit().putString("nome", nomeText.toString()).apply()
            var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}