    /**
     * Authors: Jacob Bryant, Jamie Fisher, Ibrahim Almubarak.
     * Version:0.0.3a.
     * Date: 2/1/2016.
     *
     * Functions:
     * 1-The black pin disappear after clicking it(10 pts).
     * 2-second pin changes.(5pts).
     * 3- Two Spinner one changes difficulty  the other one changes the theme(20 pts).
     * 4- SeekBar for the volume. (15pts).
     * 5- pre-Approved by professor: having popup window that shows the name of 4 elements.
     * the elements are :the pins whenever you click on them they will show a small bubble.
     *
     */
    package cs301.mastermind;

    import android.content.ClipData;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.media.AudioManager;
    import android.media.MediaPlayer;
    import android.support.v7.app.ActionBarActivity;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.MotionEvent;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.ImageButton;
    import android.view.View.DragShadowBuilder;
    import android.widget.LinearLayout;
    import android.widget.SeekBar;
    import android.widget.Spinner;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;


    public class MainActivity extends ActionBarActivity
    implements  View.OnClickListener, View.OnTouchListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener{

        //Deceleration.
        protected ImageButton blackPin;
        protected ImageButton brownPin;
        protected ImageButton purplePin;
        protected ImageButton greenPin;
        protected ImageButton bluePin;
        protected ImageButton yellowPin;
        protected ImageButton redPin;
        protected ImageButton orangePin;
        protected ImageButton pinkPin;
        protected ImageButton lightBluePin;
        protected Spinner diff;
        protected ArrayList <String> diffString;
        protected ArrayAdapter <String> diffAdapt;
        protected Button quit;
        protected Spinner theme;
        protected ArrayList <String> themeString;
        protected ArrayAdapter <String> themeAdapt;
        protected LinearLayout background;
        protected TextView volText;
        protected SeekBar volumeControl;
        protected MediaPlayer music;
        protected AudioManager audioManager ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Used to access the system volume and control it.
            setVolumeControlStream(AudioManager.STREAM_MUSIC);

            //setting the variables

            music= MediaPlayer.create(this,R.raw.background_music);
            blackPin=(ImageButton) findViewById(R.id.blackButton);
            brownPin=(ImageButton) findViewById(R.id.brownButton);
            orangePin=(ImageButton) findViewById(R.id.orangeButton);
            redPin=(ImageButton) findViewById(R.id.redButton);
            greenPin=(ImageButton) findViewById(R.id.greenButton);
            yellowPin=(ImageButton) findViewById(R.id.yellowButton);
            bluePin=(ImageButton) findViewById(R.id.blueButton);
            purplePin=(ImageButton) findViewById(R.id.purpleButton);
            pinkPin=(ImageButton) findViewById(R.id.pinkButton);
            lightBluePin=(ImageButton) findViewById(R.id.lightBlueButton);
            diff= (Spinner) findViewById(R.id.diffSpin);
            theme= (Spinner) findViewById(R.id.themeSpin);
            quit = (Button) findViewById(R.id.quitButton);
            background = (LinearLayout) findViewById(R.id.background);
            volText = (TextView) findViewById(R.id.changVol);
            volumeControl = (SeekBar) findViewById(R.id.volumeControl);

            //Array lists
            diffString = new ArrayList<String>();
            diffString.add("Choose Difficulity");
            diffString.add("Easy");
            diffString.add("Hard");
            themeString = new ArrayList<String>();
            themeString.add("Choose Theme");
            themeString.add("Cool Blue");
            themeString.add("Valentine Red");
            diffAdapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,diffString);
            themeAdapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,themeString);

            //Listeners
            blackPin.setOnClickListener(this);
            brownPin.setOnClickListener(this);
            redPin.setOnClickListener(this);
            bluePin.setOnClickListener(this);
            greenPin.setOnClickListener(this);
            yellowPin.setOnClickListener(this);
            purplePin.setOnClickListener(this);
            orangePin.setOnClickListener(this);
            lightBluePin.setOnClickListener(this);
            pinkPin.setOnClickListener(this);
            diff.setOnItemSelectedListener(this);
            diff.setAdapter(diffAdapt);
            quit.setOnClickListener(this);
            theme.setOnItemSelectedListener(this);
            theme.setAdapter(themeAdapt);
            volumeControl.setOnSeekBarChangeListener(this);
            //starting the music.
            music.start();
            //The manager contorls the audio
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            /**
             External Citation
             Date: 2 February 2016
             Problem: Could not get the background volume to set using setVolume

             Resource:
             http://stackoverflow.com/questions/10134338/
             using-seekbar-to-control-volume-in-android.
             Solution: I used the example code from this post.
             */
            volumeControl.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeControl.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));

            /*diffString[0] = "Select Difficulity";
            diffString[1] = "Easy";
            diffString[2]= "Hard";*/
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onClick(View v) {
            //The Pins
            if(v == blackPin) {
            blackPin.setVisibility(v.INVISIBLE);
                Toast.makeText(blackPin.getContext(), "Black Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
            else if(v== brownPin) {
                brownPin.setVisibility(v.INVISIBLE);
                Toast.makeText(brownPin.getContext(), "Brown Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
           else if(v== greenPin) {
                greenPin.setVisibility(v.INVISIBLE);
                Toast.makeText(greenPin.getContext(), "Green Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
           else if(v== redPin) {
                redPin.setVisibility(v.INVISIBLE);
                Toast.makeText(redPin.getContext(), "Red Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
           else if(v== purplePin) {
                purplePin.setVisibility(v.INVISIBLE);
                Toast.makeText(purplePin.getContext(), "Purple Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
           else if(v== yellowPin) {
                yellowPin.setVisibility(v.INVISIBLE);
                Toast.makeText(yellowPin.getContext(), "Yellow Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
            else if(v== orangePin) {
                orangePin.setVisibility(v.INVISIBLE);
                Toast.makeText(orangePin.getContext(), "Orange Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
           else if(v== bluePin) {
                bluePin.setVisibility(v.INVISIBLE);
                Toast.makeText(bluePin.getContext(), "Blue Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
            else if(v== pinkPin) {
                pinkPin.setVisibility(v.INVISIBLE);
                Toast.makeText(pinkPin.getContext(), "Pink Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
            else if(v== lightBluePin) {
                lightBluePin.setVisibility(v.INVISIBLE);
                Toast.makeText(lightBluePin.getContext(), "Light Blue Pin: Choose a location" , Toast.LENGTH_SHORT).show();
            }
            //Quit Button.
            else if(v== quit) {
            finish();
               System.exit(0);
            }
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            /* Not used.
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }*/return false;
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 // if(view.getId() ==diff.getId()) {
                String diffItem = parent.getItemAtPosition(position).toString();

                if (diffItem.equals("Hard")) {
                    lightBluePin.setVisibility(view.VISIBLE);
                    pinkPin.setVisibility(view.VISIBLE);
                    Toast.makeText(parent.getContext(), "" + diffItem, Toast.LENGTH_SHORT).show();
                }
                if (diffItem.equals("Easy")) {
                    lightBluePin.setVisibility(view.GONE);
                    pinkPin.setVisibility(view.GONE);
                    Toast.makeText(parent.getContext(), "" + diffItem, Toast.LENGTH_SHORT).show();
                }

            //else if(view==theme){
                String themeItem = parent.getItemAtPosition(position).toString();
                //checks the string to differentiate between spinner choices
                if (themeItem.equals("Cool Blue")) {
                        background.setBackgroundColor(0xff2b4f81);
                        Toast.makeText(parent.getContext(),
                                "" + themeItem, Toast.LENGTH_SHORT).show();
                        blackPin.setBackgroundColor(0xff2b4f81);
                        brownPin.setBackgroundColor(0xff2b4f81);
                        yellowPin.setBackgroundColor(0xff2b4f81);
                        redPin.setBackgroundColor(0xff2b4f81);
                        greenPin.setBackgroundColor(0xff2b4f81);
                        pinkPin.setBackgroundColor(0xff2b4f81);
                        purplePin.setBackgroundColor(0xff2b4f81);
                        orangePin.setBackgroundColor(0xff2b4f81);
                        bluePin.setBackgroundColor(0xff2b4f81);
                        lightBluePin.setBackgroundColor(0xff2b4f81);
                }
                if (themeItem.equals("Valentine Red")) {
                        background.setBackgroundColor(0xffBC3440);
                        blackPin.setBackgroundColor(0xffBC3440);
                        brownPin.setBackgroundColor(0xffBC3440);
                        yellowPin.setBackgroundColor(0xffBC3440);
                        redPin.setBackgroundColor(0xffBC3440);
                        greenPin.setBackgroundColor(0xffBC3440);
                        pinkPin.setBackgroundColor(0xffBC3440);
                        purplePin.setBackgroundColor(0xffBC3440);
                        orangePin.setBackgroundColor(0xffBC3440);
                        bluePin.setBackgroundColor(0xffBC3440);
                        lightBluePin.setBackgroundColor(0xffBC3440);
                        Toast.makeText(parent.getContext(),
                            "" + themeItem, Toast.LENGTH_SHORT).show();
                }



        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        //Not used
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        volText.setText(""+progress);

            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                    progress, 0);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        //Not used
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        //Not used
        }
    }
