package com.example.dialog

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        btn1.setOnClickListener{
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setCancelable(false)
            alertDialog.setTitle("Hello")
                .setIcon(R.drawable.ic_baseline_accessibility_24)
                .setMessage("How are you?")
                .setPositiveButton("Fine") { dialog, _ ->
                    dialog.dismiss()
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Not fine") { dialog, _ ->
                    dialog.dismiss()
                    Toast.makeText(this, "Everything will be fine", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }

        btn2.setOnClickListener{
            val customDialog = Dialog(this)
            customDialog.setCancelable(false)
            customDialog.setContentView(R.layout.custom_dialog)
            val btnDone = customDialog.findViewById<Button>(R.id.btnDone)
            btnDone.setOnClickListener{
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                customDialog.dismiss()
            }
            customDialog.show()
        }

        btn3.setOnClickListener{
            val snack = Snackbar.make(it,"This is a simple SnackBar",Snackbar.LENGTH_LONG)
            snack.view.setBackgroundColor(Color.WHITE)
            snack.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).setTextColor(Color.BLUE)
            snack.setAction("DISMISS") { }
            snack.setActionTextColor(Color.RED)
            snack.show()
        }

        btn4.setOnClickListener{
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
        }

    }

    override fun onBackPressed() {

        val exitDialog = AlertDialog.Builder(this)
        exitDialog.setCancelable(false)
        exitDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            .setTitle("Exit")
            .setMessage("Do you really want to exit?")
            .setPositiveButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Yes") { dialog , _ ->
                Toast.makeText(this, "Meet you soon", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                super.onBackPressed()
            }
            .create()
            .show()
    }

}