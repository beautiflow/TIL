package kr.ac.cnu.swacademy.cagong.entity;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class Answer extends BaseTimeEntity {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Builder
    public Answer(User user, String answer){
        this.user = user;
        this.answer = answer;
    }
}