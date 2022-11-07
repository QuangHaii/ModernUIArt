package com.example.modernuirelative;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class RelativeLayout extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        this.setTitle("Relative Layout");

        SeekBar sb = findViewById(R.id.seekBar);
        TextView red = findViewById(R.id.redbox);
        TextView blue = findViewById(R.id.bluebox);
        TextView yellow = findViewById(R.id.yellowbox);
        TextView orange = findViewById(R.id.orangebox);
        TextView purple = findViewById(R.id.purplebox);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progChange = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int[] redArray = {220, 20, 60};
                int[] blueArray = {10, 17, 114};
                int[] yellowArray = {255, 255, 0};
                int[] orangeArray = {255, 165, 0};
                int[] purpleArray = {150, 123, 182};

                progChange = progress;

                redArray[0] = redArray[0] - (220/100)*progChange;
                redArray[1] = redArray[1] + (229/100)*progChange;
                redArray[2] = redArray[2] + (165/100)*progChange;

                blueArray[0] = blueArray[0] + (200/100)*progChange;
                blueArray[1] = blueArray[1] + (102/100)*progChange;
                blueArray[2] = blueArray[2] - (229/100)*progChange;

                yellowArray[0] = yellowArray[0] - (203/100)*progChange;
                yellowArray[1] = yellowArray[1] - (138/100)*progChange;
                yellowArray[2] = yellowArray[2] + (94/100)*progChange;

                orangeArray[0] = orangeArray[0] - (65/100)*progChange;
                orangeArray[1] = orangeArray[1] - (157/100)*progChange;
                orangeArray[2] = orangeArray[2] + (129/100)*progChange;

                purpleArray[0] = purpleArray[0] - (123/100)*progChange;
                purpleArray[1] = purpleArray[1] - (110/100)*progChange;
                purpleArray[2] = purpleArray[2] - (165/100)*progChange;

                red.setBackgroundColor(Color.rgb(redArray[0],redArray[1],redArray[2]));
                blue.setBackgroundColor(Color.rgb(blueArray[0],blueArray[1],blueArray[2]));
                yellow.setBackgroundColor(Color.rgb(yellowArray[0],yellowArray[1],yellowArray[2]));
                orange.setBackgroundColor(Color.rgb(orangeArray[0],orangeArray[1],orangeArray[2]));
                purple.setBackgroundColor(Color.rgb(purpleArray[0],purpleArray[1],purpleArray[2]));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menurelative, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case(R.id.table):
                intent = new Intent(this,TableLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case(R.id.linear):
                intent = new Intent (this, LinearLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case(R.id.info):
                alertDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Lai Quang Hai \t 3120410150 \nDuong Van Tri \t 3120410548");
        builder.setTitle("Information");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create();
        builder.show();
    }
}