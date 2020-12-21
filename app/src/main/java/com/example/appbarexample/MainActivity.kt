package com.example.appbarexample
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myToolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(myToolbar)

        // TextView für das Context Menu registrieren
        val textview = findViewById<TextView>(R.id.textView)
        registerForContextMenu(textview)

        /*
        // LongClickListener ersetzen
        textview.setOnLongClickListener  {
            openContextMenu(textview)
            true
        }*/

    }

    // Floating Context Menu
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Farbe auswählen")
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.op_green -> {
                changeColor(Color.GREEN)
                true
            }
            R.id.op_red -> {
                changeColor(Color.RED)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }




    private fun changeColor(color: Int){
        val text = findViewById<TextView>(R.id.textView)
        text.setTextColor(color)
    }





    //Options Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.op_1 -> {
                showOption("Hallo")
                true
            }
            R.id.op_2 -> {
                showOption( "Tschüss")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




    private fun showOption(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }





}