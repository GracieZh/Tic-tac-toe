package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    String prevTurn;
    String[][] grid = new String[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View newGV = findViewById(R.id.newG);
        newGV.setVisibility(View.INVISIBLE);
        init();
    }
    public void init()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0; j<3; j++)
            {
                grid[i][j] = "empty";
            }
        }
    }
    public void disable(View v)
    {
        v.setEnabled(false);
        v.setBackgroundColor(Color.rgb(23,44,100));


        TextView text=(TextView)v;
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        text.setTextColor(Color.WHITE);
        View newGV = findViewById(R.id.newG);
        newGV.setVisibility(View.INVISIBLE);

        if(prevTurn == "Player1")
        {
            tv2.setText("Player1's Turn");
            text.setText("Player2");
            prevTurn = "Player2";
        }
        else if(prevTurn == "Player2")
        {
            tv2.setText("Player2's Turn");
            text.setText("Player1");
            prevTurn = "Player1";
        }
        else
        {
            tv2.setText("Player2's Turn");
            text.setText("Player1"); // Player1 goes first
            prevTurn = "Player1";
        }
        fillGrid(v);

        if (grid[0][0].equals(grid[0][1]) && grid[0][1].equals(grid[0][2])
                && !(grid[0][1].equals("empty")))
        {
            tv2.setText(grid[0][0] + " wins!");
            gameOver(newGV);
        }
        else if (grid[1][0].equals(grid[1][1]) && grid[1][1].equals(grid[1][2])
                && !(grid[1][0].equals("empty")))
        {
            tv2.setText(grid[1][0] + " wins!");
            gameOver(newGV);
        }
        else if (grid[2][0].equals(grid[2][1]) && grid[2][1].equals(grid[2][2])
                && !(grid[2][0].equals("empty")))
        {
            tv2.setText(grid[2][0] + " wins!");
            gameOver(newGV);
        }
        else if (grid[0][0].equals(grid[1][0]) && grid[1][0].equals(grid[2][0])
                && !(grid[0][0].equals("empty")))
        {
            tv2.setText(grid[0][0] + " wins!");
            gameOver(newGV);
        }
        else if (grid[0][1].equals(grid[1][1]) && grid[1][1].equals(grid[2][1])
                && !(grid[0][1].equals("empty")))
        {
            tv2.setText(grid[0][1] + " wins!");
            gameOver(newGV);
        }
        else if (grid[0][2].equals(grid[1][2]) && grid[1][2].equals(grid[2][2])
                && !(grid[0][2].equals("empty")))
        {
            tv2.setText(grid[0][2] + " wins!");
            gameOver(newGV);
        }
        else if (grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])
                && !(grid[0][0].equals("empty")))
        {
            tv2.setText(grid[0][0] + " wins!");
            gameOver(newGV);
        }
        else if (grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])
                && !(grid[0][2].equals("empty")))
        {
            tv2.setText(grid[0][2] + " wins!");
            gameOver(newGV);
        }
        else if (noEmpty())
        {
            tv2.setText("Tie!");
            gameOver(newGV);
        }
    }
    public void gameOver(View v)
    {
        v.setVisibility(View.VISIBLE);

        View v1 = findViewById(R.id.b1);
        View v2 = findViewById(R.id.b2);
        View v3 = findViewById(R.id.b3);
        View v4 = findViewById(R.id.b4);
        View v5 = findViewById(R.id.b5);
        View v6 = findViewById(R.id.b6);
        View v7 = findViewById(R.id.b7);
        View v8 = findViewById(R.id.b8);
        View v9 = findViewById(R.id.b9);

        v1.setEnabled(false);
        v2.setEnabled(false);
        v3.setEnabled(false);
        v4.setEnabled(false);
        v5.setEnabled(false);
        v6.setEnabled(false);
        v7.setEnabled(false);
        v8.setEnabled(false);
        v9.setEnabled(false);

    }
    public void newGame(View v)
    {
        int c = Color.BLUE;

        View newGV = findViewById(R.id.newG);
        newGV.setVisibility(View.INVISIBLE);

        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setText("");

        View v1 = findViewById(R.id.b1);
        View v2 = findViewById(R.id.b2);
        View v3 = findViewById(R.id.b3);
        View v4 = findViewById(R.id.b4);
        View v5 = findViewById(R.id.b5);
        View v6 = findViewById(R.id.b6);
        View v7 = findViewById(R.id.b7);
        View v8 = findViewById(R.id.b8);
        View v9 = findViewById(R.id.b9);

        v1.setEnabled(true);
        v2.setEnabled(true);
        v3.setEnabled(true);
        v4.setEnabled(true);
        v5.setEnabled(true);
        v6.setEnabled(true);
        v7.setEnabled(true);
        v8.setEnabled(true);
        v9.setEnabled(true);

        TextView t1=(TextView)v1;
        TextView t2=(TextView)v2;
        TextView t3=(TextView)v3;
        TextView t4=(TextView)v4;
        TextView t5=(TextView)v5;
        TextView t6=(TextView)v6;
        TextView t7=(TextView)v7;
        TextView t8=(TextView)v8;
        TextView t9=(TextView)v9;

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");

        v1.setBackgroundColor(c);
        v2.setBackgroundColor(c);
        v3.setBackgroundColor(c);
        v4.setBackgroundColor(c);
        v5.setBackgroundColor(c);
        v6.setBackgroundColor(c);
        v7.setBackgroundColor(c);
        v8.setBackgroundColor(c);
        v9.setBackgroundColor(c);

        init();
    }
    public boolean noEmpty()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0; j<3; j++)
            {
                if (grid[i][j].equals("empty"))
                    return false;
            }
        }
        return true;
    }
    public void fillGrid(View v)
    {
        Button b = (Button)v;
        String bText = b.getText().toString();
        switch (v.getId())
        {
            case R.id.b1:
                grid[0][0]= bText;
                break;
            case R.id.b2:
                grid[0][1]= bText;
                break;
            case R.id.b3:
                grid[0][2]= bText;
                break;
            case R.id.b4:
                grid[1][0]= bText;
                break;
            case R.id.b5:
                grid[1][1]= bText;
                break;
            case R.id.b6:
                grid[1][2]= bText;
                break;
            case R.id.b7:
                grid[2][0]= bText;
                break;
            case R.id.b8:
                grid[2][1]= bText;
                break;
            case R.id.b9:
                grid[2][2]= bText;
                break;
        }
    }
    public int idToInt(String id)
    {
        return Integer.parseInt(id.substring(1));
    }

}