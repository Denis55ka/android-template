package app.deni55ka.core.network

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

object HttpLogger : HttpLoggingInterceptor.Logger {

    private const val MAX_MESSAGE_LENGTH = 2000

    override fun log(message: String) {
        val parts = message.chunked(MAX_MESSAGE_LENGTH)
        for (part in parts) {
            Log.i("okhttp.OkHttpClient", part)
        }
    }
}
