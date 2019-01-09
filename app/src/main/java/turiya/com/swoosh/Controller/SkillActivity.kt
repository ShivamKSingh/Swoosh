package turiya.com.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import turiya.com.swoosh.Model.Player
import turiya.com.swoosh.R
import turiya.com.swoosh.Utilities.EXTRA__PLAYER

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA__PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA__PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!= null)
            player = savedInstanceState.getParcelable(EXTRA__PLAYER)
    }

    fun onBegineerClicked(view: View)
    {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"

    }

    fun onBallerClick(view: View)
    {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishClicked(view: View)
    {
        if(player.skill!= "")
        {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA__PLAYER, player)
            startActivity(finishActivity)
        }
        else
        {
            val toast = Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
