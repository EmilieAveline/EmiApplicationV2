package com.emilie.emisapplication.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.emilie.emisapplication.R
import com.emilie.emisapplication.ui.scan.ScanActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monBoutonStart = findViewById<Button>(R.id.buttonStart).setOnClickListener{
           /* MaterialDialog(this).show {
                title(text = "Entrée dans le gang : ")
                message(text = "(Auncun retour en arrière possible)")

                positiveButton(text = "Ouiii") { dialog ->
                    // Do something
                }
                negativeButton(text = "Une autre fois peut-être") { dialog ->
                    // Do something
                }*/
            MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.title))
                .setMessage(resources.getString(R.string.supporting_text))
                .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                    // Respond to neutral button press
                }
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    startActivity(
                        ScanActivity.getStartIntent(this,
                        getString(R.string.c_est_parti)));// Respond to positive button press
                }
                .show()
            }

            /* Snackbar.make(findViewById(android.R.id.content),"blabla", Snackbar.LENGTH_SHORT).setAction("Action"){
                Toast.makeText(this,"Let's Goooo",Toast.LENGTH_SHORT)
            }.show() */

        }


    }


