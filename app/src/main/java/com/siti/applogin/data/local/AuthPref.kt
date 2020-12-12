package com.siti.applogin.data.local

import android.content.Context
import android.content.SharedPreferences
import com.siti.applogin.data.model.ActionState
import com.siti.applogin.data.model.AuthUser
import com.siti.applogin.util.getObject
import com.siti.applogin.util.putObject

class AuthPref(val context:Context) {
    private val sp:SharedPreferences by lazy{
        context.getSharedPreferences(AuthPref::class.java.name, Context.MODE_PRIVATE)
    }

    private  companion object {
        const val AUTH_USER="auth_user"
        const val IS_lOGIN="is_login"
    }

    var autUser: AuthUser?
    get()= sp.getObject(AUTH_USER)
    private set(value) = sp.edit().putObject(AUTH_USER, value).apply()

    var isLogin: Boolean
    get() = sp.getBoolean(IS_lOGIN, false)
    private set(value) = sp.edit().putBoolean(IS_lOGIN, value).apply()

    suspend fun login(email: String, password: String): ActionState<AuthUser>{
        val user = autUser
        return if (user == null){
            ActionState(message = "Anda belum terdaftar", isSucces = false)
        }else if (email.isBlank() || password.isBlank()){
            ActionState(message = " Email dan password tidak boleh kosong", isSucces = false)
        }else if (user.email  == email && user.password == password) {
            isLogin = true
            ActionState(autUser, message = "Anda berhasil login")
        }else  {
            ActionState(message = "Email atau password salah", isSucces = false)
        }

    }

    suspend fun register(user: AuthUser): ActionState<AuthUser> {
        return if (user.email.isBlank() || user.password.isBlank()) {
            ActionState(message = "Email dan password tidak boleh kosong", isSucces = false)
        }else {
            autUser = user
            ActionState(user, message = "Anda berhasil daftar")
        }
    }

    suspend fun logout(): ActionState<Boolean> {
        isLogin = false
        return ActionState(true, message = "Anda berhasil logout")
    }
}