package com.michael.mediareview;

import com.michael.mediareview.media.Media;
import com.michael.mediareview.media.auth.ApplicationUser;
import com.michael.mediareview.media.auth.ApplicationUserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.michael.mediareview.security.ApplicationUserRoles.ADMIN;

@SpringBootApplication
public class MediaReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaReviewApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(PasswordEncoder passwordEncoder, ApplicationUserDao applicationUserDao){
		return args -> {
			ApplicationUser user = new ApplicationUser(
					ADMIN.getGrantedAuthorities(),
					"michael",
					passwordEncoder.encode("password"),
					true,
					true,
					true,
					true
			);
			user.addMedia(new Media("test","test.com",6,"very good"));
			applicationUserDao.save(user);

		};
	}
}
