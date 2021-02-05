package com.create.Project.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Library {

	/** 自動採番ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** 図書名 */
	private String name;

	/** ステータス(館内・貸出中) */
	private String status;

	/** 貸出日 */
	private Date startDate;

	public static Library newLibrary(String name, String status, Date startdate) {
		Library library = new Library();
		library.name = name;
		library.status = status;
		library.startDate = startdate;
		return library;
	}
}
