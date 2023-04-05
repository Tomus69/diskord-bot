package com.example.discord_bot

import com.jessecorbett.diskord.bot.bot
import com.jessecorbett.diskord.bot.events
import com.jessecorbett.diskord.util.sendMessage
import kotlinx.coroutines.runBlocking
import okhttp3.*
import okio.IOException

class Discord {

    private val client = OkHttpClient()

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                println(">>>>>>>> RESPONSE " + response.body?.toString())
            }
        })
    }

    fun startDiscordBot(token: String = Credentials().TOKEN) {
        runBlocking {
            bot(token) {
                events {
                    onReady {
                        println("is Loaded")
                        println(this.botUser.username)
                        run("https://discordapp.com/channels/1092562379327418432/messages")
                        var t = "KEKW"
                        while (true) {
                            t += "-KEKW"
                            this.channel("1092562379327418432").sendMessage(t)
                        }
                    }
                    onMessageCreate {
                        println("onMessageCreate" + it.content)
                    }
                }
            }
        }
    }

}