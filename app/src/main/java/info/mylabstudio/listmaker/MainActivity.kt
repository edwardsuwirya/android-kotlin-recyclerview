package info.mylabstudio.listmaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import info.mylabstudio.listmaker.commonutils.hideKeyboard
import info.mylabstudio.listmaker.datamanagers.ArrayListDataManager
import info.mylabstudio.listmaker.datamanagers.ListDataManager
import info.mylabstudio.listmaker.models.Language
import info.mylabstudio.listmaker.viewadapters.ListSelectionRecyclerViewAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var listsRecyclerView: RecyclerView
    private lateinit var languageEditText: EditText
    private lateinit var addLanguageButton: Button

    private lateinit var listDataManager: ListDataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        listDataManager =
            ArrayListDataManager()
        listsRecyclerView = findViewById(R.id.lists_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter =
            ListSelectionRecyclerViewAdapter(
                listDataManager.readList()
            )
        listsRecyclerView.adapter = adapter

        languageEditText = findViewById(R.id.language_edit_text)
        addLanguageButton = findViewById(R.id.add_language_button)
        addLanguageButton.setOnClickListener {
            val newLanguage = languageEditText.text.toString()
            if (newLanguage.length > 0) {
                listDataManager.saveList(
                    Language(
                        newLanguage
                    )
                )
                languageEditText.setText("")
                adapter.notifyDataSetChanged()
                hideKeyboard()
            } else {
                Toast.makeText(
                    this, getString(R.string.empty_name_message),
                    Toast.LENGTH_LONG
                ).show()
            }

        }
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
