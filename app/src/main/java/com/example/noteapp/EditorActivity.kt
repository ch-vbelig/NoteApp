package com.example.noteapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_editor.*

class EditorActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_editor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save -> {
                val title: String = edt_title.text.toString()
                val note: String = edt_note.text.toString()
                val color: Int = -2184710

                if(title.isEmpty()){
                    edt_title.error = "Please, enter a title"
                } else if (note.isEmpty()){
                    edt_note.error = "Please, enter a note"
                } else {
                    saveNote(title, note, color)
                }

                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }

    }

    private fun saveNote(title: String, note: String, color: Int) {
        progressDialog.show()
        val noteObject = Note(title, note, color)

    }


}