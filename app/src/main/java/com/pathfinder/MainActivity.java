package com.pathfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pathfinder.R;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.ViewInterface {

    TextView resultView;
    TextView yesOrNo;
    TextView totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputText = findViewById(R.id.input);
        yesOrNo = findViewById(R.id.yesOrNo);
        totalCost = findViewById(R.id.totalCost);
        resultView = findViewById(R.id.path);
        findViewById(R.id.findPath).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                informPresenterOfButtonClick(inputText);
            }
        });
    }

    private void informPresenterOfButtonClick(EditText inputText) {
        MainActivityPresenter presenter = new MainActivityPresenter();
        presenter.setView(MainActivity.this);
        presenter.onFindButtonClicked(inputText.getText().toString());
    }

    @Override
    public void showResult(String result) {
        resultView.setText(result);
    }

    @Override
    public void setYesOrNo(String result) {
        yesOrNo.setText(result);
    }

    @Override
    public void setPathCost(String result) {
        totalCost.setText(result);
    }
}
