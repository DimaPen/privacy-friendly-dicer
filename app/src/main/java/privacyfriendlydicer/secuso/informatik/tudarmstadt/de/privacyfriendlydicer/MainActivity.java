package privacyfriendlydicer.secuso.informatik.tudarmstadt.de.privacyfriendlydicer;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    ImageView resultOne;
    ImageView resultTwo;
    ImageView resultThree;
    ImageView resultFour;
    ImageView resultFive;
    ImageView resultSix;
    ImageView resultSeven;
    ImageView resultEight;
    ImageView resultNine;
    ImageView resultTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollDiceButton = (Button) findViewById(R.id.rollButton);

        final SeekBar poolSeekBar = (SeekBar) findViewById(R.id.seekBar);

        SeekBar seekBarLength = (SeekBar) findViewById(R.id.seekBar);

        seekBarLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textViewLengthDisplay =
                        (TextView) findViewById(R.id.chooseDiceNumber);
                textViewLengthDisplay.setText(Integer.toString(progress + 1));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String resultString = "";
                Dicer dicer = new Dicer();
                //TextView result = (TextView) findViewById(R.id.textViewResults);
                int[] dice = dicer.rollDice(poolSeekBar.getProgress() + 1);
                initResultDiceViews();

                /*for (int i = 0; i < dice.length; i++) {
                    resultString += dice[i];
                }

                result.setText(resultString);*/

                for (int i = 0; i < dice.length; i++) {
                    ImageView resultOne = (ImageView) findViewById(R.id.resultOne);
                    switch (i) {
                        case 0:  switchDice(resultOne, dice[i]);
                            break;
                        case 1:  switchDice(resultTwo, dice[i]);
                            break;
                        case 2:  switchDice(resultThree, dice[i]);
                            break;
                        case 3:  switchDice(resultFour, dice[i]);
                            break;
                        case 4: switchDice(resultFive, dice[i]);
                            break;
                        case 5:  switchDice(resultSix, dice[i]);
                            break;
                        case 6:  switchDice(resultSeven, dice[i]);
                            break;
                        case 7:  switchDice(resultEight, dice[i]);
                            break;
                        case 8:  switchDice(resultNine, dice[i]);
                            break;
                        case 9:  switchDice(resultTen, dice[i]);
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        //ImageView resultOne = (ImageView) findViewById(R.id.resultOne);
        //resultOne.setImageResource(R.drawable.ws1);

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

    public void initResultDiceViews(){
        resultOne = (ImageView) findViewById(R.id.resultOne);
        resultTwo = (ImageView) findViewById(R.id.resultTwo);
        resultThree = (ImageView) findViewById(R.id.resultThree);
        resultFour = (ImageView) findViewById(R.id.resultFour);
        resultFive = (ImageView) findViewById(R.id.resultFive);
        resultSix = (ImageView) findViewById(R.id.resultSix);
        resultSeven = (ImageView) findViewById(R.id.resultSeven);
        resultEight = (ImageView) findViewById(R.id.resultEight);
        resultNine = (ImageView) findViewById(R.id.resultNine);
        resultTen = (ImageView) findViewById(R.id.resultTen);
    }

    public void switchDice(ImageView imageView, int i){
        switch (i) {
            case 1:  imageView.setImageResource(R.drawable.ws1);
                break;
            case 2:  imageView.setImageResource(R.drawable.ws2);
                break;
            case 3:  imageView.setImageResource(R.drawable.ws3);
                break;
            case 4:  imageView.setImageResource(R.drawable.ws4);
                break;
            case 5: imageView.setImageResource(R.drawable.ws5);
                break;
            case 6:  imageView.setImageResource(R.drawable.ws6);
                break;
            default:
                break;
        }

    }
}
