package pl.edu.uksw.hangman;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Random;

import pl.edu.uksw.R;

public class GameActivity extends Activity implements View.OnClickListener{
    Button btnA;
    Button btnB;
    Button btnC;
    Button btnD;
    Button btnE;
    Button btnF;
    Button btnG;
    Button btnH;
    Button btnI;
    Button btnJ;
    Button btnK;
    Button btnL;
    Button btnM;
    Button btnN;
    Button btnO;
    Button btnP;
    Button btnQ;
    Button btnR;
    Button btnS;
    Button btnT;
    Button btnU;
    Button btnV;
    Button btnW;
    Button btnX;
    Button btnY;
    Button btnZ;

    Button nextPhrase;

    Button hint;

    TextView phraseTV;
    TextView scoreTV;
    TextView categoryTV;

    ImageView hangmanImgView;


    String phrase = "";

    ArrayList<Character> knownLetters = new ArrayList<Character>();

    Random rnd = new Random();

    String[] words;
    String[] categories;

    int faults = 0;
    int wonCount = 0;
    int allCount = 0;

    boolean inGame = true;

    SharedPreferences currentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        inGame = true;
        currentStatus = getSharedPreferences(Constants.PREFS_NAME, 0);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density  = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth  = outMetrics.widthPixels / density;

        Log.d("TEST", String.valueOf(density)+" "+String.valueOf(dpHeight)+" "+String.valueOf(dpWidth));


        Resources res = getResources();
        words = res.getStringArray(R.array.words);
        categories = res.getStringArray(R.array.categories);

        wonCount = getIntent().getExtras().getInt(Constants.KEYS.GOOD_ANSWERS, 0);
        allCount = getIntent().getExtras().getInt(Constants.KEYS.ATTEMPTS, 0);

