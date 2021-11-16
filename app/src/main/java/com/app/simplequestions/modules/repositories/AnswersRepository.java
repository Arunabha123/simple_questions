package com.app.simplequestions.modules.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.core.os.ExecutorCompat;
import androidx.lifecycle.LiveData;

import com.app.simplequestions.database.SimpleQuestionDatabase;
import com.app.simplequestions.modules.daos.AnswerDao;
import com.app.simplequestions.modules.entities.Answer;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AnswersRepository {
    private final AnswerDao answerDao;
    private final LiveData<List<Answer>> allAnswers;
    private final Executor executor;

    public AnswersRepository(Application application) {
        SimpleQuestionDatabase database = SimpleQuestionDatabase.getInstance(application);
        answerDao = database.answerDao();
        allAnswers = answerDao.getAllAnswers();
        executor = Executors.newSingleThreadExecutor();
    }

    public void insert(List<Answer> answers) {
        executor.execute(() -> answerDao.saveData(answers));
    }

    public void update(List<Answer> answers) {
        executor.execute(() -> answerDao.updateData(answers));
    }

    public LiveData<List<Answer>> getAllAnswers() {
        return allAnswers;
    }

}