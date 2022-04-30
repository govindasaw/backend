/**
 * 
 */
package com.saw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saw.model.MyProduct;
import com.saw.model.Pen;

/**
 * @author Govin
 *
 */
@Repository
public interface MyProductPenRepository extends JpaRepository<Pen, Long> {

}
