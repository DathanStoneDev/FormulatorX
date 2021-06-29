package com.devstone.formulatorx;

import com.devstone.formulatorx.dao.ManufacturerRepository;
import com.devstone.formulatorx.model.Manufacturer;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    //test to see if a manufacturer is actually added to the database. Checks against the name.
    @Test
    @Rollback(false)
    public void testFindManufacturerByName() {
        Manufacturer manufacturer = new Manufacturer("Testing123456", "USA", "Phoenix", "at@gmail.com", "687593403");
        manufacturerRepository.save(manufacturer);

        assertThat(manufacturer.getManName()).isEqualTo("Testing123456");

    }

    //test to see if delete function works
    @Test
    @Rollback(false)
    public void testDeleteManufacturer() {
        manufacturerRepository.deleteById(38);
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(35);
        assertThat(manufacturer).isEmpty();

    }



}
