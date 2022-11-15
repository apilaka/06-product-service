package com.pilaka.productservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_role")
//@IdClass(UserRoleId.class)
public class UserRole implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="user_id", nullable=false)
	private long  userid;
	
	@Column(name="role_id", nullable=false)
	private long roleId;
//
//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//@JoinColumn(name = "role_id")
//private List<UserRole> roles = new ArrayList<>();
//
//
//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//@JoinColumn(name = "user_id")
//private List<Users> users = new ArrayList<>();


 
	


}
