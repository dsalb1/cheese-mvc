package org.launchcode.models.Data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Dan on 6/14/2017.
 */

@Transactional
@Repository
public interface CheeseDao extends CrudRepository<Cheese, Integer> {

}
