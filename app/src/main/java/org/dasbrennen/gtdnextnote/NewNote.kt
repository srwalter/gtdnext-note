package org.dasbrennen.gtdnextnote

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.actions.NoteIntents

import kotlinx.android.synthetic.main.activity_new_note.*

class NewNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        var intent = getIntent();
        var subject = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (subject != "") {
            val prefs = getSharedPreferences("gtdnext", Context.MODE_PRIVATE)
            var email = prefs.getString("email","foo")
            if (email != "foo") {
                var mail_intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
                        .putExtra(Intent.EXTRA_SUBJECT, subject)
                try {
                    startActivityForResult(Intent.createChooser(mail_intent, "Send mail"), 0)
                } catch (ex: android.content.ActivityNotFoundException) {
                    Toast.makeText(this, "No mail clients available", Toast.LENGTH_LONG)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        finish()
    }
}
