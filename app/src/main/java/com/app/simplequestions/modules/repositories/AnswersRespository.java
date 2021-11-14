package com.app.simplequestions.modules.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.simplequestions.database.SimpleQuestionDatabase;
import com.app.simplequestions.modules.daos.AnswerDao;
import com.app.simplequestions.modules.entities.Answer;

import java.util.List;

public class AnswersRespository {
    private AnswerDao answerDao;
    private LiveData<List<Answer>> allAnswers;

    public AnswersRespository(Application application) {
        SimpleQuestionDatabase database = SimpleQuestionDatabase.getInstance(application);
        answerDao = database.noteDao();
        allAnswers = answerDao.getAllAnswers();
    }

    public void insert(List<Answer> answers) {
        new InsertAnswerAsyncTask(answerDao).execute(answers);
    }

    public void update(List<Answer> answers) {
        new UpdateAnswerAsyncTask(answerDao).execute(answers);
    }

    public LiveData<List<Answer>> getAllAnswers() {
        return allAnswers;
    }

    private static class InsertAnswerAsyncTask extends AsyncTask<List<Answer>, Void, Void> {
        private AnswerDao answerDao;

        private InsertAnswerAsyncTask(AnswerDao answerDao) {
            this.answerDao = answerDao;
        }

        @Override
        protected Void doInBackground(List<Answer>... lists) {
            answerDao.saveData(lists[0]);
            return null;
        }
    }

    private static class UpdateAnswerAsyncTask extends AsyncTask<List<Answer>, Void, Void> {
        private AnswerDao answerDao;

        private UpdateAnswerAsyncTask(AnswerDao answerDao) {
            this.answerDao = answerDao;
        }

        @Override
        protected Void doInBackground(List<Answer>... lists) {
            answerDao.updateData(lists[0]);
            return null;
        }
    }

}