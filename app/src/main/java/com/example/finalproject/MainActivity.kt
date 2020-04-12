package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.Helper.doAsync
import com.example.finalproject.database.User
import com.example.finalproject.database.UserDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    /*
        btnCrearCuenta.setOnClickListener {
            //Insert

            val objUser = User(userName = "Eddieware",phoneUser = "4622494244", userEmail = "eddieware@gmail",userPass = "1234",userUpdateAt = Date())

            doAsync{
               UserDatabase.getInstance(this)!!.userDao().insertUser(objUser)// contexto se refiere a actividad o clase local
            }.execute()
            Toast.makeText(this,"Usuario insertado",Toast.LENGTH_LONG).show()

            //update

            doAsync{
                //linea para no tener el adapter
                // y este objeto cargarlo al formulario

                val objUserUp= UserDatabase.getInstance(this)!!.userDao().getUserById(1)// contexto se refiere a actividad o clase local
                UserDatabase.getInstance(this)!!.userDao().updateUser(objUserUp)
            }.execute()

        } */

    }


}



