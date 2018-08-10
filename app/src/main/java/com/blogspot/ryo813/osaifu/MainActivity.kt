package com.blogspot.ryo813.osaifu

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FuelManager.instance.baseHeaders = mapOf("Content-Type" to "text/plain")

        val UnLock = findViewById(R.id.button) as Button
        val Lock = findViewById(R.id.button2) as Button

        val seikatusiyou = findViewById<View>(R.id.textView6) as TextView
        val gorakusiyou = findViewById<View>(R.id.textView15) as TextView

        val seikatuzumi = findViewById<View>(R.id.textView8) as TextView
        val seikatukore = findViewById<View>(R.id.textView11) as TextView

        val gorakuzumi = findViewById<View>(R.id.textView17) as TextView
        val gorakukore = findViewById<View>(R.id.textView16) as TextView


        var selectedId = 0

        val dialogMenu = arrayOf<String>("5", "10", "15", "20", "25", "30", "35")


        my_swipeRefresh_Layout.setOnRefreshListener {

            Fuel.get("http://192.168.1.1/k").response { request, response, result ->
                println(request)
                println(response)
                seikatuzumi.setText(String(response.data))

                val (bytes, error) = result
                if (bytes != null) {
                    println(bytes)
                }
            }

            Fuel.get("http://192.168.1.1/l").response { request, response, result ->
                println(request)
                println(response)
                seikatukore.setText(String(response.data))

                val (bytes, error) = result
                if (bytes != null) {
                    println(bytes)
                }
            }

            Fuel.get("http://192.168.1.1/sk").response { request, response, result ->
                println(request)
                println(response)
                gorakuzumi.setText(String(response.data))

                val (bytes, error) = result
                if (bytes != null) {
                    println(bytes)
                }
            }

            Fuel.get("http://192.168.1.1/sl").response { request, response, result ->
                println(request)
                println(response)
                gorakukore.setText(String(response.data))

                val (bytes, error) = result
                if (bytes != null) {
                    println(bytes)
                }
            }
            my_swipeRefresh_Layout.setRefreshing(false);
        }


        UnLock.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("お財布を開ける回数を変更")
                setSingleChoiceItems(dialogMenu, 0, { _, i ->
                    selectedId = i
                })
                setPositiveButton("OK", { _, _ ->
                    Toast.makeText(applicationContext, "使用回数を変更しました", Toast.LENGTH_LONG).show()
                    when (selectedId) {
                        0 -> {
                            Fuel.get("http://192.168.1.1/a").response { request, response, result -> }
                            seikatusiyou.setText("5"); }
                        1 -> {
                            Fuel.get("http://192.168.1.1/b").response { request, response, result -> }
                            seikatusiyou.setText("10"); }
                        2 -> {
                            Fuel.get("http://192.168.1.1/c").response { request, response, result -> }
                            seikatusiyou.setText("15"); }
                        3 -> {
                            Fuel.get("http://192.168.1.1/d").response { request, response, result -> }
                            seikatusiyou.setText("20"); }
                        4 -> {
                            Fuel.get("http://192.168.1.1/e").response { request, response, result -> }
                            seikatusiyou.setText("25"); }
                        5 -> {
                            Fuel.get("http://192.168.1.1/f").response { request, response, result -> }
                            seikatusiyou.setText("30"); }
                        6 -> {
                            Fuel.get("http://192.168.1.1/g").response { request, response, result -> }
                            seikatusiyou.setText("35"); }
                    }
                })

                setNegativeButton("Cancel", null)
                show()

            }
        }


        Lock.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("お財布を開ける回数を変更")
                setSingleChoiceItems(dialogMenu, 0, { _, i ->
                    selectedId = i
                })
                setPositiveButton("OK", { _, _ ->
                    Toast.makeText(applicationContext, "使用回数を変更しました", Toast.LENGTH_LONG).show()
                    when (selectedId) {
                        0 -> {
                            Fuel.get("http://192.168.1.1/sa").response { request, response, result -> }
                            gorakusiyou.setText("5"); }
                        1 -> {
                            Fuel.get("http://192.168.1.1/sb").response { request, response, result -> }
                            gorakusiyou.setText("10"); }
                        2 -> {
                            Fuel.get("http://192.168.1.1/sc").response { request, response, result -> }
                            gorakusiyou.setText("15"); }
                        3 -> {
                            Fuel.get("http://192.168.1.1/sd").response { request, response, result -> }
                            gorakusiyou.setText("20"); }
                        4 -> {
                            Fuel.get("http://192.168.1.1/se").response { request, response, result -> }
                            gorakusiyou.setText("25"); }
                        5 -> {
                            Fuel.get("http://192.168.1.1/sf").response { request, response, result -> }
                            gorakusiyou.setText("30"); }
                        6 -> {
                            Fuel.get("http://192.168.1.1/sg").response { request, response, result -> }
                            gorakusiyou.setText("35"); }
                    }
                })

                setNegativeButton("Cancel", null)
                show()

            }
        }

    }

}