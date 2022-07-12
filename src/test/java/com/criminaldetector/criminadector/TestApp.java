package com.criminaldetector.criminadector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.criminaldetector.criminadector.objects.person.Criminal;
import com.criminaldetector.criminadector.objects.person.User;
import com.criminaldetector.criminadector.repositories.CriminalRepository;
import com.criminaldetector.criminadector.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TestApp {
    
    @Autowired
    private CriminalRepository criminalRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test(){
        Criminal criminal = new Criminal(2L, "Ken Lloyd L. Billones", "Male", 21L, "Criminal", "Murder", "Tagum City", "Somewhere Down the Road");
        
        Criminal savedCriminal = criminalRepository.save(criminal);

        Criminal existCriminal = entityManager.find(Criminal.class, savedCriminal.getId());

        assertThat(existCriminal.getName()).isEqualTo(savedCriminal.getName());
    }

    @Test
    public void testUser(){
        User user = new User(1L, "KL", "Male", 21L, "Admin", "0-12345", "PasswordNi");
        
        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getName()).isEqualTo(savedUser.getName());
    }

}
