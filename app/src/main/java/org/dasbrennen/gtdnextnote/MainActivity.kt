package org.dasbrennen.gtdnextnote

import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.actions.NoteIntents

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = getSharedPreferences("gtdnext", Context.MODE_PRIVATE)
        val email = findViewById<TextView>(R.id.editText)
        email.setText(prefs.getString("email","foo"))
    }

    fun saveEmail(view: View) {
        val prefs = getSharedPreferences("gtdnext", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val email = findViewById<TextView>(R.id.editText).getText().toString()
        editor.putString("email", email)
        editor.apply()
        //
    }
}
