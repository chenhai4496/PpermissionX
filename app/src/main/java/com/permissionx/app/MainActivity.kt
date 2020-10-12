package com.permissionx.app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.chenhaidev.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCallBtn.setOnClickListener {
            PermissionX.request(this,
                android.Manifest.permission.CALL_PHONE){
                allGranted, deniedList ->

                if(allGranted){
                    call()
                }else{
                    Toast.makeText(this, "您决绝了${deniedList} 的权限", Toast.LENGTH_LONG).show()
                }

            }
        }


    }



    @SuppressLint("MissingPermission")
    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)

        }catch (e : Exception){
            e.printStackTrace()
        }
    }



}
