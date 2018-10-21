package com.alevel.qalist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class QA {
    private final Long id;
    private final String question;
    private final String answer;


    @Override
    public String toString() {
        return "QA{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QA qa = (QA) o;
        return Objects.equals(id, qa.id) &&
                Objects.equals(question, qa.question) &&
                Objects.equals(answer, qa.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, question, answer);
    }


    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }



    public QA(String question, String answer) {
        this.id = null;
        this.question = question;
        this.answer = answer;
    }

    @JsonCreator
    public QA(
            @JsonProperty("id") Long id,
            @JsonProperty("question") String question,
            @JsonProperty("answer") String answer
    ) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

}
