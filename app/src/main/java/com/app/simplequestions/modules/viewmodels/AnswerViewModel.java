package com.app.simplequestions.modules.viewmodels;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.app.simplequestions.modules.entities.Answer;
import com.app.simplequestions.modules.repositories.AnswersRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnswerViewModel extends AndroidViewModel {
    private AnswersRespository repository;
    private LiveData<List<Answer>> answers;
    private List<Answer> updatedAnswers;

    public AnswerViewModel(@NonNull Application application) {
        super(application);
        repository = new AnswersRespository(application);
        answers = repository.getAllAnswers();
        updatedAnswers = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
           updatedAnswers.add(new Answer(i+1, true));
        }
    }

    public void insert() {
        repository.insert(updatedAnswers);
    }

    public void update() {
        repository.update(updatedAnswers);
    }

    public LiveData<List<Answer>> getAllAnswers() {
        return answers;
    }

    public void setUpdatedAnswers(List<Answer> updatedAnswers) {
        this.updatedAnswers = updatedAnswers;
    }

    public AnswerClickHandlers getClickHandler() {
        return new AnswerClickHandlers();
    }

    public class AnswerClickHandlers {
        public void onAnswerClicked(int index, boolean answer)  {
            updatedAnswers.get(index).setAnswer(answer);
        }

        public void onSaveClicked(View view) {
            if(answers.getValue() == null || answers.getValue().size() == 0) insert();
            else update();
            Toast.makeText(view.getContext(), "Answers Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
