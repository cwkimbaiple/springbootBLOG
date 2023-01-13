package com.gol.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결한 데이타베이스의 규칙을 따라간다.
	private int id;
	
	@Column(nullable = false, length=200)
	private String content;
	
	@ManyToOne // Many는 Reply, One은 Board
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne // Many는 Reply, One은 User
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp //시간 자동 입력..
	private Timestamp createDate;
}
