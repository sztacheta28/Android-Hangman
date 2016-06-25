package pl.edu.uksw.hangman;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.uksw.R;

public class MenuActivity extends AppCompatActivity {
    @BindView(R.id.newGameBtn)
    Button newGameBtn;

    @BindView(R.id.exitGameBtn)
    Button exitGameBtn;

    @BindView(R.id.continueBtn)
    Button continueBtn;

    SharedPreferences currentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);

        currentStatus = getSharedPreferences(Constants.PREFS_NAME, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(currentStatus.getInt(Constants.KEYS.ATTEMPTS, 0) == 0){
            continueBtn.setVisibility(View.GONE);
        }else {
            continueBtn.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.newGameBtn)
    public void newGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(Constants.KEYS.GOOD_ANSWERS, 0);
        intent.putExtra(Constants.KEYS.ATTEMPTS, 0);
        startActivity(intent);
    }

    @OnClick(R.id.exitGameBtn)
    public void exitGame(View view) {
        currentStatus.edit().clear().commit();

        this.finish();
        System.exit(0);
    }


    @Override
    protected void onPause() {
        currentStatus.edit().clear().commit();

        super.onPause();
    }

    @OnClick(R.id.continueBtn)
    public void continueGame(View view) {
        int goodAnswers = currentStatus.getInt(Constants.KEYS.GOOD_ANSWERS, 0);
        int allAnswers = currentStatus.getInt(Constants.KEYS.ATTEMPTS, 0);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(Constants.KEYS.GOOD_ANSWERS, goodAnswers);
        intent.putExtra(Constants.KEYS.ATTEMPTS, allAnswers);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {}
}
