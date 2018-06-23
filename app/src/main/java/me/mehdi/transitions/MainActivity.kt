package me.mehdi.transitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.ImageTransformation
import android.transition.*
import android.view.ViewGroup
import android.widget.Button
import me.mehdi.transitions.ui.main.MainFragment

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow()
//        }

        val login = findViewById<Button>(R.id.login);
        val register = findViewById<Button>(R.id.register);
        val root = findViewById<ViewGroup>(R.id.root);
        val scene = Scene.getSceneForLayout(root, R.layout.main_activity, this);
        val sceneLogin = Scene.getSceneForLayout(root, R.layout.main_activity_login, this);
        val sceneRegister = Scene.getSceneForLayout(root, R.layout.main_activity_register, this);

        val set = TransitionSet();

        set.addTransition(ChangeBounds()).addTransition(Fade()).addTransition(AutoTransition());

        login.setOnClickListener {
            TransitionManager.go(sceneLogin, set);
        }

        register.setOnClickListener {
            TransitionManager.go(sceneRegister, set);
        }

    }

}
