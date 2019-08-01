/**
 * 
 */
package org.bapan.repository;

import java.util.List;

import org.bapan.entity.Derived;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ruptam
 *
 */
public interface InheritanceRepository extends CrudRepository<Derived, String> {
	
	Derived findByFieldA(String fieldA);
	Derived findByFieldB(String fieldB);

}
