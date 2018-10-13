package com.asterisklab.testyourknowledge;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.interfaces.RSAKey;
import java.util.Random;

public class questionActivity extends AppCompatActivity {


    TextView displayQuestion,crntScore;
    ProgressBar progress;
    Button trueBtn,falseBtn;
    int score = 0,index = 0;
    int question;
    int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100/26);

    TrueFalse[] nationalQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.National1,true),
            new TrueFalse(R.string.National2,false),
            new TrueFalse(R.string.National3,true),
            new TrueFalse(R.string.National4,true),
            new TrueFalse(R.string.National5,false),
            new TrueFalse(R.string.National6,false),
            new TrueFalse(R.string.National7,true),
            new TrueFalse(R.string.National8,true),
            new TrueFalse(R.string.National9,true),
            new TrueFalse(R.string.National10,true),
            new TrueFalse(R.string.National11,false),
            new TrueFalse(R.string.National12,false),
            new TrueFalse(R.string.National13,false),
            new TrueFalse(R.string.National14,true),
            new TrueFalse(R.string.National15,true),
            new TrueFalse(R.string.National16,true),
            new TrueFalse(R.string.National17,false),
            new TrueFalse(R.string.National18,false),
            new TrueFalse(R.string.National19,false),
            new TrueFalse(R.string.National20,true),
            new TrueFalse(R.string.National21,true),
            new TrueFalse(R.string.National22,true),
            new TrueFalse(R.string.National23,false),
            new TrueFalse(R.string.National24,false),
            new TrueFalse(R.string.National25,false),
            new TrueFalse(R.string.National26,true),
            new TrueFalse(R.string.National27,true),
            new TrueFalse(R.string.National28,true),
            new TrueFalse(R.string.National29,false),
            new TrueFalse(R.string.National30,false)
    };

    TrueFalse[] internationalQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.International1,true),
            new TrueFalse(R.string.International2,true),
            new TrueFalse(R.string.International3,false),
            new TrueFalse(R.string.International4,true),
            new TrueFalse(R.string.International5,false),
            new TrueFalse(R.string.International6,false),
            new TrueFalse(R.string.International7,true),
            new TrueFalse(R.string.International8,true),
            new TrueFalse(R.string.International9,false),
            new TrueFalse(R.string.International10,false),
            new TrueFalse(R.string.International11,false),
            new TrueFalse(R.string.International12,true),
            new TrueFalse(R.string.International13,true),
            new TrueFalse(R.string.International14,false),
            new TrueFalse(R.string.International15,true),
            new TrueFalse(R.string.International16,false),
            new TrueFalse(R.string.International17,true),
            new TrueFalse(R.string.International18,true),
            new TrueFalse(R.string.International19,true),
            new TrueFalse(R.string.International20,false),
            new TrueFalse(R.string.International21,false),
            new TrueFalse(R.string.International22,false),
            new TrueFalse(R.string.International23,true),
            new TrueFalse(R.string.International24,true),
            new TrueFalse(R.string.International25,true),
            new TrueFalse(R.string.International26,false),
            new TrueFalse(R.string.International27,false),
            new TrueFalse(R.string.International28,true),
            new TrueFalse(R.string.International29,true),
            new TrueFalse(R.string.International30,false)
    };


    TrueFalse[] techQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.Tech1,true),
            new TrueFalse(R.string.Tech2,true),
            new TrueFalse(R.string.Tech3,false),
            new TrueFalse(R.string.Tech4,false),
            new TrueFalse(R.string.Tech5,true),
            new TrueFalse(R.string.Tech6,false),
            new TrueFalse(R.string.Tech7,true),
            new TrueFalse(R.string.Tech8,true),
            new TrueFalse(R.string.Tech9,false),
            new TrueFalse(R.string.Tech10,true),
            new TrueFalse(R.string.Tech11,true),
            new TrueFalse(R.string.Tech12,false),
            new TrueFalse(R.string.Tech13,false),
            new TrueFalse(R.string.Tech14,false),
            new TrueFalse(R.string.Tech15,true),
            new TrueFalse(R.string.Tech16,true),
            new TrueFalse(R.string.Tech17,false),
            new TrueFalse(R.string.Tech18,true),
            new TrueFalse(R.string.Tech19,false),
            new TrueFalse(R.string.Tech20,true),
            new TrueFalse(R.string.Tech21,false),
            new TrueFalse(R.string.Tech22,true),
            new TrueFalse(R.string.Tech23,true),
            new TrueFalse(R.string.Tech24,true),
            new TrueFalse(R.string.Tech25,true),
            new TrueFalse(R.string.Tech26,false),
            new TrueFalse(R.string.Tech27,false),
            new TrueFalse(R.string.Tech28,true),
            new TrueFalse(R.string.Tech29,false),
            new TrueFalse(R.string.Tech30,true)
    };

    TrueFalse[] geographyQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.Geography1,true),
            new TrueFalse(R.string.Geography2,true),
            new TrueFalse(R.string.Geography3,false),
            new TrueFalse(R.string.Geography4,false),
            new TrueFalse(R.string.Geography5,true),
            new TrueFalse(R.string.Geography6,false),
            new TrueFalse(R.string.Geography7,true),
            new TrueFalse(R.string.Geography8,true),
            new TrueFalse(R.string.Geography9,false),
            new TrueFalse(R.string.Geography10,false),
            new TrueFalse(R.string.Geography11,true),
            new TrueFalse(R.string.Geography12,true),
            new TrueFalse(R.string.Geography13,true),
            new TrueFalse(R.string.Geography14,false),
            new TrueFalse(R.string.Geography15,false),
            new TrueFalse(R.string.Geography16,true),
            new TrueFalse(R.string.Geography17,true),
            new TrueFalse(R.string.Geography18,false),
            new TrueFalse(R.string.Geography19,true),
            new TrueFalse(R.string.Geography20,false),
            new TrueFalse(R.string.Geography21,true),
            new TrueFalse(R.string.Geography22,true),
            new TrueFalse(R.string.Geography23,false),
            new TrueFalse(R.string.Geography24,false),
            new TrueFalse(R.string.Geography25,false),
            new TrueFalse(R.string.Geography26,true),
            new TrueFalse(R.string.Geography27,true),
            new TrueFalse(R.string.Geography28,false),
            new TrueFalse(R.string.Geography29,false),
            new TrueFalse(R.string.Geography30,true)
    };


    TrueFalse[] HistoryQuestionBank = new TrueFalse[] {
      new TrueFalse(R.string.History1,true),
      new TrueFalse(R.string.History2,false),
      new TrueFalse(R.string.History3,false),
      new TrueFalse(R.string.History4,true),
      new TrueFalse(R.string.History5,true),
      new TrueFalse(R.string.History6,true),
      new TrueFalse(R.string.History7,false),
      new TrueFalse(R.string.History8,true),
      new TrueFalse(R.string.History9,false),
      new TrueFalse(R.string.History10,true),
      new TrueFalse(R.string.History11,false),
      new TrueFalse(R.string.History12,true),
      new TrueFalse(R.string.History13,true),
      new TrueFalse(R.string.History14,true),
      new TrueFalse(R.string.History15,true),
      new TrueFalse(R.string.History16,false),
      new TrueFalse(R.string.History17,false),
      new TrueFalse(R.string.History18,false),
      new TrueFalse(R.string.History19,true),
      new TrueFalse(R.string.History20,false),
      new TrueFalse(R.string.History21,true),
      new TrueFalse(R.string.History22,false),
      new TrueFalse(R.string.History23,true),
      new TrueFalse(R.string.History24,false),
      new TrueFalse(R.string.History25,true),
      new TrueFalse(R.string.History26,false),
      new TrueFalse(R.string.History27,true),
      new TrueFalse(R.string.History28,true),
      new TrueFalse(R.string.History29,true),
      new TrueFalse(R.string.History30,false)
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        trueBtn = findViewById(R.id.trueBtn);
        falseBtn = findViewById(R.id.falseBtn);
        displayQuestion = findViewById(R.id.question);
        crntScore = findViewById(R.id.score);
        progress = findViewById(R.id.progressBar);

        String choice = getIntent().getStringExtra("chosenSet");
        String choosedNational = "National";
        String choosedInternational = "International";
        String choosedTech = "Tech";
        String choosedGeography = "Geography";
        String choosedHistory = "History";

           if(choice.equals(choosedNational)){
               trueBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       nationalCheckAnswer(true);
                       nationalUpdateQuestion();

                   }
               });

               falseBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       nationalCheckAnswer(false);
                       nationalUpdateQuestion();

                   }
               });
           }

           if(choice.equals(choosedInternational)){

               displayQuestion.setText(R.string.International1);

               trueBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       internationalCheckAnswer(true);
                       internationalUpdateQuestion();
                   }
               });

               falseBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       internationalCheckAnswer(false);
                       internationalUpdateQuestion();
                   }
               });

           }

           if(choice.equals(choosedTech)){
               displayQuestion.setText(R.string.Tech1);

               trueBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       techCheckAnswer(true);
                       techUpdateQuestion();
                   }
               });

               falseBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       techCheckAnswer(false);
                       techUpdateQuestion();
                   }
               });



           }

           if(choice.equals(choosedGeography)){
               displayQuestion.setText(R.string.Geography1);

               trueBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       geographyCheckAnswer(true);
                       geographyUpdateQuestion();
                   }
               });

               falseBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       geographyCheckAnswer(false);
                       geographyUpdateQuestion();
                   }
               });
           }

           if(choice.equals(choosedHistory)){
               displayQuestion.setText(R.string.History1);

               trueBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       HistoryCheckAnswer(true);
                       HistoryUpdateQuestion();
                   }
               });

               falseBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       HistoryCheckAnswer(false);
                       HistoryUpdateQuestion();
                   }
               });

           }

    }

    private void nationalCheckAnswer(boolean givenAnswer){
            boolean correctAnswer = nationalQuestionBank[index].getAnswer();

            if(givenAnswer == correctAnswer){
                Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
                score = score + 1;
                MediaPlayer trueSound = MediaPlayer.create(this,R.raw.correct_answer);
                trueSound.start();
            } else {
                Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                MediaPlayer falseSound = MediaPlayer.create(this,R.raw.false_answer);
                falseSound.start();
            }
    }

    private void nationalUpdateQuestion(){
        index = (index + 1 ) % nationalQuestionBank.length;
        question = nationalQuestionBank[index].getQuestionID();
        displayQuestion.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        crntScore.setText("" + score + "/30");

        if(index == 0){

            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("Finished !");
            myAlert.setCancelable(false);
            myAlert.setMessage("You Scored " + score + "/" + nationalQuestionBank.length);
            myAlert.setPositiveButton("Back to Topics", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlert.show();
        }
    }

    private void internationalCheckAnswer(boolean givenAnswer){
        boolean correctAnswer = internationalQuestionBank[index].getAnswer();

        if(givenAnswer == correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            MediaPlayer trueSound = MediaPlayer.create(this,R.raw.correct_answer);
            trueSound.start();
            score = score + 1;
        } else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            MediaPlayer falseSound = MediaPlayer.create(this,R.raw.false_answer);
            falseSound.start();
        }
    }

    private void internationalUpdateQuestion() {
        index = (index + 1) % internationalQuestionBank.length;
        question = internationalQuestionBank[index].getQuestionID();
        displayQuestion.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        crntScore.setText("" + score + "/30");

        if (index == 0) {

            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("Finished !");
            myAlert.setCancelable(false);
            myAlert.setMessage("You Scored " + score + "/" + internationalQuestionBank.length);
            myAlert.setPositiveButton("Back to Topics", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlert.show();
        }
    }


    private void techCheckAnswer(boolean givenAnswer){
        boolean correctAnswer = techQuestionBank[index].getAnswer();

        if(givenAnswer == correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            MediaPlayer trueSound = MediaPlayer.create(this,R.raw.correct_answer);
            trueSound.start();
            score = score + 1;
        } else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            MediaPlayer falseSound = MediaPlayer.create(this,R.raw.false_answer);
            falseSound.start();
        }
    }

    private void techUpdateQuestion(){
        index = (index + 1) % techQuestionBank.length;
        question = techQuestionBank[index].getQuestionID();
        displayQuestion.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        crntScore.setText("" + score + "/30");

        if (index == 0) {

            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("Finished !");
            myAlert.setCancelable(false);
            myAlert.setMessage("You Scored " + score + "/" + techQuestionBank.length);
            myAlert.setPositiveButton("Back to Topics", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlert.show();
        }
    }


    private void geographyCheckAnswer(boolean givenAnswer){
        boolean correctAnswer = geographyQuestionBank[index].getAnswer();

        if(givenAnswer == correctAnswer){
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            MediaPlayer trueSound = MediaPlayer.create(this,R.raw.correct_answer);
            trueSound.start();
            score = score + 1;
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            MediaPlayer falseSound = MediaPlayer.create(this,R.raw.false_answer);
            falseSound.start();
        }
    }

    private void geographyUpdateQuestion(){

        index = ( index + 1 ) % geographyQuestionBank.length;
        question = geographyQuestionBank[index].getQuestionID();
        displayQuestion.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        crntScore.setText("" + score + "/30");

        if(index == 0 ) {
            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("Finished !");
            myAlert.setCancelable(false);
            myAlert.setMessage("You Scored " + score + "/" + geographyQuestionBank.length);
            myAlert.setPositiveButton("Back to Topics", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlert.show();
        }
    }



    private void HistoryCheckAnswer(boolean givenAnswer){
        boolean correctAnswer = HistoryQuestionBank[index].getAnswer();

        if(givenAnswer == correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            score = score + 1;
            MediaPlayer trueSound = MediaPlayer.create(this,R.raw.correct_answer);
            trueSound.start();
        } else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            MediaPlayer falseSound = MediaPlayer.create(this,R.raw.false_answer);
            falseSound.start();
        }
    }

    private void HistoryUpdateQuestion(){

        index = ( index + 1 ) % HistoryQuestionBank.length;
        question = HistoryQuestionBank[index].getQuestionID();
        displayQuestion.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        crntScore.setText("" + score + "/30");

        if(index == 0 ) {
            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("Finished !");
            myAlert.setCancelable(false);
            myAlert.setMessage("You Scored " + score + "/" + HistoryQuestionBank.length);
            myAlert.setPositiveButton("Back to Topics", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            myAlert.show();
        }
    }


}
