package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.Helper.DoAsync
import com.example.finalproject.database.ConnectDatabase
import com.example.finalproject.database.User
import kotlinx.android.synthetic.main.register_activity.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view)



        btnregister.setOnClickListener {
            //Insert

            val objUser = User(userName = "Eddieware",phoneUser = "4622494244", userEmail = "eddieware@gmail",userPass = "1234",userUpdateAt = Date())

            DoAsync{
                ConnectDatabase.getInstance(this)!!.userDAO().insertUser(objUser)// contexto se refiere a actividad o clase local
            }.execute()
            Toast.makeText(this,"Usuario insertado",Toast.LENGTH_LONG).show()

            //update

            DoAsync{
                //linea para no tener el adapter
                // y este objeto cargarlo al formulario

                val objUserUp= ConnectDatabase.getInstance(this)!!.userDAO().getUserById(1)// contexto se refiere a actividad o clase local
                ConnectDatabase.getInstance(this)!!.userDAO().updateUser(objUserUp)
            }.execute()

        }

    }


}



