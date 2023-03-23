package com.yukiii.sprphonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@Entity
@Where(clause = "deleted is false")
@SQLDelete(sql = "update phonebook set deleted = true where id = ?")
@Table(indexes = {
	@Index(name = "idx_id", columnList = "id"),
	@Index(name = "idx_phone_number", columnList = "phoneNumber")
})
@NoArgsConstructor
@AllArgsConstructor
public class Phonebook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String phoneNumber;

	private Boolean deleted;
}
