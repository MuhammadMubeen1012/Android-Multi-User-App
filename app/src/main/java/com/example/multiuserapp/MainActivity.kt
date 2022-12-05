package com.example.multiuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var nameET : EditText
    lateinit var passwordET : EditText
    lateinit var roleSpinner : Spinner
    lateinit var loginBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.nameET)
        passwordET = findViewById(R.id.passwordET)
        roleSpinner = findViewById(R.id.roleSpinner)
        loginBTN = findViewById(R.id.loginBTN)

        val arrayAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.userRole,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        roleSpinner.adapter = arrayAdapter

        loginBTN.setOnClickListener{
            val selectedItem: String = roleSpinner.selectedItem.toString()
            if(
                selectedItem.equals("admin") && nameET.text.toString().equals("admin")
                && passwordET.text.toString().equals("admin123")
            ){
                val intent: Intent = Intent(this,AdminDashboard::class.java)
                startActivity(intent)
            } else if(
                selectedItem.equals("salesman") && nameET.text.toString().equals("salesman")
                && passwordET.text.toString().equals("salesman123")
        ){
            val intent: Intent = Intent(this,SalemanDashboard::class.java)
            startActivity(intent)
        } else if(
                selectedItem.equals("operator") && nameET.text.toString().equals("operator")
                && passwordET.text.toString().equals("operator123")
            ){
                val intent: Intent = Intent(this,OperatorsDashboard::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Incorrect Credientials" , Toast.LENGTH_LONG).show()
            }

        }
    }
}