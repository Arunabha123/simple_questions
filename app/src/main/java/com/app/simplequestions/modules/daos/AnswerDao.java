package com.app.simplequestions.modules.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.app.simplequestions.modules.entities.Answer;

import java.util.List;

@Dao
public interface AnswerDao {
    @Insert
    void saveData(List<Answer> answers);

    @Update
    void updateData(List<Answer> answers);

    @Query("SELECT * FROM table_answers ORDER BY question_no ASC")
    LiveData<List<Answer>> getAllAnswers();
}
