package edu.niu.android.hangman;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Hangman game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (game == null)
            game = new Hangman(Hangman.DEFAULT_GUESSES);
        setContentView(R.layout.activity_main);
        TextView status = (TextView) findViewById(R.id.status);
        status.setText("" + game.getGuessesLeft());

        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentById(R.id.game_state) == null)
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            GameStateFragment fragment = new GameStateFragment();
            transaction.add(R.id.game_state, fragment);
            transaction.commit();
        }
    }

    public Hangman getGame()
    {
        return game;
    }

    public void play(View view)
    {
    }
}
