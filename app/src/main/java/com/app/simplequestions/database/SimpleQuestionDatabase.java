package com.app.simplequestions.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.simplequestions.modules.daos.AnswerDao;
import com.app.simplequestions.modules.entities.Answer;

@Database(entities = {Answer.class}, version = 1)
public abstract class SimpleQuestionDatabase extends RoomDatabase {

    private static SimpleQuestionDatabase instance;

    public abstract AnswerDao answerDao();

    public static synchronized SimpleQuestionDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SimpleQuestionDatabase.class, "db_simple_questions")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
