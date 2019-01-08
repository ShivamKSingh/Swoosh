package turiya.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import turiya.com.swoosh.Utilities.EXTRA_LEAGUE
import turiya.com.swoosh.R
import turiya.com.swoosh.Utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onBegineerClicked(view: View)
    {
        ballerSkillBtn.isChecked = false
        skill = "beginner"

    }

    fun onBallerClick(view: View)
    {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onSkillFinishClicked(view: View)
    {
        if(skill!= "")
        {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        }
        else
        {
            val toast = Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
