package com.example.mypawfectpetsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    private lateinit var feedProgressBar: ProgressBar
    private lateinit var cleanProgressBar: ProgressBar
    private  lateinit var playProgressBar: ProgressBar

    private var feedProgressStatus: Int = 0
    private var cleanProgressStatus: Int = 0
    private var playProgressStatus: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //initialising the progress bars
        feedProgressBar = findViewById(R.id.feedProgressBar)
        cleanProgressBar = findViewById(R.id.cleanProgressBar)
        playProgressBar = findViewById(R.id.playProgressBar)

        val puppyImageView = findViewById<ImageView>(R.id.puppyImageView)
        val feedButton = findViewById<Button>(R.id.feedButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val playButton = findViewById<Button>(R.id.playButton)

        val hungerTextView = findViewById<TextView>(R.id.hungerTextView)
        val cleanTextView = findViewById<TextView>(R.id.cleanTextView)
        val happyTextView = findViewById<TextView>(R.id.happyTextView)

        val feedMessage = intent.getStringExtra("FEED_MESSAGE")
        hungerTextView.text = feedMessage

        feedButton.setOnClickListener {
            puppyImageView.setImageResource(R.drawable.image_pet_feed)

            feedProgressStatus = 0
            feedProgressBar.progress = feedProgressStatus
            Thread(Runnable{
                while(feedProgressStatus<100){
                    feedProgressStatus +=5
                    Thread.sleep(1000)
                    runOnUiThread{
                        feedProgressBar.progress = feedProgressStatus
                    }
                }
                runOnUiThread{
                    //update hungerTextView text
                }
            }).start()

            hungerTextView.text = getString(R.string.feed_thank_you)

            happyTextView.text = getString(R.string.play_with_me)

        }
        //assigning actions for when the clean button is clicked
        cleanButton.setOnClickListener {
            puppyImageView.setImageResource(R.drawable.image_pet_clean)

            cleanProgressStatus = 0
            cleanProgressBar.progress = cleanProgressStatus
            Thread(Runnable{
                while(cleanProgressStatus<100){
                    cleanProgressStatus +=5
                    Thread.sleep(1000)
                    runOnUiThread{
                        cleanProgressBar.progress = cleanProgressStatus
                    }
                }
                runOnUiThread{
                    //update cleanTextView text
                }
            }).start()


            cleanTextView.text = getString(R.string.clean_nice_and_clean)
        }

        playButton.setOnClickListener {
            puppyImageView.setImageResource(R.drawable.image_pet_play)

            playProgressStatus = 0
            playProgressBar.progress = playProgressStatus
            Thread(Runnable{
                while(playProgressStatus<100){
                    playProgressStatus +=5
                    Thread.sleep(1000)
                    runOnUiThread{
                        playProgressBar.progress = playProgressStatus
                    }
                }
                runOnUiThread{
                    //update happyTextView text
                }
            }).start()



            happyTextView.text= getString(R.string.play_that_was_fun)

            cleanTextView.text = getString(R.string.clean_after_play)
        }
    }
}