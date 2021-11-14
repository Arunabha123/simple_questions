package com.app.simplequestions.modules.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_answers")
public class Answer {
    @PrimaryKey
    @ColumnInfo(name = "question_no")
    private int questionNo;
    private boolean answer;

    public Answer(int questionNo, boolean answer) {
        this.questionNo = questionNo;
        this.answer = answer;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
