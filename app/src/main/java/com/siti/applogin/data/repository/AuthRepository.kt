package com.siti.applogin.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.siti.applogin.data.local.AuthPref
import com.siti.applogin.data.model.ActionState
import com.siti.applogin.data.model.AuthUser

class AuthRepository(val context: Context) {
    private  val authPref: AuthPref by lazy { AuthPref(context) }

    val authUser = MutableLiveData<AuthUser>(authPref.autUser)
    val isLogin = MutableLiveData<Boolean>(authPref.isLogin)

    suspend fun login(email: String, password: String) : ActionState<AuthUser> {
        return authPref.login(email, password)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser> {
        return authPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean> {
        return authPref.logout()
    }
}