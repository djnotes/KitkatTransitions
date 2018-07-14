package me.mehdi.transitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.register -> {
                if (!animationStarted) {
                    TransitionManager.go(sceneRegister, set);
                    animationStarted = true;
                }
            }
            R.id.login -> {
                if(!animationStarted) {
                    TransitionManager.go(sceneLogin, set);
                    animationStarted = true;
                }
            }

        }

    }


    var animationStarted = false;

    lateinit var scene: Scene
    lateinit var login: Button
    lateinit var register: Button
    lateinit var root : ViewGroup
    lateinit var sceneRegister: Scene
    lateinit var sceneLogin: Scene
    lateinit var set: TransitionSet


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        login = findViewById<Button>(R.id.login);
        register = findViewById<Button>(R.id.register);
        root = findViewById<ViewGroup>(R.id.root);
        scene = Scene.getSceneForLayout(root, R.layout.main_activity, this);
        sceneLogin = Scene.getSceneForLayout(root, R.layout.main_activity_login, this);
        sceneRegister = Scene.getSceneForLayout(root, R.layout.main_activity_register, this);

        set = TransitionSet();

        set.addTransition(ChangeBounds()).addTransition(Fade()).addTransition(AutoTransition());

        login.setOnClickListener (this)
        register.setOnClickListener(this)




    }

    override fun onBackPressed() {
        if(animationStarted) {
            val root = findViewById<ViewGroup>(R.id.root);
            TransitionManager.go(scene, ChangeBounds() );
            animationStarted = false;
            login = findViewById(R.id.login)
            register = findViewById(R.id.register)

            login.setOnClickListener(this)
            register.setOnClickListener(this)
        }
        else {

            super.onBackPressed();
        }

    }
}
