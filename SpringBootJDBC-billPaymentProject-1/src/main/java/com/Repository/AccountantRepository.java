package com.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Beans.Accountant;

public interface AccountantRepository extends JpaRepository<Accountant,Long>  {

}
