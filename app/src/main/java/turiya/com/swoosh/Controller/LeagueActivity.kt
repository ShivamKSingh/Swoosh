package turiya.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import turiya.com.swoosh.Model.Player
import turiya.com.swoosh.R
import turiya.com.swoosh.Utilities.EXTRA__PLAYER

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA__PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!= null)
        {
            player = savedInstanceState.getParcelable(EXTRA__PLAYER)
        }
    }

    fun onMensClicked(view: View)
    {
        womensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        player.league = "Mens"
    }

    fun onWomensClicked(view: View)
    {
        mensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        player.league = "Womens"
    }

    fun onCoedClicked(view: View)
    {
        womensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        player.league = "Co-Ed"
    }

    fun leagueNextClicked(view: View) {

        if(player.league!= "")
        {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA__PLAYER, player)
            startActivity(skillActivity)

        }
        else
        {
           val toast = Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT)
            toast.show()
        }

    }


}
