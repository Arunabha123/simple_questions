package com.app.simplequestions.modules.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.app.simplequestions.R;
import com.app.simplequestions.databinding.ActivityMainBinding;
import com.app.simplequestions.modules.entities.Answer;
import com.app.simplequestions.modules.viewmodels.AnswerViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AnswerViewModel answerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        answerViewModel = new ViewModelProvider(this).get(AnswerViewModel.class);
        binding.setClickHandler(answerViewModel.getClickHandler());
    }

    @Override
    protected void onStart() {
        super.onStart();
        answerViewModel.getAllAnswers().observe(this, answers -> {
            if(answers != null && answers.size() > 0) {
                answerViewModel.setUpdatedAnswers(answers);
                for (int i = 0; i < answers.size(); i++) {
                    switch (answers.get(i).getQuestionNo()) {
                        case 1:
                            if (answers.get(i).isAnswer()) binding.rdYes1.setChecked(true);
                            else binding.rdNo1.setChecked(true);
                            break;
                        case 2:
                            if (answers.get(i).isAnswer()) binding.rdYes2.setChecked(true);
                            else binding.rdNo2.setChecked(true);
                            break;
                        case 3:
                            if (answers.get(i).isAnswer()) binding.rdYes3.setChecked(true);
                            else binding.rdNo3.setChecked(true);
                            break;
                        case 4:
                            if (answers.get(i).isAnswer()) binding.rdYes4.setChecked(true);
                            else binding.rdNo4.setChecked(true);
                            break;
                        case 5:
                            if (answers.get(i).isAnswer()) binding.rdYes5.setChecked(true);
                            else binding.rdNo5.setChecked(true);
                            break;
                    }
                }
            }
        });
    }

}