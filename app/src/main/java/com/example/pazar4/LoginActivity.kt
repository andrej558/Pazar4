package com.example.pazar4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.facebook.*
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.common.graph.Graph
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private val mauth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var callbackManager:CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login_button : Button = findViewById(R.id.login_button)
        login_button.setOnClickListener {
            LoginManager.getInstance()
                .logInWithReadPermissions(this, listOf("public_profile", "email"))
        }

        val login2 : Button = findViewById(R.id.btn2)
        login2.setOnClickListener{
            if (isLoggedIn()){
                openDetailsActivity()
            }
            else{
                val intent = Intent(this,MainActivity :: class.java)
                startActivity(intent)
            }
        }

        val btnLogOut : Button = findViewById(R.id.btnLogout)
        btnLogOut.setOnClickListener{
            logOutUser()
        }

        callbackManager = CallbackManager.Factory.create();
        super.onStart()

        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

            override fun onCancel() {
                Toast.makeText(this@LoginActivity,"Login Cancelled", Toast.LENGTH_LONG).show()
            }

            override fun onError(exception: FacebookException) {
                Toast.makeText(this@LoginActivity,exception.message, Toast.LENGTH_LONG).show()
            }

            override fun onSuccess(result: LoginResult) {
                getUserProfile(result?.accessToken, result?.accessToken?.userId)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    var id = ""
    var firstName = ""



    fun logOutUser() {
        LoginManager.getInstance().logOut()
    }

    fun isLoggedIn(): Boolean {
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        return isLoggedIn
    }

    private fun getUserProfile(accessToken: AccessToken?, userId: String?) {
                val parametars = Bundle()
                parametars.putString("fields","id, first_name, middle_name, last_name, name, picture, email")

                GraphRequest(accessToken,"/$userId/",parametars,HttpMethod.GET,GraphRequest.Callback {
                    response ->
                    val jsonObject = response.jsonObject
                    if (BuildConfig.DEBUG) {
                        FacebookSdk.setIsDebugEnabled(true)
                        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS)
                    }


                    if (jsonObject != null) {
                        if (jsonObject.has("id")){
                            val facebookId =jsonObject.getString("id")
                            id = facebookId.toString()
                            Log.i("Facebook Id: ", facebookId.toString())
                        }
                        else{
                            id = "Not exists"
                            Log.i("Facebook Id: ", "Not exists")
                        }
                        if (jsonObject.has("first_name")) {
                            val facebookFirstName = jsonObject.getString("first_name")
                            firstName = facebookFirstName
                            Log.i("Facebook First Name: ", facebookFirstName)
                        } else {
                            firstName = "Not exists"
                            Log.i("Facebook First Name: ", "Not exists")
                        }


                        // Facebook Middle Name
                        if (jsonObject.has("middle_name")) {
                            val facebookMiddleName = jsonObject.getString("middle_name")
                            Log.i("Facebook Middle Name: ", facebookMiddleName)
                        } else {
                            Log.i("Facebook Middle Name: ", "Not exists")
                        }


                        // Facebook Last Name
                        if (jsonObject.has("last_name")) {
                            val facebookLastName = jsonObject.getString("last_name")
                            Log.i("Facebook Last Name: ", facebookLastName)
                        } else {
                            Log.i("Facebook Last Name: ", "Not exists")
                        }


                        // Facebook Name
                        if (jsonObject.has("name")) {
                            val facebookName = jsonObject.getString("name")
                            Log.i("Facebook Name: ", facebookName)
                        } else {
                            Log.i("Facebook Name: ", "Not exists")
                        }


                        if (jsonObject.has("picture")) {
                            val facebookPictureObject = jsonObject.getJSONObject("picture")
                            if (facebookPictureObject.has("data")) {
                                val facebookDataObject = facebookPictureObject.getJSONObject("data")
                                if (facebookDataObject.has("url")) {
                                    val facebookProfilePicURL = facebookDataObject.getString("url")
                                    Log.i("Facebook Profile Pic URL: ", facebookProfilePicURL)
                                }
                            }
                        } else {
                            Log.i("Facebook Profile Pic URL: ", "Not exists")
                        }


                        if (jsonObject.has("email")) {
                            val facebookEmail = jsonObject.getString("email")
                            Log.i("Facebook Email: ", facebookEmail)
                        } else {
                            Log.i("Facebook Email: ", "Not exists")
                        }
                    }
                }).executeAsync()
    }

    private fun openDetailsActivity() {
        val myIntent = Intent(this, details ::class.java)
        myIntent.putExtra("facebook_id", id)
        myIntent.putExtra("facebook_first_name", firstName)
        startActivity(myIntent)
    }
}

