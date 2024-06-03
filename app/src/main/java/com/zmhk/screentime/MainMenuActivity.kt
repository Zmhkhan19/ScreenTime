package com.zmhk.screentime

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainMenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val dateTv = findViewById<TextView>(R.id.edtDate);
        val amTimeTv = findViewById<TextView>(R.id.txtTimeAm);
        val pmTimeTv = findViewById<TextView>(R.id.txtTimePm);
        val actNotesTv = findViewById<TextView>(R.id.txtNotes);

        // Initialize them
        var i: Int = 0 //Stores number of entries in array
        var display: String = "" // Display blank first
        val maxEntries = 7 // Only allow 7 array entries

        // Create arrays
        val day = Array(maxEntries) { "" }
        val morningTime = Array(maxEntries) { 0 }
        val afternoonTime = Array(maxEntries) { 0 }
        val actNotes = Array(maxEntries) { "" }

        val btnInsert: Button = findViewById<Button>(R.id.btnInsert)
        val btnDetails: Button = findViewById<Button>(R.id.btnDetails)
        val btnClear: Button = findViewById<Button>(R.id.btnClear)

        btnInsert.setOnClickListener {
            // Check if there's enough entries
            if (i < maxEntries) {
                // Convert toi display types
                day[i] = dateTv.text.toString()
                morningTime[i] =
                    amTimeTv.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                afternoonTime[i] =
                pmTimeTv.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                actNotes[i] = actNotesTv.text.toString()
                i++ // Increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
            }   else {
                    Toast.makeText(this, "Maximum entries reached", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear the text viewa
        btnClear.setOnClickListener {
            dateTv.text = ""
            amTimeTv.text = ""
            pmTimeTv.text = ""
            actNotesTv.text = ""
        }

        //Button to navigate to Details View
        btnDetails.setOnClickListener {
            display = ""

            for (counter in 0 until i) {
                display += "Date: ${day[counter]}\nAM Time: ${morningTime[counter]}\nPM Time: ${afternoonTime[counter]}\nNotes: ${actNotes[counter]}\n\n"
            }

            //Pass the data to DetailViewsActivity and start the activity
            val intent = Intent(this, DetailViewsActivity::class.java)
            intent.putExtra("DISPLAY_DATA", display)
            startActivity(intent)
        }

      //  btnClear.setOnClickListener {
       //     dateTv.text = null;
      //      amTimeTv.text = null;
      //      pmTimeTv.text = null;
       //     actNotesTv.text = null;
       // }

    }
}