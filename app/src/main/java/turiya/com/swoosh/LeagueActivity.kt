package turiya.com.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View)
    {
        womensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        selectedLeague = "Mens"
    }

    fun onWomensClicked(view: View)
    {
        mensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        selectedLeague = "Womens"
    }

    fun onCoedClicked(view: View)
    {
        womensLeagueBtn.isChecked = false
        coedLeaguebtn.isChecked = false

        selectedLeague = "Coed"
    }

    fun leagueNextClicked(view: View) {

        if(selectedLeague!= "")
        {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)

        }
        else
        {
           val toast = Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT)
            toast.show()
        }

    }


}
