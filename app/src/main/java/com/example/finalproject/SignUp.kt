package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.Helper.doAsync
import com.example.finalproject.database.User
import com.example.finalproject.database.UserDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        /*

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btnFecha.setOnClickListener{
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener{
                        view: DatePicker, mYear: Int, mMonth: Int, mDay: Int -> txtFecha.setText("" + mDay + "/" + (mMonth+1) + "/" + mYear)
                },
                year,
                month,
                day
            )

            dpd.show()
        }*/

        // Insertamos el usuario a la base de datos
        btnCrearCuenta.setOnClickListener{
            val userName = edtNombre.text.toString()
            val phoneUser = edtTelefono.text.toString()
            val emailUser = edtCorreo.text.toString()
            val passUser = edtContrasena.text.toString()
            val objUser = User(userName = userName,phoneUser = phoneUser, userEmail =  emailUser, userPass = passUser,userUpdateAt = Date())
            doAsync{
                UserDatabase.getInstance(this)!!.userDao().insertUser(objUser)
                //finish()
            }.execute()
            Toast.makeText(this,"Se registró el usuario", Toast.LENGTH_LONG).show()
        }

        btnCrearCuenta.setOnClickListener{
            val intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }
    }




    }