        InitializeGameplay();
    }

    private void InitializeGameplay(){
        faults = 0;
        phrase = "";
        knownLetters.clear();

        btnA = (Button)findViewById(R.id.A);
        btnB = (Button)findViewById(R.id.B);
        btnC = (Button)findViewById(R.id.C);
        btnD = (Button)findViewById(R.id.D);
        btnE = (Button)findViewById(R.id.E);
        btnF = (Button)findViewById(R.id.F);
        btnG = (Button)findViewById(R.id.G);
        btnH = (Button)findViewById(R.id.H);
        btnI = (Button)findViewById(R.id.I);
        btnJ = (Button)findViewById(R.id.J);
        btnK = (Button)findViewById(R.id.K);
        btnL = (Button)findViewById(R.id.L);
        btnM = (Button)findViewById(R.id.M);
        btnN = (Button)findViewById(R.id.N);
        btnO = (Button)findViewById(R.id.O);
        btnP = (Button)findViewById(R.id.P);
        btnQ = (Button)findViewById(R.id.Q);
        btnR = (Button)findViewById(R.id.R);
        btnS = (Button)findViewById(R.id.S);
        btnT = (Button)findViewById(R.id.T);
        btnU = (Button)findViewById(R.id.U);
        btnV = (Button)findViewById(R.id.V);
        btnW = (Button)findViewById(R.id.W);
        btnX = (Button)findViewById(R.id.X);
        btnY = (Button)findViewById(R.id.Y);
        btnZ = (Button)findViewById(R.id.Z);

        hint = (Button)findViewById(R.id.hint);

        phraseTV = (TextView)findViewById(R.id.phrase);
        scoreTV = (TextView)findViewById(R.id.score);
        categoryTV = (TextView)findViewById(R.id.category);

        hangmanImgView = (ImageView)findViewById(R.id.hangmanImg);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
        btnG.setOnClickListener(this);
        btnH.setOnClickListener(this);
        btnI.setOnClickListener(this);
        btnJ.setOnClickListener(this);
        btnK.setOnClickListener(this);
        btnL.setOnClickListener(this);
        btnM.setOnClickListener(this);
        btnN.setOnClickListener(this);
        btnO.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnQ.setOnClickListener(this);
        btnR.setOnClickListener(this);
        btnS.setOnClickListener(this);
        btnT.setOnClickListener(this);
        btnU.setOnClickListener(this);
        btnV.setOnClickListener(this);
        btnW.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnY.setOnClickListener(this);
        btnZ.setOnClickListener(this);

        hint.setOnClickListener(this);
        nextPhrase();
        setHiddenPhrase();
        setScore();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.A) {
            letterInteraction('a', view);
        }else if(view.getId() == R.id.B){
            letterInteraction('b', view);
        }else if(view.getId() == R.id.C){
            letterInteraction('c', view);
        }else if(view.getId() == R.id.D){
            letterInteraction('d', view);
        }else if(view.getId() == R.id.E){
            letterInteraction('e', view);
        }else if(view.getId() == R.id.F){
            letterInteraction('f', view);
        }else if(view.getId() == R.id.G){
            letterInteraction('g', view);
        }else if(view.getId() == R.id.H){
            letterInteraction('h', view);
        }else if(view.getId() == R.id.I){
            letterInteraction('i', view);
        }else if(view.getId() == R.id.J){
            letterInteraction('j', view);
        }else if(view.getId() == R.id.K){
            letterInteraction('k', view);
        }else if(view.getId() == R.id.L){
            letterInteraction('l', view);
        }else if(view.getId() == R.id.M){
            letterInteraction('m', view);
        }else if(view.getId() == R.id.N){
            letterInteraction('n', view);
        }else if(view.getId() == R.id.O){
            letterInteraction('o', view);
        }else if(view.getId() == R.id.P){
            letterInteraction('p', view);
        }else if(view.getId() == R.id.Q){
            letterInteraction('q', view);
        }else if(view.getId() == R.id.R){
            letterInteraction('r', view);
        }else if(view.getId() == R.id.S){
            letterInteraction('s', view);
        }else if(view.getId() == R.id.T){
            letterInteraction('t', view);
        }else if(view.getId() == R.id.U){
            letterInteraction('u', view);
        }else if(view.getId() == R.id.V){
            letterInteraction('v', view);
        }else if(view.getId() == R.id.W){
            letterInteraction('w', view);
        }else if(view.getId() == R.id.X){
            letterInteraction('x', view);
        }else if(view.getId() == R.id.Y){
            letterInteraction('y', view);
        }else if(view.getId() == R.id.Z){
            letterInteraction('z', view);
        }else if(view.getId() == R.id.hint){
            hintInteraction(view);
        }else if(view.getId() == R.id.nextPhrase){
            setContentView(R.layout.activity_start);
            inGame = true;
            InitializeGameplay();
        }
    }

    private void setHiddenPhrase(){
        int hiddenLetters = 0;
        String phraseHidden = "";
        for(int i = 0; i<phrase.length(); ++i){
            char currentChar = phrase.charAt(i);
            if(currentChar !=' '){
                if(knownLetters.contains(Character.toLowerCase(currentChar))) {
                    phraseHidden += String.valueOf(currentChar)+" ";
                }else{
                    ++hiddenLetters;
                    phraseHidden += "_ ";
                }
            }else {
                phraseHidden += "  ";
            }
        }

        phraseTV.setText(phraseHidden);

        if(hiddenLetters == 0){
            ++wonCount;
            ++allCount;

            setContentView(R.layout.activity_win);
            inGame = false;
            nextPhrase =  (Button)findViewById(R.id.nextPhrase);
            nextPhrase.setOnClickListener(this);

            phraseTV = (TextView)findViewById(R.id.phrase);
            phraseHidden = "";
            for(int i = 0; i<phrase.length(); ++i){
                char currentChar = phrase.charAt(i);
                phraseHidden += String.valueOf(currentChar) + " ";
            }

            phraseTV.setText(phraseHidden);

            hangmanImgView = (ImageView)findViewById(R.id.hangmanImg);
            setHangmanImg();

            scoreTV = (TextView)findViewById(R.id.score);
            setScore();
        }
    }



    private void letterInteraction(char letter, View view){
        if(phrase.contains(String.valueOf(letter)) || phrase.contains(String.valueOf(Character.toUpperCase(letter)))){
            knownLetters.add(letter);
            view.setBackgroundResource(R.drawable.button_letter_good);
        }else{
            ++faults;
            setHangmanImg();
            view.setBackgroundResource(R.drawable.button_letter_bad);
            ((Button)view).setTextColor(Color.rgb(255, 255, 255));
        }
        view.setClickable(false);

        setHiddenPhrase();

        if(faults == 6){
            ++allCount;

            setContentView(R.layout.activity_lost);
            inGame = false;
            nextPhrase =  (Button)findViewById(R.id.nextPhrase);
            nextPhrase.setOnClickListener(this);

            phraseTV = (TextView)findViewById(R.id.phrase);

            String phraseHidden = "";
            for(int i = 0; i<phrase.length(); ++i){
                char currentChar = phrase.charAt(i);
                phraseHidden += String.valueOf(currentChar) + " ";
            }
            phraseTV.setText(phraseHidden);

            hangmanImgView = (ImageView)findViewById(R.id.hangmanImg);
            setHangmanImg();

            YoYo.with(Techniques.Tada)
                    .duration(1000)
                    .playOn(hangmanImgView);

            scoreTV = (TextView)findViewById(R.id.score);
            setScore();
        }
    }

    private void setScore(){
        scoreTV.setText(String.valueOf(wonCount) + "/" + String.valueOf(allCount));
    }

    private void setHangmanImg(){
        if(faults == 1){
            hangmanImgView.setImageResource(R.drawable.hangman1);
        }else if(faults == 2){
            hangmanImgView.setImageResource(R.drawable.hangman2);
        }else if(faults == 3){
            hangmanImgView.setImageResource(R.drawable.hangman3);
        }else if(faults == 4){
            hangmanImgView.setImageResource(R.drawable.hangman4);
        }else if(faults == 5){
            hangmanImgView.setImageResource(R.drawable.hangman5);
        }else if(faults == 6){
            hangmanImgView.setImageResource(R.drawable.hangman6);
        }
    }

    private void nextPhrase(){
        int idx = rnd.nextInt(words.length);
        phrase = words[idx];
        categoryTV.setText(categories[idx]);
    }

    private void hintInteraction(View view){
        view.setClickable(false);
        view.setBackgroundResource(R.drawable.button_hint_disabled);

        while(true){
            int idx = rnd.nextInt(phrase.length());
            char sign = Character.toLowerCase(phrase.charAt(idx));
            if(sign!=' ' && !knownLetters.contains(sign)){
                knownLetters.add(sign);

                if(sign == 'a'){
                    btnA.setBackgroundResource(R.drawable.button_letter_good);
                    btnA.setClickable(false);
                }else if(sign == 'b'){
                    btnB.setBackgroundResource(R.drawable.button_letter_good);
                    btnB.setClickable(false);
                }else if(sign == 'c'){
                    btnC.setBackgroundResource(R.drawable.button_letter_good);
                    btnC.setClickable(false);
                }else if(sign == 'd'){
                    btnD.setBackgroundResource(R.drawable.button_letter_good);
                    btnD.setClickable(false);
                }else if(sign == 'e'){
                    btnE.setBackgroundResource(R.drawable.button_letter_good);
                    btnE.setClickable(false);
                }else if(sign == 'f'){
                    btnF.setBackgroundResource(R.drawable.button_letter_good);
                    btnF.setClickable(false);
                }else if(sign == 'g'){
                    btnG.setBackgroundResource(R.drawable.button_letter_good);
                    btnG.setClickable(false);
                }else if(sign == 'h'){
                    btnH.setBackgroundResource(R.drawable.button_letter_good);
                    btnH.setClickable(false);
                }else if(sign == 'i'){
                    btnI.setBackgroundResource(R.drawable.button_letter_good);
                    btnI.setClickable(false);
                }else if(sign == 'j'){
                    btnJ.setBackgroundResource(R.drawable.button_letter_good);
                    btnJ.setClickable(false);
                }else if(sign == 'k'){
                    btnK.setBackgroundResource(R.drawable.button_letter_good);
                    btnK.setClickable(false);
                }else if(sign == 'l'){
                    btnL.setBackgroundResource(R.drawable.button_letter_good);
                    btnL.setClickable(false);
                }else if(sign == 'm'){
                    btnM.setBackgroundResource(R.drawable.button_letter_good);
                    btnM.setClickable(false);
                }else if(sign == 'n'){
                    btnN.setBackgroundResource(R.drawable.button_letter_good);
                    btnN.setClickable(false);
                }else if(sign == 'o'){
                    btnO.setBackgroundResource(R.drawable.button_letter_good);
                    btnO.setClickable(false);
                }else if(sign == 'p'){
                    btnP.setBackgroundResource(R.drawable.button_letter_good);
                    btnP.setClickable(false);
                }else if(sign == 'q'){
                    btnQ.setBackgroundResource(R.drawable.button_letter_good);
                    btnQ.setClickable(false);
                }else if(sign == 'r'){
                    btnR.setBackgroundResource(R.drawable.button_letter_good);
                    btnR.setClickable(false);
                }else if(sign == 's'){
                    btnS.setBackgroundResource(R.drawable.button_letter_good);
                    btnS.setClickable(false);
                }else if(sign == 't'){
                    btnT.setBackgroundResource(R.drawable.button_letter_good);
                    btnT.setClickable(false);
                }else if(sign == 'u'){
                    btnU.setBackgroundResource(R.drawable.button_letter_good);
                    btnU.setClickable(false);
                }else if(sign == 'v'){
                    btnV.setBackgroundResource(R.drawable.button_letter_good);
                    btnV.setClickable(false);
                }else if(sign == 'w'){
                    btnW.setBackgroundResource(R.drawable.button_letter_good);
                    btnW.setClickable(false);
                }else if(sign == 'x'){
                    btnX.setBackgroundResource(R.drawable.button_letter_good);
                    btnX.setClickable(false);
                }else if(sign == 'y'){
                    btnY.setBackgroundResource(R.drawable.button_letter_good);
                    btnY.setClickable(false);
                }else if(sign == 'z'){
                    btnZ.setBackgroundResource(R.drawable.button_letter_good);
                    btnZ.setClickable(false);
                }

                break;
            }
        }
        setHiddenPhrase();
    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = currentStatus.edit();
        editor.putInt(Constants.KEYS.GOOD_ANSWERS, wonCount);

        if(inGame) {
            editor.putInt(Constants.KEYS.ATTEMPTS, ++allCount);
        }else{
            editor.putInt(Constants.KEYS.ATTEMPTS, allCount);
        }

        editor.commit();
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        currentStatus.edit().clear().commit();

        super.onSaveInstanceState(bundle);
    }
}
