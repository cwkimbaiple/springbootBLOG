package com.gol.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결한 데이타베이스의 규칙을 따라간다.
	private int id;
	
	@Column(nullable = false, length=100)
	private String title;
	
	@Lob
	private String content;
	
	@ColumnDefault("0")
	private String count; // 조회수
	
	@ManyToOne(fetch=FetchType.EAGER) // Many는 Board, One은 User
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "board", fetch=FetchType.EAGER) //mappedBy 연관관계의 주인이 아니며 FK가 아니니까 DB에 컬럼을 만들지마세요.
	private List<Reply> reply;
	
	@CreationTimestamp //시간 자동 입력..
	private Timestamp createDate;
	
	
}
