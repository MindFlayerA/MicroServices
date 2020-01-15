package com.codeseeker.microUserService.ui.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeseeker.microUserService.ui.Entities.UserEntity;;

@Repository
public interface DaoLayer extends JpaRepository<UserEntity, Long> 
{

}
