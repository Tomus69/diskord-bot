package com.example.discord_bot

import com.jessecorbett.diskord.bot.bot
import com.jessecorbett.diskord.bot.classicCommands
import com.jessecorbett.diskord.bot.events
import com.jessecorbett.diskord.bot.interaction.interactions
import com.jessecorbett.diskord.util.sendMessage
import kotlinx.coroutines.runBlocking

class Discord {

    fun startDiscordBot(token: String = Credentials().TOKEN) {
        runBlocking {
            bot(token) {
                // Generic hook set for all events
                events {
                    onReady {
                        channel("1092562379327418431").sendMessage("Loading")
                        // it.channel.sendMessage("FUCK SEMIH")
                    }
                    onMessageCreate {
                        channel("1092562379327418431").sendMessage("Fuck Semih")
                        it.channel.sendMessage("FUCK SEMIH")
                    }
                    onGuildMemberAdd {
                        channel("1092562379327418431").sendMessage("Welcome to the server !")
                    }
                }
            }
        }
    }

}