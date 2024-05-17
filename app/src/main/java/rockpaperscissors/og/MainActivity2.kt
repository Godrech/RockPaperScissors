package rockpaperscissors.og

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    //declarations
    private lateinit var spRock:Button
    private lateinit var spPaper:Button
    private lateinit var spScissor:Button
    private lateinit var compImageView: ImageView
    private lateinit var playerImageView: ImageView
    private lateinit var resultsText:TextView

    // Array of image resource IDs
    private val images = arrayOf(R.drawable.rockhand, R.drawable.paperhand, R.drawable.scissorshand)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//initialize
        spRock = findViewById(R.id.spRock)
        spPaper = findViewById(R.id.spPaper)
        spScissor = findViewById(R.id.spScissor)
        compImageView = findViewById(R.id.compImageView)
        playerImageView = findViewById(R.id.playerImageView)
        resultsText = findViewById(R.id.resultsText)
        // Process
        spRock.setOnClickListener {
            handlePlayerChoice(R.drawable.rockhand)
        }
        spPaper.setOnClickListener {
            handlePlayerChoice(R.drawable.paperhand)
        }
        spScissor.setOnClickListener {
            handlePlayerChoice(R.drawable.scissorshand)
        }
    }

    // Method to randomize the computer's choice
    private fun randomize(): Int {
        val randomIndex = Random.nextInt(images.size)
        return images[randomIndex]
    }

    // Method to handle player choice and determine the result
    private fun handlePlayerChoice(playerChoice: Int) {
        playerImageView.setImageResource(playerChoice)
        val compChoice = randomize()
        compImageView.setImageResource(compChoice)

        val result = when {
            playerChoice == compChoice -> "Draw!"
            (playerChoice == R.drawable.rockhand && compChoice == R.drawable.scissorshand) ||
                    (playerChoice == R.drawable.paperhand && compChoice == R.drawable.rockhand) ||
                    (playerChoice == R.drawable.scissorshand && compChoice == R.drawable.paperhand) -> "You Win!"
            else -> "You Lose!"
        }

        resultsText.text = result
    }
}