package turiya.com.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import turiya.com.swoosh.Model.Player
import turiya.com.swoosh.R
import turiya.com.swoosh.Utilities.EXTRA__PLAYER

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA__PLAYER)

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} league near you..."

    }
}
