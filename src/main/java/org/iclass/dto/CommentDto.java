package org.iclass.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private int idx;
	private int mref;
	private String writer;
	private String content;
	private int readCount;
	private Date createdAt;
	private String ip;
	private int heart;
}
