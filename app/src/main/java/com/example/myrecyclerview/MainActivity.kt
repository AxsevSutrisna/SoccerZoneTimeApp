package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rvPlayer: RecyclerView
    private val list = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvPlayer = findViewById(R.id.rv_player)
        rvPlayer.setHasFixedSize(true)

        list.addAll(getListPlayer())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.apk_info -> {
                val intent = Intent(this@MainActivity, DetailInfo::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private fun getListPlayer(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.data_player)
        val dataFullName = resources.getStringArray(R.array.data_player_full_name)
        val dataNationality: Array<String> = resources.getStringArray(R.array.player_nationality)
        val dataClub = resources.getStringArray(R.array.player_fc)
        val dataHeight = resources.getStringArray(R.array.data_player_height)
        val dataWeight = resources.getStringArray(R.array.data_player_weight)
        val dataDesc = resources.getStringArray(R.array.data_deskripsi_player)
        val dataFlag = resources.obtainTypedArray(R.array.flags)
        val dataClubFLag = resources.obtainTypedArray(R.array.clubs)
        val dataPhoto = resources.obtainTypedArray(R.array.player_photo)
        val listPlayer = ArrayList<Player>()
        for (i in dataName.indices) {
            val player = Player(
                dataName[i],
                dataFullName[i],
                dataNationality[i],
                dataClub[i],
                dataHeight[i],
                dataWeight[i],
                dataDesc[i],
                dataFlag.getResourceId(i, -1),
                dataClubFLag.getResourceId(i, -1),
                dataPhoto.getResourceId(i, -1)
            )
            listPlayer.add(player)
        }
        return listPlayer
    }

    private fun showRecyclerList() {
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter
    }


}